package cn.bertsir.animationutils;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

import cn.bertsir.animationlibrary.AnimationUtils;
import cn.bertsir.imageloaderlibrary.Loader.ImageLoader;

public class ShowActivity extends AppCompatActivity {

    private ImageView iv;
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        ImageLoader.getInstance().init(getApplicationContext());
        name = getIntent().getStringExtra("name");
        initView();
    }

    private void initView() {
        iv = (ImageView) findViewById(R.id.iv);
        //用到了本人写的一个Glide封装库，喜欢的可以在引用中使用
        ImageLoader.getInstance().displayCircleFromDrawable(R.drawable.haimian,iv);
        showAnimation(name);
    }

    private void showAnimation(String name) {
        switch (name){
            case "moveToSelfTop":
                iv.setAnimation(AnimationUtils.getInstance().moveToSelfTop());
                break;
            case "moveToSelfBottom":
                iv.setAnimation(AnimationUtils.getInstance().moveToSelfBottom());
                break;
            case "moveToSelfFromTop":
                iv.setAnimation(AnimationUtils.getInstance().moveToSelfFromTop());
                break;
            case "moveToSelfFromBottom":
                iv.setAnimation(AnimationUtils.getInstance().moveToSelfFromBottom());
                break;
        }
    }
}
