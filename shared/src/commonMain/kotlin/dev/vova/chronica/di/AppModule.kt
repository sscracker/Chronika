package dev.vova.chronica.di

import dev.vova.chronica.data.remote.OnThisDayApi
import dev.vova.chronica.data.repository.EventRepositoryImpl
import dev.vova.chronica.domain.repository.EventRepository
import dev.vova.chronica.domain.usecase.GetTodayEventsUseCase
import dev.vova.chronica.ui.today.TodayViewModel
import io.ktor.client.HttpClient
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.request.header
import io.ktor.http.HttpHeaders
import io.ktor.serialization.kotlinx.json.json
import kotlinx.serialization.json.Json
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module

private const val USER_AGENT = "ChronicaApp/0.1 (https://github.com/sscracker/Chronika)"

val networkModule = module {
    single { createHttpClient() }
    single { OnThisDayApi(client = get()) }
}

val dataModule = module {
    single<EventRepository> { EventRepositoryImpl(api = get()) }
}

val domainModule = module {
    factory { GetTodayEventsUseCase(repository = get()) }
}

val presentationModule = module {
    viewModel { TodayViewModel(getTodayEvents = get()) }
}

val appModules = listOf(networkModule, dataModule, domainModule, presentationModule)

private fun createHttpClient(): HttpClient = HttpClient {
    install(ContentNegotiation) {
        json(
            Json {
                ignoreUnknownKeys = true
            }
        )
    }
    defaultRequest {
        header(HttpHeaders.UserAgent, USER_AGENT)
    }
}
