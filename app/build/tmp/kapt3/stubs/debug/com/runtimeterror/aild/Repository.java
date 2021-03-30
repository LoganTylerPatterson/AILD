package com.runtimeterror.aild;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u001e\u0010\r\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012J\u0012\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\f0\u00140\u000eJ\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\u0016\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/runtimeterror/aild/Repository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alarmDao", "Lcom/runtimeterror/aild/db/dao/AlarmDao;", "alarmDatabase", "Lcom/runtimeterror/aild/db/AlarmDatabase;", "deleteAlarm", "", "alarm", "Lcom/runtimeterror/aild/db/entities/Alarm;", "getAlarm", "Landroidx/lifecycle/LiveData;", "id", "Ljava/util/UUID;", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getAlarms", "", "insertAlarm", "updateAlarm", "Companion", "app_debug"})
public final class Repository {
    private final com.runtimeterror.aild.db.AlarmDatabase alarmDatabase = null;
    private final com.runtimeterror.aild.db.dao.AlarmDao alarmDao = null;
    private static com.runtimeterror.aild.Repository INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.runtimeterror.aild.Repository.Companion Companion = null;
    
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.runtimeterror.aild.db.entities.Alarm>> getAlarms() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<com.runtimeterror.aild.db.entities.Alarm> getAlarm(@org.jetbrains.annotations.NotNull()
    java.util.UUID id, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        return null;
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
    
    private Repository(android.content.Context context) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/runtimeterror/aild/Repository$Companion;", "", "()V", "INSTANCE", "Lcom/runtimeterror/aild/Repository;", "get", "initialize", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        public final void initialize(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.runtimeterror.aild.Repository get() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}