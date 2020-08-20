package com.studytrial.ccstorage

import android.os.Parcelable
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize
import java.util.*

@Entity
@Parcelize
data class Memo(
    @PrimaryKey(autoGenerate = true) var id: Int?,
    @ColumnInfo(name = "tanggal") var tanggal: String,
    @ColumnInfo(name = "isimemo") var isimemo: String
) : Parcelable