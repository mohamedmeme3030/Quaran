package com.seniorsteps.holyqurang16;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.seniorsteps.holyqurang16.Adapters.SurasListAdapter;
import com.seniorsteps.holyqurang16.Base.MyBaseFragment;

import java.util.ArrayList;
import java.util.Arrays;


/**
 * A simple {@link Fragment} subclass.
 */
public class QuranFragment extends MyBaseFragment {


    public QuranFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    SurasListAdapter adapter;
    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_quran, container, false);
        recyclerView =view.findViewById(R.id.recycler_view);
        layoutManager = new LinearLayoutManager(getActivity());
        ArrayList<String> names =
                new ArrayList<>(Arrays.asList(DataHolder.ArSuras));
        adapter= new SurasListAdapter(names);
        adapter.setOnItemClickListener(new SurasListAdapter.OnItemClickListener() {
            @Override
            public void onClick(int position, String name) {
                Intent intent=  new Intent(getActivity(),SuraActivity.class);
                intent.putExtra("file_name",(position+1)+".txt");
                intent.putExtra("title",name);
                startActivity(intent);
            }
        });
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

}
