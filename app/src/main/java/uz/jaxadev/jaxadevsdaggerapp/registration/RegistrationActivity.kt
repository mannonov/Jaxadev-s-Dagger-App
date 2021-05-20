package uz.jaxadev.jaxadevsdaggerapp.registration

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import uz.jaxadev.jaxadevsdaggerapp.MyApplication
import uz.jaxadev.jaxadevsdaggerapp.R
import uz.jaxadev.jaxadevsdaggerapp.main.MainActivity
import uz.jaxadev.jaxadevsdaggerapp.registration.enterdetails.EnterDetailsFragment
import uz.jaxadev.jaxadevsdaggerapp.registration.termsandconditions.TermsAndConditionsFragment

class RegistrationActivity : AppCompatActivity() {

    lateinit var registrationViewModel: RegistrationViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registrationViewModel = RegistrationViewModel((application as MyApplication).userManager)
        supportFragmentManager.beginTransaction()
            .add(R.id.fragment_holder, EnterDetailsFragment())
            .commit()
    }

    fun onDetailsEntered() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_holder, TermsAndConditionsFragment())
            .addToBackStack(TermsAndConditionsFragment::class.java.simpleName)
            .commit()
    }

    fun onTermsAndConditionsAccepted() {
        registrationViewModel.registerUser()
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }

    override fun onBackPressed() {
        if (supportFragmentManager.backStackEntryCount > 0) {
            supportFragmentManager.popBackStack()
        } else {
            super.onBackPressed()
        }
    }
}
