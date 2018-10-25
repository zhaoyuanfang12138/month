package com.example.lenovo.month021025.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.lenovo.month021025.R;
import com.example.lenovo.month021025.sort.adapter.LeftAdapter;
import com.example.lenovo.month021025.sort.adapter.RightAdapter;
import com.example.lenovo.month021025.sort.bean.ChildBean;
import com.example.lenovo.month021025.sort.bean.ShopBean;
import com.example.lenovo.month021025.sort.p.SortPresenter;
import com.example.lenovo.month021025.sort.v.IView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2018/10/25.
 */

public class SortFragment extends Fragment implements IView{

    private RecyclerView left;
    private RecyclerView right;
    private List<ShopBean.DataBean> list;
    private List<ChildBean.DataBean> list1;
    private SortPresenter presenter;

    private String urll = "http://www.zhaoapi.cn/product/getProductCatagory";
    private RightAdapter rightAdapter;
    private LeftAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View v = inflater.inflate(R.layout.fragment_sort,container,false);
         initView(v);
        return v;
    }

    private void initView(View v) {
        left = v.findViewById(R.id.recyclerleft);
        right = v.findViewById(R.id.recyclerright);

    }




    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

            initData();
    }

    private void initData() {
        presenter = new SortPresenter();
        presenter.attach(this);
        presenter.getleft();
        presenter.setView(1,"http://www.zhaoapi.cn/product/getProductCatagory");

        //左边
        list = new ArrayList<>();
        adapter = new LeftAdapter(getActivity(),list);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getActivity());

        left.addItemDecoration(new DividerItemDecoration(getActivity(),DividerItemDecoration.VERTICAL));

        left.setLayoutManager(layoutManager);

        left.setAdapter(adapter);

        adapter.setOnItemClickListener(new LeftAdapter.OnItemClickListener() {
            @Override
            public void OnItemClick(View itemView, int position) {
                int cid = list.get(position).getCid();
                presenter.setView(cid,urll);
            }
        });







        //右边
        RecyclerView.LayoutManager layoutManager1 =  new LinearLayoutManager(getActivity());
        list1= new ArrayList<>();
        right.setLayoutManager(layoutManager1);
        rightAdapter = new RightAdapter(getActivity(),list1);
        right.setAdapter(rightAdapter);


    }

    @Override
    public void success(List<ShopBean.DataBean> data) {

     for (int i=0;i<data.size();i++){
         list.add(data.get(i));
     }


    }

    @Override
    public void success1(List<ChildBean.DataBean> chilBean) {

        if (chilBean!=null){
            list1.clear();
            list1.addAll(chilBean);
            rightAdapter.notifyDataSetChanged();
        }
    }

    @Override
    public void failed(Exception e) {

    }


    @Override
    public void onDestroy() {
        super.onDestroy();
        if (presenter!=null){
            presenter.detach();
        }
    }
}
