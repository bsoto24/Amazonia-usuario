package com.openlab.amazonia_guardabosque.data.remote.request;


import com.openlab.amazonia_guardabosque.data.entities.AccessTokenEntity;
import com.openlab.amazonia_guardabosque.data.entities.ResponseUser;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

/**
 * Created by katherine on 10/05/17.
 */

public interface LoginRequest {
    @FormUrlEncoded
    @POST("api-token-auth/")
    Call<AccessTokenEntity> login(@Field("username") String email, @Field("password") String password);


    @GET("accounts/{id}")
    Call<ResponseUser> getUser(@Path("id") int id);

    /*@FormUrlEncoded
    @POST("login/mobile/facebook/")
    Call<AccessTokenEntity> loginUserFacebook(@Field("access_token") String tokenFace);

    @FormUrlEncoded
    @POST("user/recovery/")
    Call<UserEntity> recovery(@Field("email") String email);


    @FormUrlEncoded
    @PUT("user/change-password/")
    Call<UserEntity> changePassword(@Header("Authorization") String token,
                                    @Field("old_password") String old_password,
                                    @Field("new_password") String new_password,
                                    @Field("email") String email);

    @PUT("user/{id}/photo/")
    Call<UploadResponse> updatePhoto(@Header("Authorization") String token,
                                     @Path("id") int id,
                                     @Body RequestBody body);
*/
}
