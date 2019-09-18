package com.marleyspoon.challenge.mvp.ui.details;


import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.marleyspoon.challenge.mvp.R;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.BaseActivity;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;


public class DetailsActivity extends BaseActivity implements DetailsMvpView {

    @Inject
    DetailsMvpPresenter<DetailsMvpView> mPresenter;


    @BindView(R.id.tv_recipe_title)
    TextView mRecipeTitle;

    @BindView(R.id.recipe_photo_bar)
    ImageView mRecipePhotoBar;


    @BindView(R.id.tv_recipe_description)
    TextView mRecipeDescription;

    @BindView(R.id.cv_chef)
    CardView mCardViewChef;

    @BindView(R.id.tv_recipe_chef)
    TextView mRecipeChef;


    @BindView(R.id.cv_tags)
    CardView mCardViewTags;

    @BindView(R.id.recycler_view_tags)
    RecyclerView mRecyclerViewTags;

    @Inject
    FlexboxLayoutManager mFlexLayoutTagManager;

    @Inject
    TagsAdapter mTagsAdapter;


    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    @BindView(R.id.collapsing_toolbar_layout)
    CollapsingToolbarLayout mCToolbarLayout;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, DetailsActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        getActivityComponent().inject(this);
        setUnBinder(ButterKnife.bind(this));
        mPresenter.onAttach(DetailsActivity.this);
        mPresenter.onGetRecipeDetails();

        setSupportActionBar(mToolbar);
        mCToolbarLayout.setCollapsedTitleTextColor(Color.WHITE);
        mCToolbarLayout.setExpandedTitleColor(Color.TRANSPARENT);
        mToolbar.setNavigationIcon(android.support.v7.appcompat.R.drawable.abc_ic_ab_back_material);
        mToolbar.setNavigationOnClickListener(view -> onBackPressed());
    }

    @Override
    public void showRecipeDetails(RecipeResponse recipeResponse) {

        if (recipeResponse.getPhoto() != null) {
            renderPhoto(recipeResponse.getPhoto());
        }

        if (recipeResponse.getTitle() != null) {
            renderTitle(recipeResponse.getTitle());
        }

        if (recipeResponse.getDescription() != null) {
            renderDescription(recipeResponse.getDescription());
        }

        if (recipeResponse.getChef() != null) {
            renderChef(recipeResponse.getChef());
            mCardViewChef.setVisibility(View.VISIBLE);
        } else {
            mCardViewChef.setVisibility(View.GONE);
        }


        if (recipeResponse.getTags() != null && recipeResponse.getTags().size() > 0) {
            renderTags(recipeResponse.getTags());
        } else {
            mCardViewTags.setVisibility(View.GONE);
        }

    }

    public void renderPhoto(String photoUrl) {
        Glide.with(this)
                .load(photoUrl)
                .listener(new RequestListener<String, GlideDrawable>() {
                    @Override
                    public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                        //photoProgressBar.setVisibility(View.GONE);
                        return false;
                    }

                    @Override
                    public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                        // photoProgressBar.setVisibility(View.GONE);
                        return false;
                    }
                })
                .centerCrop()
                .into(mRecipePhotoBar);
    }

    public void renderTitle(String title) {
        mRecipeTitle.setText(title);
        mCToolbarLayout.setTitle(title);
    }

    public void renderDescription(String description) {
        mRecipeDescription.setText(description);
    }

    public void renderChef(RecipeResponse.Chef chef) {
        mRecipeChef.setText(chef.getName());
    }

    public void renderTags(List<RecipeResponse.Tags> tagsList) {
        mTagsAdapter.addItems(tagsList);
        mRecyclerViewTags.setLayoutManager(mFlexLayoutTagManager);
        mRecyclerViewTags.setAdapter(mTagsAdapter);
    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

}
