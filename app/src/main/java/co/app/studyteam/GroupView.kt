package co.app.studyteam

import android.annotation.SuppressLint
import android.view.View
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class GroupView(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var group: Group? = null

    var subject: TextView =itemView.findViewById(R.id.groupSubject)
    var date: TextView =  itemView.findViewById(R.id.groupDate)
    var startHour: TextView = itemView.findViewById(R.id.startHour)
    var finishHour: TextView = itemView.findViewById(R.id.finishHour)


    fun initializer(groupView: Group){
        subject.text = groupView.subject
        date.text = groupView.date
        startHour.text = groupView.startHour
        finishHour.text = groupView.finishHour

        //pokemonDetails()
    }


}