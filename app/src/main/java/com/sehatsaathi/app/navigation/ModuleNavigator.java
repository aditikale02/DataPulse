package com.sehatsaathi.app.navigation;

import android.content.Context;
import android.content.Intent;

import com.sehatsaathi.app.activities.PlaceholderActivity;
import com.sehatsaathi.app.activities.PrescriptionSummaryActivity;
import com.sehatsaathi.app.constants.AppConstants;

public final class ModuleNavigator {

    private ModuleNavigator() {
    }

    public static void openPrescriptionSummary(Context context) {
        context.startActivity(new Intent(context, PrescriptionSummaryActivity.class));
    }

    public static void openPlaceholder(Context context, String title, String message) {
        Intent intent = new Intent(context, PlaceholderActivity.class);
        intent.putExtra(AppConstants.EXTRA_TITLE, title);
        intent.putExtra(AppConstants.EXTRA_MESSAGE, message);
        context.startActivity(intent);
    }
}
