package com.marleyspoon.challenge.mvp.ui.recipes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.LinearLayout;

import com.marleyspoon.challenge.mvp.R;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.BaseActivity;
import com.marleyspoon.challenge.mvp.ui.custom.RecyclerItemClickListener;
import com.marleyspoon.challenge.mvp.ui.details.DetailsActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import io.supercharge.shimmerlayout.ShimmerLayout;


public class RecipesActivity extends BaseActivity implements
        RecipesMvpView, RecipesAdapter.Callback {

    @Inject
    RecipesMvpPresenter<RecipesMvpView> mPresenter;
    @Inject
    RecipesAdapter mRecipesAdapter;
    @Inject
    GridLayoutManager mLayoutManager;

    @BindView(R.id.recipe_recycler_view)
    RecyclerView mRecyclerView;
    List<RecipeResponse> mRecipeList;
    @BindView(R.id.shimmer_layout)
    ShimmerLayout mShimmer;
    @BindView(R.id.toolbar)
    Toolbar mToolbar;
    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCToolbarLayout;
    @BindView(R.id.layout_try_again)
    LinearLayout layout_try_again;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, RecipesActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);

        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));


        setSupportActionBar(mToolbar);
        mCToolbarLayout.setTitle(getResources().getString(R.string.app_name));
        mCToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        mCToolbarLayout.setExpandedTitleColor(Color.WHITE);
        mShimmer.startShimmerAnimation();

        mPresenter.onAttach(this);
        mPresenter.onServerSearchRecipes();

        mRecyclerView.setLayoutManager(mLayoutManager);
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mRecyclerView.setAdapter(mRecipesAdapter);

        mRecyclerView.addOnItemTouchListener(
                new RecyclerItemClickListener(this, mRecyclerView, (view, position) -> mPresenter.onSaveCurrentRecipe(mRecipeList.get(position)))
        );


    }

    @Override
    public void showRecipeDetails() {
        Intent intent = new Intent(this, DetailsActivity.class);
        startActivity(intent);
    }

    @Override
    public void updateRecipes(List<RecipeResponse> RecipeList) {
        mRecipeList = RecipeList;
        mRecipesAdapter.addItems(RecipeList);

    }

    @Override
    public void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    public void showShimmer() {
        mShimmer.setVisibility(View.VISIBLE);
        mShimmer.startShimmerAnimation();
    }

    @Override
    public void hideShimmer() {
        mShimmer.stopShimmerAnimation();
        mShimmer.setVisibility(View.GONE);
    }

    @Override
    public void showTryAgain() {
        layout_try_again.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideTryAgain() {
        layout_try_again.setVisibility(View.GONE);
    }

    @OnClick(R.id.try_again)
    void tryAgainAction(View v) {
        mPresenter.onServerSearchRecipes();
    }
}
