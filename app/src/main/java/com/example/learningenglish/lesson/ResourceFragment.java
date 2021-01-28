package com.example.learningenglish.lesson;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.example.learningenglish.R;
import com.example.learningenglish.model.ResourcesOfCategory;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ResourceFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ResourceFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String WORD_RU = "wordRu";
    private static final String WORD_EN = "wordEn";
    private static final String IMAGE_RESOURCE_ID = "imageResourceId";

    // TODO: Rename and change types of parameters
    private String wordRu;
    private String wordEn;
    private int resourceImageId;

    public ResourceFragment() {
        // Required empty public constructor
    }

    // TODO: Rename and change types and number of parameters
    public static ResourceFragment newInstance(ResourcesOfCategory resources) {
        ResourceFragment fragment = new ResourceFragment();
        Bundle args = new Bundle();
        args.putString(WORD_RU, resources.getWordRu());
        args.putString(WORD_EN, resources.getWordEn());
        args.putInt(IMAGE_RESOURCE_ID, resources.getImageResourceId());
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            wordRu = getArguments().getString(WORD_RU);
            wordEn = getArguments().getString(WORD_EN);
            resourceImageId = getArguments().getInt(IMAGE_RESOURCE_ID);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_resource, null);
        TextView tvWordRu = (TextView) view.findViewById(R.id.tvWordRu);
        tvWordRu.setText(wordRu);
        TextView tvWordEn = (TextView) view.findViewById(R.id.tvWordEn);
        tvWordEn.setText(wordEn);
        ImageView ivPicture = (ImageView) view.findViewById(R.id.ivPicture);
        ivPicture.setImageResource(resourceImageId);
        return view;
    }
}