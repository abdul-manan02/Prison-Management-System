package Business_Logic;

import Database.DBHandler;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;
public class Warden
{
    private String username;
    private String password;
    private ArrayList<Prisoner> prisoners;
    private ArrayList <CellBlock_Head> blockHeads;
    private ArrayList <Prison_Staff> staff;
    private ArrayList <CellChangeRequests_Record> transferRecord;
    private ArrayList <TimeTable> timeTable;

    Warden()
    {
        username = "username";
        password = "password";
        prisoners = new ArrayList<Prisoner>();
        blockHeads = new ArrayList<CellBlock_Head>();
        staff = new ArrayList<Prison_Staff>();
        transferRecord = new ArrayList<CellChangeRequests_Record>();
        timeTable =  new ArrayList<TimeTable>();
        DBHandler db = new DBHandler();
        prisoners = db.readPrisoners();
        blockHeads = db.readHeads();
        staff = db.readStaff();
        transferRecord = db.readCellChangeRecord();
        timeTable = db.readTimeTable();
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

    public void                         setPrisoners(ArrayList <Prisoner> Prisoners)            { prisoners=Prisoners; }
    public ArrayList <Prisoner>         getPrisoners()                                          { return prisoners; }
    public void                         setBlockHeads(ArrayList <CellBlock_Head> BlockHeads)    { blockHeads=BlockHeads; }
    public ArrayList <CellBlock_Head>   getBlockHeads()                                         { return blockHeads; }
    public void                         setStaff(ArrayList <Prison_Staff> Staff)                { staff=Staff; }
    public ArrayList <Prison_Staff>     getStaff()                                              { return staff; }
    public void     setUsername(String name)    { username=name; }
    public String   getUsername()               { return username; }
    public void     setPassword(String pass)    { password=pass; }
    public String   getPassword()               { return password;}

    public Prisoner prisonerLogin()
    {
        Scanner strScan = new Scanner(System.in);
        String inputPass;
        String inputUsername;
        printSpaces(55);
        printStars(20);
        System.out.println();
        printSpaces(62);
        System.out.println("PRISONER");
        printSpaces(55);
        printStars(20);
        System.out.println("\n");

        printSpaces(55);
        System.out.print("USERNAME : ");
        inputUsername = strScan.nextLine();
        printSpaces(55);
        System.out.print("PASSWORD : ");
        inputPass = strScan.nextLine();

        for(int i=0; i<prisoners.size();i++)
        {
            if (Objects.equals(inputUsername, prisoners.get(i).getName()) && Objects.equals(inputPass, prisoners.get(i).getPass()))
            {
                System.out.println();
                printSpaces(56);
                System.out.println("!!! LOGGED IN !!! \n");
                return prisoners.get(i);
            }
        }
        return null;
    }

    public CellBlock_Head HeadLogin()
    {
        Scanner strScan = new Scanner(System.in);
        String inputPass;
        String inputUsername;
        printSpaces(55);
        printStars(20);
        System.out.println();
        printSpaces(57);
        System.out.println("CELL-BLOCK HEAD");
        printSpaces(55);
        printStars(20);
        System.out.println("\n");

        printSpaces(55);
        System.out.print("USERNAME : ");
        inputUsername = strScan.nextLine();
        printSpaces(55);
        System.out.print("PASSWORD : ");
        inputPass = strScan.nextLine();

        for(int i=0; i<blockHeads.size();i++)
        {
            if (Objects.equals(inputUsername, blockHeads.get(i).getUsername()) && Objects.equals(inputPass, blockHeads.get(i).getPassword()))
            {
                System.out.println();
                printSpaces(56);
                System.out.println("!!! LOGGED IN !!! \n");
                return blockHeads.get(i);
            }
        }
        printSpaces(56);
        System.out.println("!!! ACCOUNT NOT FOUND !!! \n");
        return null;
    }

    public void mainFunction()
    {
        printSpaces(55);
        printStars(20);
        System.out.println();
        printSpaces(62);
        System.out.println("WARDEN");
        printSpaces(55);
        printStars(20);
        System.out.println("\n");
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        String inputPass;
        String inputUsername;

        printSpaces(55);
        System.out.print("USERNAME : ");
        inputUsername = strScan.nextLine();
        printSpaces(55);
        System.out.print("PASSWORD : ");
        inputPass = strScan.nextLine();

        if (Objects.equals(inputUsername, username) && Objects.equals(inputPass, password))
        {
            System.out.println();
            printSpaces(56);
            System.out.println("!!! LOGGED IN !!! \n");
            while(true)
            {
                int wardenChoice = -1;
                printSpaces(60);
                System.out.println("0) BACK");
                printSpaces(60);
                System.out.println("1) CRUD OPERATIONS");
                printSpaces(60);
                System.out.println("2) REVIEW CELL TRANSFER");
                printSpaces(60);
                System.out.println("3) TIME-TABLE \n");
                printSpaces(70);
                System.out.print("ENTER : ");
                wardenChoice = intScan.nextInt();
                System.out.println();

                switch(wardenChoice)
                {
                    case 0:
                            return;
                    case 1:
                            crudOperations();
                            break;
                    case 2:
                            reviewCellTransfers();
                            break;
                    case 3:
                            timeTable();
                            break;
                    default:
                        printSpaces(80);
                        System.out.println(" !INVALID INPUT !");
                        break;
                }
            }
        }
    }

    void timeTable()
    {
        DBHandler db = new DBHandler();
        printSpaces(70);
        printStars(5);
        System.out.print(" TIME TABLE ");
        printStars(5);
        System.out.println();

        printSpaces(80);
        System.out.println("0) BACK");
        printSpaces(80);
        System.out.println("1) ADD");
        printSpaces(80);
        System.out.println("2) UPDATE");
        printSpaces(80);
        System.out.println("3) READ \n");

        int tableChoice;
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        printSpaces(90);
        System.out.print("ENTER : ");
        tableChoice = intScan.nextInt();

        if(tableChoice==0)
        {
            return;
        }
        else if (tableChoice==1)
        {
            TimeTable t = new TimeTable();
            printSpaces(100);
            System.out.print("      Week # : ");
            t.setWeekNo(intScan.nextInt());
            printSpaces(100);
            System.out.print("WAKE-UP TIME : ");
            t.setWake(strScan.nextLine());
            printSpaces(100);
            System.out.print("OUTDOOR TIME : ");
            t.setOutdoor(strScan.nextLine());
            printSpaces(100);
            System.out.print("LIGHTS OUT   : ");
            t.setLightsOut(strScan.nextLine());

            for(int i=0; i<timeTable.size(); i++)
            {
                if(t.getWeekNo() == timeTable.get(i).getWeekNo())
                {
                    printSpaces(110);
                    System.out.println("TIME TABLE FOR THIS WEEK ALREADY EXISTS ");
                    return;
                }
            }
            timeTable.add(t);
            db.saveTimeTable(t);
        }
        else if(tableChoice==2)
        {
            int searchWeek=-1;
            int index=-1;
            printSpaces(90);
            System.out.println("TIME TABLES AVAILABLE");
            for (int j = 0; j < timeTable.size(); j++) {
                printSpaces(115);
                System.out.println((j + 1) + ") " + timeTable.get(j).getWeekNo());
            }
            printSpaces(105);
            System.out.print("WEEK # : ");
            searchWeek = intScan.nextInt();
            for (int i = 0; i < timeTable.size(); i++) {
                if (searchWeek == timeTable.get(i).getWeekNo()) {
                    index = i;
                }
            }
            if (index==-1){return;}
            printSpaces(110);
            System.out.print("NEW WAKE UP TIME    : ");
            timeTable.get(index).setWake(strScan.nextLine());
            printSpaces(110);
            System.out.print("NEW OUTDOOR TIME    : ");
            timeTable.get(index).setOutdoor(strScan.nextLine());
            printSpaces(110);
            System.out.print("NEW LIGHTS OUT TIME : ");
            timeTable.get(index).setLightsOut(strScan.nextLine());
            db.updateTimeTable(timeTable.get(index));
            index = -1;
            searchWeek = -1;
        }
        else if (tableChoice==3)
        {
            for(int i=0; i<timeTable.size(); i++)
            {
                printSpaces(100);
                System.out.println("WEEK #       : " + timeTable.get(i).getWeekNo());
                printSpaces(100);
                System.out.println("WAKE-UP TIME : " + timeTable.get(i).getWake());
                printSpaces(100);
                System.out.println("OUTDOOR TIME : " + timeTable.get(i).getOutdoor());
                printSpaces(100);
                System.out.println("LIGHTS OUT   : " + timeTable.get(i).getLightsOut() + "\n");
            }
        }
    }
    void reviewCellTransfers()
    {
        DBHandler db = new DBHandler();
        printSpaces(70);
        printStars(5);
        System.out.print(" REVIEW CELL TRANSFERS ");
        printStars(5);
        System.out.println();

        printSpaces(80);
        System.out.println(" PRISONERS THAT HAVE REQUESTED ");

        for(int i=0; i<prisoners.size();i++)
        {
            if(prisoners.get(i).getCellChangeRequest())
            {
                printSpaces(90);
                System.out.println("             ID : " + prisoners.get(i).getId());
                printSpaces(90);
                System.out.println("CURRENT ROOM #  : " + prisoners.get(i).getRoomNo());
                printSpaces(90);
                System.out.println("TRANSFER REASON : " + prisoners.get(i).getCellChangeTo());
                printSpaces(90);
                System.out.println("REQUEST ROOM #  : "  + prisoners.get(i).getCellChangeReason());
            }
        }
        for(int i=0; i<prisoners.size(); i++)
        {
            if( prisoners.get(i).getCellChangeRequest())
            {
                if ( prisoners.get(i).getCellChangeReason().length() >=10 )     // reason validity check //
                {
                    printSpaces(100);
                    System.out.println("CELL CHANGED");
                    CellChangeRequests_Record r = new CellChangeRequests_Record(
                            prisoners.get(i).getId(), prisoners.get(i).getCellChangeReason(), true,
                            prisoners.get(i).getRoomNo(), prisoners.get(i).getCellChangeTo()
                    );
                    db.saveCellChangeRecord(r);
                    transferRecord.add(r);
                    prisoners.get(i).setRoomNo(prisoners.get(i).getCellChangeTo());
                }
                else{
                    printSpaces(100);
                    System.out.println("CELL NOT CHANGED");
                    CellChangeRequests_Record r1 = new CellChangeRequests_Record(
                            prisoners.get(i).getId(), prisoners.get(i).getCellChangeReason(), false,
                            prisoners.get(i).getRoomNo(), prisoners.get(i).getCellChangeTo()
                    );
                    db.saveCellChangeRecord(r1);
                    transferRecord.add(r1);
                }
                prisoners.get(i).setCellChangeReason("");
                prisoners.get(i).setCellChangeTo(-1);
                prisoners.get(i).setCellChangeRequest(false);
                db.updatePrisoner(prisoners.get(i));
            }
        }

        db.closeConnection();
    }

    public void crudOperations()
    {
        DBHandler db = new DBHandler();
        printSpaces(70);
        printStars(5);
        System.out.print(" CRUD OPERATIONS ");
        printStars(5);

        int crudChoice = -1;
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        Scanner boolScan = new Scanner(System.in);

        System.out.println();
        printSpaces(80);
        System.out.println("0) BACK");
        printSpaces(80);
        System.out.println("1) PRISONER");
        printSpaces(80);
        System.out.println("2) STAFF");
        printSpaces(80);
        System.out.println("3) BLOCK HEADS\n");
        printSpaces(90);
        System.out.print("ENTER : ");
        crudChoice = intScan.nextInt();
        System.out.println();

        int index = -1;
        int searchID = -1;

        switch (crudChoice)
        {
            case 0:
                return;
            case 1:
                printSpaces(90);
                printStars(3);
                System.out.print(" PRISONERS ");
                printStars(3);
                System.out.println();
                int prisonerChoice;
                printSpaces(94);
                System.out.println("0) BACK ");
                printSpaces(94);
                System.out.println("1) CREATE ");
                printSpaces(94);
                System.out.println("2) READ ");
                printSpaces(94);
                System.out.println("3) UPDATE ");
                printSpaces(94);
                System.out.println("4) DELETE \n");
                printSpaces(100);
                System.out.print("ENTER : ");
                prisonerChoice = intScan.nextInt();
                System.out.println();

                switch (prisonerChoice)
                {
                    case 0:
                        return;
                    case 1:
                        Prisoner p = new Prisoner();
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" CREATE PRISONER ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.print("ID         : ");
                        p.setId(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("PASSWORD   : ");
                        p.setPass(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("NAME       : ");
                        p.setName(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("BLOCK      : ");
                        p.setBlockNo(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("ROOM       : ");
                        p.setRoomNo(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("ENTRY DATE : ");
                        p.setDateOfEnrollment(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("CRIME      : ");
                        p.setCrimeCommitted(strScan.nextLine());
                        prisoners.add(p);
                        db.savePrisoner(p);
                        break;
                    case 2:
                        for (int i = 0; i < prisoners.size(); i++) {
                            prisoners.get(i).print();
                            System.out.println();
                        }
                        break;
                    case 3:
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" UPDATE PRISONER ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.println("IDs AVAILABLE");
                        for (int j = 0; j < prisoners.size(); j++) {
                            printSpaces(115);
                            System.out.println((j + 1) + ") " + prisoners.get(j).getId());
                        }
                        printSpaces(105);
                        System.out.print("ID : ");
                        searchID = intScan.nextInt();
                        for (int i = 0; i < prisoners.size(); i++) {
                            if (searchID == prisoners.get(i).getId()) {
                                index = i;
                            }
                        }
                        printSpaces(110);
                        System.out.print("NEW PASSWORD   : ");
                        prisoners.get(index).setPass(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("NEW NAME       : ");
                        prisoners.get(index).setName(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("NEW BLOCK      : ");
                        prisoners.get(index).setBlockNo(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("NEW ROOM       : ");
                        prisoners.get(index).setRoomNo(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("NEW ENTRY DATE : ");
                        prisoners.get(index).setDateOfEnrollment(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("NEW CRIME      : ");
                        prisoners.get(index).setCrimeCommitted(strScan.nextLine());
                        db.updatePrisoner(prisoners.get(index));
                        index = -1;
                        searchID = -1;
                        break;
                    case 4:
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" DELETE PRISONER ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.println("IDs AVAILABLE");
                        for (int j = 0; j < prisoners.size(); j++) {
                            printSpaces(115);
                            System.out.println((j + 1) + ") " + prisoners.get(j).getId());
                        }
                        printSpaces(105);
                        System.out.print("ID : ");
                        searchID = intScan.nextInt();
                        for (int i = 0; i < prisoners.size(); i++) {
                            if (searchID == prisoners.get(i).getId()) {
                                index = i;
                                break;
                            }
                        }
                        db.deletePrisoner(prisoners.get(index).getId());
                        prisoners.remove(index);
                        index = -1;
                        searchID = -1;
                        break;
                    default:
                        printSpaces(110);
                        System.out.println("!!! INVALID INPUT ");
                        break;
                }
                break;
            case 2:
                printSpaces(90);
                printStars(3);
                System.out.print(" STAFF ");
                printStars(3);
                System.out.println();
                int staffChoice;
                printSpaces(94);
                System.out.println("0) BACK ");
                printSpaces(94);
                System.out.println("1) CREATE ");
                printSpaces(94);
                System.out.println("2) READ ");
                printSpaces(94);
                System.out.println("3) UPDATE ");
                printSpaces(94);
                System.out.println("4) DELETE \n");
                printSpaces(100);
                System.out.print("ENTER : ");
                staffChoice = intScan.nextInt();
                System.out.println();

                switch (staffChoice)
                {
                    case 0:
                        return;
                    case 1:
                        Prison_Staff s = new Prison_Staff();
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" CREATE STAFF ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.print("ID    : ");
                        s.setId(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("BLOCK : ");
                        s.setBlock(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("JOB   : ");
                        s.setJob(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("PAY   : ");
                        s.setPay(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("ENTRY : ");
                        s.setDateOfEnrollment(strScan.nextLine());
                        staff.add(s);
                        db.saveStaff(s);
                        break;
                    case 2:
                        for (int i = 0; i < staff.size(); i++)
                        {
                            staff.get(i).print();
                            System.out.println();
                        }
                        break;
                    case 3:
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" UPDATE STAFF ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.println("IDs AVAILABLE");
                        for (int j = 0; j < staff.size(); j++)
                        {
                            printSpaces(115);
                            System.out.println((j + 1) + ") " + staff.get(j).getId());
                        }
                        printSpaces(105);
                        System.out.print("ID : ");
                        searchID = intScan.nextInt();
                        for (int i = 0; i < staff.size(); i++) {
                            if (searchID == staff.get(i).getId()) {
                                index = i;
                            }
                        }
                        printSpaces(110);
                        System.out.print("NEW BLOCK : ");
                        staff.get(index).setBlock(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("NEW JOB   : ");
                        staff.get(index).setJob(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("NEW PAY   : ");
                        staff.get(index).setPay(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("NEW ENTRY : ");
                        staff.get(index).setDateOfEnrollment(strScan.nextLine());
                        db.updateStaff(staff.get(index));
                        index = -1;
                        searchID = -1;
                        break;
                    case 4:
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" DELETE STAFF ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.println("IDs AVAILABLE");
                        for (int j = 0; j < staff.size(); j++) {
                            printSpaces(115);
                            System.out.println((j + 1) + ") " + staff.get(j).getId());
                        }
                        printSpaces(105);
                        System.out.print("ID : ");
                        searchID = intScan.nextInt();
                        for (int i = 0; i < staff.size(); i++) {
                            if (searchID == staff.get(i).getId()) {
                                index = i;
                                break;
                            }
                        }
                        db.deleteStaff(staff.get(index).getId());
                        staff.remove(index);
                        index = -1;
                        searchID = -1;
                        break;
                    default:
                        printSpaces(110);
                        System.out.println("!!! INVALID INPUT ");
                        break;
                }
                break;
            case 3:
                printSpaces(90);
                printStars(3);
                System.out.print(" CELL-BLOCK HEADS ");
                printStars(3);
                System.out.println();
                int headsChoice;
                printSpaces(94);
                System.out.println("0) BACK ");
                printSpaces(94);
                System.out.println("1) CREATE ");
                printSpaces(94);
                System.out.println("2) READ ");
                printSpaces(94);
                System.out.println("3) UPDATE ");
                printSpaces(94);
                System.out.println("4) DELETE \n");
                printSpaces(100);
                System.out.print("ENTER : ");
                headsChoice = intScan.nextInt();
                System.out.println();

                switch (headsChoice)
                {
                    case 0:
                        return;
                    case 1:
                        CellBlock_Head h = new CellBlock_Head();
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" CREATE BLOCK-HEAD ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.print("SERVICE # : ");
                        h.setServiceNumber(intScan.nextInt());
                        printSpaces(110);
                        System.out.print("USERNAME  : ");
                        h.setUsername(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("PASSWORD  : ");
                        h.setPassword(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("BLOCK     : ");
                        h.setDesignatedBlock(intScan.nextInt());
                        blockHeads.add(h);
                        db.saveHead(h);
                        break;
                    case 2:
                        for (int i = 0; i < blockHeads.size(); i++)
                        {
                            blockHeads.get(i).print();
                            System.out.println();
                        }
                        break;
                    case 3:
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" UPDATE BLOCK-HEADS ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.println("SERVICE # AVAILABLE");
                        for (int j = 0; j<blockHeads.size(); j++)
                        {
                            printSpaces(115);
                            System.out.println((j + 1) + ") " + blockHeads.get(j).getServiceNumber());
                        }
                        printSpaces(105);
                        System.out.print("SERVICE # : ");
                        searchID = intScan.nextInt();
                        for (int i = 0; i < blockHeads.size(); i++) {
                            if (searchID == blockHeads.get(i).getServiceNumber()) {
                                index = i;
                            }
                        }
                        printSpaces(110);
                        System.out.print("NEW USERNAME  : ");
                        blockHeads.get(index).setUsername(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("NEW PASSWORD  : ");
                        blockHeads.get(index).setPassword(strScan.nextLine());
                        printSpaces(110);
                        System.out.print("NEW BLOCK     : ");
                        blockHeads.get(index).setDesignatedBlock(intScan.nextInt());
                        db.updateHeads(blockHeads.get(index));
                        index = -1;
                        searchID = -1;
                        break;
                    case 4:
                        printSpaces(105);
                        printStars(1);
                        System.out.print(" DELETE BLOCK-HEADS ");
                        printStars(1);
                        System.out.println();
                        printSpaces(110);
                        System.out.println("SERVICE # AVAILABLE");
                        for (int j = 0; j < blockHeads.size(); j++) {
                            printSpaces(115);
                            System.out.println((j + 1) + ") " + blockHeads.get(j).getServiceNumber());
                        }
                        printSpaces(105);
                        System.out.print("SERVICE # : ");
                        searchID = intScan.nextInt();
                        for (int i = 0; i < blockHeads.size(); i++) {
                            if (searchID == blockHeads.get(i).getServiceNumber()) {
                                index = i;
                                break;
                            }
                        }
                        db.deleteHead(blockHeads.get(index).getServiceNumber());
                        blockHeads.remove(index);
                        index = -1;
                        searchID = -1;
                        break;
                    default:
                        printSpaces(110);
                        System.out.println("!!! INVALID INPUT ");
                        break;
                }
                break;
            default:
                printSpaces(85);
                System.out.println("!!! INVALID INPUT !!!");
                break;
        }
        db.closeConnection();
    }

}
