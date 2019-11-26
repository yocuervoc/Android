package co.edu.unal.tutorial12;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {


    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 =(EditText)findViewById(R.id.etm);
        String archivos [] =fileList();

        if(archivoExiste(archivos, "tareas.txt")){
            try {
                InputStreamReader texto = new InputStreamReader(openFileInput("tareas.txt"));
                BufferedReader br = new BufferedReader(texto);
                String linea = br.readLine();
                String textoCompleto= "";
                while(linea !=null){
                    textoCompleto = textoCompleto + linea +"\n";
                    linea = br.readLine();
                }
                br.close();
                texto.close();
                et1.setText(textoCompleto);
            }catch (IOException e){

            }
        }
    }

    public boolean archivoExiste(String archivos [], String nombre){
        for(int i=0; i<archivos.length; i++)
            if(archivos[i].equals(nombre))
                return true;
        return false;
    }

    public void guardar(View v) throws FileNotFoundException {
        try {
            OutputStreamWriter archivo = new OutputStreamWriter(openFileOutput("tareas.txt", Activity.MODE_PRIVATE));
            archivo.write(et1.getText().toString());
            archivo.flush();
            archivo.close();
        }catch (IOException e){

        }
        Toast.makeText(this, "archivo guardo", Toast.LENGTH_LONG).show();

    }
}
