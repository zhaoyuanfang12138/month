package com.example.lenovo.month021025;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;





public class MainActivity extends AppCompatActivity {

    private TextView txtRound;
    private static final int FLAG = 123;

    private Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);

            if (msg.what == FLAG){
                Intent intent = new Intent(MainActivity.this,HomeActivity.class);
                startActivity(intent);


            }

        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtRound = findViewById(R.id.txt_round);

        ObjectAnimator xanimator = ObjectAnimator.ofFloat(
                txtRound,
                "translationX",
                0,
                600
        );

        ObjectAnimator yanimator = ObjectAnimator.ofFloat(
                txtRound,
                "translationY",
                0,
                1100
        );

        xanimator.setDuration(3000);
        yanimator.setDuration(3000);
        xanimator.start();
        yanimator.start();
       handler.sendEmptyMessageDelayed(FLAG,5000);


    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        handler.removeCallbacksAndMessages(null);
    }

}

