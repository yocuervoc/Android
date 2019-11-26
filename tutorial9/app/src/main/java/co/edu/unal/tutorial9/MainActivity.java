package co.edu.unal.tutorial9;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.url);
    }

    public void Navegar(View view){
        Intent ir = new Intent(this, web.class);
        ir.putExtra("direccion", et1.getText().toString());
        startActivity(ir);
    }
}
