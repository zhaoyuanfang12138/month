package com.example.lenovo.month021025;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.lenovo.month021025.fragment.HomeFragment;
import com.example.lenovo.month021025.fragment.ShoppingFragment;
import com.example.lenovo.month021025.fragment.SortFragment;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewPager vp;
    private TextView txtHome;
    private TextView txtSort;
    private TextView txtShopping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        vp = findViewById(R.id.vp);
        txtHome = findViewById(R.id.txt_home);
        txtSort = findViewById(R.id.txt_sort);
        txtShopping = findViewById(R.id.txt_shopping);

        txtHome.setOnClickListener(this);
        txtSort.setOnClickListener(this);
        txtShopping.setOnClickListener(this);



        final List<Fragment> list = new ArrayList<>();
        list.add(new HomeFragment());
        list.add(new SortFragment());
        list.add(new ShoppingFragment());

        vp.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return list.get(position);
            }

            @Override
            public int getCount() {
                return list.size();
            }
        });


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.txt_home:
                vp.setCurrentItem(0);
                break;


            case R.id.txt_sort:
                vp.setCurrentItem(1);
                break;


            case R.id.txt_shopping:
                vp.setCurrentItem(2);
                break;
        }
    }
}
