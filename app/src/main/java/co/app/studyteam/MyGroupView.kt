package co.app.studyteam

import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class MyGroupView (itemView: View) : RecyclerView.ViewHolder(itemView) {

    var group: Group? = null

    var subject: TextView =itemView.findViewById(R.id.subjectText)
    var date: TextView =  itemView.findViewById(R.id.dateText)
    var startHour: TextView = itemView.findViewById(R.id.startHourText)
    var finishHour: TextView = itemView.findViewById(R.id.finishHourText)

    fun initializer(groupView: Group){
        subject.text = groupView.subject
        date.text = groupView.date
        startHour.text = groupView.startHour
        finishHour.text = groupView.finishHour

        //pokemonDetails()
    }
}