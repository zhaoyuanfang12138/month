package com.example.lenovo.month021025.sort.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.month021025.R;
import com.example.lenovo.month021025.sort.bean.ChildBean;

import java.util.List;

/**
 * Created by lenovo on 2018/10/25.
 */

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.Holder>{

   private Context mcontext;
   private List<ChildBean.DataBean.ListBean> lists;

    public MyAdapter(Context mcontext, List<ChildBean.DataBean.ListBean> lists) {
        this.mcontext = mcontext;
        this.lists = lists;
    }

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

      View v = View.inflate(mcontext,R.layout.sort_right_child,null);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {

        holder.content.setText(lists.get(position).getName());
        Glide.with(mcontext).load(lists.get(position).getIcon()).into(holder.img1);

    }

    @Override
    public int getItemCount() {
        return lists.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        private final ImageView img1;
        private final TextView content;

        public Holder(View itemView) {
            super(itemView);

            img1 = itemView.findViewById(R.id.img1);
            content = itemView.findViewById(R.id.content);

        }
    }

}
