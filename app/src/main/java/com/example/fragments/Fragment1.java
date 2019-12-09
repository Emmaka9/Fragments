package com.example.fragments;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Fragment1 extends Fragment implements AdapterView.OnItemSelectedListener {

    View view1;
    public Fragment1() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        // Inflate the layout for this fragment
        view1 = inflater.inflate(R.layout.fragment_fragment1, container, false);

        String[] cityString = new String[]{"CHENGDU","CHONGQING","BEIJING","SHANGHAI"  };

        Spinner citySpinner = view1.findViewById(R.id.spinner_city);
        citySpinner.setOnItemSelectedListener(this);
        //create an adapter using the string array and a default spinner_layout

        // Creating adapter for spinner
        ArrayAdapter<String> adapter = new ArrayAdapter<>
                (this.getActivity(), android.R.layout.simple_spinner_dropdown_item, cityString);

        citySpinner.setAdapter(adapter);

        return view1;
    }

    /**
     * This method generates different contents as different items from the
     * spinner are selected.
     *
     * @param cityName
     * @param id
     */

    private void spinnerHandler(String cityName, int id){
        TextView cityTextView = view1.findViewById(R.id.tv_city);
        ImageView cityImageView = view1.findViewById(R.id.iv_city);
        cityTextView.setText(cityName);
        cityImageView.setImageDrawable(getResources().getDrawable(id));
    }

    /**
     *
     * @param parent
     * @param view
     * @param position
     * @param id
     */

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        String cityName = parent.getItemAtPosition(position).toString();

        switch (position){
            case 0:
                int imgID = R.drawable.chengdu;
                spinnerHandler(cityName, imgID);
                break;
            case 1:
                spinnerHandler(cityName, R.drawable.chongqing);
                break;
            case 2:
                spinnerHandler(cityName, R.drawable.beijing);
                break;
            case 3:
                spinnerHandler(cityName, R.drawable.shanghai);
                break;
            default:break;

        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
        Toast.makeText(this.getActivity(), "OnNothingSelectedMethod!!", Toast.LENGTH_LONG).show();
    }
}
