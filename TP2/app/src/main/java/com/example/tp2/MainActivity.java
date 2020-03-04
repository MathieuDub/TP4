package com.example.tp2;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    //bien chercher les éléments apres setContentView

    private EditText nom = null;
    private EditText prenom = null;
    private EditText phone = null;
    private EditText datedenaissance = null;
    private EditText adressepostale = null;
    public EditText codepostal = null;
    private ImageView avatar = null;

    private Button validButton = null;
    public static final int PICK_IMAGE = 2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nom = findViewById(R.id.editNom);
        prenom = findViewById(R.id.editPrenom);
        phone = findViewById(R.id.inputPhone);
        datedenaissance = findViewById(R.id.inputDate);
        adressepostale = findViewById(R.id.inputAdrPostal);
        codepostal = findViewById(R.id.codePostal);
        avatar = findViewById(R.id.imgAvatar);
        validButton = findViewById(R.id.valider);

        avatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent imageActivity = new Intent();
                imageActivity .setType("image/*");
                imageActivity.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(Intent.createChooser(imageActivity, "Select Picture"),PICK_IMAGE);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    public Context getContextOfApp() {
        return this.getApplicationContext();
    }

    public void onClickValider(View view) {

        if (!nom.getText().toString().equals("") && !prenom.getText().toString().equals("") && !phone.getText().toString().equals("")){
            int duration = Toast.LENGTH_SHORT;

            Toast toast = Toast.makeText(getContextOfApp(), "sending informations", duration);
            toast.show();

            System.out.println("creation du dialogue");

            /*AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setMessage("Nom : " + nom.getText()+
                    "\nPrenom : " + prenom.getText()+
                    "\nPhone : " + phone.getText()
            ).setTitle("Données rentrées");

            AlertDialog dialog = builder.create();
            dialog.show();*/

            Intent syntheseActivity = new Intent(MainActivity.this, com.example.tp2.SyntheseActivity.class);

            syntheseActivity.putExtra("nom",nom.getText().toString());
            syntheseActivity.putExtra("prenom",prenom.getText().toString());
            syntheseActivity.putExtra("date",datedenaissance.getText().toString());
            syntheseActivity.putExtra("tel",phone.getText().toString());
            syntheseActivity.putExtra("adresse",adressepostale.getText().toString());
            syntheseActivity.putExtra("codepostal",codepostal.getText().toString());

            startActivityForResult(syntheseActivity,1);
        }



    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK){
            avatar.setImageURI(data.getData());
        }
    }
}


