package co.edu.unal.tutorial8;

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

        et1 = (EditText)findViewById(R.id.etNombre);
    }

    public void Enviar(View v){
        Intent siguiente = new Intent(this, Main2Activity.class);
        siguiente.putExtra("nombreFormulario", et1.getText().toString());
        startActivity(siguiente);
    }
}
