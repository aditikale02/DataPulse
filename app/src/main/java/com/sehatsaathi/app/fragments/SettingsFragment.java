package com.sehatsaathi.app.fragments;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.sehatsaathi.app.R;
import com.sehatsaathi.app.adapters.SettingsAdapter;
import com.sehatsaathi.app.databinding.FragmentSettingsBinding;
import com.sehatsaathi.app.models.ActionItem;
import com.sehatsaathi.app.navigation.ModuleNavigator;
import com.sehatsaathi.app.utils.SpacingItemDecoration;

import java.util.ArrayList;
import java.util.List;

public class SettingsFragment extends Fragment {

    private FragmentSettingsBinding binding;

    public static SettingsFragment newInstance() {
        return new SettingsFragment();
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        binding = FragmentSettingsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        List<ActionItem> items = buildItems();

        binding.recyclerSettings.setLayoutManager(new LinearLayoutManager(requireContext()));
        binding.recyclerSettings.setAdapter(new SettingsAdapter(items, actionItem ->
                ModuleNavigator.openPlaceholder(
                        requireContext(),
                        getString(actionItem.getTitleResId()),
                        getString(R.string.placeholder_message)
                )));
        binding.recyclerSettings.addItemDecoration(
                new SpacingItemDecoration((int) TypedValue.applyDimension(
                        TypedValue.COMPLEX_UNIT_DIP,
                        2,
                        getResources().getDisplayMetrics()
                ))
        );
    }

    private List<ActionItem> buildItems() {
        List<ActionItem> items = new ArrayList<>();
        items.add(new ActionItem(R.drawable.ic_person, R.string.personal_info));
        items.add(new ActionItem(R.drawable.ic_language, R.string.change_language));
        items.add(new ActionItem(R.drawable.ic_edit, R.string.edit_patient_details));
        items.add(new ActionItem(R.drawable.ic_contacts, R.string.manage_contacts));
        items.add(new ActionItem(R.drawable.ic_notifications, R.string.notification_settings));
        items.add(new ActionItem(R.drawable.ic_check_circle, R.string.reminder_settings));
        items.add(new ActionItem(R.drawable.ic_backup, R.string.backup_restore));
        return items;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}
