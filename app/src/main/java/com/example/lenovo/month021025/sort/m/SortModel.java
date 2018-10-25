package com.example.lenovo.month021025.sort.m;

import com.example.lenovo.month021025.inter.ICallBack;
import com.example.lenovo.month021025.utils.HttpUtils;

import java.lang.reflect.Type;

/**
 * Created by lenovo on 2018/10/25.
 */

public class SortModel {


    public void getData(String url, ICallBack callBack, Type type){
        HttpUtils.getInstance().get(url,callBack,type);
    }

}
