package com.example.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment3 extends Fragment implements AdapterView.OnItemSelectedListener {

    View view1;

    public Fragment3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_fragment2, container, false);

        String[] universityString = new String[]{"FRONT GATE",
                "LIBRARY BUILDINNG", "MINGBIAN Building", "Boxue Building"};

        Spinner spinner = view1.findViewById(R.id.spinner_university);
        spinner.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this.getActivity(), android.R.layout.simple_spinner_dropdown_item, universityString);
        spinner.setAdapter(adapter);



        return view1;
    }

    /**
     * This method generates different contents as different items from the
     * spinner are selected.
     *
     * @param id
     */

    private void spinnerHandler(int id){

        ImageView universityImageView = view1.findViewById(R.id.iv_university);

        universityImageView.setImageDrawable(getResources().getDrawable(id));
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        switch (position){
            case 0:
                int imgID = R.drawable.frontgate;
                spinnerHandler(imgID);
                break;
            case 1:
                spinnerHandler(R.drawable.library);
                break;
            case 2:
                spinnerHandler(R.drawable.mingbian);
                break;
            case 3:
                spinnerHandler(R.drawable.boxue);
                break;
            default:break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this.getActivity(), "OnNothingSelectedMethod!!", Toast.LENGTH_LONG).show();
    }
}
