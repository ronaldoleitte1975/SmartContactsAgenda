package br.com.fiap.smartcontactsagenda.model

import com.google.gson.annotations.SerializedName

data class ContactResponse(
    @SerializedName("content")val contacts: List<Contact>
)