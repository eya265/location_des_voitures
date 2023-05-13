package com.example.locationdesvoitures.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.locationdesvoitures.R;

public class MainActivity5 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

            ImageView imageView;



                imageView = findViewById(R.id.image7);
                imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        // Votre code pour gérer l'événement de clic sur l'image
                        Toast.makeText(MainActivity5.this, "Image clicked", Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(MainActivity5.this, Reservation.class);

                    }
                });
            }
        }

