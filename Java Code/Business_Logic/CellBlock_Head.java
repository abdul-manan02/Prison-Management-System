package Business_Logic;

import Database.DBHandler;

import java.util.Scanner;
import java.util.ArrayList;

public class CellBlock_Head
{
    private int serviceNumber;
    private String username;
    private String password;
    private int designatedBlock;
    private ArrayList <MeetingRecord> meetingRecords;
    private ArrayList <ItemRequestRecord> itemsRecord;
    public CellBlock_Head()
    {
        serviceNumber = -1;
        username = "";
        password = "";
        designatedBlock = -1;

        DBHandler db= new DBHandler();
        meetingRecords = new ArrayList<MeetingRecord>();
        itemsRecord = new ArrayList<ItemRequestRecord>();
        meetingRecords =db.readMeetingRecord();
        itemsRecord = db.readItemsRecord();
        db.closeConnection();
    }

    public CellBlock_Head(int num, String name, String pass, int block)
    {
        serviceNumber = num;
        username = name;
        password = pass;
        designatedBlock = block;

        DBHandler db= new DBHandler();
        meetingRecords = new ArrayList<MeetingRecord>();
        itemsRecord = new ArrayList<ItemRequestRecord>();
        meetingRecords =db.readMeetingRecord();
        itemsRecord = db.readItemsRecord();
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

    public void     setServiceNumber(int num)       {serviceNumber = num; }
    public int      getServiceNumber()              { return serviceNumber; }
    public void     setUsername(String name)        { username=name; }
    public String   getUsername()                   { return username; }
    public void     setPassword(String pass)        { password=pass; }
    public String   getPassword()                   { return password; }
    public void     setDesignatedBlock(int block)   { designatedBlock=block; }
    public int      getDesignatedBlock()            { return designatedBlock; }
    public ArrayList <MeetingRecord> getMeetingRecords()    {return meetingRecords; }

    public void print()
    {
        printSpaces(110);
        System.out.println("SERVICE # : " + serviceNumber);
        printSpaces(110);
        System.out.println("USERNAME  : " + designatedBlock);
        printSpaces(110);
        System.out.println("PASSWORD  : " + password);
        printSpaces(110);
        System.out.println("BLOCK     : " + designatedBlock);
    }

    public void mainFunction(ArrayList <Prisoner> prisoners )
    {
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        int headChoice = -1;

        while (true)
        {
            printSpaces(60);
            System.out.println("0) BACK");
            printSpaces(60);
            System.out.println("1) REVIEW PRISONER MEETINGS");
            printSpaces(60);
            System.out.println("2) REVIEW PRISONER ITEM REQUESTS");
            printSpaces(60);
            System.out.println("3) REVIEW JOB CHANGE REQUESTS");
            printSpaces(70);
            System.out.print("ENTER : ");
            headChoice = intScan.nextInt();
            System.out.println();

            switch(headChoice)
            {
                case 0:
                    return;
                case 1:
                    reviewMeetingRequests(prisoners);
                    break;
                case 2:
                    reviewItemRequests(prisoners);
                    break;
                case 3:
                    reviewJobRequests(prisoners);
                    break;
                default:
                    printSpaces(80);
                    System.out.println(" !INVALID INPUT !");
                    break;
            }
        }

    }
    void reviewItemRequests(ArrayList <Prisoner> prisoners)
    {
        DBHandler db = new DBHandler();
        printSpaces(70);
        printStars(5);
        System.out.print(" REVIEW ITEM REQUESTS ");
        printStars(5);
        System.out.println();

        printSpaces(80);
        System.out.println(" PRISONERS THAT HAVE REQUESTED ");

        for(int i=0; i<prisoners.size();i++)
        {
            if(prisoners.get(i).getItemRequest())
            {
                printSpaces(90);
                System.out.println("       ID : " + prisoners.get(i).getId());
                printSpaces(90);
                System.out.println("ITEM TYPE : " + prisoners.get(i).getItemType());
            }
        }

        int selectID = -1;
        Scanner intScan = new Scanner(System.in);
        printSpaces(90);
        System.out.print("ENTER ID : ");
        selectID = intScan.nextInt();

        for(int i=0; i<prisoners.size(); i++)
        {
            if( prisoners.get(i).getId() == selectID) {
                if (prisoners.get(i).getItemRequest()) {
                    int userInput;
                    printSpaces(90);
                    System.out.println("PRESS 1 TO ALLOW");
                    printSpaces(90);
                    System.out.println("PRESS 0 TO DENY");
                    printSpaces(100);
                    System.out.print("ENTER : ");
                    userInput = intScan.nextInt();
                    if (userInput == 1)
                    {
                        ItemRequestRecord r = new ItemRequestRecord(prisoners.get(i).getId(), prisoners.get(i).getItemType(), true);
                        db.saveItemRecord(r);
                        itemsRecord.add(r);
                    }
                    else if (userInput==0)
                    {
                        ItemRequestRecord r = new ItemRequestRecord(prisoners.get(i).getId(), prisoners.get(i).getItemType(), false);
                        db.saveItemRecord(r);
                        itemsRecord.add(r);
                    }
                    prisoners.get(i).setItemType("");
                    prisoners.get(i).setItemRequest(false);
                    db.updatePrisoner(prisoners.get(i));
                }
            }
        }
        db.closeConnection();
    }

    void reviewMeetingRequests(ArrayList <Prisoner> prisoners)
    {
        DBHandler db = new DBHandler();
        printSpaces(70);
        printStars(5);
        System.out.print(" REVIEW MEETING REQUESTS ");
        printStars(5);
        System.out.println();

        printSpaces(80);
        System.out.println(" PRISONERS THAT HAVE REQUESTED ");

        for(int i=0; i<prisoners.size();i++)
        {
            if(prisoners.get(i).getMeetingRequest())
            {
                printSpaces(90);
                System.out.println("          ID : " + prisoners.get(i).getId());
                printSpaces(90);
                System.out.println("MEETING TIME : " + prisoners.get(i).getMeetingTime());
            }
        }

        int selectID = -1;
        Scanner intScan = new Scanner(System.in);
        printSpaces(90);
        System.out.print("ENTER ID : ");
        selectID = intScan.nextInt();

        for(int i=0; i<prisoners.size(); i++)
        {
            if( prisoners.get(i).getId() == selectID) {
                if (prisoners.get(i).getMeetingRequest()) {
                    int userInput;
                    printSpaces(90);
                    System.out.println("PRESS 1 TO ALLOW");
                    printSpaces(90);
                    System.out.println("PRESS 0 TO DENY");
                    printSpaces(100);
                    System.out.print("ENTER : ");
                    userInput = intScan.nextInt();
                    if (userInput == 1)
                    {
                        MeetingRecord r = new MeetingRecord(prisoners.get(i).getId(), prisoners.get(i).getMeetingTime(), true);
                        db.saveMeetingRecord(r);
                        meetingRecords.add(r);
                    }
                    else if (userInput==0)
                    {
                        MeetingRecord r = new MeetingRecord(prisoners.get(i).getId(), prisoners.get(i).getMeetingTime(), false);
                        db.saveMeetingRecord(r);
                        meetingRecords.add(r);
                    }
                    prisoners.get(i).setMeetingTime("");
                    prisoners.get(i).setMeetingRequest(false);
                    db.updatePrisoner(prisoners.get(i));
                }
            }

        }
        db.closeConnection();
    }

    void reviewJobRequests(ArrayList <Prisoner> prisoners)
    {
        DBHandler db = new DBHandler();
        printSpaces(70);
        printStars(5);
        System.out.print(" REVIEW JOB REQUESTS ");
        printStars(5);
        System.out.println();

        printSpaces(80);
        System.out.println(" PRISONERS THAT HAVE REQUESTED ");

        for(int i=0; i<prisoners.size();i++)
        {
            if(prisoners.get(i).getJobChangeRequest())
            {
                printSpaces(90);
                System.out.println("     ID : " + prisoners.get(i).getId());
                printSpaces(90);
                System.out.println("OLD JOB : " + prisoners.get(i).getJobTitle());
                printSpaces(90);
                System.out.println("OLD PAY : " + prisoners.get(i).getJobPay());

                printSpaces(90);
                System.out.println("JOB APPLIED FOR : " + prisoners.get(i).getJobAppliedFor());

                Scanner intScan = new Scanner(System.in);
                int userInput;
                printSpaces(100);
                System.out.println("PRESS 1 TO ALLOW");
                printSpaces(100);
                System.out.println("PRESS 0 TO DENY");
                printSpaces(110);
                System.out.print("ENTER : ");
                userInput = intScan.nextInt();

                if ( userInput==1 )
                {
                    printSpaces(110);
                    System.out.print("NEW PAY : ");
                    prisoners.get(i).setJobPay(intScan.nextInt());
                    prisoners.get(i).setJobTitle(prisoners.get(i).getJobAppliedFor());
                }
                prisoners.get(i).setJobChangeRequest(false);
                prisoners.get(i).setJobAppliedFor("");
                db.updatePrisoner(prisoners.get(i));
            }
        }
    }

}


