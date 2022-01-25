package com.shia.practice115;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.squareup.picasso.Picasso;

public class MainActivity2 extends AppCompatActivity implements RegDialogFragment.MyDialogEventListener, BottomFragment.MyBottomSheetFragment{

    ImageView image;
    Button login, register, email;
    TextView regTxt, txtEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        image = findViewById(R.id.image);
        Picasso.get().load(R.drawable.pic2).into(image);

        login = findViewById(R.id.login);
        register = findViewById(R.id.register);
        
        regTxt = findViewById(R.id.regTxt);

        email = findViewById(R.id.email);
        txtEmail = findViewById(R.id.txtEmail);

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                transaction.add(R.id.frame1, new LoginFragment());
                transaction.addToBackStack(null);
                transaction.commit();
            }
        });

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegDialogFragment regDialogFragment = new RegDialogFragment();
                regDialogFragment.setCancelable(false);
                regDialogFragment.show(getSupportFragmentManager(), null);
            }
        });

        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                BottomFragment bottomFragment = new BottomFragment();
                bottomFragment.setCancelable(false);
                bottomFragment.show(getSupportFragmentManager(), null);
            }
        });
    }


    @Override
    public void onOkButtonClicked(String data) {
        regTxt.setText(data);
    }

    @Override
    public void onCancelButtonClicked() {
        Toast.makeText(getApplicationContext(), "register canceled", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onOkBottomClicked(String data) {
        txtEmail.setText(data);
    }

    @Override
    public void onCancelBottomClicked() {
        Toast.makeText(getApplicationContext(), "email canceled", Toast.LENGTH_SHORT).show();
    }
}