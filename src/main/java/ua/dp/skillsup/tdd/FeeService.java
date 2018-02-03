package ua.dp.skillsup.tdd;

import org.springframework.beans.factory.InitializingBean;
//import sun.reflect.generics.reflectiveObjects.NotImplementedException;

import java.util.Date;

public class FeeService implements InitializingBean{

  private HolidayService holidayService;
  private WeekendService weekendService;
  private double fee;

    public WeekendService getWeekendService() {
        return weekendService;
    }

    public void setWeekendService(WeekendService weekendService) {
        this.weekendService = weekendService;
    }

    public void setHolidayService(HolidayService holidayService) {
        this.holidayService = holidayService;
    }

    public void setFee(double fee) {
        this.fee = fee;
    }

    public FeeService(){}

    public FeeService(HolidayService holidayService, WeekendService weekendService) {
        this.holidayService = holidayService;
        this.weekendService = weekendService;
        this.fee = 0.01;
    }

    public double getFee(double payement){
        if(!holidayService.isHoliday(new Date()) && !weekendService.weekendS()){
            return fee;
        }
        return fee;
    }




    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("FeeService Initialised with fee " + fee);
    }}

