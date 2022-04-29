package com.example.tienda;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class SesionActivity extends AppCompatActivity {

    private EditText edtNombre;
    private EditText edtPassword;
    private Button btnEntrar;
    private String usuario =" ";
    private String password=" ";
    private TextView txtvRegistro;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sesion);
        edtNombre=findViewById(R.id.edtNombre);
        edtPassword=findViewById(R.id.edtPassword);
        btnEntrar=findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(onClickEntrar);
        txtvRegistro=findViewById(R.id.txtvRegistro);
        CargarPreferencias();
        txtvRegistro.setOnClickListener(onClickReg);
    }

    private void CargarPreferencias()
    {
        SharedPreferences preferencias=getSharedPreferences(getResources().getString(R.string.strCredenciales),MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        String user = preferencias.getString(getResources().getString(R.string.strUser),getResources().getString(R.string.strNoUsuarios));
        String password = preferencias.getString(getResources().getString(R.string.strPassword),getResources().getString(R.string.strNoPassword));
        edtNombre.setText(user);
        edtPassword.setText(password);
    }
    View.OnClickListener onClickReg=view ->  //implementar interfaces de manera rapida con expresion lambda
    {
        Intent intentRegistro=new Intent(SesionActivity.this,RegistroActivity.class);
        startActivity(intentRegistro);
    };

    View.OnClickListener onClickEntrar=new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(Valida()==true)
            {
                Intent intMain=new Intent(SesionActivity.this,MainActivity.class);
                startActivity(intMain);
            }else
            {
                Toast.makeText(getApplicationContext(),"Usuario o contraseña incorrecta",Toast.LENGTH_LONG).show();
            }
        }
    };
    private boolean Valida()
    {
        try {
            usuario = edtNombre.getText().toString();
            password = edtPassword.getText().toString();
        }
        catch(Exception error)
        {
            Log.d("login","error en los datos:: "+error.toString());
        }
        if(usuario.equals("emilio") && password.equals("contra")) //se comparan cadenas con .equals
        {
            return true;
        }else
        {
            return false;
        }


    }
}