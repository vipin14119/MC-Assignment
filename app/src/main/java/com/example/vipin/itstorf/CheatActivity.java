package com.example.vipin.itstorf;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class CheatActivity extends AppCompatActivity {
    public int m_current_number;
    public boolean cheat_taken=false;
    public static final String CHEAT_FLAG="Cheat taken flag";
    private static final String msg = "Android : ";
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
    public void reveal_cheat(View v){

        if (cheat_taken){
            Toast.makeText(getApplicationContext(), "Cheat Already Revealed", Toast.LENGTH_SHORT).show();
        }
        else{
            cheat_taken = true;
            TextView text_f = (TextView)findViewById(R.id.cheat_content);
            String res = "Can be Divided by 2 and 4";
            text_f.setText(res);

        }

    }
    @Override
    public void onBackPressed(){
        Log.d(msg, "=============== BACK BUTTON PRESSED ================");
        Intent intent = new Intent(this, CheatActivity.class);
        intent.putExtra(CHEAT_FLAG, true);
        setResult(RESULT_OK, intent);
        finish();
    }
}
