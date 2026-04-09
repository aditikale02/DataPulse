package com.sehatsaathi.app.fragments.placeholders;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.sehatsaathi.app.R;

public class PlaceholderFragment extends Fragment {

    private static final String ARG_TITLE = "arg_title";
    private static final String ARG_MESSAGE = "arg_message";

    public static PlaceholderFragment newInstance(String title, String message) {
        PlaceholderFragment fragment = new PlaceholderFragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        args.putString(ARG_MESSAGE, message);
        fragment.setArguments(args);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_placeholder, container, false);
        TextView titleView = view.findViewById(R.id.text_title);
        TextView messageView = view.findViewById(R.id.text_message);
        View backButton = view.findViewById(R.id.button_back);

        Bundle args = getArguments();
        if (args != null) {
            titleView.setText(args.getString(ARG_TITLE));
            messageView.setText(args.getString(ARG_MESSAGE));
        }
        backButton.setVisibility(View.GONE);
        return view;
    }
}
