package com.example.tp1_sharedpreferences.registro;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.tp1_sharedpreferences.R;
import com.example.tp1_sharedpreferences.modelo.Usuario;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

public class RegistroActivity extends AppCompatActivity {

    EditText dni;
    EditText apellido;
    EditText nombre;
    EditText mail;
    EditText password;
    RegistroViewModel registroViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        dni = findViewById(R.id.txtDni);
        apellido = findViewById(R.id.txtApellido);
        nombre = findViewById(R.id.txtNombre);
        mail = findViewById(R.id.txtMail);
        password = findViewById(R.id.txtPassword);
        registroViewModel = ViewModelProviders.of(this).get(RegistroViewModel.class);
        registroViewModel.getMLDUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                dni.setText(usuario.getDni()+"");
                nombre.setText(usuario.getNombre());
                apellido.setText(usuario.getApellido());
                mail.setText(usuario.getMail());
                password.setText(usuario.getPassword());
            }
        });
        registroViewModel.mostrar(getApplicationContext());
    }

    public void guardar(View view){
        Usuario usuario = new Usuario(Long.parseLong(dni.getText().toString()), apellido.getText().toString(), nombre.getText().toString(), mail.getText().toString(), password.getText().toString());
        registroViewModel.guardar(getApplicationContext(), usuario);
        StyleableToast.makeText(this, "Usuario guardado", R.style.ToastPersonalizado1).show();
    }
}
