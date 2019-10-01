package com.example.secondlab;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.fragment.app.DialogFragment;

import java.util.Objects;

public class MyAlertDialogFragment extends DialogFragment {
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Здравствуй МИРЭА!")
                .setMessage("Успех близок?")
                .setIcon(R.mipmap.ic_launcher_round)
                .setPositiveButton("Иду дальше", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((MainActivity) Objects.requireNonNull(getActivity())).onOkClicked();
                        dialog.cancel();
                    }
                })
                .setNeutralButton("На паузе", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                            ((MainActivity) Objects.requireNonNull(getActivity())).onNeutralClicked();
                            dialog.cancel();
                    }
                })
                .setNegativeButton("Нет", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        ((MainActivity) Objects.requireNonNull(getActivity())).onCancelClicked();
                        dialog.cancel();
                    }
                });
        return builder.create();
    }
}
