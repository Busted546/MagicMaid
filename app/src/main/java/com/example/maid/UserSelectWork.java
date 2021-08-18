package com.example.maid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class UserSelectWork extends AppCompatActivity {
String x=" ",q1,q2,q3,q4,q5,q6;
TextView t1;
CheckBox c1, c2,c3,c4,c5,c6;
Button b1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_select_work);

        Bundle b=getIntent().getExtras();
        x=b.getString("locality");

        t1=findViewById(R.id.textView1);

        b1=findViewById(R.id.button5);
        c1=findViewById(R.id.checkBox13);
        c2=findViewById(R.id.checkBox14);
        c3=findViewById(R.id.checkBox15);
        c4=findViewById(R.id.checkBox16);
        c5=findViewById(R.id.checkBox17);
        c6=findViewById(R.id.checkBox18);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (c1.isChecked())

                {
                    q1=c1.getText().toString();

                }else {
                    q1=" " ;

                }


                if(c2.isChecked())
                {
                    q2=c2.getText().toString();

                }else {
                    q2=" ";

                }




                if(c3.isChecked())
                {
                    q3=c3.getText().toString();

                }else {
                    q3=" ";

                }


                if(c4.isChecked())
                {
                    q4=c4.getText().toString();

                }else {
                    q4=" ";

                }



                if(c5.isChecked())
                {
                    q5=c5.getText().toString();

                }else {
                    q5=" ";

                }



                if(c6.isChecked())
                {
                    q6=c6.getText().toString();

                }else {
                    q6=" ";

                }

                Intent i=new Intent(getApplicationContext(),user_search.class);
                i.putExtra("q1",q1);
                i.putExtra("q2",q2);
                i.putExtra("q3",q3);
                i.putExtra("q4",q4);
                i.putExtra("q5",q5);
                i.putExtra("q6",q6);
                i.putExtra("locality",x);
                startActivity(i);



            }
        });


        t1.setText("Your Selected Location is "+x);






    }
}
