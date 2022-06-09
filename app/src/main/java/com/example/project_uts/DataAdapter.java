package com.example.project_uts;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class DataAdapter extends ArrayAdapter<Data> {
    List<Data> data;
    List<View> customView;

    public DataAdapter(Context mCtx, int layoutResId, List<Data> data, List<View> customView) {
        super(mCtx, layoutResId, data);
        this.customView = customView;
        this.data = data;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView nama, email, komentar, pertanyaan;
        View view = customView.get(position);

        nama = view.findViewById(R.id.textViewNama);
        email = view.findViewById(R.id.textViewEmail);
        komentar = view.findViewById(R.id.textViewKomentar);
        pertanyaan = view.findViewById(R.id.textViewPertanyaan);

        nama.setText(data.get(position).nama);
        email.setText(data.get(position).email);
        komentar.setText(data.get(position).komentar);
        pertanyaan.setText(data.get(position).pertanyaan);

        view.setTag(data.get(position));

        return view;

    }
}