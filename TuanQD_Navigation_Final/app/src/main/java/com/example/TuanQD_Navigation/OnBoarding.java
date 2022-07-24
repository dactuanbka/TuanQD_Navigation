package com.example.TuanQD_Navigation;

import android.os.Bundle;

import androidx.activity.OnBackPressedCallback;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

public class OnBoarding extends Fragment {
    int backCount = 0;

    public OnBoarding() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        OnBackPressedCallback callback = new OnBackPressedCallback(true /* enabled by default */) {
            @Override
            public void handleOnBackPressed() {
                // Handle the back button event
                backCount = backCount + 1;
                if (backCount < 2) {
                    Toast.makeText(requireActivity(), "Nhấn thêm lần nữa để thoát", Toast.LENGTH_SHORT).show();
                } else {
                    backCount = 0;
                    requireActivity().finish();
                }
            }
        };
        requireActivity().getOnBackPressedDispatcher().addCallback(this, callback);

        // The callback can be enabled or disabled here or in handleOnBackPressed()
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_on_boarding, container, false);
        view.findViewById(R.id.btnNext).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController = Navigation.findNavController(view);
                navController.navigate(R.id.action_onBoading_to_Intro);
            }
        });

        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        backCount = 0;
    }
}