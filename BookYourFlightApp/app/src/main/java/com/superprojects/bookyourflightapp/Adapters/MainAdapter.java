package com.superprojects.bookyourflightapp.Adapters;


import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.superprojects.bookyourflightapp.Models.MainModel;
import com.superprojects.bookyourflightapp.PaymentActivity;
import com.superprojects.bookyourflightapp.R;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.viewholder>{

    ArrayList<MainModel> list;
    Context context;

    public MainAdapter(ArrayList<MainModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.sample_mainflight,parent,false);
        return new viewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewholder holder, int position) {

        final MainModel model = list.get(position);
        holder.fmaname.setText(model.getFlightname());
        holder.fmadesc.setText(model.getDescription());
        holder.fmaprice.setText(model.getPrice());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, PaymentActivity.class);
                intent.putExtra("flightname",model.getFlightname());
                intent.putExtra("description",model.getDescription());
                intent.putExtra("price",model.getPrice());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewholder extends RecyclerView.ViewHolder {

        TextView fmaname, fmadesc, fmaprice;

        public viewholder(@NonNull View itemView) {
            super(itemView);

            fmaname= itemView.findViewById(R.id.fname);
            fmadesc= itemView.findViewById(R.id.fdesc);
            fmaprice= itemView.findViewById(R.id.fprice);

        }
    }
}


