package com.example.project_uts;

public class Data {
    public int id;
    public String nama;
    public String email;
    public String komentar;
    public String pertanyaan;

    public Data(int id, String nama, String email, String komentar, String pertanyaan) {
        this.id = id;
        this.nama = nama;
        this.email = email;
        this.komentar = komentar;
        this.pertanyaan = pertanyaan;
    }

    public Data(String nama, String email, String komentar, String pertanyaan) {
        this.nama = nama;
        this.email = email;
        this.komentar = komentar;
        this.pertanyaan = pertanyaan;
    }
}