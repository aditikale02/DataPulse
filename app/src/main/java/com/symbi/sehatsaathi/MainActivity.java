package com.symbi.sehatsaathi;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;

import androidx.appcompat.app.AppCompatActivity;

import com.symbi.sehatsaathi.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private final Handler handler = new Handler(Looper.getMainLooper());
    private final Runnable moveNext = this::openLanguageScreen;
    private boolean navigated;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.getRoot().setOnClickListener(v -> openLanguageScreen());
        binding.startPrototypeButton.setOnClickListener(v -> openLanguageScreen());
        handler.postDelayed(moveNext, 1800);
    }

    private void openLanguageScreen() {
        if (navigated) {
            return;
        }
        navigated = true;
        startActivity(new Intent(this, LanguageActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        handler.removeCallbacks(moveNext);
        super.onDestroy();
    }
}
