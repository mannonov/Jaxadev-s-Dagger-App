package uz.jaxadev.jaxadevsdaggerapp.main

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import uz.jaxadev.jaxadevsdaggerapp.MyApplication
import uz.jaxadev.jaxadevsdaggerapp.R
import uz.jaxadev.jaxadevsdaggerapp.login.LoginActivity
import uz.jaxadev.jaxadevsdaggerapp.registration.RegistrationActivity
import uz.jaxadev.jaxadevsdaggerapp.settings.SettingsActivity

class MainActivity : AppCompatActivity() {

    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val userManager = (application as MyApplication).userManager
        if (!userManager.isUserLoggedIn()) {
            if (!userManager.isUserRegistered()) {
                startActivity(Intent(this, RegistrationActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            }
        } else {
            setContentView(R.layout.activity_main)

            mainViewModel = MainViewModel(userManager.userDataRepository!!)
            setupViews()
        }
    }

    override fun onResume() {
        super.onResume()
        findViewById<TextView>(R.id.notifications).text = mainViewModel.notificationsText
    }

    private fun setupViews() {
        findViewById<TextView>(R.id.hello).text = mainViewModel.welcomeText
        findViewById<Button>(R.id.settings).setOnClickListener {
            startActivity(Intent(this, SettingsActivity::class.java))
        }
    }
}
