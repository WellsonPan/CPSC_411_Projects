package com.app2.cpsc411.app2

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface DAO
{
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(contact: Contact)

    @Query("DELETE FROM contactTable")
    fun deleteAll()

    @Delete
    fun deleteOne(contact:Contact)

    @Query("SELECT * FROM contactTable ORDER BY personName ASC")
    fun getAllContacts():LiveData<List<Contact>>
}
