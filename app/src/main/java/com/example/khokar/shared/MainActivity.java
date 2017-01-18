package com.example.khokar.shared;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText uname,pass;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uname=(EditText) findViewById(R.id.username);
        pass=(EditText) findViewById(R.id.password);
        btn=(Button) findViewById(R.id.btn);
        tv= (TextView) findViewById(R.id.Signup);
        final Database db = new Database(this);


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String userValue = uname.getText().toString();
                String passValue = pass.getText().toString();
                boolean accountMatch = db.validateUser(userValue,passValue);
                if(accountMatch){

                    SharedPreferences sp = getSharedPreferences("mubeen", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("U",userValue);
                    editor.putString("P",passValue);
                    editor.apply();

                    Toast.makeText(getApplicationContext(),"Sessions Saved",Toast.LENGTH_SHORT).show();
                    Intent toSuc = new Intent(MainActivity.this, Login.class);
                    startActivity(toSuc);
                }
                else if(userValue.equals("") && passValue.equals("")){
                    Toast.makeText(MainActivity.this,"Fields Empty", Toast.LENGTH_SHORT).show();
                }

                else{Toast.makeText(MainActivity.this, "Invalid Username or Password", Toast.LENGTH_SHORT).show();}
            }
        });
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i = new Intent(MainActivity.this,Signup.class);
                startActivity(i);
            }
        });


    }
}
