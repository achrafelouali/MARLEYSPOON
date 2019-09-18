package com.marleyspoon.challenge.mvp.ui.details;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.marleyspoon.challenge.mvp.R;
import com.marleyspoon.challenge.mvp.data.network.model.RecipeResponse;
import com.marleyspoon.challenge.mvp.ui.base.BaseViewHolder;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class TagsAdapter extends RecyclerView.Adapter<BaseViewHolder> {

    private List<RecipeResponse.Tags> mTagList;

    public TagsAdapter(List<RecipeResponse.Tags> TagsList) {
        mTagList = TagsList;
    }


    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.onBind(position);
    }

    @Override
    public BaseViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tag_view, parent, false));
    }


    @Override
    public int getItemCount() {
        return mTagList.size();
    }

    public void addItems(List<RecipeResponse.Tags> TagsList) {
        mTagList.addAll(TagsList);
        notifyDataSetChanged();
    }


    public class ViewHolder extends BaseViewHolder {

        @BindView(R.id.tag_text)
        TextView tagTextView;


        public ViewHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        @Override
        protected void clear() {
        }

        public void onBind(int position) {
            super.onBind(position);
            final RecipeResponse.Tags recipe = mTagList.get(position);
            tagTextView.setText(recipe.getName());
        }
    }

}
