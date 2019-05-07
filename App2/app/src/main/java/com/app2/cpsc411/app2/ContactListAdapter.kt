package com.app2.cpsc411.app2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

class ContactListAdapter (context: Context): androidx.recyclerview.widget.RecyclerView.Adapter<ContactListAdapter.ContactViewHolder>()
{
    private val inflater: LayoutInflater = LayoutInflater.from(context)
    private var mContact: List<Contact>? = null

    inner class ContactViewHolder (itemView: View): androidx.recyclerview.widget.RecyclerView.ViewHolder(itemView)
    {
        val contactNameView: TextView = itemView.findViewById(R.id.nameView)
        val contactPhoneView: TextView = itemView.findViewById(R.id.phoneView)
    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ContactViewHolder {
        val itemView = inflater.inflate(R.layout.recyclerview_item, p0, false)
        return ContactViewHolder(itemView)
    }

    override fun onBindViewHolder(p0: ContactViewHolder, p1: Int) {
        val current = mContact!![p1]
        p0.contactNameView.text = current.personName
        p0.contactPhoneView.text = current.phoneNumber
    }

    internal fun setContacts(contacts: List<Contact>?)
    {
        mContact = contacts
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return if (mContact != null)
            mContact!!.size
        else
            0
    }

    fun getContactAtPosition(position: Int):Contact
    {
        return mContact!![position]
    }
}