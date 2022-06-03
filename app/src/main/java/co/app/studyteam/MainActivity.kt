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

            //Toast.makeText(this, "${username}:${password}", Toast.LENGTH_LONG).show()
            //Toast.makeText(this, "El usuario y contraseña son incorrectos", Toast.LENGTH_LONG).show()
            //Toast.makeText(this,"Hola ${searchUser().username}", Toast.LENGTH_LONG).show()

            var user = binding.textUser.text.toString()
            var password = binding.textPassword.text.toString()


           // lifecycleScope.launch(Dispatchers.IO) {

                val query = Firebase.firestore.collection("users").document(user)
                query.get().addOnSuccessListener {


                    var userSearch : User? = it.toObject(User::class.java)

                    if (userSearch != null){

                        if (user == userSearch.username && password == userSearch.password){

                            val intent = Intent(this@MainActivity, MenuMain::class.java).apply {
                                putExtra("username", user)
                                putExtra("name", userSearch.name)
                            }

                            startActivity(intent)
                            finish()

                        }else{

                            Toast.makeText(this@MainActivity,"Usuario incorrecto", Toast.LENGTH_LONG).show()

                        }

                    }else{

                        Toast.makeText(this@MainActivity,"Usuario incorrecto", Toast.LENGTH_LONG).show()

                    }


                }

            //}

        }

        binding.btnUserCreate.setOnClickListener {
            val intent = Intent(this, UserCreateActivity::class.java)
            startActivity(intent)
        }

    }
    interface UserListener{
        fun userName(username:String)
    }
}