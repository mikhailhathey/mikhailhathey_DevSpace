package com.mikhailhathey.devspace;

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
        return inflater.inflate(R.layout.fragment_launch, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Button nxtBtn = (Button) getView().findViewById(R.id.mainNxtBtn);

        nxtBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                visitorNameInput = (TextInputEditText) getView().findViewById(R.id.visitorNameInput);
                requiredNameTxtView = (TextView) getView().findViewById(R.id.requiredNameTxtView);

                if(visitorNameInput.getText().length()>0){
                    toMenuFrag();
                }
                else{
                    requiredNameTxtView.setText("Error: Name is required");
                }
            }
        });
    }

    public void toMenuFrag()
    {
        visitorNameInput = (TextInputEditText) getView().findViewById(R.id.visitorNameInput);
        welcomeVisitor = "Dear " + visitorNameInput.getText().toString();

        Bundle visitorBundle = new Bundle();
        visitorBundle.putString(EXTRA_TEXT, welcomeVisitor);

        NavHostFragment.findNavController(this)
                .navigate(R.id.action_LaunchFragment_to_MenuFragment, visitorBundle);
    }
}