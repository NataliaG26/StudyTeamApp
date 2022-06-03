package co.app.studyteam

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import co.app.studyteam.databinding.ActivityMenuMainBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class MenuMain : AppCompatActivity() {

    private lateinit var binding: ActivityMenuMainBinding

    private lateinit var groupsFragment: GroupsFragment
    private lateinit var profileFragment: ProfileFragment
    private var username:String? = null
    private lateinit var myGroupsFragment: MyGroupsFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMenuMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        groupsFragment = GroupsFragment.newInstance()
        profileFragment = ProfileFragment.newInstance()
        username = intent.extras?.getString("username")
        //Toast.makeText(this,"Hola $username", Toast.LENGTH_LONG).show()
        myGroupsFragment = MyGroupsFragment.newInstance()

        binding.btnNav.setOnItemSelectedListener { menuapp ->
            if (menuapp.itemId == R.id.groupItem) {
                showFragment(groupsFragment)
            } else if (menuapp.itemId == R.id.profileItem) {
                showFragment(profileFragment)
            } else if (menuapp.itemId == R.id.myGroupsItem) {
                showFragment(myGroupsFragment)
            }
            true
        }
    }

    fun getUserName(): String? {

        return username

    }
    fun showFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragmentContainer, fragment)
        transaction.commit()
    }
}