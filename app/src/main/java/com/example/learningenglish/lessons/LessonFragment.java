package com.example.learningenglish.lessons;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;

import com.example.learningenglish.R;
import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.selection_menu.SelectionMenuPresenter;

public class LessonFragment extends Fragment implements LessonContract.View {

    private View view;
    LessonPresenter presenter;

    public LessonFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new LessonPresenter(this, getContext());
        int entityId = getArguments().getInt("entityId");
        view = inflater.inflate(R.layout.fragment_lesson, null);
        presenter.getCategoryEntityFromDatabase(entityId);
        return view;
    }

    @Override
    public void showCategoryEntity(CategoryEntity entities) {
        TextView wordRu = (TextView) view.findViewById(R.id.tvWord);
        wordRu.setText(entities.getWord_ru());
        TextView wordEn = (TextView) view.findViewById(R.id.tvTransfer);
        wordEn.setText(entities.getWord_en());
        ImageView imageView = (ImageView) view.findViewById(R.id.ivPicture);
        imageView.setImageResource(entities.getImageResourceId());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }
}