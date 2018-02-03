package ua.dp.skillsup.tdd;

import java.time.DayOfWeek;
import java.time.LocalDate;

public class WeekendService {
 LocalDate localDate;

 public boolean weekendS(){
     if(localDate.getDayOfWeek() == DayOfWeek.SATURDAY &&
             localDate.getDayOfWeek() == DayOfWeek.SUNDAY){
         return true;
    }else
     return false;

}}
