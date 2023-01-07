package com.example.daddykost;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView pEmail, pPass, pUser, pNomer, pAkun;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pEmail = findViewById(R.id.print_email);
        pPass = findViewById(R.id.print_pass);
        pUser = findViewById(R.id.print_user);
        pNomer = findViewById(R.id.print_nomor);
        pAkun = findViewById(R.id.print_akun);

        Bundle daftarData = getIntent().getExtras();
//
//        pEmail.setText(list[0]);
//        pPass.setText(list[1]);
//        pUser.setText(list[2]);
//        pNomer.setText(list[3]);
//        pAkun.setText(list[4]);


        String email = daftarData.getString("email");
        String pass = daftarData.getString("pass");
        String user = daftarData.getString("user");
        String nomor = daftarData.getString("nomor");
        String akun = daftarData.getString("akun");


        pEmail.setText(email);
        pPass.setText(pass);
        pUser.setText(user);
        pNomer.setText(nomor);
        pAkun.setText(akun);

    }

}