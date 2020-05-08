package com.jl.thread.threadpool;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 模拟网关。
 */
@Service
public class UserServiceThread {

    @Autowired
    private RemoteProcedureCall remoteProcedureCall;

    public Object getUserInfo(String userId){
        JSONObject userInfo = remoteProcedureCall.getUserInfo(userId);
        System.out.println("user:" + userInfo);


        //查询积分
        JSONObject intergralInfo = remoteProcedureCall.getIntergralInfo(userId);
        System.out.println("intergralInfo:" + intergralInfo);

        //加入了物流信息
        //加入了金额信息


        //合并结果
        JSONObject result = new com.alibaba.fastjson.JSONObject();
        result.putAll(userInfo);
        result.putAll(intergralInfo);

        return result;

    }

}
