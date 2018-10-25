package com.example.lenovo.month021025;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LsbjActivity extends AppCompatActivity {

    private IViewi iViewi;
    private EditText edtLsbj;
    private Button btnShou;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lsbj);
        iViewi = findViewById(R.id.lsbj);
        edtLsbj = findViewById(R.id.edt_lsbj);
        btnShou = findViewById(R.id.btn_shou);


        btnShou.setOnClickListener(new View.OnClickListener() {

            private TextView textView;

            @Override
            public void onClick(View view) {
                textView = new TextView(LsbjActivity.this);

                ViewGroup.MarginLayoutParams layoutParams =new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT,ViewGroup.LayoutParams.WRAP_CONTENT);

                textView.setPadding(10, 10, 10, 10);
                layoutParams.setMargins(100, 100, 100, 100);
                textView.setLayoutParams(layoutParams);


                String ed_name = edtLsbj.getText().toString();
                textView.setText(ed_name);
                iViewi.addView(textView);

            }
        });







    }
}
