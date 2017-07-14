package cn.bertsir.animationutils;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button bt_one;
    private Button bt_two;
    private Button bt_three;
    private Button bt_four;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        bt_one = (Button) findViewById(R.id.bt_one);
        bt_two = (Button) findViewById(R.id.bt_two);
        bt_three = (Button) findViewById(R.id.bt_three);
        bt_four = (Button) findViewById(R.id.bt_four);

        bt_one.setOnClickListener(this);
        bt_two.setOnClickListener(this);
        bt_three.setOnClickListener(this);
        bt_four.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_one:
                startActivity("moveToSelfTop");
                break;
            case R.id.bt_two:
                startActivity("moveToSelfBottom");
                break;
            case R.id.bt_three:
                startActivity("moveToSelfFromTop");
                break;
            case R.id.bt_four:
                startActivity("moveToSelfFromBottom");
                break;
        }
    }


    private void startActivity(String name){
        this.startActivity(new Intent(getApplicationContext(),ShowActivity.class).putExtra("name",name));
    }
}
