package uz.jaxadev.jaxadevsdaggerapp.registration

import uz.jaxadev.jaxadevsdaggerapp.di.ActivityScope
import uz.jaxadev.jaxadevsdaggerapp.user.UserManager
import javax.inject.Inject

@ActivityScope
class RegistrationViewModel @Inject constructor(val userManager: UserManager) {

    private var username: String? = null
    private var password: String? = null
    private var acceptedTCs: Boolean? = null

    fun updateUserData(username: String, password: String) {
        this.username = username
        this.password = password
    }

    fun acceptTCs() {
        acceptedTCs = true
    }

    fun registerUser() {
        assert(username != null)
        assert(password != null)
        assert(acceptedTCs == true)

        userManager.registerUser(username!!, password!!)
    }
}
