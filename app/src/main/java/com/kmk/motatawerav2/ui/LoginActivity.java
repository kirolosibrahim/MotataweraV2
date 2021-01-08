package com.kmk.motatawerav2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.database.core.utilities.Validation;
import com.google.firebase.firestore.DocumentChange;
import com.google.firebase.firestore.FirebaseFirestore;
import com.kmk.motatawerav2.fragment.MainActivity;
import com.kmk.motatawerav2.R;

public class LoginActivity extends AppCompatActivity {
    //View
    EditText text_id, text_password;
    CheckBox rememberme;

    //Connect To FireStore
    private FirebaseFirestore db = FirebaseFirestore.getInstance();

    //Checking Success
    boolean isSuccess = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //FindView
        text_id = findViewById(R.id.etID);
        text_password = findViewById(R.id.etPassword);
        rememberme = findViewById(R.id.cb_rememberme);


        //Login Button on Click Method
        findViewById(R.id.btn_login).setOnClickListener(v -> {
            //Calling Method
            Validationdata();
        });


    }


    //Validation Method
    private void Validationdata2() {

        String id = text_id.getText().toString().trim();
        String password = text_password.getText().toString().trim();

        text_id.setOnFocusChangeListener((v, hasFocus) -> {
            if (text_id.getText().toString().isEmpty()) {
                text_password.setError("pleas enter your ID !");
            }
        });

        text_password.setOnFocusChangeListener((v, hasFocus) -> {
            if (text_password.getText().toString().isEmpty()) {
                text_password.setError("pleas enter your Password !");
            }
        });

        db.collection("Users")
                .addSnapshotListener((value, error) -> {
                    if (error == null) {
                        if (value == null) {
                            Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                        } else {
                            for (DocumentChange documentChange : value.getDocumentChanges()) {
                                documentChange.getDocument();
                                String idDb = documentChange
                                        .getDocument()
                                        .getId();
                                String passwordDb = documentChange
                                        .getDocument()
                                        .getString("password");

                                assert idDb != null;


                                if (idDb.equals(id)) {
                                    assert passwordDb != null;
                                    if (passwordDb.equals(password)) {

                                        isSuccess = true;
                                        break;
                                    } else {
                                        isSuccess = false;
                                    }
                                } else {
                                    isSuccess = false;
                                }

                            }
                            if (isSuccess) {
                                if (rememberme.isChecked()) {
                                    saveid(id);
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                } else {
                                    startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                    finish();
                                }
                            } else {
                                Toast.makeText(this, "No Found data", Toast.LENGTH_SHORT).show();
                            }

                        }


                    } else {
                        Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
                    }


                });

    }


    private void Validationdata() {

        String id = text_id.getText().toString().trim();
        String password = text_password.getText().toString().trim();

        if (id.isEmpty()) {
            Toast.makeText(this, "pleas enter your id", Toast.LENGTH_SHORT).show();

        } else if (password.isEmpty()) {
            Toast.makeText(this, "Pleas enter your password", Toast.LENGTH_SHORT).show();
        } else {

            db.collection("Users")
                    .addSnapshotListener((value, error) -> {
                        if (error == null) {
                            if (value == null) {
                                Toast.makeText(this, "No Data Found", Toast.LENGTH_SHORT).show();
                            } else {
                                for (DocumentChange documentChange : value.getDocumentChanges()) {
                                    documentChange.getDocument();
                                    String idDb = documentChange
                                            .getDocument()
                                            .getId();
                                    String passwordDb = documentChange
                                            .getDocument()
                                            .getString("password");
                                    assert idDb != null;
                                    if (idDb.equals(id)) {
                                        assert passwordDb != null;
                                        if (passwordDb.equals(password)) {

                                            isSuccess = true;
                                            break;
                                        } else {
                                            isSuccess = false;
                                        }
                                    } else {
                                        isSuccess = false;
                                    }

                                }
                                if (isSuccess) {
                                    if (rememberme.isChecked()) {
                                        saveid(id);
                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                        finish();
                                    } else {
                                        startActivity(new Intent(LoginActivity.this, MainActivity.class));
                                        finish();
                                    }
                                } else {
                                    Toast.makeText(this, "No Found data", Toast.LENGTH_SHORT).show();
                                }

                            }


                        } else {
                            Toast.makeText(this, error.getMessage(), Toast.LENGTH_SHORT).show();
                        }


                    });

        }

    }


    public void saveid(String id) {

        getSharedPreferences("login", MODE_PRIVATE)
                .edit()
                .putString("id", id)
                .apply();
    }
}
