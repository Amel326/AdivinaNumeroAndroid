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

public class MainActivity4 extends AppCompatActivity {

    int valor4;
    TextView numero;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main4);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        numero = findViewById(R.id.txt_4);
        valor4 = getIntent().getIntExtra("llave", 0);
    }

    public void si4(View v) {
        int numero4 = Integer.parseInt(numero.getText().toString());
        numero4 += valor4;
        Intent it = new Intent(getApplicationContext(), MainActivity5.class);
        it.putExtra("llave", numero4);
        startActivity(it);
    }

    public void no4(View v) {

        Intent it = new Intent(getApplicationContext(), MainActivity5.class);
        it.putExtra("llave", valor4);
        startActivity(it);
    }
}
