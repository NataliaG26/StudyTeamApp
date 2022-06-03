package co.app.studyteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import co.app.studyteam.databinding.ActivityCreateGroupBinding
import co.app.studyteam.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import java.text.SimpleDateFormat
import java.util.*

class CreateGroupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateGroupBinding
    private var username:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGroupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        username = intent.extras?.getString("username")
        Toast.makeText(this,"Hola $username", Toast.LENGTH_LONG).show()

        binding.btnCrear.setOnClickListener{
            // crear grupo --------------
            var date = binding.eTxtDate.text.toString()
            var startHour = binding.eTxtStart.text.toString()
            var finishHour = binding.eTxtFinish.text.toString()
            var subject = binding.eTxtSubject.text.toString()

            val group = Group(UUID.randomUUID().toString(), date, startHour, finishHour, subject)
            Firebase.firestore.collection("users").document(username.toString()).collection("group").document(group.id).set(group)
            super.finish();
        }

    }
}