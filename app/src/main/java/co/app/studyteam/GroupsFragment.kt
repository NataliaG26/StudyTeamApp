package co.app.studyteam

import android.content.Context
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import co.app.studyteam.databinding.FragmentGroupsBinding
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class GroupsFragment : Fragment() {

    private var _binding: FragmentGroupsBinding? = null
    private val binding get() = _binding!!

    private val adapter = GroupAdapter()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentGroupsBinding.inflate(inflater, container, false)
        val view = binding.root

        var username = (activity as? MenuMain)?.getUserName()

        //recrear estado
        var groupRecycler = binding.groupRecycler
        groupRecycler.setHasFixedSize(true)
        groupRecycler.layoutManager = LinearLayoutManager(activity)
        groupRecycler.adapter = adapter

        getGroup(username)

        Toast.makeText(this.context,"Hola $username", Toast.LENGTH_LONG).show()

        return view
    }

    fun getGroup(username: String?){
            Firebase.firestore.collection("users").document(username.toString()).collection("group").orderBy("date", Query.Direction.DESCENDING).get().addOnCompleteListener { task ->
                adapter.deleteAllGroup()
                for (document in task.result!!) {
                    val group = document.toObject(Group::class.java)
                    adapter.addGroup(group)
                    adapter.notifyDataSetChanged()
                }
            }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        @JvmStatic
        fun newInstance() = GroupsFragment()
    }
}