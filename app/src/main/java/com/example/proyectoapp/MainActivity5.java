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

public class MainActivity5 extends AppCompatActivity {

    int valor5;
    TextView numero;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main5);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        numero = findViewById(R.id.txt_5);
        valor5 = getIntent().getIntExtra("llave", 0);
    }

    public void si5(View v) {
        int numero5 = Integer.parseInt(numero.getText().toString());
        numero5 += valor5;
        Intent it = new Intent(getApplicationContext(), MainActivity6.class);
        it.putExtra("llave", numero5);
        startActivity(it);
    }

    public void no5(View v) {

        Intent it = new Intent(getApplicationContext(), MainActivity6.class);
        it.putExtra("llave", valor5);
        startActivity(it);
    }
}
