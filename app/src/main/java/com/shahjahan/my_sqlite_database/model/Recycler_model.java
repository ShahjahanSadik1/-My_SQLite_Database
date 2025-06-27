package com.shahjahan.my_sqlite_database.model;

import android.content.Context;

public class Recycler_model {


    private String Dr_name;
    private  String Dr_degree;
    private String Dr_category;
    private String Dr_chamber;


    public Recycler_model(String dr_name, String dr_degree, String dr_category, String dr_chamber) {
        Dr_name = dr_name;
        Dr_degree = dr_degree;
        Dr_category = dr_category;
        Dr_chamber = dr_chamber;
    }

    public String getDr_name() {
        return Dr_name;
    }

    public String getDr_degree() {
        return Dr_degree;
    }

    public String getDr_category() {
        return Dr_category;
    }

    public String getDr_chamber() {
        return Dr_chamber;
    }
}
