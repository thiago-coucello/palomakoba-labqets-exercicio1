package com.example.conversordemoedas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    TextView txtDolares;
    Button btnConverter;
    EditText edtValorReais;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        txtDolares = findViewById(R.id.txtValorDolares);
        btnConverter = findViewById(R.id.bt_converter);
        edtValorReais = findViewById(R.id.edtValorReais);

        btnConverter.setOnClickListener(v -> {
            if(!edtValorReais.getText().toString().isEmpty()){
                double valorReais = Double.parseDouble(edtValorReais.getText().toString());
    
                double valorDolares = valorReais / 5.35;
                txtDolares.setText("U$ " + valorDolares);
            }
            else{
                txtDolares.setText("NENHUM VALOR INSERIDO !!!");
            }
        });
    }
}