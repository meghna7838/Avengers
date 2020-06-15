package meghna.t.tony_stark

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MessageActivity : AppCompatActivity() {

    lateinit var txtMessage: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_message)

        txtMessage = findViewById(R.id.txtMessage)
        var message: String = "Message recieved"
        if (intent != null) {
            message = intent.getStringExtra("Message")
            txtMessage.text = message
        }


    }
}