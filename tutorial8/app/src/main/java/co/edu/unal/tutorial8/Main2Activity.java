package co.edu.unal.tutorial8;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private TextView tv1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv1 = (TextView)findViewById(R.id.tvNombre2);


        String dato = getIntent().getStringExtra("nombreFormulario");
        tv1.setText("hi "+ dato);

    }

    public void volver(View v){
        Intent atras = new Intent(this, MainActivity.class);
        startActivity(atras);
    }
}
