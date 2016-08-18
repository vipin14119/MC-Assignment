package com.example.vipin.itstorf;

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
        field.setText(m_screen_value);
    }
    public void listen_false(){
        if (!isPrime()){
            Toast.makeText(getApplicationContext(), "Yes! You are Right", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Oops! you are wrong", Toast.LENGTH_SHORT).show();
        }
        Random r = new Random();
        m_current_number = r.nextInt(1000-1)+1;
        print_number();

    }
    public void listen_true(){
        if (isPrime()){
            Toast.makeText(getApplicationContext(), "Yes! You are Right", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(getApplicationContext(), "Oops! you are wrong", Toast.LENGTH_SHORT).show();
        }
        Random r = new Random();
        m_current_number = r.nextInt(1000-1)+1;
        print_number();

    }
    public void listen_next(){
//        Toast.makeText(getApplicationContext(), "You Clicked Next", Toast.LENGTH_LONG).show();
        Random r = new Random();
        m_current_number = r.nextInt(1000-1)+1;
        print_number();
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

}
