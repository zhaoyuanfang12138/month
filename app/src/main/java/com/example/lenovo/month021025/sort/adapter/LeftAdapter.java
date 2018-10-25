package com.example.lenovo.month021025.sort.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.month021025.R;
import com.example.lenovo.month021025.sort.bean.ShopBean;

import java.util.List;

/**
 * Created by lenovo on 2018/10/25.
 */

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.Holder>{

    private Context context;
    private List<ShopBean.DataBean> list;

    public LeftAdapter(Context context, List<ShopBean.DataBean> list) {
        this.context = context;
        this.list = list;
    }


    //接口回调
    public interface OnItemClickListener{
        void OnItemClick(View itemView,int position);
    }

    private OnItemClickListener itemClickListener;

    public void setOnItemClickListener(OnItemClickListener itemClickListener){
        this.itemClickListener=itemClickListener;
    }



    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View v = View.inflate(context, R.layout.sort_left,null);

        return new Holder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, final int position) {

        holder.txtLeft.setText(list.get(position).getName());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                itemClickListener.OnItemClick(view,position);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class Holder extends RecyclerView.ViewHolder{

        private final TextView txtLeft;

        public Holder(View itemView) {
            super(itemView);

            txtLeft = itemView.findViewById(R.id.txt_left_title);
        }
    }

}
