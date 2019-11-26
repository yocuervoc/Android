package co.edu.unal.tutorial7;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class SegundoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segundo);
    }

    public void Anterior(View v){
        Intent anterior = new Intent(this, MainActivity.class);
        startActivity(anterior);
    }
}
