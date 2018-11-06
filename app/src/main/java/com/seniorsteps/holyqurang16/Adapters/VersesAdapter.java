package com.seniorsteps.holyqurang16.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seniorsteps.holyqurang16.R;

import java.util.ArrayList;

public class VersesAdapter extends RecyclerView.Adapter<VersesAdapter.ViewHolder>{


    ArrayList<String> ayat;
    OnItemClickListener onItemClickListener;



    public VersesAdapter(ArrayList<String> ayat) {
        this.ayat = ayat;
    }



    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sura_item_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        final String name= ayat.get(position);
        holder.name.setText(name+" {"+(position+1)+"}");
        if(onItemClickListener!=null)
            holder.cell.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onClick(position,name);
                }
            });
    }

    @Override
    public int getItemCount() {
        return ayat.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name;
        View cell;
        ViewHolder(View view){
            super(view);
            name= view.findViewById(R.id.name);
            cell =view;
        }

    }

    interface OnItemClickListener{
        void onClick(int position, String name);
    }
}
