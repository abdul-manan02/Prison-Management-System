package Business_Logic;

public class CellChangeRequests_Record
{
    private int prisonerId;
    private String reason;
    private Boolean permission;
    private int oldRoomNo;
    private int newRoomNo;

    CellChangeRequests_Record() {
        prisonerId=-1; reason=""; permission=false; oldRoomNo=-1; newRoomNo=-1;
    }

    public CellChangeRequests_Record(int id, String Reason, Boolean Permission, int OldRoom, int NewRoom){
        prisonerId=id; reason=Reason; permission=Permission; oldRoomNo=OldRoom; newRoomNo=NewRoom;
    }

    public void     setPrisonerId(int id)               { prisonerId=id; }
    public int      getPrisonerId()                     { return prisonerId; }
    public void     setReason(String Reason)            { reason=Reason; }
    public String   getReason()                         { return  reason;}
    public void     setPermission(Boolean Permission)   { permission=Permission; }
    public Boolean  getPermission()                    { return permission; }
    public void     setOldRoomNo(int OldRoom)           { oldRoomNo=OldRoom;}
    public int      getOldRoomNo()                      { return oldRoomNo; }
    public void     setNewRoomNo(int NewRoomNo)         { newRoomNo=NewRoomNo; }
    public int      getNewRoomNo()                      { return newRoomNo; }
}
