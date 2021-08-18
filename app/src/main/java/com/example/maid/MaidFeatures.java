package com.example.maid;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class MaidFeatures extends AppCompatActivity {
    String x;
    TextView t2, t3, t4, t5, t6, t7, t8, t9;
    Button b1, b2, b3, b4;
    String url = "http://192.168.1.7:5460/maid/maidsearch2.php";
    String username, age, mob, gender, state, city, locality, q1, q2, q3, q4, q5, q6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_maid_features);

        t2 = findViewById(R.id.textView11);


        b1 = findViewById(R.id.button9);
        b2 = findViewById(R.id.button10);
        b3 = findViewById(R.id.button11);
        b4 = findViewById(R.id.button12);


        t3 = findViewById(R.id.textView3);
        t4 = findViewById(R.id.textView4);
        t5 = findViewById(R.id.textView5);
        t6 = findViewById(R.id.textView6);
        t7 = findViewById(R.id.textView7);
        t8 = findViewById(R.id.textView8);
        t9 = findViewById(R.id.textView9);


        Bundle b = getIntent().getExtras();
        x = b.getString("data");

        t2.setText("Showing Record of " + x);
        direct();


        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String z = "satvikpaderiya@gmail.com";
                Intent i = new Intent(Intent.ACTION_SEND);
                i.putExtra(Intent.EXTRA_EMAIL, new String[]{z});

                i.putExtra(Intent.EXTRA_SUBJECT, "Need to complain regarding " + x);
                i.putExtra(Intent.EXTRA_TEXT, "**your complain here**");
                i.setType("message/rfc822");
                startActivity(i);


            }

        });


        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent i = new Intent(getApplicationContext(), user_log.class);
                startActivity(i);


            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("MissingPermission")
            @Override
            public void onClick(View v) {

                Toast.makeText(getApplicationContext(), "calling to " + x, Toast.LENGTH_SHORT).show();
                Intent i = new Intent(Intent.ACTION_CALL);
                i.setData(Uri.parse("tel:" + mob));
                startActivity(i);




    }
});




        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(getApplicationContext(),Feedback.class);
                i.putExtra("username",x);
                startActivity(i);


            }
        });

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



                        if (x.equals(username)){

                            t3.setText(username);
                            t4.setText(age);
                            t5.setText(mob);
                            t6.setText(gender);
                            t7.setText(state);
                            t8.setText(city);
                            t9.setText(locality);

                            Toast.makeText(getApplicationContext(), "Showing Record Of: "+x, Toast.LENGTH_SHORT).show();


                        }



                    }

                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(MaidFeatures.this, "Error", Toast.LENGTH_SHORT).show();
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
