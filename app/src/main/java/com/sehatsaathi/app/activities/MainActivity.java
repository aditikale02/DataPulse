package com.sehatsaathi.app.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.sehatsaathi.app.R;
import com.sehatsaathi.app.databinding.ActivityMainBinding;
import com.sehatsaathi.app.fragments.HomeFragment;
import com.sehatsaathi.app.fragments.SettingsFragment;
import com.sehatsaathi.app.fragments.placeholders.PlaceholderFragment;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.bottomNav.setOnItemSelectedListener(item -> {
            Fragment fragment;
            int itemId = item.getItemId();
            if (itemId == R.id.nav_home) {
                fragment = HomeFragment.newInstance();
            } else if (itemId == R.id.nav_settings) {
                fragment = SettingsFragment.newInstance();
            } else if (itemId == R.id.nav_history) {
                fragment = PlaceholderFragment.newInstance(
                        getString(R.string.history),
                        getString(R.string.section_coming_soon)
                );
            } else {
                fragment = PlaceholderFragment.newInstance(
                        getString(R.string.prescription),
                        getString(R.string.summary_hint)
                );
            }
            switchFragment(fragment);
            return true;
        });

        if (savedInstanceState == null) {
            binding.bottomNav.setSelectedItemId(R.id.nav_home);
        }
    }

    public void selectBottomNavItem(int itemId) {
        binding.bottomNav.setSelectedItemId(itemId);
    }

    private void switchFragment(Fragment fragment) {
        getSupportFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, fragment)
                .commit();
    }
}
