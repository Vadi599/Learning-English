package com.example.learningenglish.selection_menu;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.learningenglish.R;
import com.example.learningenglish.model.CategoryEntity;
import com.example.learningenglish.model.ThemeProperty;
import com.example.learningenglish.lesson.LessonFragment;
import com.example.learningenglish.model.ResourcesOfCategory;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SelectionMenuFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SelectionMenuFragment extends Fragment implements SelectionMenuContract.View {

    private View fragmentView;
    SelectionMenuPresenter presenter;
    Button btnLesson;
    CategoryEntity categoryEntity;
    String category;

    List<ResourcesOfCategory> resources = new ArrayList<>();

    public void setResources(List<ResourcesOfCategory> resources) {
        this.resources = resources;
    }

    private List<CategoryEntity> entities = new ArrayList<>();

    public void setEntities(List<CategoryEntity> entities) {
        this.entities = entities;
    }

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public SelectionMenuFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment SelectionMenuFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static SelectionMenuFragment newInstance(String param1, String param2) {
        SelectionMenuFragment fragment = new SelectionMenuFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        /* btnLesson = (Button) findViewById(R.id.btn_start_learning);*/
       /* if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }*/
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        presenter = new SelectionMenuPresenter(this, getContext());
        int themeId = getArguments().getInt("themeId");
        // Inflate the layout for this fragment
        fragmentView = inflater.inflate(R.layout.fragment_selection_menu, null);
        switch (themeId) {
            case 1:
                category = "Семья и друзья";
                break;
            case 2:
                category = "Части тела";
                break;
            case 3:
                category = "Одежда";
                break;
            case 4:
                category = "Цифры";
                break;
            case 5:
                category = "Цвета";
                break;
            case 6:
                category = "Фрукты и овощи";
                break;
            case 7:
                category = "Еда";
                break;
            case 8:
                category = "Школа";
                break;
            case 9:
                category = "Погода и природа";
                break;
            case 10:
                category = "Животные";
                break;
        }
        categoryEntity = new CategoryEntity(category);
        presenter.getThemePropertyFromDatabase(themeId);
        /* presenter.getDataFromDatabase();*/
        presenter.getResourcesFromDatabase(category);
        btnLesson = (Button) fragmentView.findViewById(R.id.btn_start_learning);
        btnLesson.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showLesson(categoryEntity);
            }
        });
        return fragmentView;
    }

    @Override
    public void showThemeProperty(ThemeProperty properties) {
        TextView typeOfTheme = (TextView) fragmentView.findViewById(R.id.tvTheme);
        typeOfTheme.setText(properties.getTypeOfTheme());
        TextView countOfWords = (TextView) fragmentView.findViewById(R.id.count_of_words);
        countOfWords.setText(properties.getCountOfWords());
    }

    @Override
    public void showMessage(String message) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showLesson(CategoryEntity categoryEntity) {
        Bundle bundle = new Bundle();
        bundle.putString("category", categoryEntity.getCategory());
        FragmentManager fragmentManager = getFragmentManager();
        LessonFragment fragment = new LessonFragment();
        fragment.setArguments(bundle);
        fragmentManager
                .beginTransaction()
                .replace(R.id.fragment_lesson, fragment)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showCategoryEntities(List<CategoryEntity> entities) {
        setEntities(entities);
    }

    @Override
    public void showResources(List<ResourcesOfCategory> resources) {
        setResources(resources);
    }
}