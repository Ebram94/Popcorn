package com.androidtutorialpoint.androidviewpagerexample.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidtutorialpoint.androidviewpagerexample.R;

public class Login_Activity extends AppCompatActivity {
 Button login,signup;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login_);
           login= (Button) findViewById(R.id.btLogin);
            signup= (Button) findViewById(R.id.bt_signup);
             signup.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent i =new Intent(Login_Activity.this,Sign_Up.class);
                     startActivity(i);
                 }
             });
             login.setOnClickListener(new View.OnClickListener() {
                 @Override
                 public void onClick(View view) {
                     Intent i =new Intent(Login_Activity.this,MainActivity.class);
                     startActivity(i);
                 }
             });

    }
}
