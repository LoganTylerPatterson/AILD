package com.runtimeterror.aild.viewmodels;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002R\u001d\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/runtimeterror/aild/viewmodels/AlarmListViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "alarmListLiveData", "Landroidx/lifecycle/LiveData;", "", "Lcom/runtimeterror/aild/db/entities/Alarm;", "getAlarmListLiveData", "()Landroidx/lifecycle/LiveData;", "alarmRepository", "Lcom/runtimeterror/aild/db/Repository;", "app_debug"})
public final class AlarmListViewModel extends androidx.lifecycle.ViewModel {
    private final com.runtimeterror.aild.db.Repository alarmRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final androidx.lifecycle.LiveData<java.util.List<com.runtimeterror.aild.db.entities.Alarm>> alarmListLiveData = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.runtimeterror.aild.db.entities.Alarm>> getAlarmListLiveData() {
        return null;
    }
    
    public AlarmListViewModel() {
        super();
    }
}