package com.seniorsteps.holyqurang16;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class HadethDialogFragment extends DialogFragment {


    View view;
    String HadethContentString;

    public void setHadethContentString(String hadethContentString) {
        HadethContentString = hadethContentString;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view =inflater.inflate(R.layout.hadeth_dialog_fragment,container,false);
        Log.e("conent",HadethContentString+"");
        TextView content = view.findViewById(R.id.content);
        content.setText(HadethContentString);
        return view;
    }
}
