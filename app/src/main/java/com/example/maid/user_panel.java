package com.example.maid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class user_panel extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
TextView t1;
Spinner sp1,sp2,sp3;
Button b1;
    String x;
    ArrayAdapter aa,aa1, aa2,aa3,aa4,aa5,aa6;

    String state[] = {"madhya pradesh", "maharastra", "new delhi"};

    String city1[] = {"bhopal", "indore"};
    String city2[] = {"mumbai", "pune"};
    String city3[] = {"central delhi", "ncr"};

    String bhopallocal[] = {"kolar road", "mp nagar"};
    String indorelocal[] = {"vmart", "sarafa market"};
    String mumbailocal[] = {"marnine drive ", "lonavla"};
    String punelocal[] = {"it park", "singhgargh"};
    String cdelhilocal[] = {"Connaught Place", "Hauz Khas"};
    String ndelhilocal[] = {"gurugram", "noida"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_panel);

        t1=findViewById(R.id.textView4);
        sp1=findViewById(R.id.spinner);
        sp2=findViewById(R.id.spinner2);
        sp3=findViewById(R.id.spinner3);
        b1=findViewById(R.id.button5);



        Bundle b = getIntent().getExtras();
        x = b.getString("yo");
        t1.setText("Welcome " + x);





        sp1.setOnItemSelectedListener(this);

        aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item, state);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp1.setAdapter(aa);



    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        final String select = (String) aa.getItem(position);

        if (select.equals("madhya pradesh")) {


            aa1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, city1);
            aa1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(aa1);

            sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view,  int position, long id) {

                    String q = (String) aa1.getItem(position);

                    if (q.equals("bhopal")) {

                        aa2 = new ArrayAdapter ( user_panel.this,android.R.layout.simple_spinner_dropdown_item,bhopallocal);
                        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp3.setAdapter(aa2);

                        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {



                                b1.setOnClickListener(new View.OnClickListener() {
                                    String x= (String) aa2.getItem(position);

                                    @Override
                                    public void onClick(View v) {

                                        Intent i = new Intent(getApplicationContext(), UserSelectWork.class);
                                        i.putExtra("locality", x);
                                        startActivity(i);
                                    }

                                });


                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });

                    }



                    else if (q.equals("indore")){


                        aa2 = new ArrayAdapter ( user_panel.this,android.R.layout.simple_spinner_dropdown_item,indorelocal);
                        aa2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp3.setAdapter(aa2);


                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });





        }


            else if (select.equals("maharastra"))
            {
            aa4 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, city2);
            aa4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(aa4);


            sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String q = (String) aa4.getItem(position);





                    if (q.equals("mumbai")) {



                        aa5 = new ArrayAdapter ( user_panel.this,android.R.layout.simple_spinner_dropdown_item,mumbailocal);
                        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp3.setAdapter(aa5);


                        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {


                                b1.setOnClickListener(new View.OnClickListener() {
                                    String x= (String) aa5.getItem(position);

                                    @Override
                                    public void onClick(View v) {

                                        Intent i = new Intent(getApplicationContext(), UserSelectWork.class);
                                        i.putExtra("locality", x);
                                        startActivity(i);
                                    }

                                });

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });




                    }else if (q.equals("pune")){


                        aa5 = new ArrayAdapter ( user_panel.this,android.R.layout.simple_spinner_dropdown_item,punelocal);
                        aa5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp3.setAdapter(aa5);



                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }


        else if (select.equals("new delhi"))
        {
            aa3 = new ArrayAdapter(this, android.R.layout.simple_spinner_item, city3);
            aa3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            sp2.setAdapter(aa3);


            sp2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                @Override
                public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                    String q = (String) aa3.getItem(position);





                    if (q.equals("central delhi")) {



                        aa6 = new ArrayAdapter ( user_panel.this,android.R.layout.simple_spinner_dropdown_item,cdelhilocal);
                        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp3.setAdapter(aa6);


                        sp3.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                            @Override
                            public void onItemSelected(AdapterView<?> parent, View view, final int position, long id) {


                                b1.setOnClickListener(new View.OnClickListener() {
                                    String x= (String) aa6.getItem(position);

                                    @Override
                                    public void onClick(View v) {

                                        Intent i = new Intent(getApplicationContext(), UserSelectWork.class);
                                        i.putExtra("locality", x);
                                        startActivity(i);
                                    }

                                });

                            }

                            @Override
                            public void onNothingSelected(AdapterView<?> parent) {

                            }
                        });




                    }else if (q.equals("ncr")){


                        aa6 = new ArrayAdapter ( user_panel.this,android.R.layout.simple_spinner_dropdown_item,ndelhilocal);
                        aa6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
                        sp3.setAdapter(aa6);



                    }

                }

                @Override
                public void onNothingSelected(AdapterView<?> parent) {

                }
            });

        }
    }


@Override
public void onNothingSelected(AdapterView<?> parent) {

    }



}
