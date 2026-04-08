package com.symbi.sehatsaathi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.symbi.sehatsaathi.databinding.ActivityPatientDetailsBinding;

public class PatientDetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPatientDetailsBinding binding = ActivityPatientDetailsBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.nameInput.setText("Rajesh Sober");
        binding.phoneValue.setText("+91 99766 43210");
        binding.ageValue.setText("34 years");
        binding.genderValue.setText("Male");
        binding.conditionsValue.setText("Diabetes | Heart Care");

        binding.continueButton.setOnClickListener(v ->
                startActivity(new Intent(this, TrustedContactsActivity.class)));
    }
}
