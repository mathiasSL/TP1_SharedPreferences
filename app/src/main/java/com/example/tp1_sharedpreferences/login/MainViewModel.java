package com.example.tp1_sharedpreferences.login;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp1_sharedpreferences.modelo.Usuario;
import com.example.tp1_sharedpreferences.request.ApiClient;

public class MainViewModel extends ViewModel {

    private MutableLiveData<Usuario> mldUsuario;

    public LiveData<Usuario> getMLDUsuario() {
        if (mldUsuario == null) {
            mldUsuario = new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public void login(Context context, String email, String pass){
        Usuario usuario = ApiClient.login(context,email,pass);
        mldUsuario.setValue(usuario);
    }

}
