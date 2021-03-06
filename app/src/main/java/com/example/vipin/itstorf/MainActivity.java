package com.example.vipin.itstorf;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private static final String msg = "Android : ";
    private  int m_current_number;
    private static final String CURRENT_NUMBER="Current random number";
    public static final String HINT_NUMBER="Current hinted number";
    private boolean cheat_flag = false;
    private boolean hint_flag = false;


    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        savedInstanceState.putInt(CURRENT_NUMBER, m_current_number);
        super.onSaveInstanceState(savedInstanceState);
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(savedInstanceState != null){
            m_current_number = savedInstanceState.getInt(CURRENT_NUMBER);
        }
        else{
            Random r = new Random();
            m_current_number = r.nextInt(1000-1)+1;
        }
        print_number();
        Log.d(msg, "On Create Invoked");
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
    ///////////////////
    private void print_number(){
        final TextView field = (TextView)findViewById(R.id.number);
        String m_screen_value = m_current_number+"";
        if (field!=null){
            field.setText(m_screen_value);
        }

    }
    public void listen_false(View v){
        TextView screen = (TextView)findViewById(R.id.number);
        if (!isPrime()){
            Toast.makeText(getApplicationContext(), "Yes! You are Right", Toast.LENGTH_SHORT).show();
            if(screen!=null){
                screen.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_number_screen, null));
                screen.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white_text, null));
            }


        }
        else{
            Toast.makeText(getApplicationContext(), "Oops! you are wrong", Toast.LENGTH_SHORT).show();
            if (screen!=null){
                screen.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.wrong_number_screen, null));
                screen.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white_text, null));
            }

        }
        Random r = new Random();
        m_current_number = r.nextInt(1000-1)+1;
        print_number();
        cheat_flag = false;
        hint_flag = false;

    }
    public void listen_true(View v){
        TextView screen = (TextView)findViewById(R.id.number);
        if (isPrime()){
            Toast.makeText(getApplicationContext(), "Yes! You are Right", Toast.LENGTH_SHORT).show();
            if (screen!=null){
                screen.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.correct_number_screen, null));
                screen.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white_text, null));
            }

        }
        else{
            Toast.makeText(getApplicationContext(), "Oops! you are wrong", Toast.LENGTH_SHORT).show();
            if(screen!=null){
                screen.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.wrong_number_screen, null));
                screen.setTextColor(ResourcesCompat.getColor(getResources(), R.color.white_text, null));
            }

        }
        Random r = new Random();
        m_current_number = r.nextInt(1000-1)+1;
        print_number();
        cheat_flag = false;
        hint_flag = false;

    }
    public void listen_next(View v){
        TextView screen = (TextView)findViewById(R.id.number);
        if (screen!=null){
            screen.setBackground(ResourcesCompat.getDrawable(getResources(), R.drawable.number_screen, null));
            screen.setTextColor(ResourcesCompat.getColor(getResources(), R.color.light_font, null));
        }
        Random r = new Random();
        m_current_number = r.nextInt(1000-1)+1;
        print_number();
        cheat_flag = false;
        hint_flag = false;
    }
    //checks whether an int is prime or not.
    private boolean isPrime() {
        int n =m_current_number;
        if (n%2==0) return false;
        for(int i=3;i*i<=n;i+=2) {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public void take_hint(View v){
        if(!hint_flag){
            hint_flag = true;
            Intent intent = new Intent(this, HintActivity.class);
            intent.putExtra(HINT_NUMBER, m_current_number);
            startActivityForResult(intent, 1);
        }
        else{
            Toast.makeText(getApplicationContext(), "Hint Already Taken", Toast.LENGTH_SHORT).show();
        }

    }
    public void take_cheat(View v){
        if (!cheat_flag){
            Intent intent = new Intent(this, CheatActivity.class);
            intent.putExtra(HINT_NUMBER, m_current_number);
            startActivityForResult(intent, 2);
        }
        else{
            Toast.makeText(getApplicationContext(), "Cheat Already Taken", Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d(msg, "=============== ACTIVITY RESULT I CAME ================");
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK && requestCode == 2) {
            if(data != null){
                Log.d(msg, "=============== ACTIVITY RESULT ================");
                cheat_flag = data.getBooleanExtra(CheatActivity.CHEAT_FLAG, false);
                Log.d(msg, "=============== ACTIVITY RESULT ================"+ cheat_flag);
            }
            else{
                Log.d(msg, "=============== NULL ================");
            }
        }
    }

}
