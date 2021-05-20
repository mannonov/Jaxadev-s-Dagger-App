package uz.jaxadev.jaxadevsdaggerapp

import android.app.Application
import uz.jaxadev.jaxadevsdaggerapp.di.AppComponent
import uz.jaxadev.jaxadevsdaggerapp.di.DaggerAppComponent
import uz.jaxadev.jaxadevsdaggerapp.storage.SharedPreferencesStorage
import uz.jaxadev.jaxadevsdaggerapp.user.UserManager

open class MyApplication : Application() {

    val appComponent: AppComponent by lazy {
        DaggerAppComponent.factory().create(applicationContext)
    }

    open val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }
}
