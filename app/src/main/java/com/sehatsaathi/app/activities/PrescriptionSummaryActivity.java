package com.sehatsaathi.app.activities;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.sehatsaathi.app.R;
import com.sehatsaathi.app.databinding.ActivityPrescriptionSummaryBinding;
import com.sehatsaathi.app.databinding.ItemSummaryOptionBinding;
import com.sehatsaathi.app.navigation.ModuleNavigator;

public class PrescriptionSummaryActivity extends AppCompatActivity {

    private ActivityPrescriptionSummaryBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityPrescriptionSummaryBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        configureOption(binding.optionScan, R.drawable.ic_scan, R.string.scan_prescription, R.string.summary_hint);
        configureOption(binding.optionGallery, R.drawable.ic_gallery, R.string.upload_from_gallery, R.string.upload_hint);
        configureOption(binding.optionMobile, R.drawable.ic_check_circle, R.string.mobile, R.string.mobile_value);

        binding.buttonBack.setOnClickListener(v -> finish());
        binding.textCancel.setOnClickListener(v -> finish());
        binding.buttonNotNow.setOnClickListener(v -> finish());
        binding.buttonSaveRx.setOnClickListener(v -> ModuleNavigator.openPlaceholder(
                this,
                getString(R.string.save_rx),
                getString(R.string.summary_hint)
        ));
        binding.optionScan.getRoot().setOnClickListener(v -> ModuleNavigator.openPlaceholder(
                this,
                getString(R.string.scan_prescription),
                getString(R.string.placeholder_message)
        ));
        binding.optionGallery.getRoot().setOnClickListener(v -> ModuleNavigator.openPlaceholder(
                this,
                getString(R.string.upload_from_gallery),
                getString(R.string.placeholder_message)
        ));
        binding.optionMobile.getRoot().setOnClickListener(v -> ModuleNavigator.openPlaceholder(
                this,
                getString(R.string.mobile),
                getString(R.string.mobile_value)
        ));
    }

    private void configureOption(ItemSummaryOptionBinding itemBinding, int iconRes, int titleRes, int subtitleRes) {
        itemBinding.summaryIcon.setImageResource(iconRes);
        itemBinding.summaryTitle.setText(titleRes);
        itemBinding.summarySubtitle.setText(subtitleRes);
    }
}
