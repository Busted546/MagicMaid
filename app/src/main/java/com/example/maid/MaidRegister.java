package com.example.maid;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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

import java.util.HashMap;
import java.util.Map;

public class MaidRegister extends AppCompatActivity {

    EditText e1, e2, e3, e4, e5, e6,e7,e8,e9;
    Button b1,b2;
    String username,password,cpassword,age,adhar,mob, gender=null ,state,city,locality,q1,q2,q3,q4,q5,q6,f="";
    private static final String url = "http://192.168.1.7:5460/maid/maidreg.php";
    ProgressDialog dialog;
    CheckBox c1,c2,c3,c4,c5,c6;
    RadioButton r1;
    RadioGroup radio;

     TextView t1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.maid_register);



        e1 = findViewById(R.id.editText);
        t1 = findViewById(R.id.textView6);

        e2 = findViewById(R.id.editText3);
        e3 = findViewById(R.id.editText4);
        e4 = findViewById(R.id.editText11);
        e5 = findViewById(R.id.editText5);
        e6 = findViewById(R.id.editText6);

        b1 = findViewById(R.id.button4);
        b2 = findViewById(R.id.button5);

        e7 = findViewById(R.id.editText2);
        e8 = findViewById(R.id.editText7);
        e9 = findViewById(R.id.editText8);

        radio=(RadioGroup)findViewById(R.id.radio);


        c1=findViewById(R.id.checkBox);
        c2=findViewById(R.id.checkBox2);
        c3=findViewById(R.id.checkBox3);
        c4=findViewById(R.id.checkBox4);
        c5=findViewById(R.id.checkBox5);
        c6=findViewById(R.id.checkBox6);



        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i =new Intent(getApplicationContext(),MaidLogin.class);
                startActivity(i);

            }
        });





        b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        if (c1.isChecked())

        {
            q1=c1.getText().toString();

        }else {
            q1="-" ;

        }


        if(c2.isChecked())
        {
            q2=c2.getText().toString();

        }else {
            q2="-";

        }




        if(c3.isChecked())
        {
            q3=c3.getText().toString();

        }else {
            q3="-";

        }


        if(c4.isChecked())
        {
            q4=c4.getText().toString();

        }else {
            q4="-";

        }



        if(c5.isChecked())
        {
            q5=c5.getText().toString();

        }else {
            q5="-";

        }



        if(c6.isChecked())
        {
            q6=c6.getText().toString();

        }else {
            q6="-";

        }
reguser();

    }
});


    }




    public void reguser() {



        int selectedId= radio.getCheckedRadioButtonId();
        r1=findViewById(selectedId);

        String selection= r1.getText().toString();

        if(selection.equalsIgnoreCase("male"))

        {

            gender="male";

        }
        else {

           gender="female";


        }



        dialog=new ProgressDialog(this);
        dialog.setTitle("Register");
        dialog.setMessage("please wait....");
        dialog.show();


        username = e1.getText().toString();
        password = e2.getText().toString();
        cpassword = e3.getText().toString();
        age = e4.getText().toString();
        adhar = e5.getText().toString();
        mob = e6.getText().toString();
        state = e7.getText().toString();
        city = e8.getText().toString();
        locality = e9.getText().toString();



        RequestQueue queue = Volley.newRequestQueue(MaidRegister.this);
        StringRequest stringRequest = new StringRequest(Request.Method.POST, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Toast.makeText(getApplicationContext(), "recorded added", Toast.LENGTH_LONG).show();


                e1.setText("");
                e2.setText("");
                e3.setText("");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                e7.setText("");
                e8.setText("");
                e9.setText("");


                dialog.dismiss();
            }
        },

                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                        t1.setText(error.toString());
                        Toast.makeText(MaidRegister.this,error.toString(), Toast.LENGTH_SHORT).show();
                        dialog.dismiss();
                    }
                }) {
            protected Map<String,String> getParams() throws AuthFailureError {

                Map<String,String> params = new HashMap<>();

                params.put("username",username);
                params.put("password",password);
                params.put("age",age);
                params.put("adhar",adhar);
                params.put("mob",mob);
                params.put("gender",gender);
                params.put("state",state);
                params.put("city",city);
                params.put("locality",locality);

                params.put("q1",q1);
                params.put("q2",q2);
                params.put("q3",q3);
                params.put("q4",q4);
                params.put("q5",q5);
                params.put("q6",q6);
                params.put("feedback",f);


                return params;

            }
        };

        queue.add(stringRequest);


    }

 }
