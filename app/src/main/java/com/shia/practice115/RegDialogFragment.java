package com.shia.practice115;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.DialogFragment;

public class RegDialogFragment extends DialogFragment {

    EditText insertName;
    Button btnOk, btnCancel;

    private MyDialogEventListener myDialogEventListener;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myDialogEventListener = (MyDialogEventListener) context;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_reg_dialog, null, false);

        builder.setView(view);

        insertName = view.findViewById(R.id.insert_name);
        btnOk = view.findViewById(R.id.btn_ok);
        btnCancel = view.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialogEventListener.onOkButtonClicked(insertName.getText().toString().trim());
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myDialogEventListener.onCancelButtonClicked();
                dismiss();
            }
        });

        return builder.create();
    }

    public interface MyDialogEventListener{
        void onOkButtonClicked(String data);
        void onCancelButtonClicked();
    }
}
