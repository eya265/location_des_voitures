package com.example.locationdesvoitures.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.locationdesvoitures.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        // Récupération du LinearLayout
        LinearLayout linearLayout = findViewById(R.id.my_linear_layout);

// Récupération des ImageView
        ImageView image1 = findViewById(R.id.image1);
        ImageView image2 = findViewById(R.id.image2);
        ImageView image3 = findViewById(R.id.image3);
        ImageView image4 = findViewById(R.id.image4);

// Ajout du OnClickListener à chaque ImageView
        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code à exécuter lors du clic sur l'image 1
                Intent intent = new Intent(MainActivity2.this, MainActivity3.class);

            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code à exécuter lors du clic sur l'image 2
                Intent intent = new Intent(MainActivity2.this, MainActivity4.class);

            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code à exécuter lors du clic sur l'image 3
                Intent intent = new Intent(MainActivity2.this, MainActivity5.class);

            }
        });

        image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Code à exécuter lors du clic sur l'image 4
                Intent intent = new Intent(MainActivity2.this, MainActivity6.class);

            }
        });

    }
}