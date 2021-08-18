package com.example.maid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
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

public class Feedback extends AppCompatActivity {
String x,username,feedback;
EditText e1;
Button b1;
    String url2 = "http://192.168.1.7:5460/maid/maidfeedback.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);

        e1=findViewById(R.id.editText15);
        b1=findViewById(R.id.button12);

Bundle b=getIntent().getExtras();
x=b.getString("username");


b1.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {


        update();
    }
});










    }





    private void update()
    {

        username=x;
        feedback=e1.getText().toString();

        RequestQueue que = Volley.newRequestQueue(Feedback.this);
        StringRequest str = new StringRequest(Request.Method.POST, url2, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {



                Toast.makeText(getApplicationContext(), "Feedback Posted Successfully!", Toast.LENGTH_SHORT).show();
                e1.setText("");
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

                parm.put("feedback",feedback);

                return parm;
            }
        };

        que.add(str);



    }






}
