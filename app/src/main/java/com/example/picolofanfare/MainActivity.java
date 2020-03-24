package com.example.picolofanfare;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private ArrayList<String> liste_joueurs = null;
    private EditText nom_joueurs = null;
    private Button bouton_enregistrer = null;
    private TextView affichage_joueurs = null;
    private ConstraintLayout layout = null;
    private Button bouton_commencer_partie = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        layout = (ConstraintLayout) ConstraintLayout.inflate(this, R.layout.activity_main, null);
        nom_joueurs = layout.findViewById (R.id.nom_joueurs);
        bouton_enregistrer = layout.findViewById (R.id.bouton_enregistrer);
        affichage_joueurs = layout.findViewById(R.id.affichage_joueurs);
        bouton_commencer_partie = layout.findViewById(R.id.commencer_partie);
        bouton_enregistrer.setText("Enregistrer");
        affichage_joueurs.setText("Liste des joueurs");
        bouton_commencer_partie.setText("Commencer la partie");
        liste_joueurs = new ArrayList<String>() {};
        setContentView(layout);
        bouton_enregistrer.setOnClickListener(this);
        bouton_commencer_partie.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.bouton_enregistrer) {
            if (nom_joueurs.getText()== null){
                return;
            }
            else{
                liste_joueurs.add(nom_joueurs.getText().toString());
                affichage_joueurs.setText(affichage_joueurs.getText() + "\n" + nom_joueurs.getText());
                nom_joueurs.setText("");

            }
        }
        else if(v.getId() == R.id.commencer_partie){
            Intent intent = new Intent(this, ActiviteGame.class);
            intent.putExtra("liste_joueurs", liste_joueurs);
            startActivity(intent);
        }
    }
}
