package ua.dp.skillsup.tdd;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import java.util.Date;

public class FeeServiceTest extends Assert {

    private BankAccount sender;
    private BankAccount recipient;
    private FeeService feeService;
    private AccountService accountService;
    private WeekendService weekendService;
    private HolidayService holidayService;

    @Before
    public void before() {
        sender = new BankAccount(100);
        recipient = new BankAccount(200);
        weekendService = Mockito.mock(WeekendService.class);
        holidayService = Mockito.mock(HolidayService.class);
        feeService = new FeeService(holidayService, weekendService);
        accountService = new AccountService(feeService);
    }

    @Test

    public void workingDays(){
        Mockito.when(holidayService.isHoliday(new Date())).thenReturn(false);
        Mockito.when(weekendService.weekendS()).thenReturn(false);
        accountService.transferMoney(sender,recipient,100);
        assertEquals(0,sender.getAmount(),01);
        assertEquals(299,recipient.getAmount(),01);

    }


    @Test

    public void weekendDays(){
        Mockito.when(holidayService.isHoliday(new Date())).thenReturn(false);
        Mockito.when(weekendService.weekendS()).thenReturn(true);
        accountService.transferMoney(sender,recipient,100);
        assertEquals(0,sender.getAmount(),01);
        assertEquals(298.5,recipient.getAmount(),01);

    }

    @Test

    public void weekendAndWorkingDays(){
        Mockito.when(holidayService.isHoliday(new Date())).thenReturn(true);
        Mockito.when(weekendService.weekendS()).thenReturn(false);
        accountService.transferMoney(sender,recipient,100);
        assertEquals(0,sender.getAmount(),01);
        assertEquals(298.5,recipient.getAmount(),01);

    }






}
