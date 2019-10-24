package com.example.tp1_sharedpreferences.registro;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.tp1_sharedpreferences.modelo.Usuario;
import com.example.tp1_sharedpreferences.request.ApiClient;


public class RegistroViewModel extends ViewModel {

    private MutableLiveData<Usuario> mldUsuario;

    public LiveData<Usuario> getMLDUsuario(){
        if(mldUsuario==null){
            mldUsuario= new MutableLiveData<>();
        }
        return mldUsuario;
    }

    public void mostrar(Context context){
        Usuario usuario= ApiClient.leer(context);
        mldUsuario.setValue(usuario);
    }

    public void guardar(Context context,Usuario usuario ){
        ApiClient.guardar(context,usuario);
    }
}
