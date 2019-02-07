package com.giussepr.butterknife.models;

import androidx.room.ColumnInfo;

public class EmailDisplayName {
    @ColumnInfo(name = "email")
    public String email;

    @ColumnInfo(name = "displayName")
    public String displayName;
}
