package com.acme.a3csci3130;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailViewActivity extends Activity {

    private Button submitButton;
    private EditText nameField, emailField,BNField,PBField,AdField,PField;
    private MyApplicationData appState;
    Contact receivedPersonInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Contact)getIntent().getSerializableExtra("Contact");

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        emailField = (EditText) findViewById(R.id.email);
        BNField = (EditText) findViewById(R.id.BN);
        PBField = (EditText) findViewById(R.id.PB);
        AdField = (EditText) findViewById(R.id.Ad);
        PField = (EditText) findViewById(R.id.P);
        appState = ((MyApplicationData)getApplicationContext());// firebase reference


        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            emailField.setText(receivedPersonInfo.email);
            BNField.setText(receivedPersonInfo.bn);
            PBField.setText(receivedPersonInfo.pb);
            AdField.setText(receivedPersonInfo.Ad);
            PField.setText(receivedPersonInfo.p);
        }
    }

    public void updateInfo(){
        String personID=receivedPersonInfo.uid;
        String name = nameField.getText().toString();
        String email = emailField.getText().toString();
        String bn = BNField.getText().toString();
        String pb = PBField.getText().toString();
        String Ad = AdField.getText().toString();
        String p = PField.getText().toString();
        Contact contact = new Contact(personID, name, email, bn, pb, Ad, p);//create object with parameters
        appState.firebaseReference.child(personID).setValue(contact);//catch uid and set value
        finish();
    }

    public void eraseInfo(){
        String personID=receivedPersonInfo.uid;//
        appState.firebaseReference.child(personID).removeValue();//catch uid and remove it
    }

    public void updateContact(View v){

        //TODO: Update contact funcionality
       updateInfo();//call updateInfo method
       Intent intent = new Intent(this, MainActivity.class);//start another activity
       startActivity(intent);

    }

    public void eraseContact(View v)
    {
        //TODO: Erase contact functionality
        eraseInfo();//call eraseInfo
        Intent intent = new Intent(this, MainActivity.class);//start another activity
        startActivity(intent);

    }

}
