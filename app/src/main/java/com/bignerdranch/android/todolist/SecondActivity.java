package com.bignerdranch.android.todolist;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends Activity {
    @Override
    protected void onCreate( Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Button btnShowAlert = (Button) findViewById(R.id.showAlert);
        btnShowAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AlertDialog.Builder builder = new AlertDialog.Builder(SecondActivity.this);

                //this is for alert
                builder.setTitle(R.string.alert_title);
                builder.setPositiveButton(R.string.ok, null);
                builder.setMessage(R.string.alert_message);

                AlertDialog alertDialog = builder.create();
                alertDialog.show();
            }
        });
    }
}
