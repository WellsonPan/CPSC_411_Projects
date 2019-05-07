package com.app2.cpsc411.app2

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData

class ContactsViewModel(application: Application): AndroidViewModel(application){
    private val repo: ContactRepository
    internal val allContacts: LiveData<List<Contact>>

    init {
        repo = ContactRepository(application)
        allContacts = repo.allContacts
    }

    fun insert(contact: Contact)
    {
        repo.insert(contact)
    }

    fun delete(contact: Contact)
    {
        repo.delete(contact)
    }

}