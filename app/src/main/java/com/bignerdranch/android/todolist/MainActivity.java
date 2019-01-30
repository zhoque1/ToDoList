package com.bignerdranch.android.todolist;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;


import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ArrayList<String> do_list = new ArrayList<String>();

        final EditText text = (EditText) findViewById(R.id.editText);

        ListView lv = (ListView) findViewById(R.id.listView);
        final ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, do_list);

        lv.setAdapter(adapter);

        text.setOnKeyListener(new View.OnKeyListener() {

            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                // TODO Auto-generated method stub
                if (event.getAction() == KeyEvent.ACTION_DOWN) {
                    if ((keyCode == KeyEvent.KEYCODE_DPAD_CENTER)
                            || (keyCode == KeyEvent.KEYCODE_ENTER)) {
                        do_list.add(0, text.getText().toString());
                        adapter.notifyDataSetChanged();
                        text.setText("");
                        return true;
                    }
                }
                return false;
            }
        });

        // Next Activity
        Button nextActivity = (Button) findViewById(R.id.secondActivity);
        nextActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }
}
