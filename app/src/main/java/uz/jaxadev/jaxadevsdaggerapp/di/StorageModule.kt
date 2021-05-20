package uz.jaxadev.jaxadevsdaggerapp.di

import dagger.Binds
import dagger.Module
import uz.jaxadev.jaxadevsdaggerapp.storage.SharedPreferencesStorage
import uz.jaxadev.jaxadevsdaggerapp.storage.Storage

@Module
abstract class StorageModule {

    @Binds
    abstract fun provideStorage(storage: SharedPreferencesStorage): Storage

}