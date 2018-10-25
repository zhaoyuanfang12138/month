package com.example.lenovo.month021025.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.example.lenovo.month021025.LsbjActivity;
import com.example.lenovo.month021025.R;

/**
 * Created by lenovo on 2018/10/25.
 */

public class HomeFragment extends Fragment{


    private EditText edt;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

     View v = inflater.inflate(R.layout.fragment_home,container,false);
        edt = v.findViewById(R.id.edt);
        return v;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

          edt.setOnClickListener(new View.OnClickListener() {
              @Override
              public void onClick(View view) {
                  Intent intent = new Intent(getActivity(), LsbjActivity.class);
                  startActivity(intent);

              }
          });
    }
}
