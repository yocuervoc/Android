package co.edu.unal.tutorial10;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private EditText et1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.correo);

        SharedPreferences preference = getSharedPreferences("dato", Context.MODE_PRIVATE);
        et1.setText(preference.getString("mail", ""));

    }

    public void guardar(View v){

        SharedPreferences guardado = getSharedPreferences("dato", Context.MODE_PRIVATE);
        SharedPreferences.Editor objetoEditor = guardado.edit();
        objetoEditor.putString("mail", et1.getText().toString());
        objetoEditor.commit();
        finish();
    }
}
