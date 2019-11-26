package co.edu.unal.tutorial13;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    private EditText et1, et2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.nombre);
        et2 = (EditText)findViewById(R.id.notas);
    }

    public void guardar (View v) {
        try {
            String nombre = et1.getText().toString();
            String notas = et2.getText().toString();

            File tarjetaSD = getExternalFilesDir(null);
            Toast.makeText(this, tarjetaSD.getPath(), Toast.LENGTH_LONG).show();
            File ruta = new File(tarjetaSD.getPath(), nombre);
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput(nombre, Activity.MODE_PRIVATE));

            archivo.write(notas);
            archivo.flush();
            archivo.close();

            et1.setText("");
            et2.setText("");

            Toast.makeText(this, "guardadp correcamente"+ruta, Toast.LENGTH_SHORT).show();
        }catch (IOException e){
            Toast.makeText(this, "error al guardar", Toast.LENGTH_SHORT).show();
        }

    }

    public void recuperar(View view){
        String nombre = et1.getText().toString();
        Toast.makeText(this, "nombre "+ nombre, Toast.LENGTH_LONG).show();


        try{
            //File tarjetaSD = getExternalFilesDir(null);
            //File rutaArchivo = new File(tarjetaSD.getPath(), nombre);
            InputStreamReader abrirArchivo = new InputStreamReader(openFileInput(nombre));

            BufferedReader leerArchivo = new BufferedReader(abrirArchivo);
            String linea = leerArchivo.readLine();
            String contenidoCompleto = "";

            while (linea != null){
                contenidoCompleto = contenidoCompleto + linea + "\n";
                linea = leerArchivo.readLine();
            }

            leerArchivo.close();
            abrirArchivo.close();
            et2.setText(contenidoCompleto);
        }catch (IOException e){
            Toast.makeText(this, "Error al leer el archivo", Toast.LENGTH_SHORT).show();
        }
    }
}
