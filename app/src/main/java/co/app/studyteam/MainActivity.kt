package co.app.studyteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.app.studyteam.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var userListener: UserListener? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener{
            var username = binding.textUser.text.toString()
            var password = binding.textPassword.text.toString()
            val user = User(UUID.randomUUID().toString(), username, password)

            //Toast.makeText(this, "${username}:${password}", Toast.LENGTH_LONG).show()
            //Toast.makeText(this, "El usuario y contraseña son incorrectos", Toast.LENGTH_LONG).show()

            Firebase.firestore.collection("users").document(user.username).set(user)

            userListener?.userName(username)

            val intent = Intent(this, MenuMain::class.java).apply {
                putExtra("username", username)
            }

            startActivity(intent)
            finish()

        }

    }

    interface UserListener{
        fun userName(username:String)
    }
}