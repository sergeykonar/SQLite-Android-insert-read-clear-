package com.example.contentprovider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.net.URI;

public class MyContentProvider extends ContentProvider {

    static final String DB_NAME = "mydb";
    static final int DB_VERSION = 1;

    static final String CONTACT_TABLE = "contacts";

    static final String CONTACT_ID = "_id";
    static final String CONTACT_NAME = "name";
    static final String CONTACT_EMAIL = "email";

    static final String DB_CREATE = "create table " + CONTACT_TABLE + "("
            + CONTACT_ID + "integer primary key autoincrement, "
            + CONTACT_NAME + " text, " + CONTACT_EMAIL + " text" + ");";

    static final String AUTHORITY = "com.sergeykonar.providers.AdressBook";

    static final String CONTACT_PATH = "contacts";

    public static final Uri CONTACT_CONTENT_URI = Uri.parse("content://" + AUTHORITY + "/" +CONTACT_PATH);

    static final String CONTACT_CONTENT_TYPE ="vnd.android.cursor.dir/vnd."
            + AUTHORITY + "." + CONTACT_PATH;

    static final String CONTACT_CONTENT_ITEM_TYPE ="vnd.android.cursor.item/vnd."
            + AUTHORITY + "." + CONTACT_PATH;

    static final int URI_CONTACTS = 1;
    static final int URI_CONTACTS_ID = 2;

    private static final UriMatcher uriMatcher;
    static {
        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(AUTHORITY, CONTACT_PATH, URI_CONTACTS);
        uriMatcher.addURI(AUTHORITY, CONTACT_PATH + "/#", URI_CONTACTS_ID);
    }

    DBHelper dbHelper;
    SQLiteDatabase db;



    @Override
    public boolean onCreate() {
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] projection, @Nullable String selection, @Nullable String[] selectionArgs, @Nullable String sortOrder) {
        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues values) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues values, @Nullable String selection, @Nullable String[] selectionArgs) {
        return 0;
    }
}
