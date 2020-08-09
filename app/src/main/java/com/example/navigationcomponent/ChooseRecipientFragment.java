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

public class ChooseRecipientFragment extends Fragment {
    private NavController navController;
    private Button nextButton, cancelButton;
    private EditText editTextRecipient;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_choose_recipient, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        editTextRecipient = view.findViewById(R.id.input_recipient);
        nextButton = view.findViewById(R.id.next_btn);
        cancelButton = view.findViewById(R.id.cancel_btn);

        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String recipientName = editTextRecipient.getText().toString();
                NavDirections navDirections = ChooseRecipientFragmentDirections
                        .actionChooseRecipientFragmentToSpecifyAmountFragment(recipientName);
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