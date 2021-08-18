package com.example.maid;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class user_log extends AppCompatActivity {
EditText us,pa;
    String url = "http://192.168.1.7:5460/maid/fetch.php";
String name,pass,x,y;
    StringRequest req;
Button log,reg;
int flag=0;
    ProgressDialog dialog;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_log);

        us=findViewById(R.id.editText);
        pa=findViewById(R.id.editText3);
        log=findViewById(R.id.button);
        reg=findViewById(R.id.button2);



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getApplicationContext(),user_reg.class);
                startActivity(in);
            }
        });
log.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        name=us.getText().toString().trim();
        pass=pa.getText().toString().trim();
        reuse();
    }


});

    }

    public void reuse()
    {

        dialog=new ProgressDialog(this);
        dialog.setMessage("please wait......");
        dialog.setTitle("Login");
        dialog.show();
        RequestQueue que= Volley.newRequestQueue(user_log.this);
        req=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {


                try {
                    JSONArray js=new JSONArray(response);
                    for(int i=0;i<js.length();i++)
                    {
                        JSONObject ob = js.getJSONObject(i);

                        x = ob.getString("name");
                        y = ob.getString("password");


                            if (name.equals(x) && pass.equals(y))
                            {
                                flag=1; break;
                            }
                        }

                    if(flag == 1)
                    {
                        Intent in = new Intent(getApplicationContext(), user_after_log.class);
                        in.putExtra("name", name);
                        startActivity(in);
                        dialog.dismiss();
                        Toast.makeText(getApplicationContext(), "Redirecting..", Toast.LENGTH_SHORT).show();


                    }
                    else
                    {
                        Toast.makeText(getApplicationContext(), "invalid username/password", Toast.LENGTH_SHORT).show();
                    }


                }

                catch(JSONException e)
                {
                    e.printStackTrace();
                    dialog.dismiss();
                    Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                dialog.dismiss();

            }
        });
        que.add(req);
    }




}

