package com.example.maid;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
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

public class adminHome extends AppCompatActivity {
    String username;
    Button b1;
    TextView t1;


    SearchUserAdapter adapter;
    RecyclerView recycler;
    List<SearchUserData> dataList;
    RecyclerView.LayoutManager layoutManager;






    String url = "http://192.168.1.7:5460/maid/maidlist.php";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.admin_home);


        recycler = findViewById(R.id.recycler);

        layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recycler.setLayoutManager(layoutManager);



        t1=findViewById(R.id.textView17);
        b1=findViewById(R.id.button);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                loadData();


            }
        });
    }


    public void loadData() {


        StringRequest stringRequest = new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {

                    dataList =new ArrayList<>();

                    JSONArray array = new JSONArray(response);
                    for (int i = 0; i < array.length(); i++) {
                        JSONObject pro = array.getJSONObject(i);

                        SearchUserData data = new SearchUserData();

                        username = pro.getString("username");
                        data.setShopname(username);

                        dataList.add(data);


                    }

                    adapter = new SearchUserAdapter(dataList, getApplicationContext());
                    recycler.setAdapter(adapter);


                } catch (JSONException e) {

                    e.printStackTrace();
                    Toast.makeText(adminHome.this, "Error", Toast.LENGTH_SHORT).show();
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
