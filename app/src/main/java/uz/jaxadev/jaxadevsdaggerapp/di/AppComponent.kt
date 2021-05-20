package uz.jaxadev.jaxadevsdaggerapp.di

import android.content.Context
import dagger.BindsInstance
import dagger.Component
import uz.jaxadev.jaxadevsdaggerapp.main.MainActivity
import uz.jaxadev.jaxadevsdaggerapp.registration.RegistrationActivity
import uz.jaxadev.jaxadevsdaggerapp.registration.RegistrationComponent
import uz.jaxadev.jaxadevsdaggerapp.registration.enterdetails.EnterDetailsFragment
import uz.jaxadev.jaxadevsdaggerapp.registration.termsandconditions.TermsAndConditionsFragment
import javax.inject.Singleton

@ActivityScope
@Component(modules = [StorageModule::class])
interface AppComponent {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance context: Context): AppComponent
    }

    fun registrationComponent(): RegistrationComponent.Factory

    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)
    fun inject(activity: MainActivity)

}