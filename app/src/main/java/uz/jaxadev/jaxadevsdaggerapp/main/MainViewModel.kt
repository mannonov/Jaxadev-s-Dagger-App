package uz.jaxadev.jaxadevsdaggerapp.main

import uz.jaxadev.jaxadevsdaggerapp.di.ActivityScope
import uz.jaxadev.jaxadevsdaggerapp.user.UserDataRepository
import javax.inject.Inject

@ActivityScope
class MainViewModel @Inject constructor(private val userDataRepository: UserDataRepository) {

    val welcomeText: String
        get() = "Hello ${userDataRepository.username}!"

    val notificationsText: String
        get() = "You have ${userDataRepository.unreadNotifications} unread notifications"
}
