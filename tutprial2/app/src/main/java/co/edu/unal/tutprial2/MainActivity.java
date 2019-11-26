package co.edu.unal.tutprial2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText et1;
    private EditText et2;
    private EditText et3;
    private TextView tv1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1 = (EditText)findViewById(R.id.txt_matematicas);
        et2 = (EditText)findViewById(R.id.txt_fisica);
        et3 = (EditText)findViewById(R.id.txt_quimica);
        tv1 = (TextView)findViewById(R.id.status1);
    }

    public void calcular(View a){
        int mathGrade = Integer.parseInt(et1.getText().toString());
        int physicGrade =Integer.parseInt(et2.getText().toString());
        int chemstryGrade = Integer.parseInt(et3.getText().toString());

        int average = (mathGrade+ physicGrade + chemstryGrade)/3;

        if(average >=6){
            tv1.setText("aprobado con : "+ average);
        }else{
            tv1.setText("reprobado con : "+ average);
        }
     }
}
