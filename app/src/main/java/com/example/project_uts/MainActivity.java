package com.example.project_uts;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.firebase.analytics.FirebaseAnalytics;

public class MainActivity<mFirebaseAnalytics> extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Project_uts_moprog");
        DbConnection con = new DbConnection(this);
        con.createTable();
    }

    public void onClickLihatSaran(View v) {
        Intent intent = new Intent(this, LihatSaranActivity.class);
        startActivity(intent);
    }

    public void onClickInputSaran(View v) {
        Intent intent = new Intent(this, InputSaranActivity.class);
        startActivity(intent);
    }
}