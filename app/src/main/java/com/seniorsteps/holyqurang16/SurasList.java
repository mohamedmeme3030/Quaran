package com.seniorsteps.holyqurang16;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.seniorsteps.holyqurang16.Adapters.SurasListAdapter;

import java.util.ArrayList;
import java.util.Arrays;

public class SurasList extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SurasListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suras_list);
        recyclerView =findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(this);
        ArrayList<String> names =
                new ArrayList<>(Arrays.asList(DataHolder.ArSuras));
        adapter= new SurasListAdapter(names);
        adapter.setOnItemClickListener(new SurasListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, String name) {
               Intent intent=  new Intent(SurasList.this,SuraContent.class);
                intent.putExtra("file_name",(position+1)+".txt");
                intent.putExtra("name",name);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
    }
}
