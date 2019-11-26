package co.edu.unal.tutorial6;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void mensaje(View v){

        Toast.makeText(this, "Esto es un cerdo", Toast.LENGTH_LONG).show();
    }
    public void mensaje2(View v){

        Toast.makeText(this, "Esto es una vaca", Toast.LENGTH_LONG).show();
    }
}
