package com.runtimeterror.aild.db;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\b\u0018\u0000  2\u00020\u0001:\u0001 B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u001e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u000e\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u00190\u0013J\u001e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017J\u0012\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00110\u00190\u0013J\u000e\u0010\u001c\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001d\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011J\u000e\u0010\u001e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eJ\u000e\u0010\u001f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006!"}, d2 = {"Lcom/runtimeterror/aild/db/Repository;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "alarmDao", "Lcom/runtimeterror/aild/db/dao/AlarmDao;", "database", "Lcom/runtimeterror/aild/db/Database;", "journalDao", "Lcom/runtimeterror/aild/db/dao/JournalDao;", "deleteAlarm", "", "alarm", "Lcom/runtimeterror/aild/db/entities/Alarm;", "deleteJournal", "journal", "Lcom/runtimeterror/aild/db/entities/Journal;", "getAlarm", "Landroidx/lifecycle/LiveData;", "id", "", "scope", "Lkotlinx/coroutines/CoroutineScope;", "getAlarms", "", "getJournal", "getJournals", "insertAlarm", "insertJournal", "updateAlarm", "updateJournal", "Companion", "app_debug"})
public final class Repository {
    private final com.runtimeterror.aild.db.Database database = null;
    private final com.runtimeterror.aild.db.dao.AlarmDao alarmDao = null;
    private final com.runtimeterror.aild.db.dao.JournalDao journalDao = null;
    private static com.runtimeterror.aild.db.Repository INSTANCE;
    @org.jetbrains.annotations.NotNull()
    public static final com.runtimeterror.aild.db.Repository.Companion Companion = null;
    
    /**
     * ALARM FUNCTIONS
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.runtimeterror.aild.db.entities.Alarm>> getAlarms() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<com.runtimeterror.aild.db.entities.Alarm> getAlarm(int id, @org.jetbrains.annotations.NotNull()
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
    
    /**
     * JOURNAL FUNCTIONS
     */
    @org.jetbrains.annotations.NotNull()
    public final androidx.lifecycle.LiveData<java.util.List<com.runtimeterror.aild.db.entities.Journal>> getJournals() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final androidx.lifecycle.LiveData<com.runtimeterror.aild.db.entities.Journal> getJournal(int id, @org.jetbrains.annotations.NotNull()
    kotlinx.coroutines.CoroutineScope scope) {
        return null;
    }
    
    public final void insertJournal(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Journal journal) {
    }
    
    public final void updateJournal(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Journal journal) {
    }
    
    public final void deleteJournal(@org.jetbrains.annotations.NotNull()
    com.runtimeterror.aild.db.entities.Journal journal) {
    }
    
    private Repository(android.content.Context context) {
        super();
    }
    
    /**
     * Instatiates the repository upon app creation
     */
    @kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0004J\u000e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\n"}, d2 = {"Lcom/runtimeterror/aild/db/Repository$Companion;", "", "()V", "INSTANCE", "Lcom/runtimeterror/aild/db/Repository;", "get", "initialize", "", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        public final void initialize(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.runtimeterror.aild.db.Repository get() {
            return null;
        }
        
        private Companion() {
            super();
        }
    }
}