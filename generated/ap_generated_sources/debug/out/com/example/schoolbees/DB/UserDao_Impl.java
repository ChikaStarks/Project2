package com.example.schoolbees.DB;

import android.database.Cursor;
import androidx.room.EntityDeletionOrUpdateAdapter;
import androidx.room.EntityInsertionAdapter;
import androidx.room.RoomDatabase;
import androidx.room.RoomSQLiteQuery;
import androidx.room.util.CursorUtil;
import androidx.room.util.DBUtil;
import androidx.sqlite.db.SupportSQLiteStatement;
import com.example.schoolbees.User;
import java.lang.Class;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@SuppressWarnings({"unchecked", "deprecation"})
public final class UserDao_Impl implements UserDao {
  private final RoomDatabase __db;

  private final EntityInsertionAdapter<User> __insertionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __deletionAdapterOfUser;

  private final EntityDeletionOrUpdateAdapter<User> __updateAdapterOfUser;

  public UserDao_Impl(RoomDatabase __db) {
    this.__db = __db;
    this.__insertionAdapterOfUser = new EntityInsertionAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "INSERT OR ABORT INTO `USER_TABLE2` (`mUserId`,`mUserName`,`mPassword`,`mIsAdmin`) VALUES (nullif(?, 0),?,?,?)";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
        if (value.getUserName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserName());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getIsAdmin() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIsAdmin());
        }
      }
    };
    this.__deletionAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "DELETE FROM `USER_TABLE2` WHERE `mUserId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
      }
    };
    this.__updateAdapterOfUser = new EntityDeletionOrUpdateAdapter<User>(__db) {
      @Override
      public String createQuery() {
        return "UPDATE OR ABORT `USER_TABLE2` SET `mUserId` = ?,`mUserName` = ?,`mPassword` = ?,`mIsAdmin` = ? WHERE `mUserId` = ?";
      }

      @Override
      public void bind(SupportSQLiteStatement stmt, User value) {
        stmt.bindLong(1, value.getUserId());
        if (value.getUserName() == null) {
          stmt.bindNull(2);
        } else {
          stmt.bindString(2, value.getUserName());
        }
        if (value.getPassword() == null) {
          stmt.bindNull(3);
        } else {
          stmt.bindString(3, value.getPassword());
        }
        if (value.getIsAdmin() == null) {
          stmt.bindNull(4);
        } else {
          stmt.bindString(4, value.getIsAdmin());
        }
        stmt.bindLong(5, value.getUserId());
      }
    };
  }

  @Override
  public void insert(final User... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __insertionAdapterOfUser.insert(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void delete(final User user) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __deletionAdapterOfUser.handle(user);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public void update(final User... users) {
    __db.assertNotSuspendingTransaction();
    __db.beginTransaction();
    try {
      __updateAdapterOfUser.handleMultiple(users);
      __db.setTransactionSuccessful();
    } finally {
      __db.endTransaction();
    }
  }

  @Override
  public List<User> getAllUsers() {
    final String _sql = "SELECT * FROM USER_TABLE2";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 0);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserName");
      final int _cursorIndexOfMPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "mPassword");
      final int _cursorIndexOfMIsAdmin = CursorUtil.getColumnIndexOrThrow(_cursor, "mIsAdmin");
      final List<User> _result = new ArrayList<User>(_cursor.getCount());
      while(_cursor.moveToNext()) {
        final User _item;
        final String _tmpMUserName;
        if (_cursor.isNull(_cursorIndexOfMUserName)) {
          _tmpMUserName = null;
        } else {
          _tmpMUserName = _cursor.getString(_cursorIndexOfMUserName);
        }
        final String _tmpMPassword;
        if (_cursor.isNull(_cursorIndexOfMPassword)) {
          _tmpMPassword = null;
        } else {
          _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        }
        final String _tmpMIsAdmin;
        if (_cursor.isNull(_cursorIndexOfMIsAdmin)) {
          _tmpMIsAdmin = null;
        } else {
          _tmpMIsAdmin = _cursor.getString(_cursorIndexOfMIsAdmin);
        }
        _item = new User(_tmpMIsAdmin,_tmpMUserName,_tmpMPassword);
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        _item.setUserId(_tmpMUserId);
        _result.add(_item);
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserByUsername(final String username) {
    final String _sql = "SELECT * FROM USER_TABLE2 WHERE mUserName = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    if (username == null) {
      _statement.bindNull(_argIndex);
    } else {
      _statement.bindString(_argIndex, username);
    }
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserName");
      final int _cursorIndexOfMPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "mPassword");
      final int _cursorIndexOfMIsAdmin = CursorUtil.getColumnIndexOrThrow(_cursor, "mIsAdmin");
      final User _result;
      if(_cursor.moveToFirst()) {
        final String _tmpMUserName;
        if (_cursor.isNull(_cursorIndexOfMUserName)) {
          _tmpMUserName = null;
        } else {
          _tmpMUserName = _cursor.getString(_cursorIndexOfMUserName);
        }
        final String _tmpMPassword;
        if (_cursor.isNull(_cursorIndexOfMPassword)) {
          _tmpMPassword = null;
        } else {
          _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        }
        final String _tmpMIsAdmin;
        if (_cursor.isNull(_cursorIndexOfMIsAdmin)) {
          _tmpMIsAdmin = null;
        } else {
          _tmpMIsAdmin = _cursor.getString(_cursorIndexOfMIsAdmin);
        }
        _result = new User(_tmpMIsAdmin,_tmpMUserName,_tmpMPassword);
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        _result.setUserId(_tmpMUserId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  @Override
  public User getUserByUserId(final int userId) {
    final String _sql = "SELECT * FROM USER_TABLE2 WHERE mUserId = ?";
    final RoomSQLiteQuery _statement = RoomSQLiteQuery.acquire(_sql, 1);
    int _argIndex = 1;
    _statement.bindLong(_argIndex, userId);
    __db.assertNotSuspendingTransaction();
    final Cursor _cursor = DBUtil.query(__db, _statement, false, null);
    try {
      final int _cursorIndexOfMUserId = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserId");
      final int _cursorIndexOfMUserName = CursorUtil.getColumnIndexOrThrow(_cursor, "mUserName");
      final int _cursorIndexOfMPassword = CursorUtil.getColumnIndexOrThrow(_cursor, "mPassword");
      final int _cursorIndexOfMIsAdmin = CursorUtil.getColumnIndexOrThrow(_cursor, "mIsAdmin");
      final User _result;
      if(_cursor.moveToFirst()) {
        final String _tmpMUserName;
        if (_cursor.isNull(_cursorIndexOfMUserName)) {
          _tmpMUserName = null;
        } else {
          _tmpMUserName = _cursor.getString(_cursorIndexOfMUserName);
        }
        final String _tmpMPassword;
        if (_cursor.isNull(_cursorIndexOfMPassword)) {
          _tmpMPassword = null;
        } else {
          _tmpMPassword = _cursor.getString(_cursorIndexOfMPassword);
        }
        final String _tmpMIsAdmin;
        if (_cursor.isNull(_cursorIndexOfMIsAdmin)) {
          _tmpMIsAdmin = null;
        } else {
          _tmpMIsAdmin = _cursor.getString(_cursorIndexOfMIsAdmin);
        }
        _result = new User(_tmpMIsAdmin,_tmpMUserName,_tmpMPassword);
        final int _tmpMUserId;
        _tmpMUserId = _cursor.getInt(_cursorIndexOfMUserId);
        _result.setUserId(_tmpMUserId);
      } else {
        _result = null;
      }
      return _result;
    } finally {
      _cursor.close();
      _statement.release();
    }
  }

  public static List<Class<?>> getRequiredConverters() {
    return Collections.emptyList();
  }
}
