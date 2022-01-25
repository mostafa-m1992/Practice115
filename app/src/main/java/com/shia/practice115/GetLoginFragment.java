package com.shia.practice115;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class GetLoginFragment extends Fragment {

    TextView txtName, txtPass;
    Button btnAgree;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_get_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        txtName = view.findViewById(R.id.txtName);
        txtPass = view.findViewById(R.id.txtPass);
        btnAgree = view.findViewById(R.id.btnAgree);

        String getName = getArguments().getString(LoginFragment.KEY_NAME);
        String getPass = getArguments().getString(LoginFragment.KEY_PASS);

        txtName.setText(getName);
        txtPass.setText(getPass);

        btnAgree.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
                transaction.add(R.id.frameAgree, new AgreeFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
