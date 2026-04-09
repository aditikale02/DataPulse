package com.sehatsaathi.app.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sehatsaathi.app.R;
import com.sehatsaathi.app.activities.MainActivity;
import com.sehatsaathi.app.databinding.FragmentHomeBinding;
import com.sehatsaathi.app.databinding.IncludeDashboardActionSecondaryBinding;
import com.sehatsaathi.app.models.Patient;
import com.sehatsaathi.app.navigation.ModuleNavigator;

public class HomeFragment extends Fragment {

    private FragmentHomeBinding binding;

    public static HomeFragment newInstance() {
        return new HomeFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentHomeBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        bindSecondaryCard(binding.cardGallery, R.drawable.ic_gallery, R.string.upload_from_gallery);
        bindSecondaryCard(binding.cardFile, R.drawable.ic_file, R.string.upload_file);
        bindPatient(new Patient(
                getString(R.string.patient_name),
                getString(R.string.patient_meta),
                getString(R.string.patient_time),
                getString(R.string.patient_avatar)
        ));

        binding.cardScanPrescription.setOnClickListener(v -> ModuleNavigator.openPrescriptionSummary(requireContext()));
        binding.cardGallery.getRoot().setOnClickListener(v -> ModuleNavigator.openPlaceholder(
                requireContext(),
                getString(R.string.upload_from_gallery),
                getString(R.string.placeholder_message)
        ));
        binding.cardFile.getRoot().setOnClickListener(v -> ModuleNavigator.openPlaceholder(
                requireContext(),
                getString(R.string.upload_file),
                getString(R.string.placeholder_message)
        ));
        binding.cardPatient.setOnClickListener(v -> ModuleNavigator.openPlaceholder(
                requireContext(),
                getString(R.string.patient_name),
                getString(R.string.section_coming_soon)
        ));
        binding.cardReminders.setOnClickListener(v -> ModuleNavigator.openPlaceholder(
                requireContext(),
                getString(R.string.todays_reminders),
                getString(R.string.reminder_toggle)
        ));
        binding.buttonSettings.setOnClickListener(v -> {
            if (getActivity() instanceof MainActivity) {
                ((MainActivity) getActivity()).selectBottomNavItem(R.id.nav_settings);
            }
        });
    }

    private void bindSecondaryCard(IncludeDashboardActionSecondaryBinding itemBinding, int iconRes, int titleRes) {
        itemBinding.actionIcon.setImageResource(iconRes);
        itemBinding.actionTitle.setText(titleRes);
    }

    private void bindPatient(Patient patient) {
        binding.textPatientAvatar.setText(patient.getAvatarText());
        binding.textPatientName.setText(patient.getName());
        binding.textPatientMeta.setText(patient.getMedicationInfo());
        binding.textPatientTime.setText(patient.getTime());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
