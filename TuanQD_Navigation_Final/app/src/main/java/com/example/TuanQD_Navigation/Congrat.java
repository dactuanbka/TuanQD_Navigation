package com.example.TuanQD_Navigation;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Congrat extends Fragment {

    public Congrat() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_congrat, container, false);
        int myArg= CongratArgs.fromBundle(getArguments()).getMyArg();
        TextView txtScore = view.findViewById(R.id.txtScore);
        txtScore.setText("Score: \n"+String.valueOf(myArg));
        view.findViewById(R.id.btnCongratRetest).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NavController navController= Navigation.findNavController(view);
                navController.navigate(R.id.action_Congrat_to_Quizz);
            }
        });
        return view;
    }
}