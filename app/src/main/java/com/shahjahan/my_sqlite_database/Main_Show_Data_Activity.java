package com.shahjahan.my_sqlite_database;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.shahjahan.my_sqlite_database.adapter.MY_ADAPTER;
import com.shahjahan.my_sqlite_database.model.Recycler_model;

import java.util.ArrayList;
import java.util.List;

public class Main_Show_Data_Activity extends AppCompatActivity {

    RecyclerView recycler_View;
   // List<Recycler_model> recyclerModel_Lists = new ArrayList<>();
    MY_ADAPTER my_adapter;

   // Database_Helper database_helper;
    Database_Helper_two database_helper_two;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);


        //StatusBars color>>>>>>>>>>>>>>>>>
        WindowCompat.getInsetsController(getWindow(),getWindow().getDecorView())
                .setAppearanceLightStatusBars(true);


        //NavigationBar color>>>>>>>>>>>>>>>>
        if (Build.VERSION.SDK_INT>= Build.VERSION_CODES.Q){
            getWindow().setNavigationBarContrastEnforced(false);
        }



        setContentView(R.layout.activity_main_show_data);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        recycler_View = findViewById(R.id.recycler_View);

       // database_helper = new Database_Helper(Main_Show_Data_Activity.this);











        database_helper_two = new Database_Helper_two(this);
        Cursor cursor = database_helper_two.All_data();
        //Cursor cursor = database_helper_two.SearchDataBy_id(5);
        //tv_Display.setText(""+cursor.getCount());

        search_code_here(cursor);


    }//Oncreate mathod end here>>>>>>>>>>>>>>>>>>>>>>>>


    public void search_code_here(Cursor cursor){
        //Cursor cursor = database_helper_two.SearchDataBy_name(query);


        // Cursor cursor = database_helper_two.SearchDataBy_name(query);
        //condition>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
        if (cursor != null && cursor.getCount() > 0) {

            List<Recycler_model> recyclerModel_Lists = new ArrayList<>();

            while (cursor.moveToNext()) {

                int id = cursor.getInt(0);
                String Dr_name = cursor.getString(1);
                String Dr_degree = cursor.getString(2);
                String Dr_category = cursor.getString(3);
                String Dr_chamber = cursor.getString(4);

                // tv_Display.append("ID :"+id+"NAME :"+name+"MOBILE :"+mobile+"\n");
                recyclerModel_Lists.add(new Recycler_model("" + id + Dr_name, "" + Dr_degree, "" + Dr_category, "" + Dr_chamber));
                my_adapter = new MY_ADAPTER(Main_Show_Data_Activity.this, recyclerModel_Lists);

            }

            // db_helper.insartData(t_i_ed_text_1.getText().toString(),t_i_ed_text_2.getText().toString());


            //add my adapter>>>>>>>>>>
            recycler_View.setAdapter(my_adapter);
            recycler_View.setLayoutManager(new LinearLayoutManager(Main_Show_Data_Activity.this));

        } else {
            Toast.makeText(Main_Show_Data_Activity.this, "No Data ", Toast.LENGTH_SHORT).show();
        }//condition>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>

    }//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>



}//Publice class end here>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>