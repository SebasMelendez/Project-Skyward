package com.gamecodechool.tutorialtest;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.transition.Slide;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private ViewPager mSlideViewPager;
    private LinearLayout mDotLayout;

    private TextView[] mDots;

    private SliderAdapter sliderAdapter;

    private Button mNextBtn;
    private Button mBackBtn;
    private Button mBigClockBtn;

    private int mCurrentPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSlideViewPager = (ViewPager) findViewById(R.id.slideViewPager);
        mDotLayout = (LinearLayout) findViewById(R.id.dotsLayout);

        mNextBtn = (Button) findViewById(R.id.nextBtn);
        mBackBtn = (Button) findViewById(R.id.prevBtn);
        mBigClockBtn = (Button) findViewById(R.id.bigClockBtn);


        sliderAdapter = new SliderAdapter( this);

        mSlideViewPager.setAdapter(sliderAdapter);

        addDotsIndicator(0);

        mSlideViewPager.addOnPageChangeListener(viewListener);

        //OnCLickListeners

        mNextBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                mSlideViewPager.setCurrentItem(mCurrentPage +1);
            }
        });

        mBackBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                mSlideViewPager.setCurrentItem(mCurrentPage -1);
            }
        });


        mBigClockBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view){
                openBigClock();
            }
        });


    }


    public void addDotsIndicator(int position){

        mDots = new TextView[4];
        mDotLayout.removeAllViews();

        for(int i = 0; i < mDots.length; i++){

            mDots[i] = new TextView(this);
            mDots[i].setText(Html.fromHtml("&#9675;"));
            mDots[i].setTextSize(20);
            mDots[i].setTextColor(getResources().getColor(R.color.colorTransparentWhite));

            mDotLayout.addView(mDots[i]);

        }

        if(mDots.length > 0){
            mDots[position].setText(Html.fromHtml("&#8226;"));
            mDots[position].setTextColor(getResources().getColor(R.color.colorWhite));
            mDots[position].setTextSize(35);
        }

    }

    public void openBigClock(){
        Intent intent = new Intent(this, BigClock_test.class);
        startActivity(intent);
    }

    ViewPager.OnPageChangeListener viewListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {

        }

        @Override
        public void onPageSelected(int i) {

            addDotsIndicator(i);
            mCurrentPage =i;

            if(i == 0 ){

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(false);
                mBigClockBtn.setEnabled(false);
                mBigClockBtn.setVisibility(View.GONE);
                mNextBtn.setVisibility(View.VISIBLE);
                mBackBtn.setVisibility(View.INVISIBLE);

                mNextBtn.setText("Next");
                mBigClockBtn.setText("");
                mBackBtn.setText("");
            }else if (i == mDots.length -1 ) {

                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBigClockBtn.setEnabled(true);

                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.INVISIBLE);
                mBigClockBtn.setVisibility(View.VISIBLE);

                mNextBtn.setText("");
                mBackBtn.setText("Back");
                mBigClockBtn.setText("Go to BigClock");

            }else{
                mNextBtn.setEnabled(true);
                mBackBtn.setEnabled(true);
                mBackBtn.setVisibility(View.VISIBLE);
                mNextBtn.setVisibility(View.VISIBLE);
                mBigClockBtn.setVisibility(View.GONE);

                mNextBtn.setText("Next");
                mBackBtn.setText("Back");
            }
        }


        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };



}
