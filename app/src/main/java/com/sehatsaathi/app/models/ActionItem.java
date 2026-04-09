package com.sehatsaathi.app.models;

public class ActionItem {
    private final int iconResId;
    private final int titleResId;

    public ActionItem(int iconResId, int titleResId) {
        this.iconResId = iconResId;
        this.titleResId = titleResId;
    }

    public int getIconResId() {
        return iconResId;
    }

    public int getTitleResId() {
        return titleResId;
    }
}
