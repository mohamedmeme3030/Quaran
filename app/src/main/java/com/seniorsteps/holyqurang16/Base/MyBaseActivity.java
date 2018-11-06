package com.seniorsteps.holyqurang16.Base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.seniorsteps.holyqurang16.R;

public class MyBaseActivity extends AppCompatActivity{

    protected AppCompatActivity activity;
    MaterialDialog materialDialog;
    public MyBaseActivity(){
        activity=this;
    }


    public void ShowBackButton(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String sTitle= getIntent().getStringExtra("title");
        if(sTitle!=null){
            TextView textView = findViewById(R.id.title);
            if(textView !=null)
                textView.setText(sTitle);
        }
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }

    public MaterialDialog ShowMessage(String title, String content){

        return new MaterialDialog.Builder(this)
                .content(content)
                .title(title)
                .positiveText("ok")
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .show();
    }

    public MaterialDialog ShowProgressBar(){
       materialDialog= new MaterialDialog.Builder(this)
                .progress(true,0)
                 .content("loading...")
                .title("please wait")
                .cancelable(false)
                .show();
       return materialDialog;
    }

    public void HideProgressBar(){
        if(materialDialog!=null&&materialDialog.isShowing())
            materialDialog.dismiss();
    }

    public MaterialDialog ShowConfirmationDialog(String title, String content, String pos, String neg, MaterialDialog.SingleButtonCallback posCallback, MaterialDialog.SingleButtonCallback negCallback){

        return new MaterialDialog.Builder(this)
                .content(content)
                .title(title)
                .positiveText(pos)
                .onPositive(posCallback)
                .negativeText(neg)
                .onNegative(negCallback)
                .show();
    }
    @Override
    public boolean onSupportNavigateUp() {
        onBackPressed();
        return true;
    }


}
