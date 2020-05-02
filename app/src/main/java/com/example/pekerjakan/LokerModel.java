package com.example.pekerjakan;

public class LokerModel {

    private String titlePekerjaan, upahPekerjaan, kontakHandle;

    private LokerModel() {
    }

    private LokerModel(String titlePekerjaan, String upahPekerjaan, String kontakHandle) {
        this.titlePekerjaan = titlePekerjaan;
        this.kontakHandle = kontakHandle;
        this.upahPekerjaan = upahPekerjaan;
    }

    public String getTitlePekerjaan() {
        return titlePekerjaan;
    }

    public void setTitlePekerjaan(String titlePekerjaan) {
        this.titlePekerjaan = titlePekerjaan;
    }

    public String getUpahPekerjaan() {
        return upahPekerjaan;
    }

    public void setUpahPekerjaan(String upahPekerjaan) {
        this.upahPekerjaan = upahPekerjaan;
    }

    public String getKontakHandle() {
        return kontakHandle;
    }

    public void setKontakHandle(String kontakHandle) {
        this.kontakHandle = kontakHandle;
    }
}