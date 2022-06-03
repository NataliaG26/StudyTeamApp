package co.app.studyteam

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import java.text.SimpleDateFormat
import java.util.*
import kotlin.collections.ArrayList

class GroupAdapter: RecyclerView.Adapter<GroupView>() {

    private val groups = ArrayList<Group>()

    fun addGroup(group: Group){
        groups.add(group)
        notifyItemInserted(groups.size-1)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GroupView {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.group_row, parent, false)
        val groupView = GroupView(view)
        return groupView
    }

    override fun onBindViewHolder(holder: GroupView, position: Int) {
        val chart =groups[position]
        holder.group = chart
        holder.initializer(chart)
        // verificar vista -------------------------------------------------------

    }

    fun deleteAllGroup(){
        groups.clear()
    }

    fun convertLongToTime(time: Long, format:String): String {
        val date = Date(time)
        //"yyyy.MM.dd HH:mm"
        val format = SimpleDateFormat(format)
        return format.format(date)
    }

    override fun getItemCount(): Int {
        return groups.size
    }
}