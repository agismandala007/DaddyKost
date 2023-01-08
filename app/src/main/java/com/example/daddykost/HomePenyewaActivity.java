package com.example.daddykost;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Base64;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

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
import java.util.HashMap;
import java.util.List;
import java.util.stream.Stream;

public class HomePenyewaActivity extends AppCompatActivity {

    TextView helloUser, test;

    String JsonURL1 = "https://daddykos.000webhostapp.com/readKos.php";
    RequestQueue requestQueue1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_penyewa);

        //Say Hello ke yang Login
        Bundle get = getIntent().getExtras();
        String user = get.getString("user");
        helloUser = findViewById(R.id.helo_username);
        helloUser.setText(user);

        test = findViewById(R.id.test_teks);

        //Parse Json List Kosan
        requestQueue1 = Volley.newRequestQueue(this);
        ArrayList<HashMap<String, String>> list = new ArrayList<>();
        HashMap<String, String> map = new HashMap<>();

        JsonArrayRequest arrayKos = new JsonArrayRequest(Request.Method.GET, JsonURL1, null, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                try {
                    for (int i = 0; i < response.length(); i++) {
                        JSONObject jsonObject = response.getJSONObject(i);
                        map.put("namaKos", jsonObject.getString("namaKos"));
                        map.put("email", jsonObject.getString("email"));

//                        byte[] imageBytes = Base64.decode(jsonObject.getString("foto1"), Base64.DEFAULT);
//                        Bitmap bitmap = BitmapFactory.decodeByteArray(imageBytes, 0, imageBytes.length);
//
//                        map.put("foto1", bitmap);
                        list.add(map);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
                SimpleAdapter adapter = new SimpleAdapter(HomePenyewaActivity.this, list, R.layout.list_kosan, new String[]{"namaKos", "email", "foto1"}, new int[]{R.id.list_judul, R.id.list_fasilitas, R.id.img_kosan});
                ListView listView = findViewById(R.id.list_kosan_tersedia);
                listView.setAdapter(adapter);
            }
        },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error){Log.e("Volley", "Error");}
                });
        requestQueue1.add(arrayKos);
    }

}