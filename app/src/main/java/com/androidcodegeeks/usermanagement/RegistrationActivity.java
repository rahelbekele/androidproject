package com.androidcodegeeks.usermanagement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import com.androidcodegeeks.user.R;

public class RegistrationActivity extends AppCompatActivity {
     EditText fullname,email,phone,username,password;
     RadioButton male,female;
     DataBaseHelper addRecord;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        fullname = findViewById(R.id.fullname_et);
        email = findViewById(R.id.email_et);
        phone = findViewById(R.id.phonenum_et);
        username = findViewById(R.id.username_et);
        password = findViewById(R.id.password_et);
        male = findViewById(R.id.radioButton3);
        female=findViewById(R.id.radioButton4);

        addRecord = new DataBaseHelper(this);

    }
    public void register(View view) {
        String fn =fullname.getText().toString();
        String em =email.getText().toString();
        String pn =phone.getText().toString();
        String un =username.getText().toString();
        String pa =password.getText().toString();
        String ge1 =male.getText().toString();
        String ge2=female.getText().toString();
        DataBaseHelper db = new DataBaseHelper(this);
        if (fn.isEmpty()){
            fullname.setError("full name is not entered");
            fullname.requestFocus();
        }
        else if (em.isEmpty()) {
            email.setError("email is not entered");
        }
        else if (pn.isEmpty()) {
            phone.setError("phone number is not entered");
        }
        else if (un.isEmpty()) {
            username.setError("user name is not entered");
        }
        else if (pa.isEmpty()) {
            password.setError("password is not entered");
        }
        else if (ge1.isEmpty()) {
            male.setError("gender is not entered");
        }else {
            String res= db.userRegistered(fn,em,pn,un,pa,ge1);
            Toast.makeText(this, res, Toast.LENGTH_SHORT).show();
            startActivity(new Intent(this,UsersPageActivity.class));
            fullname.setText("");
            email.setText("");
            phone.setText("");
            username.setText("");
            password.setText("");
            male.setText("");
        }


    }

    public void clear(View view) {
        fullname.setText("");
        email.setText("");
        phone.setText("");
        username.setText("");
        password.setText("");
        male.setText("");
    }
}
