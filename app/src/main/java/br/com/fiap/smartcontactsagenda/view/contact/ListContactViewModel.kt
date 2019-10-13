package br.com.fiap.smartcontactsagenda.view.contact

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.fiap.smartcontactsagenda.model.Contact
import br.com.fiap.smartcontactsagenda.model.User
import br.com.fiap.smartcontactsagenda.repository.ContactRepository

class ListContactViewModel(val contactRepository: ContactRepository) : ViewModel() {

    val isLoading = MutableLiveData<Boolean>()
    val contacts = MutableLiveData<List<Contact>>()
    val messageError = MutableLiveData<String>()

    fun getContacts(user: User) {
        isLoading.value = true
        contactRepository.getContacts(
            user = user,
            sort = "name,asc",
            size = 150,
            onComplete = {
                isLoading.value = false
                contacts.value = it
                messageError.value = ""
            },
            onError = {
                isLoading.value = false
                contacts.value = listOf()
                messageError.value = it.message

            }
        )
    }


}