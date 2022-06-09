package com.example.project_uts;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class UpdateDataActivity extends AppCompatActivity {
    public static String EXTRA_DATA = "extra_data";
    int idData;
    EditText etNama, etEmail, etKomentar, etPertanyaan;
    Button btnProses, btnBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_saran);
        setTitle("Update Saran");

        etNama = findViewById(R.id.editTextNama);
        etEmail = findViewById(R.id.editTextEmail);
        etKomentar = findViewById(R.id.editTextKomentar);
        etPertanyaan = findViewById(R.id.editTextPertanyaan);

        btnProses = findViewById(R.id.buttonProses);
        btnBatal = findViewById(R.id.buttonBatal);

        Bundle extras = getIntent().getExtras();
        idData = extras.getInt(EXTRA_DATA);

        initializeText();
    }

    public void initializeText() {
        DbConnection con = new DbConnection(this);
        Data data = con.getData(idData);

        etNama.setText(data.nama);
        etEmail.setText(data.email);
        etKomentar.setText(data.komentar);
        etPertanyaan.setText(data.pertanyaan);
    }

    public void onClickProses(View v) {
        String nama, email, komentar, pertanyaan;
        Intent intent = new Intent(this, LihatSaranActivity.class);
        DbConnection con = new DbConnection(this);

        nama = etNama.getText().toString();
        email = etEmail.getText().toString();
        komentar = etKomentar.getText().toString();
        pertanyaan = etPertanyaan.getText().toString();

        con.updateData(idData, nama, email, komentar, pertanyaan);

        Toast.makeText(this, "Data berhasil diubah!", Toast.LENGTH_SHORT).show();

        startActivity(intent);
        finish();
    }

    public void onClickBatal(View v) {
        Intent intent = new Intent(this, LihatSaranActivity.class);
        startActivity(intent);
        finish();
    }
}