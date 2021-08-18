package com.example.maid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class user_reg extends AppCompatActivity {
EditText e1,e2,e3,e4;
Button b1,b2;
    String url = "http://192.168.1.7:5460/maid/index.php";
    String name, pass, email,cont;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_reg);
        e1=findViewById(R.id.editText);
        e2=findViewById(R.id.editText2);
        e3=findViewById(R.id.editText3);
        e4=findViewById(R.id.editText4);
        b2=findViewById(R.id.button2);
        b1=findViewById(R.id.button);

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getApplicationContext(),user_log.class);
                startActivity(in);

            }
        });
b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        yolo();
    }


});


}
    public void yolo()
    {
        name = e1.getText().toString();
        pass = e3.getText().toString();
        email = e2.getText().toString();
        cont=e4.getText().toString();

        RequestQueue que = Volley.newRequestQueue(user_reg.this);
        StringRequest str = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                if (name.equals("") || pass.equals("") || email.equals("") || cont.equals(""))
                {
                    Toast.makeText(getApplicationContext(), "please fill all the fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(getApplicationContext(), "Record Added", Toast.LENGTH_SHORT).show();

                    e1.setText("");
                    e2.setText("");
                    e3.setText("");
                    e4.setText("");

                }
            }
        }, new Response.ErrorListener(){
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
        )
        {
            protected Map<String,String> getParams() throws AuthFailureError {
                Map<String,String> parm= new HashMap<>();
                parm.put("name",name);
                parm.put("password",pass);
                parm.put("email",email);
                parm.put("contact",cont);
                return parm;
            }
        };

        que.add(str);

    }


    }


