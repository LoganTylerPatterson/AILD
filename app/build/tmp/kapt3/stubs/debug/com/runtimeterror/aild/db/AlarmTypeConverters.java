package com.runtimeterror.aild.db;

import java.lang.System;

@kotlin.Metadata(mv = {1, 4, 2}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0019\u0010\u0003\u001a\u0004\u0018\u00010\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0007\u00a2\u0006\u0002\u0010\u0007J\u0014\u0010\b\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0007J\u0019\u0010\f\u001a\u0004\u0018\u00010\u00062\b\u0010\r\u001a\u0004\u0018\u00010\u0004H\u0007\u00a2\u0006\u0002\u0010\u000eJ\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\tH\u0007\u00a8\u0006\u0010"}, d2 = {"Lcom/runtimeterror/aild/db/AlarmTypeConverters;", "", "()V", "fromDate", "", "date", "Ljava/util/Date;", "(Ljava/util/Date;)Ljava/lang/Long;", "fromUUID", "", "uuid", "Ljava/util/UUID;", "toDate", "timeStamp", "(Ljava/lang/Long;)Ljava/util/Date;", "toUUID", "app_debug"})
public final class AlarmTypeConverters {
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.lang.Long fromDate(@org.jetbrains.annotations.Nullable()
    java.util.Date date) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.util.Date toDate(@org.jetbrains.annotations.Nullable()
    java.lang.Long timeStamp) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.util.UUID toUUID(@org.jetbrains.annotations.Nullable()
    java.lang.String uuid) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    @androidx.room.TypeConverter()
    public final java.lang.String fromUUID(@org.jetbrains.annotations.Nullable()
    java.util.UUID uuid) {
        return null;
    }
    
    public AlarmTypeConverters() {
        super();
    }
}