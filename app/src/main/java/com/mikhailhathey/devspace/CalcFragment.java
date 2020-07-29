package com.mikhailhathey.devspace;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;
import java.util.Arrays;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link CalcFragment#newInstance} factory method to
 * create an instance of this fragment.
 */

public class CalcFragment extends Fragment {

    EditText num1input;
    EditText num2input;
    EditText num3input;
    TextView calcResults;
    int num1,num2,num3;
    EditText[] calcArray = new EditText[3];

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public CalcFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment CalcFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static CalcFragment newInstance(String param1, String param2) {
        CalcFragment fragment = new CalcFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootView = inflater.inflate(R.layout.fragment_calc, container, false);

        super.onCreateView(inflater, container, savedInstanceState);

        Button calcBackBtn = (Button) rootView.findViewById(R.id.calcBackBtn);
        calcBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //CalcFragment.super.onBackPressed();
                CalcBackBtn();
            }
        });

        num1input = (EditText) rootView.findViewById(R.id.num1input);
        //num1 = Integer.parseInt(num1input.getText().toString());

        num2input = (EditText) rootView.findViewById(R.id.num2input);
        //num2 = Integer.parseInt(num2input.getText().toString());

        num3input = (EditText) rootView.findViewById(R.id.num3input);
        //num3 = Integer.parseInt(num3input.getText().toString());

        int[] calcArray = new int[]{
                Integer.parseInt(num1input.getText().toString()),
                Integer.parseInt(num1input.getText().toString()),
                Integer.parseInt(num1input.getText().toString())};


        Arrays.sort(calcArray);

        Button calcButton = (Button) rootView.findViewById(R.id.calcButton);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                num1input = (EditText) v.findViewById(R.id.num1input);
                num2input = (EditText) v.findViewById(R.id.num2input);
                num3input = (EditText) v.findViewById(R.id.num3input);
                calcResults = (TextView) v.findViewById(R.id.calcResults);
                calcResults.setTextColor(Color.parseColor("#2196F3"));

                if(num1input.getText().length()>0 && num2input.getText().length()>0 && num3input.getText().length()==0)
                {
                    calcGreaterThan();
                }

                else if(num1input.getText().length()>0 && num2input.getText().length()>0 && num3input.getText().length()==0)
                {
                    calcMiddle();
                }

                else if(num1input.getText().length()>0 && num2input.getText().length()>0 && num3input.getText().length()==0)
                {
                    calcLessThan();
                }

                else if(num1input.getText().length()>0 && num2input.getText().length()>0 && num3input.getText().length()>0)
                {
                    calcResults.setTextColor(Color.parseColor("#008000"));
                    calcResults.setText("Nothing to calculate!!!");
                }

                else
                {
                    calcResults.setTextColor(Color.parseColor("#FF0000"));
                    calcResults.setText("2 values required!!!");
                }


                calcResults.setText("The results are:\n" + "Less than:, " + num1 + "\n" + "Middle:, " + num2 + "\n" + "Greater than:, " + num3 + "\n" );
            }
        });

        return rootView;
    }

    public void CalcBackBtn()
    {
        Intent intent = new Intent(getContext(), MenuFragment.class);
        startActivity(intent);
    }


    public void calcLessThan(){
        int num1 = Integer.parseInt(num1input.getText().toString());
    }

    public void calcMiddle(){
        int num2 = Integer.parseInt(num2input.getText().toString());
    }

    public void calcGreaterThan(){
        int num3 = Integer.parseInt(num3input.getText().toString());
    }
}