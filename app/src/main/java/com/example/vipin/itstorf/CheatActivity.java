package com.example.vipin.itstorf;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.TextView;

public class CheatActivity extends AppCompatActivity {
    public int m_current_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cheat);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        TextView text_f = (TextView)findViewById(R.id.cheat_number);
        m_current_number = getIntent().getIntExtra(MainActivity.HINT_NUMBER, 0);
        String res = m_current_number + "";
        text_f.setText(res);
    }

}
