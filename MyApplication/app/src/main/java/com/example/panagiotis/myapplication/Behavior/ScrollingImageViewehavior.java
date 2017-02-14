package com.example.panagiotis.myapplication.Behavior;

import android.content.Context;
import android.content.res.TypedArray;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.CoordinatorLayout;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.panagiotis.myapplication.R;



public class ScrollingImageViewehavior extends CoordinatorLayout.Behavior<ImageView> {
    private int toolbar_height;

    public ScrollingImageViewehavior(Context context, AttributeSet attrs){
        super(context,attrs);
        this.toolbar_height= getToolBarHeight(context);
    }

    @Override
    public boolean layoutDependsOn(CoordinatorLayout parent, ImageView imageView, View dependency) {
        return dependency instanceof AppBarLayout;
    }

    @Override
    public boolean onDependentViewChanged(CoordinatorLayout parent, ImageView imageView, View dependency) {
        if (dependency instanceof AppBarLayout) {
            CoordinatorLayout.LayoutParams lp = (CoordinatorLayout.LayoutParams) imageView.getLayoutParams();
            int fabBottomMargin = lp.bottomMargin;
            int distanceToScroll = imageView.getHeight() + fabBottomMargin;
            float ratio = (float)dependency.getY()/(float)toolbar_height;
            imageView.setTranslationY(-distanceToScroll * ratio);
        }
        return true;
    }

    public int getToolBarHeight(Context context) {
        int[] attrs = new int[] {R.attr.actionBarSize};
        TypedArray ta = context.obtainStyledAttributes(attrs);
        int toolBarHeight = ta.getDimensionPixelSize(0, -1);
        ta.recycle();
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        System.out.println(toolBarHeight);
        System.out.println("--------------------------------");
        System.out.println("--------------------------------");
        return toolBarHeight;
    }
}
