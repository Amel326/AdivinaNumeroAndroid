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

public class MainActivity3 extends AppCompatActivity {

    int valor3;
    TextView numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main3);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        numero = findViewById(R.id.txt_3);

        valor3 = getIntent().getIntExtra("llave", 0);
    }

    public void si3(View v) {
        int numero3 = Integer.parseInt(numero.getText().toString());
        numero3 += valor3;
        Intent it = new Intent(getApplicationContext(), MainActivity4.class);
        it.putExtra("llave", numero3);
        startActivity(it);
    }

    public void no3(View v) {

        Intent it = new Intent(getApplicationContext(), MainActivity4.class);
        it.putExtra("llave", valor3);
        startActivity(it);
    }
}
