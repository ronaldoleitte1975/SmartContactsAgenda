package br.com.fiap.smartcontactsagenda.api

import br.com.fiap.smartcontactsagenda.model.Contact
import retrofit2.Call
import retrofit2.http.*

interface ContactService {

    @GET("contact/username/{name}")
    fun getContacts(
        @Query("sort") sort: String,
        @Path("number") number: String,
        @Query("size") size: Int
    ) : Call<Contact>

    @PUT("/contact")
    fun updateContact(
        @Body contact: Contact
    ) : Call<Contact>

    @POST("/contact")
    fun createContact(
        @Body contact: Contact
    ) : Call<Contact>

    @DELETE("/contact")
    fun deleteContact(
        @Body contact: Contact
    ) : Void
}