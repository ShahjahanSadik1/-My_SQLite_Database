package com.shahjahan.my_sqlite_database;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.textfield.TextInputEditText;
import com.shahjahan.my_sqlite_database.adapter.MY_ADAPTER;
import com.shahjahan.my_sqlite_database.model.Recycler_model;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recycler_View;


    TextInputEditText t_i_ed_text_1,t_i_ed_text_2,t_i_ed_text_3,t_i_ed_text_4;
    Button insart_Data_button_1,show_Data_Button_2;



    //sqlite database >>>>>>>>>>>>>>>>>>>>>
    Database_Helper_two db_helher_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);



        WindowCompat.getInsetsController(getWindow(),getWindow().getDecorView())
                .setAppearanceLightStatusBars(true);


        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.Q){
            getWindow().setNavigationBarContrastEnforced(false);
        }





        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });




        t_i_ed_text_1 =findViewById(R.id.t_i_ed_text_1);
        t_i_ed_text_2 =findViewById(R.id.t_i_ed_text_2);
        t_i_ed_text_3 =findViewById(R.id.t_i_ed_text_3);
        t_i_ed_text_4 =findViewById(R.id.t_i_ed_text_4);

        insart_Data_button_1 =findViewById(R.id.insart_Data_button_1);
        show_Data_Button_2 =findViewById(R.id.show_Data_Button_2);


        db_helher_two = new Database_Helper_two(MainActivity.this);















































        insart_Data_button_1.setOnClickListener(v -> {

             String stri_name= t_i_ed_text_1.getText().toString();
             String stri_degree =t_i_ed_text_2.getText().toString();
             String stri_category =t_i_ed_text_3.getText().toString();
             String stri_chamber =t_i_ed_text_4.getText().toString();


             if (stri_name.isEmpty() && stri_degree.isEmpty() && stri_category.isEmpty() && stri_chamber.isEmpty()){
                 t_i_ed_text_1.setError("Enter FirstName");
                 t_i_ed_text_2.setError("Enter FirstName");
                 t_i_ed_text_3.setError("Enter FirstName");
                 t_i_ed_text_4.setError("Enter FirstName");
             }else if (stri_name.isEmpty() && stri_degree.isEmpty() && stri_category.isEmpty()){
                 t_i_ed_text_1.setError("Enter FirstName");
                 t_i_ed_text_2.setError("Enter FirstName");
                 t_i_ed_text_3.setError("Enter FirstName");
             }else if (stri_name.isEmpty() && stri_degree.isEmpty()  && stri_chamber.isEmpty()){
                 t_i_ed_text_1.setError("Enter FirstName");
                 t_i_ed_text_2.setError("Enter FirstName");
                 t_i_ed_text_4.setError("Enter FirstName");
             }else if (stri_name.isEmpty()  && stri_category.isEmpty() && stri_chamber.isEmpty()){
                 t_i_ed_text_1.setError("Enter FirstName");
                 t_i_ed_text_3.setError("Enter FirstName");
                 t_i_ed_text_4.setError("Enter FirstName");
             }else if ( stri_degree.isEmpty() && stri_category.isEmpty() && stri_chamber.isEmpty()){
                 t_i_ed_text_2.setError("Enter FirstName");
                 t_i_ed_text_3.setError("Enter FirstName");
                 t_i_ed_text_4.setError("Enter FirstName");
             }else if ( stri_name.isEmpty() && stri_degree.isEmpty()){
                 t_i_ed_text_1.setError("Enter FirstName");
                 t_i_ed_text_2.setError("Enter FirstName");
             }else if ( stri_degree.isEmpty() && stri_category.isEmpty()){
                 t_i_ed_text_2.setError("Enter FirstName");
                 t_i_ed_text_3.setError("Enter FirstName");
             }else if ( stri_category.isEmpty() && stri_chamber.isEmpty()){
                 t_i_ed_text_3.setError("Enter FirstName");
                 t_i_ed_text_4.setError("Enter FirstName");
             }else if ( stri_name.isEmpty() && stri_category.isEmpty()){
                 t_i_ed_text_1.setError("Enter FirstName");
                 t_i_ed_text_3.setError("Enter FirstName");
             }else if ( stri_name.isEmpty() && stri_chamber.isEmpty()){
                 t_i_ed_text_1.setError("Enter FirstName");
                 t_i_ed_text_4.setError("Enter FirstName");
             }else if (stri_name.isEmpty()){
                 t_i_ed_text_1.setError("Enter FirstName");
             } else if (stri_degree.isEmpty()) {
                 t_i_ed_text_2.setError("Enter FirstName");
             }else if (stri_category.isEmpty()) {
                 t_i_ed_text_3.setError("Enter FirstName");
             }else if (stri_chamber.isEmpty()) {
                 t_i_ed_text_4.setError("Enter FirstName");
             }else {
                 db_helher_two.insart_data(stri_name,stri_degree,stri_category,stri_chamber);
                 Toast.makeText(this, "Data has been insarted ", Toast.LENGTH_SHORT).show();

             }




        });



        show_Data_Button_2.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, Main_Show_Data_Activity.class));
        });




















    }//onCreate mathod end here>>><>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>





}//Publice class_ end here>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>