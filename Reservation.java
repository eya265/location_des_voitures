package com.example.locationdesvoitures.View;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locationdesvoitures.R;

public class Reservation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reservation);

        final int[] number = new int[1];
            TextView numberTextView;
            Button reserveButton;



                // Initialize views
                numberTextView = findViewById(R.id.number_textview);
                reserveButton = findViewById(R.id.reserve_button);

                // Set initial values
                number[0] = 5;
                numberTextView.setText(String.valueOf(number[0]));

                // Set up click listener for reserve button
                reserveButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (number[0] > 0) {
                            number[0]--;
                            numberTextView.setText(String.valueOf(number[0]));
                            Toast.makeText(Reservation.this, "Réservé !", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Reservation.this, "Plus de places disponibles.", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
            }
        }

