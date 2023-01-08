package com.example.daddykost;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


public class LoginActivity extends AppCompatActivity {

    String JsonURL = "https://daddykos.000webhostapp.com/read.php";
    RequestQueue requestQueue;
    EditText logEmail, logPass;
    ArrayList<String> email = new ArrayList<>();
    ArrayList<String> pass = new ArrayList<>();
    ArrayList<String> jenisAkun = new ArrayList<>();
    ArrayList<String> user = new ArrayList<>();
    TextView wrongPass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        requestQueue = Volley.newRequestQueue(this);

        JsonArrayRequest array = new JsonArrayRequest(Request.Method.GET, JsonURL, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        email.add(jsonObject.getString("email"));
                        jenisAkun.add(jsonObject.getString("jenisAkun"));
                        pass.add(jsonObject.getString("pass"));
                        user.add(jsonObject.getString("username"));
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

        },
            new Response.ErrorListener() {
                @Override
                public void onErrorResponse(VolleyError error){Log.e("Volley", "Error");}
            });

        requestQueue.add(array);
    }


    public void setLogin(View view){

        logEmail = findViewById(R.id.log_email);
        logPass = findViewById(R.id.log_pass);
        wrongPass = findViewById(R.id.text_pass_salah);

        String emailLog = logEmail.getText().toString();
        String passLog = logPass.getText().toString();

        for(int i=0; i<email.size(); i++){
            if(emailLog.equals(email.get(i))){
                if(passLog.equals(pass.get(i))){
                    if (jenisAkun.get(i).equals("Penyewa Kos")){
                        Intent homePenyewa = new Intent(LoginActivity.this, HomePenyewaActivity.class);
                        homePenyewa.putExtra("user", user.get(i));
                        startActivity(homePenyewa);
                    }
                    else if(jenisAkun.get(i).equals("Pemilik Kos")){
                        Intent homePemilik = new Intent(LoginActivity.this, HomePemilikActivity.class);
                        homePemilik.putExtra("user", user.get(i));
                        startActivity(homePemilik);
                    }
                }else{
                    wrongPass.setText("Email atau Password yang anda masukan salah!!");
                }
            }
        }
    }


}