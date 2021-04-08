package com.runtimeterror.aild.db.dao;

import android.database.Cursor;
import androidx.lifecycle.LiveData;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.runtimeterror.aild.db.entities.Alarm;
import java.lang.Exception;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;

@SuppressWarnings({"unchecked", "deprecation"})
public final class AlarmDao_Impl implements AlarmDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<Alarm> __insertionAdapterOfAlarm;

  private final EntityDeletionOrUpdateAdapter<Alarm> __deletionAdapterOfAlarm;

  private final EntityDeletionOrUpdateAdapter<Alarm> __updateAdapterOfAlarm;

  public AlarmDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfAlarm = new EntityInsertionAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR REPLACE INTO `alarm` (`id`,`title`,`hour`,`minute`,`dayHalf`,`active`,`autoOff`,`autoOffDuration`,`repeat`,`sound`) VALUES (nullif(?, 0),?,?,?,?,?,?,?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        stmt.bindLong(3, value.getHour());
        stmt.bindLong(4, value.getMinute());
        if (value.getDayHalf() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDayHalf());
        }
        final int _tmp;
        _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getAutoOff() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        stmt.bindLong(8, value.getAutoOffDuration());
        final int _tmp_2;
        _tmp_2 = value.getRepeat() ? 1 : 0;
        stmt.bindLong(9, _tmp_2);
        stmt.bindLong(10, value.getSound());
      }
    };
    this.__deletionAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `alarm` WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
      }
    };
    this.__updateAdapterOfAlarm = new EntityDeletionOrUpdateAdapter<Alarm>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `alarm` SET `id` = ?,`title` = ?,`hour` = ?,`minute` = ?,`dayHalf` = ?,`active` = ?,`autoOff` = ?,`autoOffDuration` = ?,`repeat` = ?,`sound` = ? WHERE `id` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, Alarm value) {
        stmt.bindLong(1, value.getId());
        if (value.getTitle() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getTitle());
        }
        stmt.bindLong(3, value.getHour());
        stmt.bindLong(4, value.getMinute());
        if (value.getDayHalf() == null) {
          stmt.bindNull(5);
        } else {
          stmt.bindString(5, value.getDayHalf());
        }
        final int _tmp;
        _tmp = value.getActive() ? 1 : 0;
        stmt.bindLong(6, _tmp);
        final int _tmp_1;
        _tmp_1 = value.getAutoOff() ? 1 : 0;
        stmt.bindLong(7, _tmp_1);
        stmt.bindLong(8, value.getAutoOffDuration());
        final int _tmp_2;
        _tmp_2 = value.getRepeat() ? 1 : 0;
        stmt.bindLong(9, _tmp_2);
        stmt.bindLong(10, value.getSound());
        stmt.bindLong(11, value.getId());
      }
    };
  }

  @Override
  public void insertAlarm(final Alarm alarm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfAlarm.insert(alarm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void deleteAlarm(final Alarm alarm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfAlarm.handle(alarm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void updateAlarm(final Alarm alarm) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfAlarm.handle(alarm);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public LiveData<List<Alarm>> getAllAlarms() {
    final String _sql = "SELECT * FROM alarm";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    return __db.getInvalidationTracker().createLiveData(new String[]{"alarm"}, false, new Callable<List<Alarm>>() {
      @Override
      public List<Alarm> call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final int _cursorIndexOfDayHalf = CursorUtil.getColumnIndexOrThrow(_cursor, "dayHalf");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfAutoOff = CursorUtil.getColumnIndexOrThrow(_cursor, "autoOff");
          final int _cursorIndexOfAutoOffDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "autoOffDuration");
          final int _cursorIndexOfRepeat = CursorUtil.getColumnIndexOrThrow(_cursor, "repeat");
          final int _cursorIndexOfSound = CursorUtil.getColumnIndexOrThrow(_cursor, "sound");
          final List<Alarm> _result = new ArrayList<Alarm>(_cursor.getCount());
          while(_cursor.moveToNext()) {
            final Alarm _item;
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final int _tmpHour;
            _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            final int _tmpMinute;
            _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            final String _tmpDayHalf;
            _tmpDayHalf = _cursor.getString(_cursorIndexOfDayHalf);
            final boolean _tmpActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfActive);
            _tmpActive = _tmp != 0;
            final boolean _tmpAutoOff;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAutoOff);
            _tmpAutoOff = _tmp_1 != 0;
            final int _tmpAutoOffDuration;
            _tmpAutoOffDuration = _cursor.getInt(_cursorIndexOfAutoOffDuration);
            final boolean _tmpRepeat;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfRepeat);
            _tmpRepeat = _tmp_2 != 0;
            final int _tmpSound;
            _tmpSound = _cursor.getInt(_cursorIndexOfSound);
            _item = new Alarm(_tmpId,_tmpTitle,_tmpHour,_tmpMinute,_tmpDayHalf,_tmpActive,_tmpAutoOff,_tmpAutoOffDuration,_tmpRepeat,_tmpSound);
            _result.add(_item);
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }

  @Override
  public LiveData<Alarm> getAlarm(final int id) {
    final String _sql = "SELECT * FROM alarm WHERE id = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, id);
    return __db.getInvalidationTracker().createLiveData(new String[]{"alarm"}, false, new Callable<Alarm>() {
      @Override
      public Alarm call() throws Exception {
        final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
        try {
          final int _cursorIndexOfId = CursorUtil.getColumnIndexOrThrow(_cursor, "id");
          final int _cursorIndexOfTitle = CursorUtil.getColumnIndexOrThrow(_cursor, "title");
          final int _cursorIndexOfHour = CursorUtil.getColumnIndexOrThrow(_cursor, "hour");
          final int _cursorIndexOfMinute = CursorUtil.getColumnIndexOrThrow(_cursor, "minute");
          final int _cursorIndexOfDayHalf = CursorUtil.getColumnIndexOrThrow(_cursor, "dayHalf");
          final int _cursorIndexOfActive = CursorUtil.getColumnIndexOrThrow(_cursor, "active");
          final int _cursorIndexOfAutoOff = CursorUtil.getColumnIndexOrThrow(_cursor, "autoOff");
          final int _cursorIndexOfAutoOffDuration = CursorUtil.getColumnIndexOrThrow(_cursor, "autoOffDuration");
          final int _cursorIndexOfRepeat = CursorUtil.getColumnIndexOrThrow(_cursor, "repeat");
          final int _cursorIndexOfSound = CursorUtil.getColumnIndexOrThrow(_cursor, "sound");
          final Alarm _result;
          if(_cursor.moveToFirst()) {
            final int _tmpId;
            _tmpId = _cursor.getInt(_cursorIndexOfId);
            final String _tmpTitle;
            _tmpTitle = _cursor.getString(_cursorIndexOfTitle);
            final int _tmpHour;
            _tmpHour = _cursor.getInt(_cursorIndexOfHour);
            final int _tmpMinute;
            _tmpMinute = _cursor.getInt(_cursorIndexOfMinute);
            final String _tmpDayHalf;
            _tmpDayHalf = _cursor.getString(_cursorIndexOfDayHalf);
            final boolean _tmpActive;
            final int _tmp;
            _tmp = _cursor.getInt(_cursorIndexOfActive);
            _tmpActive = _tmp != 0;
            final boolean _tmpAutoOff;
            final int _tmp_1;
            _tmp_1 = _cursor.getInt(_cursorIndexOfAutoOff);
            _tmpAutoOff = _tmp_1 != 0;
            final int _tmpAutoOffDuration;
            _tmpAutoOffDuration = _cursor.getInt(_cursorIndexOfAutoOffDuration);
            final boolean _tmpRepeat;
            final int _tmp_2;
            _tmp_2 = _cursor.getInt(_cursorIndexOfRepeat);
            _tmpRepeat = _tmp_2 != 0;
            final int _tmpSound;
            _tmpSound = _cursor.getInt(_cursorIndexOfSound);
            _result = new Alarm(_tmpId,_tmpTitle,_tmpHour,_tmpMinute,_tmpDayHalf,_tmpActive,_tmpAutoOff,_tmpAutoOffDuration,_tmpRepeat,_tmpSound);
          } else {
            _result = null;
          }
          return _result;
        } finally {
          _cursor.close();
        }
      }

      @Override
      protected void finalize() {
        _statement.release();
      }
    });
  }
}
