package co.edu.unal.tutorial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.numero1);
        et2 = (EditText)findViewById(R.id.numero2);

        tv = (TextView)findViewById(R.id.resultado);

    }

    public void Suma(View view){

        String valor1 = et1.getText().toString();
        String valor2 = et2.getText().toString();


        int num1 = Integer.parseInt(valor1);
        int num2 = Integer.parseInt(valor2);
        int sum = num1 + num2;



        String resultado = String.valueOf(sum);
        tv.setText(resultado);
    }
}
