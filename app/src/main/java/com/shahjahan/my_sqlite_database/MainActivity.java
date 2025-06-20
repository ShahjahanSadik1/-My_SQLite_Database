package com.shahjahan.my_sqlite_database;

import android.os.Bundle;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    TextInputEditText vt_i_ed_text_1,t_i_ed_text_2;
    Button Insart_Data_button_1,Show_Data_Button_2;

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


        vt_i_ed_text_1 =findViewById(R.id.t_i_ed_text_1);
        t_i_ed_text_2 =findViewById(R.id.t_i_ed_text_2);

        Insart_Data_button_1 =findViewById(R.id.Insart_Data_button_1);
        Show_Data_Button_2 =findViewById(R.id.Show_Data_Button_2);








    }//onCreate mathod end here>>><>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>





}//Publice class_ end here>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>