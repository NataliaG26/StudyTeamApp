package co.app.studyteam

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import co.app.studyteam.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnLogin.setOnClickListener{
            var username = binding.textUser.text.toString()
            var password = binding.textPassword.text.toString()

            //Toast.makeText(this, "${username}:${password}", Toast.LENGTH_LONG).show()
            //Toast.makeText(this, "El usuario y contraseña son incorrectos", Toast.LENGTH_LONG).show()

            val intent = Intent(this, MenuMain::class.java)
            startActivity(intent)

        }

    }
}