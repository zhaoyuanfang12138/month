package com.example.lenovo.month021025.sort.p;

import com.example.lenovo.month021025.inter.ICallBack;
import com.example.lenovo.month021025.sort.bean.ChildBean;
import com.example.lenovo.month021025.sort.bean.ShopBean;
import com.example.lenovo.month021025.sort.m.SortModel;
import com.example.lenovo.month021025.sort.v.IView;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.List;

/**
 * Created by lenovo on 2018/10/25.
 */

public class SortPresenter {

    private IView iv;
    private SortModel model;


    public void attach(IView iv){
        this.iv =iv;
        model = new SortModel();
    }


    public void getleft(){

        Type type = new TypeToken<ShopBean>(){}.getType();
        model.getData("http://www.zhaoapi.cn/product/getCatagory", new ICallBack() {
            @Override
            public void success(Object obj) {
                  ShopBean shopBean = (ShopBean) obj;
                  if (shopBean!=null){
                      List<ShopBean.DataBean> data = shopBean.getData();
                      iv.success(data);
                  }


            }

            @Override
            public void failed(Exception e) {
               iv.failed(e);
            }
        },type);

    }


    public void setView(int cid,String url){
        String url2 = url+"?cid="+cid;

        Type type = new TypeToken<ChildBean>(){}.getType();

        model.getData(url2, new ICallBack() {
            @Override
            public void success(Object obj) {

                ChildBean childBean = (ChildBean) obj;
                List<ChildBean.DataBean> data = childBean.getData();
                iv.success1(data);


            }

            @Override
            public void failed(Exception e) {
                iv.failed(e);
            }
        },type);

    }


    public void detach(){
        if (iv!=null){
            iv=null;
        }
    }

}
