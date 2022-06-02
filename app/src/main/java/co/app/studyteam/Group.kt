package co.app.studyteam

import java.io.DataOutput
import java.util.*

class Group {

    var id: String
    var date: Long
    var startHour: Long
    var finishHour: Long
    var subject: String
    var users: ArrayList<User>

    constructor(date:Long, startHour: Long, finishHour: Long, subject:String){
        this.id = UUID.randomUUID().toString()
        this.date = date
        this.startHour = startHour
        this.finishHour = finishHour
        this.subject = subject
        users = ArrayList<User>()
    }
}