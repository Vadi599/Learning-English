package com.example.learningenglish.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.learningenglish.model.Category;
import com.example.learningenglish.R;
import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.model.ThemeProperty;

import java.util.ArrayList;
import java.util.List;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {

    private List<ThemeProperty> properties = new ArrayList<>();

    public List<ThemeProperty> getProperties() {
        return properties;
    }

    private OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setThemePropertyList(List<ThemeProperty> properties) {
        this.properties = properties;
        notifyDataSetChanged();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        CardView cv;
        TextView categoryName;
        ImageView categoryIcon;

        ViewHolder(View itemView) {
            super(itemView);
            cv = (CardView) itemView.findViewById(R.id.cardView);
            categoryName = (TextView) itemView.findViewById(R.id.tvCategory);
            categoryIcon = (ImageView) itemView.findViewById(R.id.ivCategory);
        }
    }

    List<Category> categories;

    public void setCategoryList(List<Category> categories) {
        this.categories = categories;
        notifyDataSetChanged();
    }

    public CategoryAdapter(List<Category> categories) {
        this.categories = categories;
    }

    @Override
    public int getItemCount() {
        return categories.size();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_category, parent, false);
        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        ThemeProperty property = getProperties().get(position);
        CardView cardview = holder.cv;
        holder.categoryName.setText(categories.get(position).getCategoryName());
        holder.categoryIcon.setImageResource(categories.get(position).getCategoryImageResourceId());
        cardview.setOnClickListener(v -> {
            if (onItemClickListener != null) {
                onItemClickListener.onItemClickedCategory(property);
            }
        });
    }
}
