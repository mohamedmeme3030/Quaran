package com.seniorsteps.holyqurang16.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seniorsteps.holyqurang16.R;

import java.util.ArrayList;

public class SurasListAdapter extends RecyclerView.Adapter<SurasListAdapter.ViewHolder>{


    ArrayList<String> names;
    OnItemClickListener onItemClickListener;



    public SurasListAdapter(ArrayList<String> names) {
        this.names = names;
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
        final String name= names.get(position);
        holder.name.setText(name);
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
        return names.size();
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

    public interface OnItemClickListener{
        void onClick(int position,String name);
    }
}
