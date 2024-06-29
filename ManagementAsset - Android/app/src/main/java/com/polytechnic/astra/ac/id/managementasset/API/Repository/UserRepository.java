package com.polytechnic.astra.ac.id.managementasset.API.Repository;

import android.content.Context;
import android.util.Log;

import androidx.lifecycle.MutableLiveData;

import com.polytechnic.astra.ac.id.managementasset.API.ApiUtils;
import com.polytechnic.astra.ac.id.managementasset.API.Service.UserService;
import com.polytechnic.astra.ac.id.managementasset.API.VO.UserVO;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserRepository {

    private static final String TAG = "UserRepository";
    private static UserRepository INSTANCE;
    private UserService mUserService;

    private UserRepository(Context context) {
        mUserService = ApiUtils.getUserService();
    }

    public static void initialize(Context context) {
        if (INSTANCE == null) {
            INSTANCE = new UserRepository(context);
        }
    }

    public static UserRepository get() {
        return INSTANCE;
    }

    public MutableLiveData<UserVO> getUserLogin(String username) {
        Log.i(TAG, "getUserLogin() called");
        MutableLiveData<UserVO> dataLogin = new MutableLiveData<>();

        Call<UserVO> call = mUserService.getUserByUsername(username);
        call.enqueue(new Callback<UserVO>() {
            @Override
            public void onResponse(Call<UserVO> call, Response<UserVO> response) {
                if (response.isSuccessful() && response.body() != null) {
                    dataLogin.setValue(response.body());
                    Log.d(TAG, response.body().toString());
                } else {
                    dataLogin.setValue(null);
                    Log.e(TAG, "Response is not successful or body is null");
                }
            }

            @Override
            public void onFailure(Call<UserVO> call, Throwable throwable) {
                Log.e("Error API Call : ", throwable.getMessage());
            }
        });
        return dataLogin;
    }
}
