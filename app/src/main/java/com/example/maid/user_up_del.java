package com.example.maid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

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

public class user_up_del extends AppCompatActivity {

    String name, email, pass,cont, username;
    String x;
    StringRequest req;
    EditText e1,e2,e3,e4;
    Button b1,b2,b3,b4;
    String durl = "http://192.168.1.7:5460/maid/delete.php";
    String surl = "http://192.168.1.7:5460/maid/search.php";
    String uurl = "http://192.168.1.7:5460/maid/update.php";
    TextView t1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_up_del);


        e1=findViewById(R.id.editText2);
        e2=findViewById(R.id.editText3);
        e3=findViewById(R.id.editText4);
        e4=findViewById(R.id.editText5);
        t1=findViewById(R.id.textView2);

        b1=findViewById(R.id.button2);
        b2=findViewById(R.id.button5);
        b3=findViewById(R.id.button6);
        b4=findViewById(R.id.button3);


        Bundle b = getIntent().getExtras();
         x = b.getString("yoy");
        t1.setText("Welcome " + x);

        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getApplicationContext(),user_after_log.class);
                startActivity(in);
            }
        });

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                direct();

            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               delete();
            }
        });

b2.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        update();
    }
});

    }


    private void direct() {




        RequestQueue que= Volley.newRequestQueue(user_up_del.this);
        req=new StringRequest(Request.Method.GET, surl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONArray js=new JSONArray(response);
                    for(int i=0;i<js.length();i++) {
                        JSONObject ob = js.getJSONObject(i);

                        name=ob.getString("name");
                        pass=ob.getString("password");
                        email=ob.getString("email");
                        cont=ob.getString("contact");

                        if (x.equals(name) ) {

                            e1.setText(name);
                            e2.setText(pass);
                            e3.setText(email);
                            e4.setText(cont);
                            Toast.makeText(getApplicationContext(), "Record Found of "+x, Toast.LENGTH_SHORT).show();
                        }
                    }}
                catch(JSONException e)
                {


                    Toast.makeText(getApplicationContext(), "Error ahh", Toast.LENGTH_SHORT).show();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
        que.add(req);
    }


    private void delete()
    {
        name=x;
        RequestQueue que = Volley.newRequestQueue(user_up_del.this);
        StringRequest str = new StringRequest(Request.Method.POST, durl, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                Toast.makeText(getApplicationContext(), "Record Deleted successfully", Toast.LENGTH_SHORT).show();
                Intent in= new Intent(getApplicationContext(),user_log.class);
                startActivity(in);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(getApplicationContext(), "Error", Toast.LENGTH_SHORT).show();
            }
        }
        ){
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> parm = new HashMap<>();
                parm.put("name", name);

                return parm;
            }
        };
        que.add(str);



    }

    private void update()
    {


        name=e1.getText().toString();
        pass=e2.getText().toString();
        email=e3.getText().toString();
        cont=e4.getText().toString();

        RequestQueue que = Volley.newRequestQueue(user_up_del.this);
        StringRequest str = new StringRequest(Request.Method.POST, uurl, new Response.Listener<String>() {
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
