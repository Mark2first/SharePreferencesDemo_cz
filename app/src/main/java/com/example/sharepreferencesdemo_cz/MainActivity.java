package com.example.sharepreferencesdemo_cz;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    SharedPreferences mySharedPreferences;
    Button saveButton;
    EditText editName,editPassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editName = (EditText) findViewById(R.id.editName);
        editPassword = (EditText) findViewById(R.id.editPassword);
        saveButton = (Button) findViewById(R.id.button1);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mySharedPreferences = getSharedPreferences("userInfo", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = mySharedPreferences.edit();
                editor.putString("username",editName.getText().toString());
                editor.putString("password",editPassword.getText().toString());
                editor.commit();
                Toast.makeText(MainActivity.this,"写入SharedPreferences成功！",Toast.LENGTH_SHORT).show();
            }
        });
        mySharedPreferences = getSharedPreferences("userInfo",Context.MODE_PRIVATE);
        String username = mySharedPreferences.getString("username","");
        String password = mySharedPreferences.getString("password","");
        editName.setText(username);
        editPassword.setText(password);
    }
}