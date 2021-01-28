package com.example.learningenglish.lesson;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.learningenglish.R;
import com.example.learningenglish.model.ResourcesOfCategory;
import com.example.learningenglish.repository_category_entity.CategoryEntityRepository;
import com.example.learningenglish.repository_category_entity.ICategoryEntityRepository;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link LessonFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class LessonFragment extends Fragment {

    ViewPager pager;
    PagerAdapter pagerAdapter;
    String category;
    Button back;
    Button forward;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public LessonFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CategoryFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static LessonFragment newInstance(String param1, String param2) {
        LessonFragment fragment = new LessonFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_lesson, null);
        category = getArguments().getString("category");
        pager = (ViewPager) view.findViewById(R.id.pager);
        back = (Button) view.findViewById(R.id.btn_back);
        forward = (Button) view.findViewById(R.id.btn_forward);
        pagerAdapter = new MyFragmentPagerAdapter(getFragmentManager(), category);
        pager.setAdapter(pagerAdapter);
        back.setEnabled(false);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getItem = pager.getCurrentItem();
                if (getItem != 0) {
                    pager.setCurrentItem(getItem - 1, true);
                    forward.setEnabled(true);
                } else {
                    back.setEnabled(false);
                }
            }
        });
        forward.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int getItem = pager.getCurrentItem();
                int totalItems = pager.getAdapter().getCount();
                if (getItem < totalItems - 1) {
                    pager.setCurrentItem(getItem + 1, true);
                    back.setEnabled(true);
                } else if (getItem == totalItems - 1) {
                    forward.setEnabled(false);
                }
            }
        });
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                int totalItems = pager.getAdapter().getCount();
                if (position == 0) {
                    back.setEnabled(false);

                } else {
                    back.setEnabled(true);
                }
                if (position == totalItems - 1) {
                    forward.setEnabled(false);
                } else {
                    forward.setEnabled(true);
                }
            }

            @Override
            public void onPageScrolled(int position, float positionOffset,
                                       int positionOffsetPixels) {
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
        return view;
    }

    private class MyFragmentPagerAdapter extends FragmentStatePagerAdapter {

        ArrayList<Fragment> fragments = new ArrayList<>();

        ICategoryEntityRepository categoryEntityRepository = new CategoryEntityRepository(getContext());

        public MyFragmentPagerAdapter(FragmentManager fm, String category) {
            super(fm);
            List<ResourcesOfCategory> resourceList = categoryEntityRepository.getResource(category);
            for (ResourcesOfCategory resources : resourceList) {
                Fragment resourceFragment = ResourceFragment.newInstance(resources);
                fragments.add(resourceFragment);
            }
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }
    }
}
