package uz.jaxadev.jaxadevsdaggerapp.settings

import uz.jaxadev.jaxadevsdaggerapp.user.UserDataRepository
import uz.jaxadev.jaxadevsdaggerapp.user.UserManager

class SettingsViewModel(
    private val userDataRepository: UserDataRepository,
    private val userManager: UserManager
) {

    fun refreshNotifications() {
        userDataRepository.refreshUnreadNotifications()
    }

    fun logout() {
        userManager.logout()
    }
}
