package com.superprojects.bookyourflightapp.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.superprojects.bookyourflightapp.Models.BookingsModel;
import com.superprojects.bookyourflightapp.R;

import java.util.ArrayList;

public class BookingAdapter extends RecyclerView.Adapter<BookingAdapter.viewHolder>{

    ArrayList<BookingsModel> list;
    Context context;

    public BookingAdapter(ArrayList<BookingsModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.booking_sample,parent,false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {

        final BookingsModel model = list.get(position);
        holder.BookUser.setText(model.getUsername());
        holder.BookFlightN.setText(model.getFlightname());
        holder.BookDesc.setText(model.getDescription());
        holder.price.setText(model.getPrice());

    }


    @Override
    public int getItemCount() {
        return list.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {

        TextView BookUser, BookFlightN, BookDesc, price;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            BookUser = itemView.findViewById(R.id.fuser);
            BookFlightN = itemView.findViewById(R.id.fname);
            BookDesc = itemView.findViewById(R.id.fdes);
            price = itemView.findViewById(R.id.fprice);
        }
    }
}