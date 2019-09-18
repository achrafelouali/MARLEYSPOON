package com.marleyspoon.challenge.mvp.ui.recipes;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.marleyspoon.challenge.mvp.R;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class RecipesAdapter extends RecyclerView.Adapter<BaseViewHolder> {


    private List<RecipeResponse> mRecipeList;


    public RecipesAdapter(List<RecipeResponse> DoctorResponseList) {
        mRecipeList = DoctorResponseList;


    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        return new ViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(R.layout.item_recipe_view, parent, false));
    }

    @Override
    public int getItemViewType(int position) {
        return 1;
    }

    @Override
    public int getItemCount() {
        if (mRecipeList != null && mRecipeList.size() > 0) {
            return mRecipeList.size();
        } else {
            return 0;
        }
    }

    public void addItems(List<RecipeResponse> RecipeList) {
        mRecipeList.addAll(RecipeList);
        notifyDataSetChanged();
    }

    public void clearItems() {
        mRecipeList.clear();
        notifyDataSetChanged();
    }

    public interface Callback {
    }

    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.recipe_image_view)
        ImageView recipeImageView;

        @BindView(R.id.name_text_view)
        TextView nameTextView;


        @BindView(R.id.pb_loading)
        ProgressBar photoProgressBar;

        @BindView(R.id.photo_container)
        RelativeLayout photoContainer;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {

        }

        public void onBind(int position) {
            super.onBind(position);

            final RecipeResponse recipe = mRecipeList.get(position);

            if (recipe.getPhoto() != null) {

                photoContainer.setVisibility(View.VISIBLE);
                photoProgressBar.setVisibility(View.VISIBLE);
                Glide.with(itemView.getContext())
                        .load(recipe.getPhoto())
                        .listener(new RequestListener<String, GlideDrawable>() {
                            @Override
                            public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                                photoProgressBar.setVisibility(View.GONE);
                                return false;
                            }

                            @Override
                            public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                                photoProgressBar.setVisibility(View.GONE);
                                return false;
                            }
                        })
                        .centerCrop()
                        .into(recipeImageView);

            } else {
                photoContainer.setVisibility(View.GONE);
            }

            if (recipe.getTitle() != null) {
                nameTextView.setText(recipe.getTitle());
            }


        }
    }
}
