package com.example.schoolbees;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CreateAccount extends AppCompatActivity {

    private Button MainPageButton2; //Main Page Button
    private EditText createUsername;
    private EditText createPass;
    private EditText confirmPass;
    private Button createButton;

    private final String CREDENTIAL_SHARED_PREF = "our_shared_pref";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_account);

        MainPageButton2 = findViewById(R.id.button9);
        createUsername = findViewById(R.id.editTextText2);
        createPass = findViewById(R.id.editTextNumberPassword2);
        confirmPass = findViewById(R.id.editTextNumberPassword3);
        createButton = findViewById(R.id.button8);

        createButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strPassword = createPass.getText().toString();
                String strConfirmationPassword = confirmPass.getText().toString();
                String strUsername = createUsername.getText().toString();

                if(strPassword != null && strConfirmationPassword != null && strPassword.equalsIgnoreCase(strConfirmationPassword)){
                    SharedPreferences credentials= getSharedPreferences(CREDENTIAL_SHARED_PREF, Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = credentials.edit();
                    editor.putString("Password", strPassword);
                    editor.putString("Username", strUsername);
                    editor.commit();

                    CreateAccount.this.finish();
                }

            }
        });

        MainPageButton2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMainActivity();
            }
        });
    }

        public void openMainActivity() {
            Intent intent4 = new Intent(this, MainActivity.class);
            startActivity(intent4);
    }
}