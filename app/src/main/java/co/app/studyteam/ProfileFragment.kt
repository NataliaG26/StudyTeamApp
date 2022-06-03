package co.app.studyteam

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import co.app.studyteam.databinding.FragmentGroupsBinding
import co.app.studyteam.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {

    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentProfileBinding.inflate(inflater, container, false)
        val vista = binding.root

        var username = (activity as? MenuMain)?.getUserName()
        var name = (activity as? MenuMain)?.getName()
        Toast.makeText(this.context,"Hola $username bienvenido a tu perfil", Toast.LENGTH_LONG).show()

        binding.txtNme.text = name
        binding.txtUsername.text = username

        binding.btnLogout.setOnClickListener {
            val intent = Intent(this.context, MainActivity::class.java)

            startActivity(intent)
        }

        return vista
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = ProfileFragment()
    }
}