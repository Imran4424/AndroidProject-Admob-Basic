package com.luminous.android.admobbasic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.jsibbold.zoomage.ZoomageView;

public class FullScreenImage extends AppCompatActivity {
    public static final String IMAGE_POSITION = "com.luminous.happybirthday.IMAGE_POSITION";
    public static final int POSITION_NOT_SET = -1;

    private int imagePosition;
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
            R.drawable.mypic_5};

    private ZoomageView zoomImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_screen_image);

        zoomImageView = (ZoomageView) findViewById(R.id.zoomImageView);

        // set bouncing false
        zoomImageView.setRestrictBounds(true);

        Intent fullScreenIntent = getIntent();
        imagePosition = fullScreenIntent.getIntExtra(IMAGE_POSITION, POSITION_NOT_SET);

        setImageViewResource();
    }

    private void setImageViewResource() {
        zoomImageView.setImageResource(imageResArray[imagePosition]);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_fullscreen, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onPrepareOptionsMenu(Menu menu) {
        MenuItem previous = menu.findItem(R.id.actionPrev);
        MenuItem next = menu.findItem(R.id.actionNext);
        int firstImageIndex = 0;
        int lastImageIndex = imageResArray.length - 1;
        previous.setEnabled(imagePosition > firstImageIndex);
        next.setEnabled(imagePosition < lastImageIndex);

        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if(id == R.id.actionNext) {
            moveNext();
        } else if(id == R.id.actionPrev) {
            movePrevious();
        }

        return super.onOptionsItemSelected(item);
    }

    private void movePrevious() {
        imagePosition--;

        setImageViewResource();

        // to search for invalid options menu
        invalidateOptionsMenu();
    }

    private void moveNext() {
        imagePosition++;

        setImageViewResource();

        // to search for invalid options menu
        invalidateOptionsMenu();
    }
}