package com.example.micertamen1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    EditText nota1, nota2, nota3, asistencia, et_examen;
    TextView tx_notapre,tx_notafinal,tx_situFinal;
    ImageView tick, x;
    Button btn_notafinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nota1 = findViewById(R.id.et_nota1);
        nota2 = findViewById(R.id.et_nota2);
        nota3 = findViewById(R.id.et_nota3);

        asistencia = findViewById(R.id.et_asistencia);
        et_examen = findViewById(R.id.et_examen);

        tx_notapre = findViewById(R.id.tx_notapre);
        tx_notafinal = findViewById(R.id.tx_notafinal);
        tx_situFinal = findViewById(R.id.tx_situFinal);

        tick = findViewById(R.id.iv_tick);
        x = findViewById(R.id.iv_x);
        tick.setVisibility(View.INVISIBLE);
        x.setVisibility(View.INVISIBLE);
        tick.setVisibility(View.GONE);
        x.setVisibility(View.GONE);

        btn_notafinal = findViewById(R.id.btn_notafinal);
    }

    public void calcularNotaPresentacion(View view){
        boolean error = false;

        double not1 = Double.valueOf(nota1.getText().toString());
        double not2 = Double.valueOf(nota2.getText().toString());
        double not3 = Double.valueOf(nota3.getText().toString());

        error = false;
        if(not1 < 1.0 || not1 > 7.0) {
            nota1.setError("Debe ingresar notas entre 1.0 y 7.0");
            error = true;
        }
        if(not2 < 1.0 || not2 > 7.0) {
            nota2.setError("Debe ingresar notas entre 1.0 y 7.0");
            error = true;
        }
        if(not3 < 1.0 || not3 > 7.0) {
            nota3.setError("Debe ingresar notas entre 1.0 y 7.0");
            error = true;
        }
        if(error) return;

        NotaPresentacion = (not1 * 0.25) + (not2 * 0.35) + (not3 * 0.40);
        tx_notapre.setText("Tu nota de presentacion es:  " + String.format("%.1f",NotaPresentacion));

        if(NotaPresentacion < 2.0){
            tx_situFinal.setText("SITUACION FINAL: SIN DERECHO A EXAMEN");
            tx_notafinal.setText("TU NOTA FINAL ES:  " + String.format("%.1f",NotaPresentacion));
            x.setVisibility(View.VISIBLE);
            tick.setVisibility(View.INVISIBLE);
            tick.setVisibility(View.GONE);
            et_examen.setEnabled(false);
            btn_notafinal.setEnabled(false);
        }
        if(NotaPresentacion >= 4.0){
            tx_situFinal.setText("SITUACION FINAL: EXIMIDO");
            tx_notafinal.setText("TU NOTA FINAL ES:  " + String.format("%.1f",NotaPresentacion));
            tick.setVisibility(View.VISIBLE);
            x.setVisibility(View.INVISIBLE);
            x.setVisibility(View.GONE);
            et_examen.setEnabled(false);
            btn_notafinal.setEnabled(false);
        }
        if(error) return;
    }

    double NotaPresentacion, NotaFinal;

    public void calcularNotaFinal(View view){
        boolean error = false;

        int asis = Integer.valueOf(asistencia.getText().toString());
        double exa = Double.valueOf(et_examen.getText().toString());

        error = false;
        if(asis < 0 || asis > 100) {
            asistencia.setError("Debe ingresar asistencia entre 0 y 100");
            error = true;
        }
        if(exa < 1.0 || exa > 7.0){
            et_examen.setError("Debe ingresar el examen");
            error = true;
        }

        if(asis == 0){
            tx_situFinal.setText("SITUACION FINAL: SIN DERECHO A EXAMEN");
            x.setVisibility(View.VISIBLE);
            tick.setVisibility(View.INVISIBLE);
            tick.setVisibility(View.GONE);
            et_examen.setEnabled(false);
            btn_notafinal.setEnabled(false);
        }
        if(asis > 0){
            tx_situFinal.setText("SITUACION FINAL: EXIMIDO");
            tick.setVisibility(View.VISIBLE);
            x.setVisibility(View.INVISIBLE);
            x.setVisibility(View.GONE);
            et_examen.setEnabled(false);
            btn_notafinal.setEnabled(false);
        }
        if(error) return;


        NotaFinal = (NotaPresentacion * 0.6) + (exa * 0.4);
        tx_notafinal.setText("TU NOTA FINAL ES:  " + NotaFinal);

        if(NotaFinal < 4.0){
            tx_situFinal.setText("SITUACION FINAL: REPROBACIÓN DEL RAMO");
            tx_notafinal.setText("TU NOTA FINAL ES:  " + String.format("%.1f",NotaFinal));
            x.setVisibility(View.VISIBLE);
            tick.setVisibility(View.INVISIBLE);
            tick.setVisibility(View.GONE);
            et_examen.setEnabled(true);
            btn_notafinal.setEnabled(true);
        }
        else{
            tx_situFinal.setText("SITUACION FINAL: APROVADO");
            tx_notafinal.setText("TU NOTA FINAL ES:  " + String.format("%.1f",NotaFinal));
            tick.setVisibility(View.VISIBLE);
            x.setVisibility(View.INVISIBLE);
            x.setVisibility(View.GONE);
            et_examen.setEnabled(true);
            btn_notafinal.setEnabled(true);
        }
    }

    public void Limpiar(View view){
        nota1.setText("");
        nota2.setText("");
        nota3.setText("");
        tick.setVisibility(View.INVISIBLE);
        x.setVisibility(View.INVISIBLE);
        tick.setVisibility(View.GONE);
        x.setVisibility(View.GONE);
        et_examen.setEnabled(true);
        btn_notafinal.setEnabled(true);
        tx_notapre.setText("Tu nota de presentacion es:");
        asistencia.setText("");
        et_examen.setText("");
        tx_notafinal.setText("TU NOTA FINAL ES:");
        tx_situFinal.setText("SITUACION FINAL:");
    }
}