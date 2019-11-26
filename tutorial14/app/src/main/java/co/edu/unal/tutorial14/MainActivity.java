package co.edu.unal.tutorial14;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText etId,etName, etPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etId = (EditText)findViewById(R.id.id);
        etName = (EditText)findViewById(R.id.name);
        etPrice = (EditText)findViewById(R.id.precio);
    }
    public void registrar(View v){
        AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();

        int codigo = Integer.parseInt(etId.getText().toString());
        String nombre = etName.getText().toString();
        String precio =  etPrice.getText().toString();

        if(!nombre.isEmpty() && !precio.isEmpty()){

            ContentValues registro = new ContentValues();

            if(etId.getText().toString().isEmpty()){
                registro.put("name", nombre);
                registro.put("precio", precio);

            }else{
                registro.put("id", codigo);
                registro.put("name", nombre);
                registro.put("precio", precio);
            }


            baseDeDatos.insert("articulos", null, registro);
            baseDeDatos.close();
            etId.setText("");
            etPrice.setText("");
            etName.setText("");
            Toast.makeText(this, "restro Exitoso", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "los campos no pueden estas vacios", Toast.LENGTH_LONG).show();
        }

    }

    public  void buscar(View v){

        AdminSQLite admin = new AdminSQLite(this, "administracion", null, 1);
        SQLiteDatabase baseDeDatos = admin.getWritableDatabase();
        int codigo = Integer.parseInt(etId.getText().toString());
        Cursor fila= baseDeDatos.rawQuery
                ("SELECT name, precio FROM articulos WHERE codigo = '"+ codigo+"'" ,null );

        if(fila.moveToFirst()){
            etName.setText(fila.getString(0));
            etPrice.setText(fila.getString(1));

        }else{
            Toast.makeText(this, "articulo no existe", Toast.LENGTH_SHORT).show();
        }
        etName.setText(etId.getText().toString());//prueba
        baseDeDatos.close();
    }
}
