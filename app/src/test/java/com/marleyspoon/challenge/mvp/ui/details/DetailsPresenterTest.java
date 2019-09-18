package com.marleyspoon.challenge.mvp.ui.details;

/**
 * Created by ELOUALI Achraf on 17/09/2019.
 */


import com.marleyspoon.challenge.mvp.data.DataManager;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.utils.rx.TestSchedulerProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.schedulers.TestScheduler;

import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;

/**
 * Created by ELOUALI .
 */
@RunWith(MockitoJUnitRunner.class)
public class DetailsPresenterTest {

    @Mock
    DetailsMvpView mMockDetailsMvpView;
    @Mock
    DataManager mMockDataManager;
    @Mock
    RecipeResponse carDetailsResponse;
    private DetailsPresenter<DetailsMvpView> mDetailsPresenter;
    private TestScheduler mTestScheduler;

    @Before
    public void setUp() {
        CompositeDisposable compositeDisposable = new CompositeDisposable();
        mTestScheduler = new TestScheduler();
        TestSchedulerProvider testSchedulerProvider = new TestSchedulerProvider(mTestScheduler);
        mDetailsPresenter = new DetailsPresenter<>(
                mMockDataManager,
                testSchedulerProvider);
        mDetailsPresenter.onAttach(mMockDetailsMvpView);
    }

    @Test
    public void testGetCarDetailsSuccess() {

        doReturn(carDetailsResponse)
                .when(mMockDataManager)
                .getRecipeFromPrefs();

        mDetailsPresenter.onGetRecipeDetails();
        mTestScheduler.triggerActions();

        verify(mMockDetailsMvpView).showRecipeDetails(carDetailsResponse);
        verifyNoMoreInteractions(mMockDetailsMvpView);
    }


    @After
    public void tearDown() {
        mDetailsPresenter.onDetach();
    }


}