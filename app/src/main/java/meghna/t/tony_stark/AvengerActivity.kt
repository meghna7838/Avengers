package meghna.t.tony_stark

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.SharedMemory
import android.widget.Button
import android.widget.EditText
import android.widget.Toast


class AvengerActivity : AppCompatActivity() {

    lateinit var btnLogout: Button
    lateinit var btnSendMessage: Button
    lateinit var etSend: EditText
    var titleName: String? = "Avengers"
    lateinit var sharedPreferences: SharedPreferences

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        sharedPreferences =
            getSharedPreferences(getString(R.string.preference_file_name), Context.MODE_PRIVATE)

        setContentView(R.layout.activity_avenger)
        if (intent != null) {
            titleName = sharedPreferences.getString("Title", "The Avengers")
        }
        title = titleName

        etSend = findViewById(R.id.etSend)

        btnLogout = findViewById(R.id.btnLogout)
        btnLogout.setOnClickListener {
            var intent = Intent(this@AvengerActivity, LoginActivity::class.java)
            startActivity(intent)
            sharedPreferences.edit().clear().apply()
            finish()


        }
        btnSendMessage = findViewById(R.id.btnSendMessage)
        btnSendMessage.setOnClickListener {
            var intent = Intent(this@AvengerActivity, MessageActivity::class.java)
            var message = etSend.text.toString()
            intent.putExtra("Message", message)
            startActivity(intent)
        }
    }


}
