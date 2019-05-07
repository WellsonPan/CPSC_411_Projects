//The code labs helped a lot. Honestly, all the code labs.
// Credit to Google. This applies to all the files.


package com.app2.cpsc411.app2

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val adapter: ContactListAdapter = ContactListAdapter(this)
        recyclerView.adapter = adapter
        recyclerView.layoutManager = androidx.recyclerview.widget.LinearLayoutManager(this)

        val contactViewModel = ViewModelProviders.of(this).get(ContactsViewModel::class.java)
        contactViewModel.allContacts.observe(this, Observer<List<Contact>> { contacts ->
            adapter.setContacts(contacts)
        })

        saveButton.setOnClickListener {
            if (nameInput.text.toString()!= "" && phoneNumberInput.text.toString() != "")
            {
                val newContact = Contact(nameInput.text.toString(), phoneNumberInput.text.toString())
                contactViewModel.insert(newContact)
            }
            else
            {
                if (nameInput.text.toString() != "")
                {
                    Toast.makeText(applicationContext, "Phone Number Field Empty", Toast.LENGTH_LONG).show()
                }
                else if (phoneNumberInput.text.toString() != "")
                {
                    Toast.makeText(applicationContext, "Name Field Empty", Toast.LENGTH_LONG).show()
                }
                else
                {
                    Toast.makeText(applicationContext, "Both Fields Empty", Toast.LENGTH_LONG).show()
                }
            }
        }

        val helper = ItemTouchHelper(object:ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT) {
            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder,
                                target: RecyclerView.ViewHolder): Boolean{
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int)
            {
                val position = viewHolder.adapterPosition
                val myContact = adapter.getContactAtPosition(position)
                contactViewModel.delete(myContact)
            }
        })
        helper.attachToRecyclerView(recyclerView)
    }
}