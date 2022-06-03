package co.app.studyteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import co.app.studyteam.databinding.ActivityMainBinding
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var userListener: UserListener? = null
    private var username:String? = null
    private var password:String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        Toast.makeText(this,"Hola $username", Toast.LENGTH_LONG).show()

        binding.btnLogin.setOnClickListener{

            //Toast.makeText(this, "${username}:${password}", Toast.LENGTH_LONG).show()
            //Toast.makeText(this, "El usuario y contraseña son incorrectos", Toast.LENGTH_LONG).show()

            Toast.makeText(this,"Hola ${searchUser().username}", Toast.LENGTH_LONG).show()

            if (username.toString() == searchUser().username && password.toString() == searchUser().password){

                val intent = Intent(this, MenuMain::class.java).apply {
                    putExtra("username", username)
                }

                startActivity(intent)
                finish()

            }else{

                Toast.makeText(this,"Usuario incorrecto", Toast.LENGTH_LONG).show()

            }

        }

        binding.btnUserCreate.setOnClickListener {
            val intent = Intent(this, UserCreateActivity::class.java)
            startActivity(intent)
        }

    }

    fun searchUser(): User {
        username = binding.textUser.text.toString()
        password = binding.textPassword.text.toString()
        lateinit var userSearch : User

        lifecycleScope.launch(Dispatchers.IO) {

            val query = Firebase.firestore.collection("users").document(username.toString())
            query.get().addOnSuccessListener {


                 userSearch = it.toObject(User::class.java)!!


                Log.e("zzzzzzzzzz", userSearch!!.email.toString())
            }

        }

        return userSearch

    }

    interface UserListener{
        fun userName(username:String)
    }
}