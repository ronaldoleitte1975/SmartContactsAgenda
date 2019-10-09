package br.com.fiap.smartcontactsagenda.repository

import br.com.fiap.smartcontactsagenda.api.ContactService
import br.com.fiap.smartcontactsagenda.model.Contact
import br.com.fiap.smartcontactsagenda.model.User

class ContactRepositoryImpl : ContactRepository {

    override fun getContacts(
        user: User,
        sort: String,
        size: Int,
        onComplete: (List<Contact>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun updateContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun deleteContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun addContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}