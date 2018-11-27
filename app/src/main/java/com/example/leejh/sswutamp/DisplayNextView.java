package com.example.leejh.sswutamp;

import android.support.v7.widget.CardView;
import android.view.animation.Animation;

/**
 * Created by Lee jh on 2017-11-16.
 */

public final class DisplayNextView implements Animation.AnimationListener {
    private boolean mCurrentView1;
    private boolean mCurrentView2;
    private boolean mCurrentView3;
    private boolean mCurrentView4;

    CardView cardView1;
    CardView cardView1_2;

    /*CardView cardView2;
    CardView cardView2_2;

    CardView cardView3;
    CardView cardView3_2;

    CardView cardView4;
    CardView cardView4_2;   */


    public DisplayNextView(boolean currentView, CardView cardView1, CardView cardView1_2) {
        mCurrentView1 = currentView;

        this.cardView1 = cardView1;
        this.cardView1_2 = cardView1_2;

        /*this.cardView2 = cardView2;
        this.cardView2_2 = cardView2_2;

        this.cardView3 = cardView3;
        this.cardView3_2 = cardView3_2;

        this.cardView4 = cardView4;
        this.cardView4_2 = cardView4_2;  */
    }



    public void onAnimationStart(Animation animation) {
    }

    public void onAnimationEnd(Animation animation) {
        cardView1.post(new SwapViews(mCurrentView1, cardView1, cardView1_2));
       /* cardView2.post(new SwapViews(mCurrentView2, cardView2, cardView2_2));
        cardView3.post(new SwapViews(mCurrentView3, cardView3, cardView3_2));
        cardView4.post(new SwapViews(mCurrentView4, cardView4, cardView4_2));*/

    }

    public void onAnimationRepeat(Animation animation) {
    }
}