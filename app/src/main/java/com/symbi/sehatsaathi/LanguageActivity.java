package com.symbi.sehatsaathi;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.symbi.sehatsaathi.databinding.ActivityLanguageBinding;

public class LanguageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityLanguageBinding binding = ActivityLanguageBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.englishChip.setOnClickListener(v -> openLoginScreen("English"));
        binding.hindiChip.setOnClickListener(v -> openLoginScreen("Hindi"));
        binding.marathiChip.setOnClickListener(v -> openLoginScreen("Marathi"));
    }

    private void openLoginScreen(String selectedLanguage) {
        Intent intent = new Intent(this, LoginActivity.class);
        intent.putExtra("selected_language", selectedLanguage);
        startActivity(intent);
    }
}
