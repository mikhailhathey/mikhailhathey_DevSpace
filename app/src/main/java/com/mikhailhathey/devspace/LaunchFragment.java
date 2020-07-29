package com.mikhailhathey.devspace;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import com.google.android.material.textfield.TextInputEditText;

public class LaunchFragment extends Fragment {
    public String welcomeVisitor;
    TextInputEditText visitorNameInput;
    TextView requiredNameTxtView;
    public static final String EXTRA_TEXT = "com.mikhailhathey.devspace";


    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        final View rootView = inflater.inflate(R.layout.fragment_launch, container, false);

        super.onCreateView(inflater, container, savedInstanceState);

        Button nxtBtn = (Button) rootView.findViewById(R.id.mainNxtBtn);

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitorNameInput = (TextInputEditText) view.findViewById(R.id.visitorNameInput);
                requiredNameTxtView = (TextView) view.findViewById(R.id.requiredNameTxtView);

                if(visitorNameInput.getText().length()>0){
                    MenuFragment();
                }
                else{
                    requiredNameTxtView.setText("Error: Name is required");
                }
            }
        });

        return rootView;
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {


        view.findViewById(R.id.mainNxtBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(LaunchFragment.this)
                        .navigate(R.id.action_MenuFragment_to_LaunchFragment);
            }
        });
    }

    public void MenuFragment()
    {
        visitorNameInput = (TextInputEditText) getView().findViewById(R.id.visitorNameInput);
        welcomeVisitor = "Dear " + visitorNameInput.getText().toString();

        Intent intent = new Intent(getActivity(), MenuFragment.class);
        intent.putExtra(EXTRA_TEXT, welcomeVisitor);

        getActivity().startActivity(intent);

    }
}