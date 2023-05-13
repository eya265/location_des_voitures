package com.example.locationdesvoitures.View;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;

import com.example.locationdesvoitures.R;
import android.content.Context;
import android.os.Bundle;
import android.os.CancellationSignal;
import android.os.ParcelFileDescriptor;
import android.print.PageRange;
import android.print.PrintAttributes;
import android.print.PrintDocumentAdapter;
import android.print.PrintDocumentInfo;
import android.print.PrintManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class PrintActivity extends AppCompatActivity {

        private TextView nomTextView;
        private TextView prenomTextView;
        private TextView adresseTextView;
        private TextView telephoneTextView;
        private TextView dateTextView;
        private TextView dureeTextView;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_print);

            // Initialisation des éléments de l'interface utilisateur
            nomTextView = findViewById(R.id.nom_text_view);
            prenomTextView = findViewById(R.id.prenom_text_view);
            adresseTextView = findViewById(R.id.adresse_text_view);
            telephoneTextView = findViewById(R.id.telephone_text_view);
            dateTextView = findViewById(R.id.date_text_view);
            dureeTextView = findViewById(R.id.duree_text_view);

            // Récupération des données saisies dans l'activité de contrat
            Intent intent = getIntent();
            String nom = intent.getStringExtra("nom");
            String prenom = intent.getStringExtra("prenom");
            String adresse = intent.getStringExtra("adresse");
            String telephone = intent.getStringExtra("telephone");
            String date = intent.getStringExtra("date");
            String duree = intent.getStringExtra("duree");

            // Affichage des données dans les TextView correspondants
            nomTextView.setText(nom);
            prenomTextView.setText(prenom);
            adresseTextView.setText(adresse);
            telephoneTextView.setText(telephone);
            dateTextView.setText(date);
            dureeTextView.setText(duree);
        }
    }
