package com.luminous.android.admobbasic.ui.notifications;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.luminous.android.admobbasic.R;

public class NotificationsFragment extends Fragment {
    private MediaPlayer golpoPlayer;
    private ImageView playImage;
    private NotificationsViewModel notificationsViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_notifications, container, false);

        playImage = (ImageView) root.findViewById(R.id.playImage);
        golpoPlayer = MediaPlayer.create(getActivity(), R.raw.sheyal_sharosh);


        return root;
    }


    public void play(View view) {
        if(!golpoPlayer.isPlaying()) {
             golpoPlayer.start();
        }
    }

    @Override
    public void onPause() {
        super.onPause();

        golpoPlayer.stop();
    }

    @Override
    public void onResume() {
        super.onResume();

        golpoPlayer.start();
    }

    @Override
    public void onAttachFragment(@NonNull Fragment childFragment) {
        super.onAttachFragment(childFragment);
    }
}
