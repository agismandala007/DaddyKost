package com.example.daddykost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.Array;

public class SignUpActivity extends AppCompatActivity {

    String[] akun = {"Pemilik Kos", "Penyewa Kos"};
    String akunFind;
    AutoCompleteTextView autoCompleteTextView;
    ArrayAdapter<String> adapterItems;
    EditText inEmail, inPass, inUser, inNomor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);


        inEmail = findViewById(R.id.input_email);
        inPass = findViewById(R.id.input_pass);
        inUser = findViewById(R.id.input_username);
        inNomor = findViewById(R.id.input_nomor);

        autoCompleteTextView = findViewById(R.id.list_akun);
        adapterItems = new ArrayAdapter<String>(this, R.layout.list_akun, akun);

        autoCompleteTextView.setAdapter(adapterItems);
        autoCompleteTextView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                akunFind = adapterView.getItemAtPosition(i).toString();
            }
        });
    }

    public void setDaftar(View view){
        Intent daftar = new Intent(SignUpActivity.this, MainActivity.class);
        daftar.putExtra("email", inEmail.getText().toString());
        daftar.putExtra("pass", inPass.getText().toString());
        daftar.putExtra("user", inUser.getText().toString());
        daftar.putExtra("nomor", inNomor.getText().toString());
        daftar.putExtra("akun", akunFind);
        startActivity(daftar);
    }
}