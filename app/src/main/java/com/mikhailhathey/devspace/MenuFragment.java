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

public class MenuFragment extends Fragment {
    public String welcomeVisitor;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        return inflater.inflate(R.layout.fragment_menu, container, false);
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        view.findViewById(R.id.myDevBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_LaunchFragment);
            }
        });

        visitorName();

        Button homeBtn = (Button) view.findViewById(R.id.homeBtn);
        homeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_LaunchFragment);
            }
        });

        Button calcBtn = (Button) view.findViewById(R.id.calcBtn);
        calcBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_calcFragment);
            }
        });

        Button aboutBtn = (Button) view.findViewById(R.id.aboutBtn);
        aboutBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_aboutFragment);
            }
        });

        Button myDevBtn = (Button) view.findViewById(R.id.myDevBtn);
        myDevBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavHostFragment.findNavController(MenuFragment.this)
                        .navigate(R.id.action_MenuFragment_to_devProfileFragment);
            }
        });
    }

    public void visitorName(){
        Intent intent = getActivity().getIntent();
        welcomeVisitor = intent.getStringExtra(LaunchFragment.EXTRA_TEXT);

        TextView dearVisitor = (TextView) getView().findViewById(R.id.dearVisitor);
        dearVisitor.setText(welcomeVisitor);
    }

    public void LaunchFragment()
    {
        Intent intent = new Intent(getActivity(), LaunchFragment.class);
        startActivity(intent);
    }

    public void CalcFragment()
    {
        Intent intent = new Intent(getActivity(), CalcFragment.class);
        startActivity(intent);
    }

    public void AboutFragment()
    {
        Intent intent = new Intent(getActivity(), AboutFragment.class);
        startActivity(intent);
    }

    public void DevProfileFragment()
    {
        Intent intent = new Intent(getActivity(), DevProfileFragment.class);
        startActivity(intent);
    }
}