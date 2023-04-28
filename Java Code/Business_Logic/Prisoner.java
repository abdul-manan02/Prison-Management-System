package Business_Logic;
import Database.DBHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class Prisoner
{
    private int id;
    private String pass;
    private String name;
    private int blockNo;
    private int roomNo;
    private String dateOfEnrollment;
    private String crimeCommitted;
    private String jobTitle;
    private int jobPay;
    private Boolean jobChangeRequest;
    private String jobAppliedFor;
    private Boolean cellChangeRequest;
    private String cellChangeReason;
    private int cellChangeTo;
    private Boolean meetingRequest;
    private String meetingTime;
    private boolean itemRequest;
    private String itemType;
    private ArrayList <CellChangeRequests_Record> cellChangeRecord;
    public Prisoner()
    {
        id=-1; pass=""; name=""; blockNo=-1; roomNo=-1; crimeCommitted=""; dateOfEnrollment="";
        jobTitle=""; jobPay=-1; jobChangeRequest=false; jobAppliedFor="";
        cellChangeRequest=false; cellChangeReason=""; cellChangeTo=-1;
        meetingRequest=false; meetingTime="";
        itemRequest=false; itemType="";
        DBHandler db= new DBHandler();
        cellChangeRecord = new ArrayList<CellChangeRequests_Record>();
        cellChangeRecord = db.readCellChangeRecord();
        db.closeConnection();
    }

    public Prisoner(int Id, String Pass, String Name,  int Block, int Room, String Date, String Crime)
    {
        name=Name; id=Id; pass=Pass; blockNo=Block; roomNo=Room; dateOfEnrollment=Date; crimeCommitted=Crime;
        jobTitle=""; jobPay=-1; jobChangeRequest=false; jobAppliedFor="";
        cellChangeRequest=false; cellChangeReason=""; cellChangeTo=-1;
        meetingRequest=false; meetingTime="";
        itemRequest=false; itemType="";
        DBHandler db= new DBHandler();
        cellChangeRecord = new ArrayList<CellChangeRequests_Record>();
        cellChangeRecord = db.readCellChangeRecord();
        db.closeConnection();
    }

    public Prisoner
            (
                int Id, String Pass, String Name, int Block, int Room, String Date, String Crime,
                String JobTitle, int JobPay, Boolean JobChangeRequest,  String NewJob,
                Boolean CellChangeRequest, String CellChangeReason, int CellChangeTo,
                Boolean MeetingRequest, String MeetingTime,
                Boolean ItemRequest, String ItemType
            )
    {
        id=Id; pass=Pass; name=Name;  blockNo=Block; roomNo=Room; crimeCommitted=Crime; dateOfEnrollment=Date;
        jobTitle=JobTitle; jobPay=JobPay; jobChangeRequest=JobChangeRequest; jobAppliedFor=NewJob;
        cellChangeRequest=CellChangeRequest; cellChangeReason=CellChangeReason; cellChangeTo=CellChangeTo;
        meetingRequest=MeetingRequest; meetingTime=MeetingTime;
        itemRequest=ItemRequest; itemType=ItemType;
        DBHandler db= new DBHandler();
        cellChangeRecord = new ArrayList<CellChangeRequests_Record>();
        cellChangeRecord = db.readCellChangeRecord();
        db.closeConnection();

    }

    private void printSpaces(int j)
    {
        for(int i=0; i<j; i++)
        {
            System.out.print(" ");
        }
    }
    static void printStars(int j)
    {
        for(int i=0; i<j; i++)
        {
            System.out.print("*");
        }
    }

    // SETTERS GETTERS //

        public void     setId(int Id)                           { id = Id; }
        public int      getId()                                 { return id; }
        public void     setPass( String Pass )                  { pass = Pass; }
        public String   getPass()                               { return pass; }
        public void     setName(String Name)                    { name = Name; }
        public String   getName()                               { return name;}
        public void     setBlockNo(int block)                   { blockNo = block; }
        public int      getBlockNo()                            { return blockNo; }
        public void     setRoomNo(int room)                     { roomNo = room; }
        public int      getRoomNo()                             { return roomNo; }
        public void     setDateOfEnrollment(String date)        { dateOfEnrollment = date; }
        public String   getDateOfEnrollment()                   { return dateOfEnrollment; }
        public void     setCrimeCommitted(String crime)         { crimeCommitted = crime; }
        public String   getCrimeCommitted()                     { return crimeCommitted; }

        public void     setJobTitle(String job)                     { jobTitle = job;}
        public String   getJobTitle()                               { return jobTitle; }
        public void     setJobPay(int pay)                          { jobPay = pay;}
        public int      getJobPay()                                 { return jobPay; }
        public void     setJobChangeRequest(Boolean request)        { jobChangeRequest=request; }
        public Boolean  getJobChangeRequest()                       { return jobChangeRequest; }

        public void     setJobAppliedFor(String job)                { jobAppliedFor=job; }
        public String   getJobAppliedFor()                          { return jobAppliedFor; }

        public void     setCellChangeRequest(Boolean request)       { cellChangeRequest=request; }
        public Boolean  getCellChangeRequest()                      { return cellChangeRequest; }
        public void     setCellChangeReason(String reason)          { cellChangeReason=reason; }
        public String   getCellChangeReason()                       { return cellChangeReason; }
        public void     setCellChangeTo(int cellNo)                 { cellChangeTo=cellNo; }
        public int      getCellChangeTo()                           { return cellChangeTo; }

        public void     setMeetingRequest(Boolean request)        { meetingRequest=request; }
        public Boolean  getMeetingRequest()                       { return meetingRequest; }
        public void     setMeetingTime(String time)               { meetingTime=time; }
        public String   getMeetingTime()                          { return meetingTime; }

        public void     setItemRequest(Boolean request)         { itemRequest=request; }
        public Boolean  getItemRequest()                        { return itemRequest; }
        public void     setItemType(String type)                { itemType=type; }
        public String   getItemType()                           { return itemType; }

    // SETTERS GETTERS //

    public void mainFunction()
    {
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);

        while(true){
            int prisonerChoice = -1;
            printSpaces(60);
            System.out.println("0) BACK");
            printSpaces(60);
            System.out.println("1) REQUEST CELL CHANGE");
            printSpaces(60);
            System.out.println("2) REQUEST MEETING");
            printSpaces(60);
            System.out.println("3) REQUEST ITEMS ");
            printSpaces(60);
            System.out.println("4) REQUEST JOB CHANGE \n");
            printSpaces(70);
            System.out.print("ENTER : ");
            prisonerChoice = intScan.nextInt();
            System.out.println();

            switch(prisonerChoice)
            {
                case 0:
                    return;
                case 1:
                    changeCell();
                    break;
                case 2:
                    setMeeting();
                    break;
                case 3:
                    requestItems();
                    break;
                case 4:
                    changeJobs();
                    break;
                default:
                    printSpaces(80);
                    System.out.println(" !INVALID INPUT !");
                    break;
            }
        }
    }
