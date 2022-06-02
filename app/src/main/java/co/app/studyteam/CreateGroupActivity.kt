package co.app.studyteam

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import co.app.studyteam.databinding.ActivityCreateGroupBinding
import co.app.studyteam.databinding.ActivityMainBinding

class CreateGroupActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCreateGroupBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCreateGroupBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        binding.btnCrear.setOnClickListener{
            // crear grupo --------------
            super.finish();
        }

    }
}