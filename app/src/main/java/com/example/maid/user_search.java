package com.example.maid;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class user_search extends AppCompatActivity {
TextView t1;
String x,aa,bb,cc,dd,ee,ff;
String username,q1,q2,q3,q4,q55,q6;
    private static final String url = "http://192.168.1.7:5460/maid/finalmaidlist.php";

    SearchUserAdapter2 adapter;


    RecyclerView recycler1;
    List<SearchUserData2> dataList;
    RecyclerView.LayoutManager layoutManager1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.user_search);

        t1=findViewById(R.id.textView4);
        recycler1 = findViewById(R.id.recycler1);

        Bundle b=getIntent().getExtras();

        aa=b.getString("q1");
        bb=b.getString("q2");
        cc=b.getString("q3");
        dd=b.getString("q4");
        ee=b.getString("q5");
        ff=b.getString("q6");
        x=b.getString("locality");

        t1.setText("Your Selected  Maids for "+aa+" "+bb+" "+cc+" "+dd+" "+ee+" "+ff+" at "+x+" are Below -");



        layoutManager1 = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler1.setLayoutManager(layoutManager1);


        loadData();


    }



    public void loadData() {


        StringRequest stringRequest;
        stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    dataList = new ArrayList<>();

                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject pro = array.getJSONObject(i);

                        SearchUserData2 data=new SearchUserData2();

                        username = pro.getString("username");

                        q1 = pro.getString("q1");
                        q2 = pro.getString("q2");
                        q3 = pro.getString("q3");
                        q4 = pro.getString("q4");
                        q55 = pro.getString("q5");
                        q6 = pro.getString("q6");

                        data.setUsername(username);

                        dataList.add(data);


                    }





     adapter = new SearchUserAdapter2(dataList, getApplicationContext());
     recycler1.setAdapter(adapter);










                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(user_search.this, "Error", Toast.LENGTH_SHORT).show();
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
