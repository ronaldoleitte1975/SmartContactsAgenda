package br.com.fiap.smartcontactsagenda.repository

import br.com.fiap.smartcontactsagenda.model.Contact
import br.com.fiap.smartcontactsagenda.model.User

interface ContactRepository {

    fun getContacts(
        user: User,
        sort: String,
        size: Int,
        onComplete: (List<Contact>) -> Unit,
        onError: (Throwable) -> Unit
    )

    fun updateContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    )

    fun deleteContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    )

    fun addContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    )


}