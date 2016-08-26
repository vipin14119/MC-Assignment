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

import java.util.ArrayList;

public class CheatActivity extends AppCompatActivity {
    public int m_current_number;
    public int cheat_taken=-1;
    public static final String CHEAT_FLAG="Cheat taken flag";
    private static final String msg = "Android : ";
    private static final String CHEAT_TAKEN_FLAG="cheat taken flag to deal with rotation";


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(CHEAT_TAKEN_FLAG, cheat_taken);
        super.onSaveInstanceState(savedInstanceState);
    }
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
        if (savedInstanceState != null){
            TextView text_f2 = (TextView)findViewById(R.id.cheat_content);
            String res2 = "Can be Divided by 2 and 4";
            text_f2.setText(res2);
        }


    }
    public void reveal_cheat(View v){

        if (cheat_taken == 1){
            Toast.makeText(getApplicationContext(), "Cheat Already Revealed", Toast.LENGTH_SHORT).show();
        }
        else{
            cheat_taken = 1;
            TextView text_f = (TextView)findViewById(R.id.cheat_content);
            ArrayList<Integer> arr = get_factors();
            String res="Divisors are ";
            if (arr.size() > 0){
                for(int i:arr){
                    res+=", "+i;
                }
            }
            else{
                res = "There is no divisor of this number";
            }

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
    public ArrayList<Integer> get_factors(){
        ArrayList<Integer> arr = new ArrayList<>();
        for(int i=2;i<m_current_number;i++){
            if(m_current_number%i==0){
                arr.add(i);
            }
        }
        return arr;
    }
}
