package com.openlab.amazonia_guardabosque.auth;

import android.os.Bundle;

import com.openlab.amazonia_guardabosque.ActivityUtils;
import com.openlab.amazonia_guardabosque.R;
import com.openlab.amazonia_guardabosque.core.BaseActivity;


public class LoginActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clear);

        LoginFragment fragment = (LoginFragment) getSupportFragmentManager()
                .findFragmentById(R.id.body);

        if (fragment == null) {
            fragment = LoginFragment.newInstance();

            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(),
                    fragment, R.id.body);
        }

        // Create the presenter
        new LoginPresenter(fragment,this);
    }


}
