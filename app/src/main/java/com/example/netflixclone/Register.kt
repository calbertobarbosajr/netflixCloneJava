package com.example.netflixclone

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.netflixclone.databinding.ActivityRegisterBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseAuthWeakPasswordException

class Register : AppCompatActivity() {

    private lateinit var binding: ActivityRegisterBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityRegisterBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
    }

    fun buttonRegister(view: View) {
        val email = binding.editEmailRegister.text.toString()
        val password = binding.editPasswordRegister.text.toString()
        val repeatPassword = binding.editRepeatPassword.text.toString()
        val errorMessageRegister = binding.errorMessageRegister

        if ( password == repeatPassword){
            if (email.isEmpty() || password.isEmpty() || repeatPassword.isEmpty()){
                errorMessageRegister.setText("Fill in all fields!")
            }else{
                UserRegistration()
            }
        }else{
            errorMessageRegister.setText("The passwords are different")
        }
    }

    private fun UserRegistration(){

        val email = binding.editEmailRegister.text.toString()
        val senha = binding.editPasswordRegister.text.toString()
        val errorMessageRegister = binding.errorMessageRegister

        FirebaseAuth.getInstance().createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this,"User registered successfully!",Toast.LENGTH_SHORT).show()
                binding.editEmailRegister.setText("")
                binding.editPasswordRegister.setText("")
                errorMessageRegister.setText("")
            }
        }.addOnFailureListener {

            var erro = it

            when{
                erro is FirebaseAuthWeakPasswordException -> errorMessageRegister.setText("Enter a password of at least 6 characters")
                erro is FirebaseAuthUserCollisionException -> errorMessageRegister.setText("This account has already been registered")
                erro is FirebaseNetworkException -> errorMessageRegister.setText("No internet connection")
                else -> errorMessageRegister.setText("Error registering user")
            }

        }
    }




}