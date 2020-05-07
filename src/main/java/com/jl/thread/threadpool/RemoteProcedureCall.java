package com.jl.thread.threadpool;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Service;

@Service
public class RemoteProcedureCall {

    public JSONObject getUserInfo(String userId){

        return new JSONObject();
    }


    /**
     * 积分信息
     * @param userId
     * @return
     */
    public JSONObject getIntergralInfo(String userId) {
        return new JSONObject();
    }
}
