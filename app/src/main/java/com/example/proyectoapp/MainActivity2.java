package com.example.proyectoapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity2 extends AppCompatActivity {

    TextView numero;
    int valor2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        numero = findViewById(R.id.txt_2);

        valor2 = getIntent().getIntExtra("llave", 0);
    }

    public void si2(View v){
        int numero2 = Integer.parseInt(numero.getText().toString());
        numero2 += valor2;
        Intent it = new Intent(getApplicationContext(), MainActivity3.class);
        it.putExtra("llave", numero2);
        startActivity(it);
    }

    public void no2(View v) {

        Intent it = new Intent(getApplicationContext(), MainActivity3.class);
        it.putExtra("llave", valor2);
        startActivity(it);
    }
}
