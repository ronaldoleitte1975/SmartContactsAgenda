package br.com.fiap.smartcontactsagenda.di

import br.com.fiap.smartcontactsagenda.api.ContactService
import br.com.fiap.smartcontactsagenda.repository.ContactRepository
import br.com.fiap.smartcontactsagenda.repository.ContactRepositoryImpl
import br.com.fiap.smartcontactsagenda.view.contact.ListContactViewModel
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


val networkModule = module {
    single { createNetworkClient(get()).create(ContactService::class.java) }
}

val repositoryModule = module {
    single<ContactRepository> { ContactRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { ListContactViewModel(get()) }
}

private fun createNetworkClient(okHttpClient: OkHttpClient): Retrofit {
    return Retrofit.Builder()
        .client(okHttpClient)
        .baseUrl("https://pokedexdx.herokuapp.com")
        .addConverterFactory(GsonConverterFactory.create())
        .build()
}