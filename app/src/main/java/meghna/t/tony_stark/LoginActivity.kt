package meghna.t.tony_stark

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class LoginActivity : AppCompatActivity() {

    lateinit var etMobileNumber: EditText
    lateinit var etPassword: EditText
    lateinit var btnLogin: Button
    lateinit var txtForgotPassword: TextView
    lateinit var txtRegister: TextView


    lateinit var sharedPreferences: SharedPreferences

    val validMobileNumber = "0123456789"
    val validPassword = arrayOf("tony", "steve", "bruce", "thanos")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        val isLoggedIn = sharedPreferences.getBoolean("isLoggedIn", false)

        if (isLoggedIn) {
            val intent = Intent(this@LoginActivity, AvengerActivity::class.java)
            startActivity(intent)
            finish()
        }

        title = "Log In"

        etMobileNumber = findViewById(R.id.etMobileNumber)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)
        txtForgotPassword = findViewById(R.id.txtForgotPassword)
        txtRegister = findViewById(R.id.txtRegister)


        btnLogin.setOnClickListener {
            val mobileNumber = etMobileNumber.text.toString()
            val password = etPassword.text.toString()
            var nameOfAvenger = "Avenger"
            val intent = Intent(
                this@LoginActivity,
                AvengerActivity::class.java
            )
            if ((mobileNumber == validMobileNumber)) {
                if (password == validPassword[0]) {
                    nameOfAvenger = "Iron Man"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (password == validPassword[1]) {

                    nameOfAvenger = "Captain American"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (password == validPassword[2]) {

                    nameOfAvenger = "The Hulk"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                } else if (password == validPassword[3]) {

                    nameOfAvenger = "The Avengers"
                    savePreferences(nameOfAvenger)
                    intent.putExtra("Name", nameOfAvenger)
                    startActivity(intent)
                }


                Toast.makeText(this@LoginActivity, "u just clicked button", Toast.LENGTH_LONG)
                    .show()


            } else {
                Toast.makeText(this@LoginActivity, "incorrect credentials", Toast.LENGTH_LONG)
                    .show()

            }
        }

        txtForgotPassword.setOnClickListener {
            var intent = Intent(this@LoginActivity, ForgotOrRegisterActivity::class.java)
            startActivity(intent)
        }

        txtRegister.setOnClickListener {
            var intent = Intent(this@LoginActivity, ForgotOrRegisterActivity::class.java)
            startActivity(intent)
        }

    }

    override fun onPause() {
        super.onPause()
        finish()
    }

    fun savePreferences(title: String) {

        sharedPreferences.edit().putBoolean("isLoggedIn", true).apply()
        sharedPreferences.edit().putString("Title", title).apply()
    }

}
