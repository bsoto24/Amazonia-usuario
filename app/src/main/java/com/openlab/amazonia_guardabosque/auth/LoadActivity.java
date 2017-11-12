package com.openlab.amazonia_guardabosque.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;

import com.openlab.amazonia_guardabosque.R;
import com.openlab.amazonia_guardabosque.TicketeraActivity;
import com.openlab.amazonia_guardabosque.core.BaseActivity;
import com.openlab.amazonia_guardabosque.data.local.SessionManager;


/**
 * Created by katherine on 10/05/17.
 */

public class LoadActivity extends BaseActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loader);
        if (savedInstanceState == null)
            initialProcess();
    }

    private void initialProcess() {
        SessionManager mSessionManager = new SessionManager(getApplicationContext());
        if(!mSessionManager.isLogin()){

            next(this,null, TicketeraActivity.class, true);
        }else{
            next(this,null, LoginActivity.class, true);
        }
    }
}
