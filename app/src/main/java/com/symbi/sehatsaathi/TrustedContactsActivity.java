package com.symbi.sehatsaathi;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.symbi.sehatsaathi.databinding.ActivityTrustedContactsBinding;

public class TrustedContactsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityTrustedContactsBinding binding = ActivityTrustedContactsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.contactNameInput.setText("Mable");
        binding.contactPhoneValue.setText("+91 440");
        binding.patientPhoneValue.setText("991 98766 43210");

        binding.continueButton.setOnClickListener(v ->
                Snackbar.make(binding.getRoot(), R.string.prototype_complete, Snackbar.LENGTH_LONG).show());
    }
}
