
Aquí tienes la versión resumida del README en Markdown, optimizada para su uso en GitHub:

markdown
Copiar código
# **Adivina el Número - Proyecto Android**

**Adivina el Número** es una aplicación Android interactiva en la que el jugador adivina un número a través de respuestas de **"Sí"** o **"No"** en seis pantallas. El número final es calculado según las respuestas y se muestra en la última pantalla.

---

## **Características**

- **6 Pantallas Interactivas**: El jugador ajusta el número basado en las respuestas ("Sí" o "No").
- **Pantalla Final**: Muestra el número adivinado por el sistema.
- **Flujo Secuencial**: El número se pasa entre actividades mediante **Intents**.

---

## **Tecnologías Utilizadas**

- **Android SDK**
- **Java**
- **Android Studio**

---

## **Estructura del Proyecto**

1. **MainActivity**: Pantalla inicial con el primer número.
2. **MainActivity2 - MainActivity5**: Ajustan el número según las respuestas.
3. **MainActivity6**: Muestra el número final.

---

## **Detalles del Código**

### **MainActivity** (Pantalla 1)

El número inicial es recibido y pasa a la siguiente actividad según la respuesta ("Sí" o "No").

```java
public void si(View v) {
    int numero = Integer.parseInt(numero1.getText().toString());
    Intent it = new Intent(getApplicationContext(), MainActivity2.class);
    it.putExtra("llave", numero); // Pasa el número a la siguiente actividad
    startActivity(it);
}
MainActivity2 - MainActivity5 (Pantallas 2 a 5)
En estas pantallas, el número se ajusta según las respuestas. Si la respuesta es "Sí", el número se incrementa. Luego, el número ajustado se pasa a la siguiente pantalla.

java
Copiar código
public void si2(View v) {
    int numero2 = Integer.parseInt(numero.getText().toString());
    numero2 += 10;  // Ajuste basado en la respuesta
    Intent it = new Intent(getApplicationContext(), MainActivity3.class);
    it.putExtra("llave", numero2);
    startActivity(it);
}
Este patrón se repite con ligeras variaciones para cada actividad de MainActivity2 a MainActivity5.

MainActivity6 (Pantalla Final)
La última pantalla muestra el número final, basado en las respuestas previas. Se ajusta la interfaz para evitar el solapamiento con las barras del sistema.

java
Copiar código
public class MainActivity6 extends AppCompatActivity {
    int numeroRecibido6;
    TextView mostrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);  // Pantalla completa
        setContentView(R.layout.activity_main6);

        // Ajuste de márgenes para evitar solapamientos con las barras del sistema
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mostrar = findViewById(R.id.txt_resp);
        numeroRecibido6 = getIntent().getIntExtra("llave", 0);  // Recupera el número final
        mostrar.setText(String.valueOf(numeroRecibido6));  // Muestra el número
    }
}
Resumen
Adivina el Número es un juego interactivo donde el jugador ajusta un número basado en respuestas de "Sí" o "No". A lo largo de las pantallas, el número final se calcula y muestra en la última pantalla. Se utiliza Intents para pasar el número entre actividades, y EdgeToEdge asegura que la interfaz se vea bien en dispositivos modernos sin solapamientos.
