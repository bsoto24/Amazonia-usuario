package com.openlab.amazonia_guardabosque.auth;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;
import com.mobsandgeeks.saripaar.annotation.NotEmpty;
import com.mobsandgeeks.saripaar.annotation.Password;
import com.openlab.amazonia_guardabosque.R;
import com.openlab.amazonia_guardabosque.TicketeraActivity;
import com.openlab.amazonia_guardabosque.core.BaseActivity;
import com.openlab.amazonia_guardabosque.core.BaseFragment;
import com.openlab.amazonia_guardabosque.data.entities.UserEntity;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by junior on 27/08/16.
 */
public class LoginFragment extends BaseFragment implements LoginContract.View {

    private static final String TAG = LoginActivity.class.getSimpleName();


    @BindView(R.id.et_email)
    EditText etEmail;
    @BindView(R.id.et_password)
    EditText etPassword;
    @BindView(R.id.btn_login)
    Button btnLogin;
    Unbinder unbinder;


    private LoginContract.Presenter mPresenter;
    //private DialogForgotPassword dialogForgotPassword;
    private boolean isLoading = false;


    public LoginFragment() {
        // Requires empty public constructor
    }

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void onResume() {
        super.onResume();
        //mPresenter.start();
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_login, container, false);
        unbinder = ButterKnife.bind(this, root);
       // dialogForgotPassword = new DialogForgotPassword(getContext(), this);
        return root;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //mProgressDialogCustom = new ProgressDialogCustom(getContext(), "Ingresando...");
    }


    @Override
    public void setPresenter(LoginContract.Presenter mPresenter) {
        this.mPresenter = mPresenter;
    }

    @Override
    public void setLoadingIndicator(boolean active) {
        if (getView() == null) {
            return;
        }/*
        if (active) {
            mProgressDialogCustom.show();
        } else {
            if (mProgressDialogCustom.isShowing()) {
                mProgressDialogCustom.dismiss();
            }
        }*/
    }

    @Override
    public void showMessage(String msg) {
        ((BaseActivity) getActivity()).showMessage(msg);
    }

    @Override
    public void showErrorMessage(String message) {
        ((BaseActivity) getActivity()).showMessageError(message);
    }

    @Override
    public void loginSuccessful(UserEntity userEntity) {

        //Toast.makeText(getContext(), "Login exitoso", Toast.LENGTH_SHORT).show();
        //Bundle bundle = new Bundle();
        //bundle.putInt("id", id);
        newActivityClearPreview(getActivity(), null, TicketeraActivity.class);
        showMessage("Login exitoso");
    }

    @Override
    public void errorLogin(String msg) {
        showErrorMessage(msg);
    }

  /*  @Override
    public void showDialogForgotPassword() {
        //dialogForgotPassword.show();
    }*/

    /*@Override
    public void showSendEmail(String email) {
        //mPresenter.sendEmail(email);
        //dialogForgotPassword.dismiss();
    }*/

    @Override
    public boolean isActive() {
        return isAdded();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }


    @OnClick({R.id.btn_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_login:
                mPresenter.loginUser(etEmail.getText().toString(), etPassword.getText().toString());
                break;

    }
    }
}