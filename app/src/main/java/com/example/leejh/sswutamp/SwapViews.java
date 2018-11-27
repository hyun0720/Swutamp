package com.example.leejh.sswutamp;

import android.support.v7.widget.CardView;
import android.view.View;
import android.view.animation.DecelerateInterpolator;

/**
 * Created by Lee jh on 2017-11-16.
 */

public final class SwapViews implements Runnable {
    private boolean mIsFirstView;
    CardView cardView1;
    CardView cardView1_2;
    CardView cardView2;
    CardView cardView2_2;
    CardView cardView3;
    CardView cardView3_2;
    CardView cardView4;
    CardView cardView4_2;

    public SwapViews(boolean isFirstView, CardView cardView1, CardView cardView1_2) {
        mIsFirstView = isFirstView;
        this.cardView1 = cardView1;
        this.cardView1_2 = cardView1_2;
        this.cardView2 = cardView2;
        this.cardView2_2 = cardView2_2;
        this.cardView3 = cardView3;
        this.cardView3_2 = cardView3_2;
        this.cardView4 = cardView4;
        this.cardView4_2 = cardView4_2;
    }



    public void run() {
        final float centerX = cardView1.getWidth() / 2.0f;
        final float centerY = cardView1_2.getHeight() / 2.0f;
        Flip3dAnimation rotation;

        if (mIsFirstView) {
            cardView1.setVisibility(View.GONE);
            cardView1_2.setVisibility(View.VISIBLE);
            cardView1_2.requestFocus();

            rotation = new Flip3dAnimation(-90, 0, centerX, centerY);
        } else {
            cardView1_2.setVisibility(View.GONE);
            cardView1.setVisibility(View.VISIBLE);
            cardView1.requestFocus();

            rotation = new Flip3dAnimation(90, 0, centerX, centerY);
        }

        rotation.setDuration(500);
        rotation.setFillAfter(true);
        rotation.setInterpolator(new DecelerateInterpolator());

        if (mIsFirstView) {
            cardView1_2.startAnimation(rotation);
        } else {
            cardView1.startAnimation(rotation);
        }
    }
}