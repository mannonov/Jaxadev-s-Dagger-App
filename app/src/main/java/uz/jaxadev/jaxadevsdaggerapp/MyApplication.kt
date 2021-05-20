package uz.jaxadev.jaxadevsdaggerapp

import android.app.Application
import uz.jaxadev.jaxadevsdaggerapp.storage.SharedPreferencesStorage
import uz.jaxadev.jaxadevsdaggerapp.user.UserManager

open class MyApplication : Application() {

    open val userManager by lazy {
        UserManager(SharedPreferencesStorage(this))
    }
}
