package com.seniorsteps.holyqurang16;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.seniorsteps.holyqurang16.Adapters.VersesAdapter;
import com.seniorsteps.holyqurang16.Base.MyBaseActivity;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class SuraContent extends MyBaseActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    VersesAdapter adapter;
    TextView suraName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sura_content);
        recyclerView = findViewById(R.id.recycler_view);
        suraName = findViewById(R.id.suraName);
        String fileName = getIntent().getStringExtra("file_name");
        String sura_name = getIntent().getStringExtra("name");
        suraName.setText(sura_name);
        ArrayList<String> allVerses = ReadSura(fileName);
        layoutManager = new LinearLayoutManager(this);
        adapter = new VersesAdapter(allVerses);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);

    }
  public ArrayList<String> ReadSura(String file_name){
        ArrayList<String>arraylist = new ArrayList<>();
      BufferedReader reader = null;
      try {
          reader = new BufferedReader(
                  new InputStreamReader(getAssets().open(file_name)));

          // do reading, usually loop until end of file reading
          String mLine;
          while ((mLine = reader.readLine()) != null) {
              //process line
              arraylist.add(mLine);
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
