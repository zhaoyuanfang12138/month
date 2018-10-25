package com.example.lenovo.month021025.sort.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.month021025.R;
import com.example.lenovo.month021025.sort.bean.ChildBean;

import java.util.List;

/**
 * Created by lenovo on 2018/10/25.
 */

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.Holder> {

    private Context context;
    private List<ChildBean.DataBean> list;

    public RightAdapter(Context context, List<ChildBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = View.inflate(context, R.layout.sort_right,null);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.sort_rightTitle.setText(list.get(position).getName());
        List<ChildBean.DataBean.ListBean> lists = this.list.get(position).getList();

        MyAdapter myAdapter = new MyAdapter(context,lists);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(context,5);
        holder.sort_rightRv.setLayoutManager(gridLayoutManager);
        holder.sort_rightRv.setAdapter(myAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        private final RecyclerView sort_rightRv;
        private final TextView sort_rightTitle;

        public Holder(View itemView) {
            super(itemView);

            sort_rightTitle = itemView.findViewById(R.id.sort_right_title);
            sort_rightRv = itemView.findViewById(R.id.sort_right_recyclerview);

        }
    }
}
