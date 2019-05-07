package com.app2.cpsc411.app2

import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "contactTable")
data class Contact(@NonNull @ColumnInfo(name = "personName")var personName: String, @PrimaryKey @NonNull @ColumnInfo(name = "phoneNumber")var phoneNumber: String)

