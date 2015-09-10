package chandu0101.scalajs.react.components
package util

import scala.scalajs.js.Date

object DateTime {

  def addDays( d: Date, days: Int) = {
    val newDate = clone(d)
    newDate.setDate(d.getDate() + days)
    newDate
  }

  def clone( d: Date) = new Date(d.getTime())

  def addMonths( d: Date, months: Int) = {
    val newDate = clone(d)
    newDate.setMonth(d.getMonth() + months)
    newDate
  }
  
  def getFirstDayOfMonth( d: Date) = new Date(d.getFullYear(),d.getMonth(),1)

  def getDaysInMonth( d: Date) = {
    val resultDate = getFirstDayOfMonth(d)
    resultDate.setMonth(resultDate.getMonth() + 1)
    resultDate.setDate(resultDate.getDate() - 1)
    resultDate.getDate()
  }

  def getFullMonth(d: Date) = {
    d.getMonth() match  {
      case 0 =>  "January"
      case 1 =>  "February"
      case 2 =>  "March"
      case 3 =>  "April"
      case 4 =>  "May"
      case 5 =>  "June"
      case 6 =>  "July"
      case 7 =>  "August"
      case 8 =>  "September"
      case 9 =>  "October"
      case 10 =>  "November"
      case 11 =>  "December"
      case _ => "Unknown"
    }
  }

  def getShortMonth( d: Date) = {
    
     d.getMonth() match {
       case 0 =>  "Jan"
       case 1 =>  "Feb"
       case 2 =>  "Mar"
       case 3 =>  "Apr"
       case 4 =>  "May"
       case 5 =>  "Jun"
       case 6 =>  "Jul"
       case 7 =>  "Aug"
       case 8 =>  "Sep"
       case 9 =>  "Oct"
       case 10 =>  "Nov"
       case 11 =>  "Dec"
       case _ => "Unknown"
     }
  }

  def getDayOfWeek( d: Date) = {
    d.getDay() match {
      case 0 =>   "Sunday";
      case 1 =>   "Monday";
      case 2 =>   "Tuesday";
      case 3 =>   "Wednesday";
      case 4 =>   "Thursday";
      case 5 =>   "Friday";
      case 6 =>   "Saturday";
      case _ => "Unknown"
    }
  }

  def getWeekArray( d: Date) = {
    val daysInMonth = getDaysInMonth(d)
    val dayArray = (1 to daysInMonth).toList.map(i => new  Date(d.getFullYear(), d.getMonth(), i)).toList
    getWeeks(dayArray)
  }

  def getWeeks( days: List[Date]) =  {
    var i = 0
    var weeks: List[List[Date]] = List()
    while(i < days.length) {
      val firstDayOfWeek = days(i).getDay()
      val daysInWeek = 7 - firstDayOfWeek
      val emptyDays = 7 - daysInWeek
       weeks = weeks.:+(List.fill(emptyDays)(null).++(days.slice(i,i+daysInWeek)))
      i = i+daysInWeek
    }
    weeks
  }

  def format(d: Date) = {
    s"${d.getMonth()+1} / ${d.getDate()} / ${d.getFullYear()}"
  }

  def isEqualDate( d1: Date ,d2: Date) = {
    if(d1 != null && d2 != null) {
      (d1.getFullYear() == d2.getFullYear()) &&
        (d1.getMonth() == d2.getMonth()) &&
        (d1.getDate() == d2.getDate())
    } else false
  }

}
