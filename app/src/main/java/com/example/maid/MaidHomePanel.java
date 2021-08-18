package com.example.maid;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
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

public class MaidHomePanel extends AppCompatActivity {


    String password,username,age,mob,gender,state,city,locality,q1,q2,q3,q4,q5,q6,x,feedback;

    StringRequest req;
    TextView t1,t2;

    String url = "http://192.168.1.7:5460/maid/maidsearch.php";

    String url2 = "http://192.168.1.7:5460/maid/maidupdate.php";

    String url3 = "http://192.168.1.7:5460/maid/maiddelete.php";

    EditText e2, e3, e4,e5,e6,e7,e8,e9;

    Button b1, bu, bd, bh;

    CheckBox c1,c2,c3,c4,c5,c6;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maid_up_del);


        e2 = findViewById(R.id.editText2);
        e3 = findViewById(R.id.editText3);
        e4 = findViewById(R.id.editText4);
        e5 = findViewById(R.id.editText12);
        e6 = findViewById(R.id.editText9);
        e7 = findViewById(R.id.editText10);
        e8 = findViewById(R.id.editText13);
        e9 = findViewById(R.id.editText14);

        t1= findViewById(R.id.textView16);
        t2= findViewById(R.id.textView10);

        b1 = findViewById(R.id.button2);
        bu = findViewById(R.id.button5);
        bd = findViewById(R.id.button6);
        bh = findViewById(R.id.button3);

        c1=findViewById(R.id.checkBox7);
        c2=findViewById(R.id.checkBox8);
        c3=findViewById(R.id.checkBox9);
        c4=findViewById(R.id.checkBox10);
        c5=findViewById(R.id.checkBox11);
        c6=findViewById(R.id.checkBox12);



        Bundle b = getIntent().getExtras();
        x = b.getString("username");

        t1.setText("Showing records of "+x);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                direct();
            }

        });


        bu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (c1.isChecked())

                {
                    q1="Moping";

                }else {
                    q1="no moping" ;

                }


                if(c2.isChecked())
                {
                    q2=c2.getText().toString();

                }else {
                    q2="no dish washing";

                }




                if(c3.isChecked())
                {
                    q3=c3.getText().toString();

                }else {
                    q3="no brooming";

                }


                if(c4.isChecked())
                {
                    q4=c4.getText().toString();

                }else {
                    q4="no cloth washing";

                }



                if(c5.isChecked())
                {
                    q5=c5.getText().toString();

                }else {
                    q5="no cooking";

                }



                if(c6.isChecked())
                {
                    q6=c6.getText().toString();

                }else {
                    q6="no dusting";

                }

                update();

            }


        });


        bd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                delete();
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
                        password = pro.getString("password");
                        age = pro.getString("age");
                        mob = pro.getString("mob");
                        gender = pro.getString("gender");
                        state = pro.getString("state");
                        city = pro.getString("city");
                        locality = pro.getString("locality");
/*

                        q1 = pro.getString("q1");
                        q2 = pro.getString("q2");
                        q3 = pro.getString("q3");
                        q4 = pro.getString("q4");
                        q5 = pro.getString("q5");
                        q6 = pro.getString("q6");


*/
                       feedback=pro.getString("feedback");

                        Log.e("shafga",username);
                        Log.e("shafga",password);



                        if (x.equals(username)){

                            e2.setText(username);
                            e3.setText(password);
                            e4.setText(age);
                            e5.setText(mob);
                            e6.setText(gender);
                            e7.setText(state);
                            e8.setText(city);
                            e9.setText(locality);
                            t2.setText(feedback);

                            Toast.makeText(getApplicationContext(), "Showing Record Of: "+username, Toast.LENGTH_SHORT).show();


                        }



                    }

                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(MaidHomePanel.this, e.toString(), Toast.LENGTH_LONG).show();
                }
            }

        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MaidHomePanel.this,error.toString(), Toast.LENGTH_SHORT).show();

            }
        });
        Volley.newRequestQueue(getApplicationContext()).add(stringRequest);
    }



    private void delete()
    {


        username=x;
        RequestQueue que = Volley.newRequestQueue(MaidHomePanel.this);
        StringRequest str = new StringRequest(Request.Method.POST, url3, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                Toast.makeText(getApplicationContext(), "Account deleted sucessfully", Toast.LENGTH_SHORT).show();
                Intent i =new Intent(getApplicationContext(),MaidLogin.class);
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










    private void update()
    {

        username=x;
        password=e3.getText().toString();
        age=e4.getText().toString();
        mob=e5.getText().toString();
        gender=e6.getText().toString();
        state=e7.getText().toString();
        city=e8.getText().toString();
        locality=e9.getText().toString();


        RequestQueue que = Volley.newRequestQueue(MaidHomePanel.this);
        StringRequest str = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                Toast.makeText(getApplicationContext(), "Record Updated", Toast.LENGTH_SHORT).show();

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
                parm.put("password",password);
                parm.put("age",age);
                parm.put("mob",mob);
                parm.put("gender",gender);
                parm.put("state",state);
                parm.put("city",city);
                parm.put("locality",locality);
                parm.put("q1",q1);
                parm.put("q2",q2);
                parm.put("q3",q3);
                parm.put("q4",q4);
                parm.put("q5",q5);
                parm.put("q6",q6);



                return parm;
            }
        };

        que.add(str);



    }

}