//    public void openCellChangeRequestRecord()
//    {
//        printSpaces(70);
//        printStars(5);
//        System.out.print(" CELL CHANGE RECORD ");
//        printStars(5);
//        System.out.println();
//
//        for(int i=0; i<cellChangeRecord.size(); i++)
//        {
//            printSpaces(80);
//            System.out.println("        ID : " + cellChangeRecord.get(i).getPrisonerId());
//            printSpaces(80);
//            System.out.println("REASON     : " + cellChangeRecord.get(i).getReason());
//            printSpaces(80);
//            System.out.println("PERMISSION : " + cellChangeRecord.get(i).getPermission());
//            printSpaces(80);
//            System.out.println("OLD ROOM # : " + cellChangeRecord.get(i).getOldRoomNo());
//            printSpaces(80);
//            System.out.println("NEW ROOM # : " + cellChangeRecord.get(i).getNewRoomNo());
//        }
//    }
    public void changeCell()
    {
        printSpaces(70);
        printStars(5);
        System.out.print(" CELL CHANGE ");
        printStars(5);
        System.out.println();

        Scanner strScan = new Scanner(System.in);
        Scanner intScan = new Scanner(System.in);

        printSpaces(80);
        System.out.print("REASON : ");
        cellChangeReason = strScan.nextLine();
        printSpaces(80);
        System.out.print("CELL # : ");
        cellChangeTo = intScan.nextInt();
        cellChangeRequest = true;
    }

    public void setMeeting()
    {
        printSpaces(70);
        printStars(5);
        System.out.print(" MEETING ");
        printStars(5);
        System.out.println();

        Scanner strScan = new Scanner(System.in);

        printSpaces(80);
        System.out.print("TIME : ");
        meetingTime = strScan.nextLine();
        meetingRequest = true;
    }

    public void requestItems()
    {
        printSpaces(70);
        printStars(5);
        System.out.print(" ITEMS ");
        printStars(5);
        System.out.println();

        Scanner strScan = new Scanner(System.in);

        printSpaces(80);
        System.out.print("ITEM TYPE : ");
        itemType = strScan.nextLine();
        itemRequest = true;
    }

    public void changeJobs()
    {
        printSpaces(70);
        printStars(5);
        System.out.print(" CHANGE JOBS ");
        printStars(5);
        System.out.println();

        Scanner strScan = new Scanner(System.in);

        printSpaces(80);
        System.out.print("APPLY FOR : ");
        jobAppliedFor = strScan.nextLine();
        jobChangeRequest = true;
    }
    public void print()
    {
        printSpaces(110);
        System.out.println("ID       : " + id);
        printSpaces(110);
        System.out.println("NAME     : " + name);
        printSpaces(110);
        System.out.println("PASSWORD : " + pass);
        printSpaces(110);
        System.out.println("BLOCK    : " + blockNo);
        printSpaces(110);
        System.out.println("ROOM     : " + roomNo);
        printSpaces(110);
        System.out.println("ENTERED  : " + dateOfEnrollment);
        printSpaces(110);
        System.out.println("CRIME    : " + crimeCommitted);
        printSpaces(110);
        System.out.println("JOB TITLE       : " + jobTitle);
        printSpaces(110);
        System.out.println("JOB PAY         : " + jobPay);
        printSpaces(110);
        System.out.println("NEW JOB REQUEST : " + jobChangeRequest);
        printSpaces(110);
        System.out.println("NEW JOB         : " + jobAppliedFor);
        printSpaces(110);
        System.out.println("CELL CHANGE REQUEST : " + cellChangeRequest);
        printSpaces(110);
        System.out.println("REASON              : " + cellChangeReason);
        printSpaces(110);
        System.out.println("NEW CELL            : " + cellChangeTo);
        printSpaces(110);
        System.out.println("MEETING REQUEST : " + meetingRequest);
        printSpaces(110);
        System.out.println("TIME            : " + meetingTime);
        printSpaces(110);
        System.out.println("ITEM REQUEST   : " + itemRequest);
        printSpaces(110);
        System.out.println("ITEM TYPE      : " + itemType);
    }
}
