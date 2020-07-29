package com.mikhailhathey.devspace;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import android.text.method.LinkMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link DevProfileFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class DevProfileFragment extends Fragment {

    private static final int callRequest=1;

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public DevProfileFragment() {
        // Required empty public constructor
    }


    public static DevProfileFragment newInstance(String param1, String param2) {
        DevProfileFragment fragment = new DevProfileFragment();
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
    public View onCreateView(LayoutInflater inflater,ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_dev_profile, container, false);

        super.onCreateView(inflater, container, savedInstanceState);

        Button devBackBtn = (Button) rootView.findViewById(R.id.devBackBtn);
        devBackBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //DevProfileFragment.super.onBackPressed();
                BackBtn();
            }
        });

        TextView myDetails = (TextView) rootView.findViewById(R.id.myDetails);
        myDetails.setPaintFlags(myDetails.getPaintFlags()| Paint.UNDERLINE_TEXT_FLAG);

        TextView nameTextView = (TextView) rootView.findViewById(R.id.nameTextView);
        nameTextView.setMovementMethod(LinkMovementMethod.getInstance());

        TextView linkedInId = (TextView) rootView.findViewById(R.id.linkedInId);
        linkedInId.setMovementMethod(LinkMovementMethod.getInstance());

        TextView twitterHandle = (TextView) rootView.findViewById(R.id.twitterHandle);
        twitterHandle.setMovementMethod(LinkMovementMethod.getInstance());

        TextView emailTxt = (TextView) rootView.findViewById(R.id.emailTxt);
        emailTxt.setMovementMethod(LinkMovementMethod.getInstance());


        TextView contactNum = (TextView) rootView.findViewById(R.id.contactNum);
        contactNum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mikhailCaller();
            }
        });

        return rootView;
    }

    public void BackBtn()
    {
        Intent intent = new Intent(getContext(), MenuFragment.class);
        startActivity(intent);
    }

    public void mikhailCaller()
    {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + "0747973637"));

        if(ContextCompat.checkSelfPermission(getContext(), Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED)
        {
            requestPermissions(new String[] {Manifest.permission.CALL_PHONE}, callRequest);
        }

        else
        {
            startActivity(intent);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if(requestCode == callRequest)
        {
            if(grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED)
            {
                mikhailCaller();
            }

            else
            {
                Toast.makeText(getContext(), "Permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }
}