package com.example.navigationcomponent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ConfirmationFragment extends Fragment {
    private TextView confirmationMessage;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_confirmation, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        String recipientName = ConfirmationFragmentArgs.fromBundle(getArguments()).getRecipientName();
        int amount = ConfirmationFragmentArgs.fromBundle(getArguments()).getAmount();

        confirmationMessage = view.findViewById(R.id.confirmation_message);
        confirmationMessage.setText("" + "$" + amount + " was sent to " + recipientName);
    }
}