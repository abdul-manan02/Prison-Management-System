package Business_Logic;

public class MeetingRecord
{
    private int prisonerId;
    private String meetingTime;
    private boolean permission;

    public MeetingRecord() {
        prisonerId=-1; meetingTime=""; permission=false;
    }

    public MeetingRecord(int Id, String time, Boolean Permission) {
        prisonerId=Id; meetingTime=time; permission=Permission;
    }

    public void     setId(int Id)                       { prisonerId=Id; }
    public int      getId()                             { return prisonerId; }
    public void     setTime(String time)                { meetingTime=time; }
    public String   getTime()                           { return meetingTime; }
    public void     setPermission(Boolean Permission)    { permission=Permission; }
    public Boolean  getPermission()                     { return permission; }
}
