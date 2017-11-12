package com.openlab.amazonia_guardabosque.data.local;

import android.content.Context;
import android.content.SharedPreferences;

import com.google.gson.Gson;
import com.openlab.amazonia_guardabosque.data.entities.UserEntity;

/**
 * Created by junior on 13/10/16.
 */
public class SessionManager {


    public static final String PREFERENCE_NAME = "SymbiosisClient";
    public static int PRIVATE_MODE = 0;

    /**
     USUARIO DATA SESSION - JSON
     */
    public static final String USER_TOKEN = "user_code";
    public static final String USER_JSON = "user_json";
    public static final String IS_LOGIN = "user_login";
    public static final String EXPLANATION_SCHEDULE = "schedule_explanation";



    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;
    private Context context;

    public SessionManager(Context context) {
        this.context = context;
        preferences = this.context.getSharedPreferences(PREFERENCE_NAME, PRIVATE_MODE);
        editor = preferences.edit();
    }

    public boolean isLogin()  {
        return preferences.getBoolean(IS_LOGIN, false);
    }

   public void openSession(String token) {
        editor.putBoolean(IS_LOGIN, true);
        editor.putString(USER_TOKEN, token);
        editor.commit();
    }

    public void closeSession() {
        editor.putBoolean(IS_LOGIN, false);
        editor.putString(USER_TOKEN, null);
        editor.putString(USER_JSON, null);
        editor.commit();
    }



    public String getUserToken() {
        if (isLogin()) {
            return preferences.getString(USER_TOKEN, "");
        } else {
            return "";
        }
    }

    public void setUser(UserEntity userEntity) {
        if (userEntity != null) {
            Gson gson = new Gson();
            String user = gson.toJson(userEntity);
            editor.putString(USER_JSON, user);
        }
        editor.putBoolean(IS_LOGIN, true);
        editor.commit();
    }

    public UserEntity getUserEntity() {
        String userData = preferences.getString(USER_JSON, null);
        return new Gson().fromJson(userData, UserEntity.class);
    }

}
