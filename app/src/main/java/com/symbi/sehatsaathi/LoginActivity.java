package com.symbi.sehatsaathi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.symbi.sehatsaathi.databinding.ActivityLoginBinding;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLoginBinding binding = ActivityLoginBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        String language = getIntent().getStringExtra("selected_language");
        if (language != null && !language.isEmpty()) {
            binding.languageBadge.setText(getString(R.string.selected_language_format, language));
        }

        binding.mobileInput.setText("+91 98765-43210");
        binding.otpButton.setOnClickListener(v -> openPatientDetails());
        binding.skipText.setOnClickListener(v -> openPatientDetails());
    }

    private void openPatientDetails() {
        startActivity(new Intent(this, PatientDetailsActivity.class));
    }
}
