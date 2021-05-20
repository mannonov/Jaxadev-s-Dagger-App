package uz.jaxadev.jaxadevsdaggerapp.user

import uz.jaxadev.jaxadevsdaggerapp.storage.Storage

private const val REGISTERED_USER = "registered_user"
private const val PASSWORD_SUFFIX = "password"


class UserManager(private val storage: Storage) {


    var userDataRepository: UserDataRepository? = null

    val username: String
        get() = storage.getString(REGISTERED_USER)

    fun isUserLoggedIn() = userDataRepository != null

    fun isUserRegistered() = storage.getString(REGISTERED_USER).isNotEmpty()

    fun registerUser(username: String, password: String) {
        storage.setString(REGISTERED_USER, username)
        storage.setString("$username$PASSWORD_SUFFIX", password)
        userJustLoggedIn()
    }

    fun loginUser(username: String, password: String): Boolean {
        val registeredUser = this.username
        if (registeredUser != username) return false

        val registeredPassword = storage.getString("$username$PASSWORD_SUFFIX")
        if (registeredPassword != password) return false

        userJustLoggedIn()
        return true
    }

    fun logout() {
        userDataRepository = null
    }

    fun unregister() {
        val username = storage.getString(REGISTERED_USER)
        storage.setString(REGISTERED_USER, "")
        storage.setString("$username$PASSWORD_SUFFIX", "")
        logout()
    }

    private fun userJustLoggedIn() {
        userDataRepository = UserDataRepository(this)
    }
}
