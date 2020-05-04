package com.luminous.android.admobbasic.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.luminous.android.admobbasic.ImageRecyclerAdapter;

import java.util.Arrays;
import java.util.List;

public class DashboardFragment extends Fragment {

    private DashboardViewModel dashboardViewModel;
    private List<Integer> imageResource;
    private Integer[] imageResArray = new Integer[] {R.drawable.arshad_1,
            R.drawable.shai_1,
            R.drawable.shai_2,
            R.drawable.shai_3,
            R.drawable.shai_4,
            R.drawable.shai_5,
            R.drawable.shai_6,
            R.drawable.shai_7,
            R.drawable.shai_8,
            R.drawable.shai_9,
            R.drawable.shai_10,
            R.drawable.shai_11,
            R.drawable.shai_12,
            R.drawable.shai_13,
            R.drawable.shai_14,
            R.drawable.mypic_1,
            R.drawable.mypic_2,
            R.drawable.mypic_3,
            R.drawable.mypic_4,
            R.drawable.mypic_5,
            R.drawable.mypic_6,
            R.drawable.mypic_7,
            R.drawable.mypic_8,
            R.drawable.mypic_9,
            R.drawable.mypic_10,
            R.drawable.mypic_11,
            R.drawable.mypic_12,
            R.drawable.mypic_13,
            R.drawable.mypic_14,
            R.drawable.mypic_15,
            R.drawable.mypic_16,
            R.drawable.mypic_17,
            R.drawable.mypic_18,
            R.drawable.mypic_19,
            R.drawable.mypic_20,
            R.drawable.mypic_21};

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);
//        final TextView textView = root.findViewById(R.id.text_dashboard);
//        dashboardViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });

        imageResource = Arrays.asList(imageResArray);

        final RecyclerView recyclerImages = (RecyclerView) root.findViewById(R.id.listImage);
        final LinearLayoutManager imagesLayoutManager = new LinearLayoutManager(getActivity());
        recyclerImages.setLayoutManager(imagesLayoutManager);

        final ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(getActivity(), imageResource);
        recyclerImages.setAdapter(imageRecyclerAdapter);

        return root;
    }
}
