package com.seniorsteps.holyqurang16;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.seniorsteps.holyqurang16.Adapters.HadeathRecyclerAdapter;
import com.seniorsteps.holyqurang16.Base.MyBaseFragment;
import com.seniorsteps.holyqurang16.Model.Hadeth;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class HadeathFragment extends MyBaseFragment {


    public HadeathFragment() {
        // Required empty public constructor
    }

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager ;
    HadeathRecyclerAdapter adapter;
    ArrayList<Hadeth> data;

    View view;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view= inflater.inflate(R.layout.fragment_hadeath, container, false);
        recyclerView = view.findViewById(R.id.recycler_view);
        data=ReadAhadethFile();
        adapter = new HadeathRecyclerAdapter(data);
        adapter.setOnItemClickListener(new HadeathRecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int pos, Hadeth hadeth) {
                HadethDialogFragment dialogFragment = new HadethDialogFragment();
                dialogFragment.setHadethContentString(hadeth.getContent());
                dialogFragment.show(getChildFragmentManager(),"hadethDialog");
            }
        });
        layoutManager = new LinearLayoutManager(activity);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);
        return view;
    }

    public ArrayList<Hadeth> ReadAhadethFile(){

            ArrayList<Hadeth>arraylist = new ArrayList<>();
            BufferedReader reader = null;
            try {
                reader = new BufferedReader(
                        new InputStreamReader(activity.getAssets().open("ahadith_arabic.txt")));

                // do reading, usually loop until end of file reading
                String mLine;
                while ((mLine = reader.readLine()) != null) {
                    //process line
                    Hadeth hadeth= new Hadeth();
                    hadeth.setTitle(mLine);
                    Log.e("title",mLine);
                    while ((mLine = reader.readLine()) != null){
                        if(mLine.trim().equals("#"))break;
                        hadeth.setContent(hadeth.getContent()+"\n"+mLine);
                    }
                    Log.e("title",hadeth.getContent());

                    arraylist.add(hadeth);


                }
            } catch (IOException e) {
                //log the exception
            } finally {
                if (reader != null) {
                    try {
                        reader.close();
                    } catch (IOException e) {
                        //log the exception
                    }
                }
            }

            return arraylist;

    }
}
