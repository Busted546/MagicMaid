package com.example.maid;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class front extends AppCompatActivity {
Button b1,b2,b3;
TextView t1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.front);


        b1=findViewById(R.id.button);
        b2=findViewById(R.id.button2);
        b3=findViewById(R.id.button3);
        t1=findViewById(R.id.textView13);
        String text="By using this application, you agree to the Terms of use and Privacy Policy ";

        SpannableString ss= new SpannableString(text);
        final ClickableSpan click1= new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {

                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://192.168.1.7:5460/terms_and_conditions.html"));
                startActivity(viewIntent);
            }
        };
        ClickableSpan click2= new ClickableSpan() {
            @Override
            public void onClick(@NonNull View widget) {
                Intent viewIntent = new Intent("android.intent.action.VIEW", Uri.parse("http://192.168.1.7:5460/privacy_policy.html"));
                startActivity(viewIntent);
            }
        };

        ss.setSpan(click1,44,56, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        ss.setSpan(click2,61,75, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        t1.setText(ss);
        t1.setMovementMethod(LinkMovementMethod.getInstance());

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getApplicationContext(),user_log.class);
                startActivity(in);
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getApplicationContext(),MaidLogin.class);
                startActivity(in);
            }
        });
        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in= new Intent(getApplicationContext(), adminlogin.class);
                startActivity(in);
            }
        });


    }
}
