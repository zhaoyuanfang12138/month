package com.example.lenovo.month021025.sort.v;

import com.example.lenovo.month021025.sort.bean.ChildBean;
import com.example.lenovo.month021025.sort.bean.ShopBean;

import java.util.List;

/**
 * Created by lenovo on 2018/10/25.
 */

public interface IView {

    void success(List<ShopBean.DataBean> data);

    void success1(List<ChildBean.DataBean> chilBean);

    void failed(Exception e);

}
