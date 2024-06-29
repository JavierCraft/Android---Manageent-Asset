package com.polytechnic.astra.ac.id.managementasset.Fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.google.gson.Gson;
import com.polytechnic.astra.ac.id.managementasset.API.Repository.UserRepository;
import com.polytechnic.astra.ac.id.managementasset.API.VO.UserVO;
import com.polytechnic.astra.ac.id.managementasset.Activity.MainActivity;
import com.polytechnic.astra.ac.id.managementasset.Activity.MenuUtamaActivity;
import com.polytechnic.astra.ac.id.managementasset.Model.UserModel;
import com.polytechnic.astra.ac.id.managementasset.R;
import com.polytechnic.astra.ac.id.managementasset.ViewModel.LoginViewModel;

public class LoginFragment extends Fragment {

    private EditText mEdtUsername;
    private Button mBtnLogin;
    private LoginViewModel mLoginViewModel;

    public LoginFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        UserRepository.initialize(requireContext());
        mLoginViewModel = new ViewModelProvider(this).get(LoginViewModel.class);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        mEdtUsername = view.findViewById(R.id.edt_username);

        mBtnLogin = view.findViewById(R.id.btn_logout);
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String username = mEdtUsername.getText().toString().trim();

                if (TextUtils.isEmpty(username)) {
                    mEdtUsername.setError("Username wajib diisi");
                    mEdtUsername.requestFocus();
                    return;
                }

                mLoginViewModel.login(username);
                // Observe the login response

                observeLoginResponse();
            }
        });
        // Pengecekan Session Login
        checkSession();
        return view;
    }

    public void clearFields() {
        if (mEdtUsername != null) {
            mEdtUsername.setText("");
        }
    }

    private void checkSession() {
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("loginSession", Context.MODE_PRIVATE);
        String userJson = sharedPreferences.getString("dataUser", null);
        if (userJson != null) {
            Gson gson = new Gson();
            UserModel userModel = gson.fromJson(userJson, UserModel.class);
            if (userModel != null){
            navigateToNewActivity("Aktif");
            } else {
                navigateToNewActivity("Tidak Aktif");
            }
        } else {
            // Tidak ada sesi
            Log.d("LoginFragment", "No session found");
        }
    }

    private void navigateToNewActivity(String usrStatus) {
        if (usrStatus.equals("Aktif")) {
            Intent intent = new Intent(getActivity(), MenuUtamaActivity.class);
            startActivity(intent);
            getActivity().finish();
        }else{
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
            getActivity().finish();
        }
    }

    private void observeLoginResponse() {
        mLoginViewModel.getLoginResponse().observe(getViewLifecycleOwner(), new Observer<UserVO>() {
            @Override
            public void onChanged(UserVO userVO) {
                if (userVO != null) {
                    UserModel dataLogin = userVO.getData();

                    SharedPreferences sharedPreferences = getActivity().getSharedPreferences("loginSession", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    Gson gson = new Gson();
                    String userJson = gson.toJson(dataLogin);
                    editor.putString("dataUser", userJson);
                    editor.apply();

                    Toast.makeText(getActivity(), "Login Berhasil", Toast.LENGTH_SHORT).show();
                    if(dataLogin != null) {
                        navigateToNewActivity("Aktif");
                    }else{
                        navigateToNewActivity("Tidak Aktif");
                        clearFields();
                        //else nya ngahapus fieldnya, kek ngeclear
                    }
                } else {
                    Toast.makeText(getActivity(), "Username Salah", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
