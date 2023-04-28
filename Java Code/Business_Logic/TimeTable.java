package Business_Logic;

import java.sql.Time;

public class TimeTable
{
    private int weekNo;
    private String wakeUp_Time;
    private String outdoor_Time;
    private String lightsOut_Time;

    public TimeTable(){
        weekNo=-1; wakeUp_Time=""; outdoor_Time=""; lightsOut_Time="";
    }
    public TimeTable(int week, String wake, String outdoor, String lightsOut){
        weekNo=week; wakeUp_Time=wake; outdoor_Time=outdoor; lightsOut_Time=lightsOut;
    }

    public void    setWeekNo(int week)             { weekNo=week; }
    public int      getWeekNo()                     { return weekNo; }
    public void     setWake(String wake)            { wakeUp_Time=wake; }
    public String   getWake()                       { return wakeUp_Time; }
    public void     setOutdoor(String outdoor)      {outdoor_Time=outdoor; }
    public String   getOutdoor()                    { return outdoor_Time; }
    public void     setLightsOut(String lightsOut)  { lightsOut_Time=lightsOut; }
    public String   getLightsOut()                  { return lightsOut_Time; }

}
