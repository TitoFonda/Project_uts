package com.example.project_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class InputSaranActivity extends AppCompatActivity {
    EditText etNama, etEmail, etKomentar, etPertanyaan;
    Button btnProses, btnBatal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_saran);
        setTitle("Project_uts");

        etNama = findViewById(R.id.editTextNama);
        etEmail = findViewById(R.id.editTextEmail);
        etKomentar = findViewById(R.id.editTextKomentar);
        etPertanyaan = findViewById(R.id.editTextPertanyaan);

        btnProses = findViewById(R.id.buttonProses);
        btnBatal = findViewById(R.id.buttonBatal);
    }

    public void onClickProses(View v) {
        String nama, email, komentar, pertanyaan;
        DbConnection con = new DbConnection(this);

        nama = etNama.getText().toString();
        email = etEmail.getText().toString();
        komentar = etKomentar.getText().toString();
        pertanyaan = etPertanyaan.getText().toString();

        if (etNama.getText().toString().length() == 0) {
            etNama.setError("Harap isi Nama Anda");
        } else if (etEmail.getText().toString().length() == 0){
            etEmail.setError("Harap isi Email Anda.");
        } else if (etKomentar.getText().toString().length() == 0) {
            etKomentar.setError("Harap isi Komentar Anda");
        } else if (etPertanyaan.getText().toString().length() == 0) {
            etPertanyaan.setError("Harap isi Pertanyaan Anda");
        } else {
            con.insertData(nama, email, komentar, pertanyaan);
            Toast.makeText(this, "Data berhasil dimasukkan!", Toast.LENGTH_SHORT).show();
        }
    }

    public void onClickBatal(View v) {
        finish();
    }
}