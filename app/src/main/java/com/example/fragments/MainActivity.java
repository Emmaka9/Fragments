package com.example.fragments;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn1;
    private Button btn2;
    private Button btn3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        //initialize the buttons
        btn1 = findViewById(R.id.btn_frag1);
        btn2 = findViewById(R.id.btn_frag2);
        btn3 = findViewById(R.id.btn_frag3);

        //set onClickListener and functions
        btn1.setOnClickListener(this);
        btn2.setOnClickListener(this);
        btn3.setOnClickListener(this);

    }

    private void fragmentHandler(Fragment fragment, Button btnA, Button btnB, Button btnC){
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        //change button colors when a button is pressed
        btnA.setBackgroundColor(getResources().getColor(R.color.green));
        btnB.setBackgroundColor(getResources().getColor(R.color.olive_green));
        btnC.setBackgroundColor(getResources().getColor(R.color.olive_green));

        //set text color
        btnA.setTextColor(getResources().getColor(R.color.white));
        btnB.setTextColor(getResources().getColor(R.color.black));
        btnC.setTextColor(getResources().getColor(R.color.black));

        transaction.replace(R.id.containerFragment, fragment);
        transaction.addToBackStack(null);
        transaction.commit();


    }

    @Override
    public void onClick(View view) {
        Fragment1 fragment1;
        Fragment2 fragment2;
        Fragment3 fragment3;

        switch (view.getId()){

            case R.id.btn_frag1:
                fragment1 = new Fragment1();
                fragmentHandler(fragment1,btn1, btn2, btn3);

                break;
            case R.id.btn_frag2:
                fragment2 = new Fragment2();
                fragmentHandler(fragment2, btn2, btn1, btn3);
                break;
            case R.id.btn_frag3:
                fragment3 = new Fragment3();
                fragmentHandler(fragment3, btn3, btn1, btn2);
                break;
            default:
                Toast.makeText(this, "Watch what you're doing!!", Toast.LENGTH_SHORT).show();
                break;
        }
    }

}
