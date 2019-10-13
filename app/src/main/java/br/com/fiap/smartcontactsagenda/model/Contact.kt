package br.com.fiap.smartcontactsagenda.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Contact(
    val id: Long,
    val phoneNumber: String,
    val name: String,
    val email: String,
    val avatar: String
) : Parcelable