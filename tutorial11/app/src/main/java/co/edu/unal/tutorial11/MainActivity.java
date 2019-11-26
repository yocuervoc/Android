package co.edu.unal.tutorial11;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.nombre);
        et2 = (EditText)findViewById(R.id.datos);

    }
    public void guardar(View v){
        String nombre = et1.getText().toString();
        String datos = et2.getText().toString();

        SharedPreferences agenda = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = agenda.edit();
        editor.putString(nombre, datos);
        editor.commit();
        Toast.makeText(this, "guarddo Exitosamente", Toast.LENGTH_LONG).show();

    }

    public void buscar(View v){
        String nombre = et1.getText().toString();
        SharedPreferences agenda = getSharedPreferences("datos", Context.MODE_PRIVATE);
        String datos = agenda.getString(nombre, "");

        if(datos.length()==0){
            Toast.makeText(this, "contacto no existe", Toast.LENGTH_LONG).show();
        }else{
            et2.setText(datos);
        }

    }
}
