package com.androidtutorialpoint.androidviewpagerexample.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.androidtutorialpoint.androidviewpagerexample.R;

public class Sign_Up extends AppCompatActivity {
      Button register;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign__up);
        register= (Button) findViewById(R.id.btRgister);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i =new Intent(Sign_Up.this,Login_Activity.class);
                startActivity(i);
            }
        });
    }
}
