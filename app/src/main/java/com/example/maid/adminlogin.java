package com.example.maid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class adminlogin extends AppCompatActivity {
    EditText e1,e2;
    Button b1;
    String username,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_log);



        b1=findViewById(R.id.button);
        e1=findViewById(R.id.editText);

        e2=findViewById(R.id.editText3);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                username=e1.getText().toString();
                password=e2.getText().toString();

                if (username.equalsIgnoreCase("satvik")&&password.equalsIgnoreCase("satvik123")){


                    Toast.makeText(adminlogin.this, "Welcome "+username, Toast.LENGTH_SHORT).show();
                    Intent i=new Intent(getApplicationContext(), adminHome.class);


                    startActivity(i);
                }else {

                    Toast.makeText(adminlogin.this, "invalid username or password", Toast.LENGTH_SHORT).show();

                }



            }
        });
    }

}
