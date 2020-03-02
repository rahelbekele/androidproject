package com.androidcodegeeks.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.androidcodegeeks.user.R;

public class UsersPageActivity extends AppCompatActivity {
    TextView textViewUN,textViewPass;
    SharedPreferences sharedPreferences;
    static final String DEFAULT="N/A";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_page);
          textViewUN = findViewById(R.id.un1);
          textViewPass = findViewById(R.id.pass1);

    }

    public void load(View view) {
        sharedPreferences = getSharedPreferences("mydata", Context.MODE_PRIVATE);
        String username = sharedPreferences.getString("uname",DEFAULT);
        String password = sharedPreferences.getString("pass",DEFAULT);
        if (textViewUN.equals(DEFAULT)||textViewPass.equals(DEFAULT)){
            Toast.makeText(this, "no data is found", Toast.LENGTH_SHORT).show();
        }
        else
            Toast.makeText(this, "the data is found", Toast.LENGTH_SHORT).show();
            textViewUN.setText(username);
            textViewPass.setText(password);
    }

    public void logout(View view) {
        startActivity(new Intent(this,LoginActivity.class));
    }

    public void gotoRV(View view) {
      Intent intent = new Intent(UsersPageActivity.this,UserListActivity.class);
      startActivity(intent);
    }
}
