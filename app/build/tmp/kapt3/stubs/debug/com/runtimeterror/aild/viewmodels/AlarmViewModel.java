package com.runtimeterror.aild.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0015\u001a\u00020\u00122\u0006\u0010\u0016\u001a\u00020\u0005J\u000e\u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\fR \u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/runtimeterror/aild/viewmodels/AlarmViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "alarmIdLiveData", "Landroidx/lifecycle/MutableLiveData;", "", "getAlarmIdLiveData", "()Landroidx/lifecycle/MutableLiveData;", "setAlarmIdLiveData", "(Landroidx/lifecycle/MutableLiveData;)V", "alarmLiveData", "Landroidx/lifecycle/LiveData;", "Lcom/runtimeterror/aild/db/entities/Alarm;", "getAlarmLiveData", "()Landroidx/lifecycle/LiveData;", "alarmRepository", "Lcom/runtimeterror/aild/db/Repository;", "deleteAlarm", "", "alarm", "insertAlarm", "loadAlarm", "alarmId", "updateAlarm", "app_debug"})
public final class AlarmViewModel extends androidx.lifecycle.ViewModel {
    private final com.runtimeterror.aild.db.Repository alarmRepository = null;
    @org.jetbrains.annotations.NotNull()
    private androidx.lifecycle.MutableLiveData<java.lang.Integer> alarmIdLiveData;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<com.runtimeterror.aild.db.entities.Alarm> alarmLiveData = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.MutableLiveData<java.lang.Integer> getAlarmIdLiveData() {
        return null;
    }
    
    public final void setAlarmIdLiveData(@org.jetbrains.annotations.NotNull()
    androidx.lifecycle.MutableLiveData<java.lang.Integer> p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<com.runtimeterror.aild.db.entities.Alarm> getAlarmLiveData() {
        return null;
    }
    
    public final void loadAlarm(int alarmId) {
    }
    
    public final void insertAlarm(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Alarm alarm) {
    }
    
    public final void updateAlarm(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Alarm alarm) {
    }
    
    public final void deleteAlarm(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Alarm alarm) {
    }
    
    public AlarmViewModel() {
        super();
    }
}