package cn.bertsir.animationlibrary;

import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.TranslateAnimation;

/**
 * Created by Bert on 2017/7/13.
 */

public class AnimationUtils {

    private static AnimationUtils instance;


    public static synchronized AnimationUtils getInstance() {
        if(instance == null)
            instance = new AnimationUtils();
        return instance;
    }


    /**
     * 移动到控件底部
     * @return
     */
    public  TranslateAnimation moveToSelfBottom() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }
    /**
     * 从控件的底部移动到控件所在位置
     *
     * @return
     */
    public  TranslateAnimation moveToSelfFromBottom() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }

    /**
     * 从控件所在位置移动到控件的顶部
     *
     * @return
     */
    public  TranslateAnimation moveToSelfTop() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                0.0f, Animation.RELATIVE_TO_SELF, -1.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }
    /**
     * 从控件的顶部移动到控件所在位置
     *
     * @return
     */
    public  TranslateAnimation moveToSelfFromTop() {
        TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                -1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
        mHiddenAction.setDuration(500);
        return mHiddenAction;
    }

    /**
     * 围绕中心点顺时针旋转
     * @param Degrees
     * @param time
     * @return
     */
    public  RotateAnimation rotateSelfRightFromCenter(float Degrees,long time ){
        RotateAnimation rotateAnimation = new RotateAnimation(0f, Degrees, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(time);
        return rotateAnimation;

    }

    /**
     * 围绕中心点逆时针旋转
     * @param Degrees
     * @param time
     * @return
     */
    public  RotateAnimation rotateSelfLeftFromCenter(float Degrees,long time){
        RotateAnimation rotateAnimation = new RotateAnimation(Degrees, 0f, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(time);
        return rotateAnimation;

    }


    /**
     * 围绕自定义点逆时针旋转
     * @param Degrees
     * @param time
     * @return
     */
    public  RotateAnimation rotateSelfLeftFromCustom(float Degrees,long time,float pivotXValue,float pivotYValue){
        RotateAnimation rotateAnimation = new RotateAnimation(Degrees, 0f, Animation.RELATIVE_TO_SELF, pivotXValue, Animation.RELATIVE_TO_SELF, pivotYValue);
        rotateAnimation.setDuration(time);
        return rotateAnimation;

    }

    /**
     * 围绕自定义点顺时针旋转
     * @param Degrees
     * @param time
     * @return
     */
    public  RotateAnimation rotateSelfRightFromCustom(float Degrees,long time,float pivotXValue,float pivotYValue){
        RotateAnimation rotateAnimation = new RotateAnimation(0f,Degrees, Animation.RELATIVE_TO_SELF, pivotXValue, Animation.RELATIVE_TO_SELF, pivotYValue);
        rotateAnimation.setDuration(time);
        return rotateAnimation;
    }


    /**
     * 透明到可见
     * @param time
     * @return
     */
    public  AlphaAnimation AlphaToVisable(long time){
        AlphaAnimation alphaanimation = new AlphaAnimation(0.0f, 1.0f);
        alphaanimation.setDuration(time);
        return alphaanimation;
    }

    /**
     * 可见到透明
     * @param time
     * @return
     */
    public  AlphaAnimation VisableToAlpha(long time){
        AlphaAnimation alphaanimation = new AlphaAnimation(1.0f, 0.0f);
        alphaanimation.setDuration(time);
        return alphaanimation;
    }

    /**
     * 自定义从两个透明度的渐变
     * @param time
     * @return
     */
    public  AlphaAnimation AlphaToCustom(long time,float fromVaule,float toVaule){
        AlphaAnimation alphaanimation = new AlphaAnimation(fromVaule, toVaule);
        alphaanimation.setDuration(time);
        return alphaanimation;
    }


    /**
     * 构造两个动画的组合动画
     * @param v
     * @param one
     * @param two
     * @param time
     */
    public void makeAnimationGroup(View v,Animation one,Animation two,long time) {
        AnimationSet animationSet = new AnimationSet(true);
        animationSet.addAnimation(one);
        animationSet.addAnimation(two);
        animationSet.setDuration(time);
        animationSet.cancel();
        animationSet.reset();
        v.startAnimation(animationSet);
    }


}
