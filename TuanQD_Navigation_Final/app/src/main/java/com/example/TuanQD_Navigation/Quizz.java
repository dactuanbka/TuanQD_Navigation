package com.example.TuanQD_Navigation;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.core.view.MenuProvider;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Quizz extends Fragment implements View.OnClickListener {
    View view;

    public Quizz() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Button btnTrue, btnFalse;
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_quizz, container, false);
        btnTrue = view.findViewById(R.id.btnQuizzTrue);
        btnFalse = view.findViewById(R.id.btnQuizzFail);
        requireActivity().addMenuProvider(new MenuProvider() {
            @Override
            public void onCreateMenu(@NonNull Menu menu, @NonNull MenuInflater menuInflater) {
                menuInflater.inflate(R.menu.menu_logout, menu);
            }

            @Override
            public boolean onMenuItemSelected(@NonNull MenuItem menuItem) {

                return NavigationUI.onNavDestinationSelected(menuItem,
                        NavHostFragment.findNavController(Quizz.this));
            }
        }, getViewLifecycleOwner(), Lifecycle.State.RESUMED);
        btnFalse.setOnClickListener(this);
        btnTrue.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View v) {
        NavController navController = Navigation.findNavController(view);
        switch (v.getId()) {
            case (R.id.btnQuizzTrue):
                navController.navigate(QuizzDirections.actionQuizzToCongrat(100));
                break;
            case (R.id.btnQuizzFail):
                navController.navigate(R.id.action_Quizz_to_Fail);
                break;
        }
    }
}