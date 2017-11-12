package com.openlab.amazonia_guardabosque;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.openlab.amazonia_guardabosque.core.BaseActivity;
import com.travijuu.numberpicker.library.NumberPicker;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Bryam Soto on 12/11/2017.
 */

public class PagadoFragment extends Fragment {
    @BindView(R.id.np_extranjero)
    NumberPicker npExtranjero;
    @BindView(R.id.np_nacional)
    NumberPicker npNacional;
    @BindView(R.id.np_estudiante)
    NumberPicker npEstudiante;
    @BindView(R.id.btn_register)
    Button btnRegister;
    Unbinder unbinder;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pagado, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }

    @OnClick(R.id.btn_register)
    public void onViewClicked() {
        ((BaseActivity) getActivity()).showMessage("Datos Enviados");
    }
}
