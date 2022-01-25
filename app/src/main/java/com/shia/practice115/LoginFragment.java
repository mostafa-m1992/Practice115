package com.shia.practice115;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class LoginFragment extends Fragment {

    EditText editName, editPass;
    Button btnLogin;

    public static final String KEY_NAME = "name";
    public static final String KEY_PASS = "pass";

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_login, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {

        editName = view.findViewById(R.id.editName);
        editPass = view.findViewById(R.id.editPass);
        btnLogin = view.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String interName = editName.getText().toString().trim();
                String interPass = editPass.getText().toString().trim();

                Bundle bundle = new Bundle();

                bundle.putString(KEY_NAME, interName);
                bundle.putString(KEY_PASS, interPass);

                GetLoginFragment getLoginFragment = new GetLoginFragment();
                getLoginFragment.setArguments(bundle);

                FragmentTransaction transaction = getFragmentManager().beginTransaction();
                transaction.replace(R.id.frame1, getLoginFragment);
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });
    }
}
