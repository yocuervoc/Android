package co.edu.unal.tutorial3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private EditText et1;
    private EditText et2;

    private RadioButton rb1, rb2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.numero1);
        et2 = (EditText)findViewById(R.id.numero2);

        tv1 = (TextView)findViewById(R.id.resultado);

        rb1 = (RadioButton)findViewById(R.id.rb_sumar);
        rb2 =(RadioButton)findViewById(R.id.rb_restar);

    }
    public void calcular(View v){
        int number1 = Integer.parseInt(et1.getText().toString());
        int number2 = Integer.parseInt(et2.getText().toString());

        if(rb1.isChecked()){
            int suma = number1+number2;
            tv1.setText("resultado es: "+suma);
        }
        if(rb2.isChecked()){
            int resta = number1-number2;
            tv1.setText("resulatado es: "+resta);
        }
    }
}
