package co.app.studyteam

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var subject: TextView =itemView.findViewById(R.id.groupSubject)
    var date: TextView =  itemView.findViewById(R.id.groupDate)
    var hours: TextView = itemView.findViewById(R.id.groupHours)

}