package com.studytrial.ccstorage

import androidx.room.*
import androidx.room.Dao
import androidx.room.OnConflictStrategy.REPLACE

@Dao
interface MemoDao {
    @Query("SELECT * FROM Memo")
    fun getMemo(): List<Memo>

    @Insert(onConflict = REPLACE)
    fun addMemo(memo: Memo): Long

    @Update
    fun updateMemo(memo: Memo): Int

    @Delete
    fun deleteMemo(memo: Memo): Int
}