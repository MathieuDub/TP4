package com.example.tp2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class SyntheseActivity extends AppCompatActivity {

    public TextView afficheNom ;
    public TextView affichePrenom ;
    public TextView afficheNumTel ;
    public TextView afficheDateDeNaissance;
    public TextView afficheAdressePostale;
    public TextView afficheCodePostal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_synthese);

        afficheNom = findViewById(R.id.afficheNom);
        affichePrenom = findViewById(R.id.affichePrenom);
        afficheNumTel = findViewById(R.id.afficheNumDeTel);
        afficheDateDeNaissance = findViewById(R.id.afficheDateDeNaissance);
        afficheAdressePostale = findViewById(R.id.afficheAdressePostale);
        afficheCodePostal = findViewById(R.id.afficheCodePostal);

        afficheNom.setText(getIntent().getStringExtra("nom"));
        affichePrenom.setText(getIntent().getStringExtra("prenom"));
        afficheNumTel.setText(getIntent().getStringExtra("tel"));
        afficheDateDeNaissance.setText(getIntent().getStringExtra("date"));
        afficheAdressePostale.setText(getIntent().getStringExtra("adresse"));
        afficheCodePostal.setText(getIntent().getStringExtra("codepostal"));



    }
}
