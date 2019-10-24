package com.example.tp1_sharedpreferences.login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.muddzdev.styleabletoastlibrary.StyleableToast;

import com.example.tp1_sharedpreferences.R;
import com.example.tp1_sharedpreferences.modelo.Usuario;
import com.example.tp1_sharedpreferences.registro.RegistroActivity;

public class MainActivity extends AppCompatActivity {

    private EditText user;
    private EditText password;
    private Button registrar;
    private MainViewModel mainViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        user = findViewById(R.id.txtUsuario);
        password = findViewById(R.id.txtPassword);
        registrar = findViewById(R.id.btnRegistrar);
        registrar.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
            }
        });
        mainViewModel = ViewModelProviders.of(this).get(MainViewModel.class);
        mainViewModel.getMLDUsuario().observe(this, new Observer<Usuario>() {
            @Override
            public void onChanged(Usuario usuario) {
                if (usuario != null) {
                    startActivity(new Intent(getApplicationContext(), RegistroActivity.class));
                }
            }
        });
    }

    public void login (View view){
         String email = user.getText().toString();
         String pass = password.getText().toString();
        if(email != null && Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mainViewModel.login(this, email, pass);
        }
        else
        {
            StyleableToast.makeText(this, "Usuario inexistente", R.style.ToastPersonalizado).show();
        }
    }

}
