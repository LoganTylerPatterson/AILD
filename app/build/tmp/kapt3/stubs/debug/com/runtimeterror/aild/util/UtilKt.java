package com.runtimeterror.aild.util;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 2, d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u001a\u0016\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n\u001a\u0016\u0010\f\u001a\u00020\u00032\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010\u001a\u0018\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"TAG", "", "cancelAlarm", "", "alarm", "Lcom/runtimeterror/aild/db/entities/Alarm;", "context", "Landroid/content/Context;", "getDateString", "hour", "", "min", "replaceFragment", "fm", "Landroidx/fragment/app/FragmentManager;", "frag", "Landroidx/fragment/app/Fragment;", "setAlarm", "app_debug"})
public final class UtilKt {
    
    /**
     * This method is used to make other methods cleaner, all it does is replace the current fragment
     * ...with a destination fragment
     */
    private static final java.lang.String TAG = "Util";
    
    public static final void replaceFragment(@org.jetbrains.annotations.NotNull()
    androidx.fragment.app.FragmentManager fm, @org.jetbrains.annotations.NotNull()
    androidx.fragment.app.Fragment frag) {
    }
    
    /**
     * Formats the date from the hour and minute given
     */
    @org.jetbrains.annotations.NotNull()
    public static final java.lang.String getDateString(int hour, int min) {
        return null;
    }
    
    /**
     * This creates and alarm with alarmManager and uses a pending intent to start the alarm
     * using the alarm service from the android system
     */
    public static final void setAlarm(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Alarm alarm, @org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
    
    /**
     * This cancels an existing alarm, very similar to creating an alarm service
     */
    public static final void cancelAlarm(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Alarm alarm, @org.jetbrains.annotations.Nullable()
    android.content.Context context) {
    }
}