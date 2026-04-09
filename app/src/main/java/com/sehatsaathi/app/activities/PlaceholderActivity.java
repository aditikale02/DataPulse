package com.sehatsaathi.app.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sehatsaathi.app.constants.AppConstants;
import com.sehatsaathi.app.databinding.ActivityPlaceholderBinding;

public class PlaceholderActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityPlaceholderBinding binding = ActivityPlaceholderBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.textTitle.setText(getIntent().getStringExtra(AppConstants.EXTRA_TITLE));
        binding.textMessage.setText(getIntent().getStringExtra(AppConstants.EXTRA_MESSAGE));
        binding.buttonBack.setOnClickListener(v -> finish());
    }
}
