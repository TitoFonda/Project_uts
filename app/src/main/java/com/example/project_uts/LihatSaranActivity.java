package com.example.project_uts;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class LihatSaranActivity extends AppCompatActivity {

    ListView lvSaran;
    AlertDialog.Builder dialog;
    LayoutInflater inflater;
    View dialogView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lihat_saran);
        setTitle("Project_uts");

        lvSaran = findViewById(R.id.listViewLihatSaran);
        initializeRuangan();
    }


    public void onClickKembali(View v) {
        finish();
    }

    public void initializeRuangan() {
        DbConnection con = new DbConnection(this);
        List<Data> data = con.getDatas();
        List<View> view = new ArrayList<>();

        for (Data item : data) {
            view.add(createSaranView());
        }

        DataAdapter adapter = new DataAdapter(LihatSaranActivity.this, R.layout.view_saran, data, view);
        lvSaran.setAdapter(adapter);
    }

    public View createSaranView() {
        View view = getLayoutInflater().inflate(R.layout.view_saran, null);

        view.setOnClickListener(v -> {
            AlertDialog.Builder dialog = new AlertDialog.Builder(LihatSaranActivity.this);
            String[] menuItems = {"Update", "Delete"};
            dialog.setTitle("Pilih Menu");
            Data data = (Data) v.getTag();
            dialog.setItems(menuItems, (dialogInterface, i) -> {
                switch (i) {
                    case 0:
                        updateData(data);
                        break;
                    case 1:
                        deleteData(data);
                        break;
                }
                initializeRuangan();
            });
            dialog.show();
        });

        return view;
    }

    public void updateData(Data data) {
        Intent intent = new Intent(this, UpdateDataActivity.class);
        intent.putExtra(UpdateDataActivity.EXTRA_DATA, data.id);
        startActivity(intent);
        finish();
    }

//    public void deleteData(Data data) {
//        DbConnection con = new DbConnection(this);
//        con.deleteData(data.id);
//
//        Toast.makeText(this, "Data berhasil dihapus!", Toast.LENGTH_SHORT).show();
//    }

    public void deleteData(Data data) {
        DbConnection con = new DbConnection(this);
        dialog = new AlertDialog.Builder(LihatSaranActivity.this);
        dialog.setCancelable(true);
        dialog.setMessage("Apakah anda yakin ingin menghapus data ini?");
        dialog.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                con.deleteData(data.id);
                dialog.dismiss();

                startActivity(new Intent(LihatSaranActivity.this, MainActivity.class));
            }
        });
        dialog.setNegativeButton("Tidak", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        dialog.show();
    }
}