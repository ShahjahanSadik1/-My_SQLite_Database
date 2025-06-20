package com.shahjahan.my_sqlite_database;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText t_i_ed_text_1,t_i_ed_text_2;
    Button insart_Data_button_1,show_Data_Button_2;


    //sqlite database >>>>>>>>>>>>>>>>>>>>>
    Database_Helper db_helper;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });


        t_i_ed_text_1 =findViewById(R.id.t_i_ed_text_1);
        t_i_ed_text_2 =findViewById(R.id.t_i_ed_text_2);

        insart_Data_button_1 =findViewById(R.id.insart_Data_button_1);
        show_Data_Button_2 =findViewById(R.id.show_Data_Button_2);

        db_helper= new Database_Helper(MainActivity.this);



        insart_Data_button_1.setOnClickListener(v -> {



            db_helper.insartData(t_i_ed_text_1.getText().toString(),t_i_ed_text_2.getText().toString());
            Toast.makeText(this, "Data has been insarted ", Toast.LENGTH_SHORT).show();
        });





    }//onCreate mathod end here>>><>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>





}//Publice class_ end here>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>