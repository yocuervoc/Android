package co.edu.unal.tutoria5;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView tv1;
    private ListView lv1;

    private String nombres[] ={"Yocc", "yeimy", "jorge", "camilo", "sebastian", "daniela", "nicol", "karen", "Damian"};
    private int edad [] = {30,21,32,43,23,56,34,12,34};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tv1 = (TextView)findViewById(R.id.edad);
        lv1 = (ListView)findViewById(R.id.nombres);

        ArrayAdapter<String> adaptador = new ArrayAdapter<String>(this,R.layout.list_item_people, nombres);
        lv1.setAdapter(adaptador);

        lv1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                tv1.setText("La edad de " + lv1.getItemAtPosition(position) + " es "+ edad[position]);
            }
        });
    }
}
