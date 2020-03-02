package com.androidcodegeeks.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.androidcodegeeks.user.R;

public class LoginActivity extends AppCompatActivity {
    Button loginBtn;
    TextView registerTV;
    EditText urname,pass;
    DataBaseHelper db;
    SharedPreferences sharedPreferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        urname = findViewById(R.id.username_log);
        pass = findViewById(R.id.password_log);
        loginBtn = findViewById(R.id.login_btn);

        db = new DataBaseHelper(this);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = urname.getText().toString().trim();
                String pwd = pass.getText().toString().trim();
                Boolean res = db.checkUser(user,pwd);
                if (user.isEmpty()){
                    urname.setError("user name not entered");
                }
                else if (pwd.isEmpty()){
                    pass.setError("password not entered");
                }
                else {
                    if (res == true) {
                        sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = sharedPreferences.edit();
                        editor.putString("uname", urname.getText().toString());
                        editor.putString("pass", pass.getText().toString());
                        editor.commit();
                        Intent intent = new Intent(LoginActivity.this, UsersPageActivity.class);
                        startActivity(intent);
                        Toast.makeText(LoginActivity.this, "Successfully logged", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(LoginActivity.this, "Please enter correct username and password", Toast.LENGTH_SHORT).show();
                    }
                }
          }
        });
        registerTV = findViewById(R.id.register_tv);
        registerTV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }
}
