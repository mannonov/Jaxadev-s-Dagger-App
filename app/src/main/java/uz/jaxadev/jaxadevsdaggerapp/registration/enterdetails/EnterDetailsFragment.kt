package uz.jaxadev.jaxadevsdaggerapp.registration.enterdetails

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.widget.doOnTextChanged
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import uz.jaxadev.jaxadevsdaggerapp.R
import uz.jaxadev.jaxadevsdaggerapp.registration.RegistrationActivity
import uz.jaxadev.jaxadevsdaggerapp.registration.RegistrationViewModel

class EnterDetailsFragment : Fragment() {

    private lateinit var registrationViewModel: RegistrationViewModel
    private lateinit var enterDetailsViewModel: EnterDetailsViewModel

    private lateinit var errorTextView: TextView
    private lateinit var usernameEditText: EditText
    private lateinit var passwordEditText: EditText

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_enter_details, container, false)

        registrationViewModel = (activity as RegistrationActivity).registrationViewModel

        enterDetailsViewModel = EnterDetailsViewModel()
        enterDetailsViewModel.enterDetailsState.observe(this,
            Observer<EnterDetailsViewState> { state ->
                when (state) {
                    is EnterDetailsSuccess -> {

                        val username = usernameEditText.text.toString()
                        val password = passwordEditText.text.toString()
                        registrationViewModel.updateUserData(username, password)

                        (activity as RegistrationActivity).onDetailsEntered()
                    }
                    is EnterDetailsError -> {
                        errorTextView.text = state.error
                        errorTextView.visibility = View.VISIBLE
                    }
                }
            })

        setupViews(view)
        return view
    }

    private fun setupViews(view: View) {
        errorTextView = view.findViewById(R.id.error)

        usernameEditText = view.findViewById(R.id.username)
        usernameEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        passwordEditText = view.findViewById(R.id.password)
        passwordEditText.doOnTextChanged { _, _, _, _ -> errorTextView.visibility = View.INVISIBLE }

        view.findViewById<Button>(R.id.next).setOnClickListener {
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()
            enterDetailsViewModel.validateInput(username, password)
        }
    }
}

sealed class EnterDetailsViewState
object EnterDetailsSuccess : EnterDetailsViewState()
data class EnterDetailsError(val error: String) : EnterDetailsViewState()
