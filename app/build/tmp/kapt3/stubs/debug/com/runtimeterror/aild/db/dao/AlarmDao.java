package com.runtimeterror.aild.db.dao;

import java.lang.System;

@androidx.room.Dao()
@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\bg\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0018\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\tH\'J\u0014\u0010\n\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\u0007H\'J\u0010\u0010\f\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'J\u0010\u0010\r\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\'\u00a8\u0006\u000e"}, d2 = {"Lcom/runtimeterror/aild/db/dao/AlarmDao;", "", "deleteAlarm", "", "alarm", "Lcom/runtimeterror/aild/db/entities/Alarm;", "getAlarm", "Landroidx/lifecycle/LiveData;", "id", "Ljava/util/UUID;", "getAllAlarms", "", "insertAlarm", "updateAlarm", "app_debug"})
public abstract interface AlarmDao {
    
    @androidx.room.Insert(onConflict = androidx.room.OnConflictStrategy.REPLACE)
    public abstract void insertAlarm(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Alarm alarm);
    
    @androidx.room.Delete()
    public abstract void deleteAlarm(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Alarm alarm);
    
    @org.jetbrains.annotations.NotNull()
    @androidx.room.Query(value = "SELECT * FROM alarm")
    public abstract androidx.lifecycle.LiveData<java.util.List<com.runtimeterror.aild.db.entities.Alarm>> getAllAlarms();
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.Query(value = "SELECT * FROM alarm WHERE id = :id")
    public abstract androidx.lifecycle.LiveData<com.runtimeterror.aild.db.entities.Alarm> getAlarm(@org.jetbrains.annotations.NotNull()
    java.util.UUID id);
    
    @androidx.room.Update()
    public abstract void updateAlarm(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Alarm alarm);
}