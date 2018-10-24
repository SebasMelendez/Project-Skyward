package com.gamecodechool.tutorialtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.transition.Slide;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.security.PublicKey;

public class SliderAdapter extends PagerAdapter {

    Context context;
    LayoutInflater layoutInflater;

    public SliderAdapter(Context context) {

        this.context = context;


    }

//    //slide Arrays
//    public int[] slide_images = {
//
//       R.drawable.eat_icon,
//       R.drawable.sleep_icon,
//       R.drawable.code_icon,
//       R.mipmap.ic_launcher_round
//
//    };

    public String[] slide_headings = {
        "Welcome!",
        "This is the BigClock...",
        "The Sessions button will get you going...",
        "You can grab a bite but not from this hamburger..."


    };

    public String[] slide_descs = {
        "Project Skyward is a tool designed to help students manage their total Work-Study" +
                "hours.",
        "This big number right here is the BigClock, It is the main screen of the app and it shows you how many hours" +
                " you have to work before you complete your WS hours. " +
                "In the future you’ll be able to do more with it!",
        "The Sessions button will show 3 options when tapped. You can choose " +
                "any of the Work Session modes here: Goal, Normal, and Express.",
            "In the Hamburger Menu, you’ll be able to access the app settings, " +
                    "tweak different options and access other features."

    };

    @Override
    public int getCount() {
        return slide_headings.length;
    }

    @Override
    public boolean isViewFromObject( View view, Object o) {
        return view == (RelativeLayout) o;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

    layoutInflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    View view = layoutInflater.inflate(R.layout.slide_layout, container, false);

       // ImageView slideImageView = (ImageView) view.findViewById(R.id.slide_image);
        TextView slideHeading = (TextView) view.findViewById(R.id.slide_heading);
        TextView slideDescription = (TextView) view.findViewById(R.id.slide_desc);

       // slideImageView.setImageResource(slide_images[position]);
        slideHeading.setText(slide_headings[position]);
        slideDescription.setText(slide_descs[position]);



        container.addView(view);

    return view;

    }

    @Override
    public void destroyItem( ViewGroup container, int position, Object object) {

        container.removeView((RelativeLayout)object);

    }
}



