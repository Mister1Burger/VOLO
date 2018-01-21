package com.example.misterburger.volo.Fragments;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.text.TextUtils;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.misterburger.volo.MainActivity;
import com.example.misterburger.volo.ModulesAndController.MainActivityController;
import com.example.misterburger.volo.Player.Player;
import com.example.misterburger.volo.R;
import com.example.misterburger.volo.R2;


import butterknife.BindView;
import butterknife.ButterKnife;

public class DialogFragment extends android.app.DialogFragment {
    @BindView(R2.id.add_name_et)
    EditText add_name_et;
    @BindView(R2.id.gender_rgroup)
    RadioGroup gender_rgroup;
    MainActivityController mainActivityController;

    @RequiresApi(api = Build.VERSION_CODES.M)
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        ButterKnife.bind(this, inflater.inflate(R.layout.add_player_dialog, null));
        mainActivityController = ((MainActivity) getActivity()).getMainActivityController();


        // Inflate and set the layout for the dialog
        // Pass null as the parent view because its going in the dialog layout
        builder.setView(inflater.inflate(R.layout.add_player_dialog, null))
                .setPositiveButton(R.string.add, (dialog, id) -> {
                    addPlayer();
                    //mainActivityController.getRealm().savePlayer(getContext(), addPlayer());
                    ((MainActivity) getActivity()).getFragment(FlagOfFragment.NEW_GAME_FRAGMENT);
                })
                .setNegativeButton(R.string.cancel, (dialog, id) -> DialogFragment.this.getDialog().cancel());
        return builder.create();
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    public void addPlayer() {
        if (mainActivityController.getTmpPlayer().getPlayer() == null) {
            Log.d("TAG", "pump" );
            Player player = new Player();
            Toast.makeText(getContext(), String.valueOf(add_name_et.getText()),
                    Toast.LENGTH_LONG).show();


            gender_rgroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(RadioGroup radioGroup, int i) {
                    switch (i) {
                        case -1:
                            Toast.makeText(getContext(), R.string.chose_the_gender,
                                    Toast.LENGTH_LONG).show();
                            break;
                        case R2.id.male_rbtn:
                            player.setGender(1);
                            break;
                        case R2.id.female_rbtn:
                            player.setGender(2);
                            break;
                        default:
                            break;
                    }
                }
            });


            Log.d("TAG", String.valueOf(player.getGender()));

        } else {
            Player player = mainActivityController.getTmpPlayer().getPlayer();
            add_name_et.setText(player.getName());
            if (TextUtils.isEmpty(add_name_et.getText())) {
                Toast toast = Toast.makeText(getActivity(),
                        R.string.enter_the_name, Toast.LENGTH_SHORT);
                toast.show();
            } else {
                player.setName(String.valueOf(add_name_et.getText()));
            }


        }
    }

}
