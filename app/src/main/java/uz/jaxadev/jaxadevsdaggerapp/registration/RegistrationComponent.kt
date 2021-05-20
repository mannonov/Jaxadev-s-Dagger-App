package uz.jaxadev.jaxadevsdaggerapp.registration

import dagger.Subcomponent
import uz.jaxadev.jaxadevsdaggerapp.di.ActivityScope
import uz.jaxadev.jaxadevsdaggerapp.registration.enterdetails.EnterDetailsFragment
import uz.jaxadev.jaxadevsdaggerapp.registration.termsandconditions.TermsAndConditionsFragment

@Subcomponent
interface RegistrationComponent {

    @Subcomponent.Factory
    interface Factory {
        fun create(): RegistrationComponent
    }

    fun inject(activity: RegistrationActivity)
    fun inject(fragment: EnterDetailsFragment)
    fun inject(fragment: TermsAndConditionsFragment)

}