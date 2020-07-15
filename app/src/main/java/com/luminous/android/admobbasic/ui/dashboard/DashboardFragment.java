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

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.formats.UnifiedNativeAd;
import com.luminous.android.admobbasic.ImageRecyclerAdapter;
import com.luminous.android.admobbasic.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

public class DashboardFragment extends Fragment {
    public static final int NUMBER_OF_ADS = 5;
    AdLoader adLoader;
    List<UnifiedNativeAd> nativeAdList = new ArrayList<>();

    private DashboardViewModel dashboardViewModel;
    private List<Integer> imageResource;
    private Integer[] imageResArray = new Integer[] {R.drawable.arshad_1,
            R.drawable.holud_1,
            R.drawable.holud_2,
            R.drawable.holud_3,
            R.drawable.holud_4,
            R.drawable.holud_5,
            R.drawable.holud_6,
            R.drawable.holud_8,
            R.drawable.holud_9,
            R.drawable.holud_10,
            R.drawable.holud_11,
            R.drawable.holud_12,
            R.drawable.holud_13,
            R.drawable.holud_14,
            R.drawable.holud_15,
            R.drawable.holud_16,
            R.drawable.holud_17,
            R.drawable.holud_18,
            R.drawable.holud_19,
            R.drawable.biye_1,
            R.drawable.biye_2,
            R.drawable.biye_3,
            R.drawable.biye_4,
            R.drawable.biye_5,
            R.drawable.biye_6,
            R.drawable.biye_7,
            R.drawable.biye_8,
            R.drawable.biye_9,
            R.drawable.biye_10,
            R.drawable.biye_11,
            R.drawable.biye_12,
            R.drawable.biye_13,
            R.drawable.biye_14,
            R.drawable.biye_15,
            R.drawable.biye_16,
            R.drawable.biye_17,
            R.drawable.biye_18,
            R.drawable.biye_19,
            R.drawable.biye_20,
            R.drawable.biye_21,
            R.drawable.biye_22,
            R.drawable.biye_23,
            R.drawable.biye_24,
            R.drawable.biye_25,
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
    private RecyclerView recyclerImages;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        View root = inflater.inflate(R.layout.fragment_dashboard, container, false);


        imageResource = Arrays.asList(imageResArray);

        final RecyclerView recyclerImages = (RecyclerView) root.findViewById(R.id.listImage);
        final LinearLayoutManager imagesLayoutManager = new LinearLayoutManager(getActivity());
        recyclerImages.setLayoutManager(imagesLayoutManager);
        
        loadNativeAds();

        final ImageRecyclerAdapter imageRecyclerAdapter = new ImageRecyclerAdapter(getActivity(), imageResource);
        recyclerImages.setAdapter(imageRecyclerAdapter);

        return root;
    }

    private void loadNativeAds() {
        AdLoader.Builder builder = new AdLoader.Builder(getActivity(), getResources().getString(R.string.admob_native_id));

        adLoader = builder.forUnifiedNativeAd(new UnifiedNativeAd.OnUnifiedNativeAdLoadedListener() {
            @Override
            public void onUnifiedNativeAdLoaded(UnifiedNativeAd unifiedNativeAd) {
                nativeAdList.add(unifiedNativeAd);

                if(!adLoader.isLoading()) {
                    insertAdsInRecyclerView();
                }
            }
        }).withAdListener(new AdListener() {
            @Override
            public void onAdFailedToLoad(int i) {
                super.onAdFailedToLoad(i);
                insertAdsInRecyclerView();
            }
        }).build();

        adLoader.loadAds(new AdRequest.Builder().build(), NUMBER_OF_ADS);
    }

    private void insertAdsInRecyclerView() {
        if (nativeAdList.size() <= 0) {
            return;
        }


    }
}
