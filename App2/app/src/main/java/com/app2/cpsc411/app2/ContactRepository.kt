package com.app2.cpsc411.app2

import android.app.Application
import androidx.lifecycle.LiveData
import android.os.AsyncTask

class ContactRepository(application: Application){

    val db:ContactDatabase = ContactDatabase.getDatabase(application)
    val contactDAO: DAO = db.contactDao()
    val allContacts: LiveData<List<Contact>> = contactDAO.getAllContacts()

    fun insert(contact: Contact)
    {
        insertAsyncTask(contactDAO).execute(contact)
    }

    fun delete(contact: Contact)
    {
        deleteAsyncetask(contactDAO).execute(contact)
    }

    private class insertAsyncTask (private val mAsyncTaskDao: DAO):AsyncTask<Contact, Void, Void>()
    {
        override fun doInBackground(vararg p0: Contact): Void? {
            mAsyncTaskDao.insert(p0[0])
            return null
        }
    }

    private class deleteAsyncetask(private val mAsyncTaskDao: DAO):AsyncTask<Contact, Void, Void>()
    {
        override fun doInBackground(vararg p0: Contact): Void? {
            mAsyncTaskDao.deleteOne(p0[0])
            return null
        }
    }
}