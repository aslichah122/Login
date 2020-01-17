package com.example.rpl2016_01.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

public class Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        AndroidNetworking.initialize(getApplicationContext());
        final EditText username = findViewById(R.id.txtusername);
        final EditText password = findViewById(R.id.txtpassword);
        final Button btnreg = findViewById(R.id.btnregister);
        final Button button = findViewById(R.id.txtbutton);
        btnreg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), Register.class);
                startActivity(i);



            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidNetworking.post("http://192.168.6.201/aslichah/datalogin.php")
                        .addBodyParameter("username", username.getText().toString())
                        .addBodyParameter("password", password.getText().toString())
                        .setTag("test")
                        .setPriority(Priority.MEDIUM)
                        .build()
                        .getAsJSONObject(new JSONObjectRequestListener() {
                            @Override
                            public void onResponse(JSONObject response) {
                                Log.d("sukses", "onResponse: " + response);
                                try {
                                    JSONObject hasil = response.getJSONObject("hasil");
                                    if (hasil.getBoolean("sukses")){
                                        Toast.makeText(Login.this, "sukses", Toast.LENGTH_SHORT).show();
                                        Intent in = new Intent(getApplicationContext(), menu.class);
                                       startActivity(in);
                                    }else{
                                        Toast.makeText(Login.this, "password atau username salah", Toast.LENGTH_SHORT);
                                    }
                                }catch (JSONException e){
                                    e.printStackTrace();
                                    Toast.makeText(Login.this, "password atau username salah", Toast.LENGTH_SHORT).show();
                                }
                                //Toast.makeText(user.this, "sukses login", Toast.LENGTH_SHORT).show();
                            }

                            @Override
                            public void onError(ANError error) {
                                Log.d("error", "onResponse: " + error);
                                Toast.makeText(Login.this, "Gagal login", Toast.LENGTH_SHORT).show();
                            }
                        });

            }
        });
    }
}
