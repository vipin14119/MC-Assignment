package com.example.vipin.itstorf;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
public class Hint_Activity extends AppCompatActivity {
    private static final String msg = "Android : ";
    private int m_current_number;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hint_);

        Intent intent = getIntent();
        m_current_number = intent.getIntExtra(MainActivity.HINT_NUMBER, 0);
        TextView text_f =  (TextView)findViewById(R.id.hint_content);
        String res = m_current_number + "";
        text_f.setText(res);
    }
    @Override
    public void onStart(){
        super.onStart();
        Log.d(msg, " OnStart invoked");

    }

    @Override
    public void onResume(){
        super.onResume();
        Log.d(msg, " OnResume invoked");
    }

    @Override
    public void onPause(){
        super.onPause();
        Log.d(msg, " OnPause invoked");
    }

    @Override
    public void onStop(){
        super.onStop();
        Log.d(msg, " OnStop invoked");
    }


    @Override
    public void onDestroy(){
        super.onDestroy();
        Log.d(msg, " OnDestroy invoked");
    }

}
