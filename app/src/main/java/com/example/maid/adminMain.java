package com.example.maid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class adminMain extends AppCompatActivity {
TextView t2,t3,t4,t5,t6,t7,t8,t9,t10,t11,t12,t13,t14,t15;
    String x;
    String username, age, mob, gender,state,city,locality,q1,q2,q3,q4,q5,q6;
    String url = "http://192.168.1.7:5460/maid/maidsearch2.php";
    String url3 = "http://192.168.1.7:5460/maid/maiddelete.php";
Button b1,b2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_main);
b1=findViewById(R.id.button2);
b2=findViewById(R.id.button7);
        t3=findViewById(R.id.textView3);
        t2=findViewById(R.id.textView2);

        t4=findViewById(R.id.textView4);
        t5=findViewById(R.id.textView5);
        t6=findViewById(R.id.textView6);
        t7=findViewById(R.id.textView7);
        t8=findViewById(R.id.textView8);
        t9=findViewById(R.id.textView9);
        t10=findViewById(R.id.textView10);
        t11=findViewById(R.id.textView11);
        t12=findViewById(R.id.textView12);
        t13=findViewById(R.id.textView13);
        t14=findViewById(R.id.textView14);
        t15=findViewById(R.id.textView15);

    Bundle b=getIntent().getExtras();
     x=b.getString("data");

        t2.setText("Details of "+x);
        Toast.makeText(this, x, Toast.LENGTH_SHORT).show();

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                direct();

            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                delete();

            }
        });

    }


    private void delete()
    {


        username=x;
        RequestQueue que = Volley.newRequestQueue(adminMain.this);
        StringRequest str = new StringRequest(Request.Method.POST, url3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                Toast.makeText(getApplicationContext(), "Account deleted", Toast.LENGTH_SHORT).show();
                Intent i =new Intent(getApplicationContext(), adminHome.class);
                startActivity(i);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {


                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();

            }
        }
        )
        {
            protected Map<String,String> getParams() throws AuthFailureError {

                Map<String,String> parm= new HashMap<>();

                parm.put("username",username);

                return parm;
            }
        };

        que.add(str);



    }





    public void direct(){


        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.GET, url,new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {


                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject pro = array.getJSONObject(i);

                        username = pro.getString("username");
                        age = pro.getString("age");
                        mob = pro.getString("mob");
                        gender = pro.getString("gender");
                        state = pro.getString("state");
                        city = pro.getString("city");
                        locality = pro.getString("locality");
                        q1 = pro.getString("q1");
                        q2 = pro.getString("q2");
                        q3 = pro.getString("q3");
                        q4 = pro.getString("q4");
                        q5 = pro.getString("q5");
                        q6 = pro.getString("q6");





                        if (x.equals(username)){

                            t3.setText(username);
                            t4.setText(age);
                            t5.setText(mob);
                            t6.setText(gender);
                            t7.setText(state);
                            t8.setText(city);
                            t9.setText(locality);
                            t10.setText(q1);
                            t11.setText(q2);
                            t12.setText(q3);
                            t13.setText(q4);
                            t14.setText(q5);
                            t15.setText(q6);


                            Toast.makeText(getApplicationContext(), "Showing Record Of: "+x, Toast.LENGTH_SHORT).show();


                        }



                    }

                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(adminMain.this, "Error", Toast.LENGTH_SHORT).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }



}
