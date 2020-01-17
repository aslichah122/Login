package com.example.rpl2016_01.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;

import org.json.JSONException;
import org.json.JSONObject;

public class Register extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        final EditText username = findViewById(R.id.eduser);
        final EditText password = findViewById(R.id.edpassword);
        final EditText confirm = findViewById(R.id.edconfirm);
        final Button btnlogin = findViewById(R.id.btnlogin);
        final Button button1 = findViewById(R.id.btnconfirm);
        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ab = new Intent(getApplicationContext(), Login.class);
                startActivity(ab);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidNetworking.post("http://192.168.6.201/aslichah/register.php")
                        .addBodyParameter("username", username.getText().toString())
                        .addBodyParameter("password", password.getText().toString())
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    if (hasil.getBoolean("sukses")){
                                        Toast.makeText(Register.this, "sukses", Toast.LENGTH_SHORT).show();
                                    }else{
                                        Toast.makeText(Register.this, "psw atau usnm salah", Toast.LENGTH_SHORT);
                                    }
                                }catch (JSONException a){
                                    a.printStackTrace();
                                    // Toast.makeText(daftar.this, "psw atau usnm salah", Toast.LENGTH_SHORT).show();
                                }
                                Toast.makeText(Register.this, "sukses login", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(ANError anError) {
                                Toast.makeText(Register.this, "Gagal login", Toast.LENGTH_SHORT).show();
                            }

                        });

            }
        });
    }
}
