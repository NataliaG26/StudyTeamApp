package co.app.studyteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import co.app.studyteam.databinding.ActivityUserCreateBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.util.*

class UserCreateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUserCreateBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserCreateBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.bntUserCreate.setOnClickListener{
            var name = binding.eTxtName.text.toString()
            var username = binding.eTxtUsername.text.toString()
            var email = binding.eTxtEmail.text.toString()
            var password =  binding.eTxtPassword.text.toString()

            val user = User(UUID.randomUUID().toString(),name, email, username, password)
            Firebase.firestore.collection("users").document(user.username).set(user)

            val intent = Intent(this, MainActivity::class.java).apply {
                putExtra("username", username)
                putExtra("password", password)
            }

            startActivity(intent)
            finish()
            super.finish();
        }
    }
}