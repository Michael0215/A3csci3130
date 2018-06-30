package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateContactAcitivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField,BNField,PBField,AdField,PField;
    private MyApplicationData appState;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_contact_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        BNField = (EditText) findViewById(R.id.BN);
        PBField = (EditText) findViewById(R.id.PB);
        AdField = (EditText) findViewById(R.id.Ad);
        PField = (EditText) findViewById(R.id.P);
    }

    public void submitInfoButton(View v) {//the button of create contact
        //each entry needs a unique ID
        String personID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String bn = BNField.getText().toString();
        String pb = PBField.getText().toString();
        String Ad = AdField.getText().toString();
        String pf = PField.getText().toString();
        Contact person = new Contact(personID, name, email,bn,pb,Ad,pf);//create object named person

        appState.firebaseReference.child(personID).setValue(person);//import person to firebase

        finish();

    }
}
