package com.example.navigationcomponent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.NavDirections;
import androidx.navigation.Navigation;

public class SpecifyAmountFragment extends Fragment {
    private NavController navController;
    private Button sendButton, cancelButton;
    private EditText editTextAmount;
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_specify_amount, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        navController = Navigation.findNavController(view);
        editTextAmount = view.findViewById(R.id.input_amount);
        sendButton = view.findViewById(R.id.send_btn);
        cancelButton = view.findViewById(R.id.cancel_btn);

        final String recipient = SpecifyAmountFragmentArgs.fromBundle(getArguments()).getRecipientName();

        sendButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int amount = Integer.parseInt(editTextAmount.getText().toString());
                NavDirections navDirections = SpecifyAmountFragmentDirections
                        .actionSpecifyAmountFragmentToConfirmationFragment(recipient, amount);
                navController.navigate(navDirections);
            }
        });

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigateUp();
            }
        });
    }
}