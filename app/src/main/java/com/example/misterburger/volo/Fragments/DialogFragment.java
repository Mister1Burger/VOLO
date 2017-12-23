package com.example.misterburger.volo.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.EditText;
import android.widget.Spinner;

import com.example.misterburger.volo.R;
import com.example.misterburger.volo.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Burge on 15.12.2017.
 */

public class DialogFragment extends android.app.DialogFragment {
    @BindView(R2.id.add_name_et)
    EditText add_name_et;
    @BindView(R2.id.add_gender_spnr)
    Spinner add_gender_spnr;
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        ButterKnife.bind(this,inflater.inflate(R.layout.add_player_dialog, null));

        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.add_player_dialog, null))
                .setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {

                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        DialogFragment.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}
