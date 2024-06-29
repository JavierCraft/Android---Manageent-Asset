package com.polytechnic.astra.ac.id.managementasset.API;

import com.polytechnic.astra.ac.id.managementasset.API.Service.UserService;

public class ApiUtils {

    public static final String API_BASE_URL = "http://192.168.0.4:8080/";

    public ApiUtils() {
    }

    public static UserService getUserService(){
        return RetrofitClient.getClient(API_BASE_URL).create(UserService.class);
    }

    /*public static TransaksiService getAllTransaksiByStatus(){
    /*public static TransaksiService getAllTransaksiByStatus(){
        return RetrofitClient.getClient(API_BASE_URL).create(TransaksiService.class);
    }*/

}
