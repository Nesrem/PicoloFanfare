package com.example.picolofanfare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.Random;

public class ActiviteGame extends AppCompatActivity implements View.OnClickListener {
    private ConstraintLayout layout = null;
    private ArrayList<String> liste_joueurs = null;
    private Button texte = null;
    private String nom_joueur = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        layout = (ConstraintLayout) ConstraintLayout.inflate(this, R.layout.activity_activite_game, null);
        texte = layout.findViewById(R.id.texte);
        Intent intent = getIntent();
        liste_joueurs = intent.getStringArrayListExtra("liste_joueurs");
        texte.setText(liste_joueurs.get(0));
        setContentView(layout);
        texte.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.texte) {
            nom_joueur = liste_joueurs.get(pif(0,liste_joueurs.size()-1));
            texte.setText(nom_joueur + " tu bois !");
        }
    }



    int pif(int min,int max) {
        // tire aléatoirement un nombre entre min et max
        Random rand=new Random();
        return rand.nextInt((max - min) + 1) + min;
    }

}
