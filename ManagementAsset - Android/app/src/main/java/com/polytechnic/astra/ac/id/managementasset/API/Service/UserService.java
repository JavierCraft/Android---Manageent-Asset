package com.polytechnic.astra.ac.id.managementasset.API.Service;

import com.polytechnic.astra.ac.id.managementasset.API.VO.UserVO;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface UserService {

    @GET("user/getUserByUsername")
    Call<UserVO> getUserByUsername(@Query("usrid") String username);
}
