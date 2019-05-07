package com.app2.cpsc411.app2

import android.content.Context
import android.os.AsyncTask
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase

@Database(entities = arrayOf(Contact::class), version = 1, exportSchema = false)
abstract class ContactDatabase: RoomDatabase(){
    abstract fun contactDao(): DAO

    private class PopulateDbAsync internal constructor(db: ContactDatabase): AsyncTask<Void, Void, Void>()
    {
        private val mDAO: DAO

        init {
            mDAO = db.contactDao()
        }

        override fun doInBackground(vararg p0: Void): Void? {
            return null
        }
    }

    companion object {
        private var INSTANCE: ContactDatabase? = null

        fun getDatabase(context: Context): ContactDatabase{
            if(INSTANCE == null)
            {
                synchronized(ContactDatabase::class){
                    if(INSTANCE == null)
                    {
                        INSTANCE = Room.databaseBuilder(context.applicationContext, ContactDatabase::class.java,
                            "contactDatabase")
                            .fallbackToDestructiveMigration()
                            .addCallback(aContactDatabaseCallback)
                            .build()
                    }
                }
            }
            return INSTANCE as ContactDatabase
        }

        private val aContactDatabaseCallback = object : RoomDatabase.Callback(){
            override fun onOpen(db: SupportSQLiteDatabase) {
                super.onOpen(db)
                PopulateDbAsync(INSTANCE!!).execute()
            }
        }
    }
}

