package com.shia.practice115;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomFragment extends BottomSheetDialogFragment {

    EditText insertName;
    Button btnOk, btnCancel;

    private MyBottomSheetFragment myBottomSheetFragment;

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
        myBottomSheetFragment = (MyBottomSheetFragment) context;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = LayoutInflater.from(getContext()).inflate(R.layout.fragment_reg_dialog, null, false);

        insertName = view.findViewById(R.id.insert_name);
        btnOk = view.findViewById(R.id.btn_ok);
        btnCancel = view.findViewById(R.id.btn_cancel);

        btnOk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBottomSheetFragment.onOkBottomClicked(insertName.getText().toString().trim());
                dismiss();
            }
        });

        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myBottomSheetFragment.onCancelBottomClicked();
                dismiss();
            }
        });
        return view;
    }

    public interface MyBottomSheetFragment{
        void onOkBottomClicked(String data);
        void onCancelBottomClicked();
    }
}
