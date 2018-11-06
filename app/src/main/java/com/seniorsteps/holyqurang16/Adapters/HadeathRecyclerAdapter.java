package com.seniorsteps.holyqurang16.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.seniorsteps.holyqurang16.Model.Hadeth;
import com.seniorsteps.holyqurang16.R;

import java.util.ArrayList;

public class HadeathRecyclerAdapter extends RecyclerView.Adapter<HadeathRecyclerAdapter.ViewHolder> {

    ArrayList<Hadeth> items;
    OnItemClickListener onItemClickListener;

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public HadeathRecyclerAdapter(ArrayList<Hadeth> items){
        this.items=items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hadeath_item_view,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        final Hadeth hadeth= items.get(position);
        holder.name.setText(hadeth.getTitle());
        if(onItemClickListener!=null)
            holder.parent.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onItemClickListener.onItemClick(position,hadeth);
                }
            });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{
        TextView name;
        View parent;
        ViewHolder(View v){
            super(v);
            name= v.findViewById(R.id.name);
            parent = v;
        }

    }

    public interface OnItemClickListener{
       void onItemClick(int pos,Hadeth hadeth);
    }
}
