package com.sehatsaathi.app.adapters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.sehatsaathi.app.databinding.ItemSettingOptionBinding;
import com.sehatsaathi.app.models.ActionItem;

import java.util.List;

public class SettingsAdapter extends RecyclerView.Adapter<SettingsAdapter.SettingsViewHolder> {

    public interface OnItemClickListener {
        void onItemClick(ActionItem actionItem);
    }

    private final List<ActionItem> items;
    private final OnItemClickListener listener;

    public SettingsAdapter(List<ActionItem> items, OnItemClickListener listener) {
        this.items = items;
        this.listener = listener;
    }

    @NonNull
    @Override
    public SettingsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        ItemSettingOptionBinding binding = ItemSettingOptionBinding.inflate(inflater, parent, false);
        return new SettingsViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull SettingsViewHolder holder, int position) {
        holder.bind(items.get(position), listener);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class SettingsViewHolder extends RecyclerView.ViewHolder {

        private final ItemSettingOptionBinding binding;

        SettingsViewHolder(ItemSettingOptionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        void bind(final ActionItem item, final OnItemClickListener listener) {
            binding.imageIcon.setImageResource(item.getIconResId());
            binding.textTitle.setText(item.getTitleResId());
            binding.getRoot().setOnClickListener(v -> listener.onItemClick(item));
        }
    }
}
