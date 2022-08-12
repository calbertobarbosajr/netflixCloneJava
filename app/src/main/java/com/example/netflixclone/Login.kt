package com.example.netflixclone

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.netflixclone.databinding.ActivityLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class Login : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        CheckUserIsLoggedin()
        supportActionBar!!.hide()
    }

    fun signup(view: View) {
        val intent = Intent(this, Register::class.java)
        startActivity(intent)
    }

    fun buttonLogin(view: View) {
        val email = binding.editEmailLogin.text.toString()
        val password = binding.editPasswordLogin.text.toString()
        val errorMessageLogin = binding.errorMessageLogin

        if (email.isEmpty() || password.isEmpty()){
            errorMessageLogin.setText("Fill in all fields!")
        }else{
            AutenticarUsuario()
        }
    }


    private fun AutenticarUsuario(){

        val email = binding.editEmailLogin.text.toString()
        val password = binding.editPasswordLogin.text.toString()
        val errorMessageLogin = binding.errorMessageLogin

        FirebaseAuth.getInstance().signInWithEmailAndPassword(email,password).addOnCompleteListener {
            if (it.isSuccessful){
                Toast.makeText(this,"Login successfully done!",Toast.LENGTH_SHORT).show()
                mainScreen()
            }
        }.addOnFailureListener {

            var erro = it

            when{
                erro is FirebaseAuthInvalidCredentialsException -> errorMessageLogin.setText("Email or Password is incorrect")
                erro is FirebaseNetworkException -> errorMessageLogin.setText("No internet connection!")
                else -> errorMessageLogin.setText("User login error")
            }
        }

    }

    private fun CheckUserIsLoggedin(){
        val loggedUser = FirebaseAuth.getInstance().currentUser

        if (loggedUser != null){
            mainScreen()
        }
    }

    private fun mainScreen(){
        val intent = Intent(this,MainActivity::class.java)
        startActivity(intent)
        finish()
    }







}