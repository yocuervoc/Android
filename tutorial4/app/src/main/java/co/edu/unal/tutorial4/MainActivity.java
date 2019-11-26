package co.edu.unal.tutorial4;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Spinner spinner;
    private EditText et1, et2;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.number1);
        et2 = (EditText)findViewById(R.id.number2);

        spinner = (Spinner)findViewById(R.id.spinner);
        tv =(TextView)findViewById(R.id.result);

        String [] option= {"sumar","restar", "multiplicar","dividir"};

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this, R.layout.spinner_item_lista, option);

        spinner.setAdapter(adaptador);

    }
    public void calcular(View v){

        int resuldato=0;
        int numero1 = Integer.parseInt(et1.getText().toString());
        int numero2 = Integer.parseInt(et2.getText().toString());

        String selection = spinner.getSelectedItem().toString();

        if(selection.equals("sumar")){
            resuldato = numero1+numero2;
            tv.setText("reado: "+ resuldato);
        }
        if(selection.equals("restar")){
            resuldato = numero1-numero2;
            tv.setText("reado: "+ resuldato);
        }
        if(selection.equals("multiplicar")){
            resuldato = numero1*numero2;
            tv.setText("reado: "+ resuldato);
        }
        if(selection.equals("dividir")){
            if(numero2!=0){
                resuldato = numero1/numero2;
                tv.setText("reado: "+ resuldato);
            }else{
                Toast.makeText(this, "division en 0 no esta definida", Toast.LENGTH_LONG).show();
            }

        }


    }
}
