package com.shahjahan.my_sqlite_database.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.shahjahan.my_sqlite_database.R;
import com.shahjahan.my_sqlite_database.model.Recycler_model;

import org.w3c.dom.Text;

import java.util.List;

public class MY_ADAPTER extends RecyclerView.Adapter<MY_ADAPTER.MY_VIEW_HOLDER> {



    Context context;
    List<Recycler_model> recyclerModel_ListS;



    public MY_ADAPTER(Context context, List<Recycler_model> recyclerModel_ListS) {
        this.context = context;
        this.recyclerModel_ListS = recyclerModel_ListS;
    }







    //MY_VIEW_HOLDER>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>
    public class  MY_VIEW_HOLDER extends RecyclerView.ViewHolder{

        TextView text,text_name,text_degree,text_category,text_chamber;

        public MY_VIEW_HOLDER(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text);
            text_name = itemView.findViewById(R.id.text_name);
            text_degree = itemView.findViewById(R.id.text_degree);
            text_category = itemView.findViewById(R.id.text_category);
            text_chamber = itemView.findViewById(R.id.text_chamber);


        }
    }//MY_VIEW_HOLDER>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>


    @NonNull
    @Override
    public MY_VIEW_HOLDER onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater =  LayoutInflater.from(context);
        View view = layoutInflater.inflate(R.layout.layout_design_xml,parent,false);

        return new MY_VIEW_HOLDER(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MY_VIEW_HOLDER holder, int position) {

        //holder.text.setText(recyclerModel_ListS.get(position).getDr_name()+"\n\n"+recyclerModel_ListS.get(position).getDr_degree()+"\n\n"+""+recyclerModel_ListS.get(position).getDr_category()+"\n\n"+""+recyclerModel_ListS.get(position).getDr_chamber());

        holder.text_name.setText(recyclerModel_ListS.get(position).getDr_name());
        holder.text_degree.setText(recyclerModel_ListS.get(position).getDr_degree());
        holder.text_category.setText(recyclerModel_ListS.get(position).getDr_category());
        holder.text_chamber.setText(recyclerModel_ListS.get(position).getDr_chamber());
    }

    @Override
    public int getItemCount() {
        return recyclerModel_ListS.size();
    }




}
