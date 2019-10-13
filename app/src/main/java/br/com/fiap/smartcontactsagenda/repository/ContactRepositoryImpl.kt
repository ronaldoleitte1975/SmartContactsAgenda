package br.com.fiap.smartcontactsagenda.repository

import br.com.fiap.smartcontactsagenda.api.ContactService
import br.com.fiap.smartcontactsagenda.model.Contact
import br.com.fiap.smartcontactsagenda.model.ContactResponse
import br.com.fiap.smartcontactsagenda.model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ContactRepositoryImpl(
    val contactService: ContactService
) : ContactRepository {

    override fun getContacts(
        user: User,
        sort: String,
        size: Int,
        onComplete: (List<Contact>) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        contactService.getContacts(sort, user.nome, size).enqueue(object :
            Callback<ContactResponse> {

            override fun onFailure(call: Call<ContactResponse>, t: Throwable) {
                onError(t)
            }

            override fun onResponse(
                call: Call<ContactResponse>,
                response: Response<ContactResponse>
            ) {
                if (response.isSuccessful) {
                    onComplete(response.body()?.contacts ?: listOf())
                } else {
                    onError(Throwable("Não foi possível realizar a requisição"))
                }
            }
        })
    }

    override fun updateContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        contactService
            .updateContact(contact)
            .enqueue(object : Callback<Contact> {
                override fun onFailure(call: Call<Contact>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Contact>, response: Response<Contact>) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }

    override fun deleteContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        contactService
            .deleteContact(contact)

    }

    override fun addContact(
        contact: Contact,
        onComplete: (Contact?) -> Unit,
        onError: (Throwable) -> Unit
    ) {
        contactService
            .createContact(contact)
            .enqueue(object : Callback<Contact> {
                override fun onFailure(call: Call<Contact>, t: Throwable) {
                    onError(t)
                }

                override fun onResponse(call: Call<Contact>, response: Response<Contact>) {
                    if (response.isSuccessful) {
                        onComplete(response.body())
                    } else {
                        onError(Throwable("Não foi possível realizar a requisição"))
                    }
                }
            })
    }
}