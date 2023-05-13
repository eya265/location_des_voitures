package com.example.locationdesvoitures.View;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.locationdesvoitures.R;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class ContratActivity extends AppCompatActivity {

    private EditText nomEditText;
    private EditText prenomEditText;
    private EditText adresseEditText;
    private EditText telephoneEditText;
    private TextView dateTextView;
    private Button dateButton;
    private EditText dureeEditText;
    private Button validerButton;
    private Calendar calendar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contrat);

        // Initialisation des éléments de l'interface utilisateur
        nomEditText = findViewById(R.id.nom_edit_text);
        prenomEditText = findViewById(R.id.prenom_edit_text);
        adresseEditText = findViewById(R.id.adresse_edit_text);
        telephoneEditText = findViewById(R.id.telephone_edit_text);
        dateTextView = findViewById(R.id.date_text_view);
        dateButton = findViewById(R.id.date_button);
        dureeEditText = findViewById(R.id.duree_edit_text);
        validerButton = findViewById(R.id.valider_button);

        // Initialisation du calendrier
        calendar = Calendar.getInstance();

        // Ajout d'un OnClickListener sur le bouton de sélection de la date
        dateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Affichage du DatePickerDialog
                DatePickerDialog datePickerDialog = new DatePickerDialog(ContratActivity.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int year, int month, int day) {
                        // Mise à jour de la date sélectionnée dans le TextView
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, month);
                        calendar.set(Calendar.DAY_OF_MONTH, day);
                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy", Locale.getDefault());
                        dateTextView.setText(dateFormat.format(calendar.getTime()));
                    }
                }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
                datePickerDialog.show();
            }
        });

        // Ajout d'un OnClickListener sur le bouton de validation
        validerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Récupération des données saisies dans les champs
                String nom = nomEditText.getText().toString();
                String prenom = prenomEditText.getText().toString();
                String adresse = adresseEditText.getText().toString();
                String telephone = telephoneEditText.getText().toString();
                String date = dateTextView.getText().toString();
                String duree = dureeEditText.getText().toString();

                // Vérification que tous les champs ont été remplis
                if (nom.isEmpty() || prenom.isEmpty() || adresse.isEmpty() || telephone.isEmpty() || date.isEmpty() || duree.isEmpty()) {
                    Toast.makeText(ContratActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                } else {
                    // Création de l'intent pour l'activité d'impression
                    Intent intent = new Intent(ContratActivity.this, PrintActivity.class);
                    intent.putExtra("nom", nom);
                    intent.putExtra("prenom", prenom);
                    intent.putExtra("adresse", adresse);
                    intent.putExtra("telephone", telephone);
                    intent.putExtra("date", date);
                    intent.putExtra("duree", duree);
                    startActivity(intent);
                }
            }
        });
    }
}
