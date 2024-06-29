package com.polytechnic.astra.ac.id.managementasset.ViewModel;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.polytechnic.astra.ac.id.managementasset.API.Repository.UserRepository;
import com.polytechnic.astra.ac.id.managementasset.API.VO.UserVO;

public class LoginViewModel extends ViewModel {

    private static final String TAG = "LoginViewModel";

    private MutableLiveData<UserVO> loginResponse = new MutableLiveData<>();

    private final UserRepository mUserRepository;

    public LoginViewModel(){
        mUserRepository = UserRepository.get();
    }

    public LiveData<UserVO> getLoginResponse() {
        return loginResponse;
    }

    public void login(String username) {
        Log.i(TAG, "getProdiLiveData() called");
        loginResponse = mUserRepository.getUserLogin(username);
    }

}
