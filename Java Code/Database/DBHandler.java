package Database;

import java.util.ArrayList;
import java.sql.*;
import Business_Logic.*;


public class DBHandler {
    Connection con;

    public DBHandler()
    {
        try {
            // set these values according the credentials you are using in your MySQL Workbench database //
            // refer to "https://www.youtube.com/watch?v=e8g9eNnFpHQ" 6:30 onwards if you are still confused //
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/PMS", "root", "12345678");
//            System.out.println("Connection made to DB");
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            System.out.println("Connection failed!");
            e.printStackTrace();
        }
    }

    public ArrayList<Prisoner> readPrisoners()
    {
        ArrayList<Prisoner> prisoners = new ArrayList<Prisoner>();
        Statement stm;
        try {
            stm = con.createStatement();

            String query = "SELECT * FROM Prisoners";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                Prisoner p = new Prisoner
                        (
                                rs.getInt(1), rs.getString(2), rs.getString(3),
                                rs.getInt(4), rs.getInt(5), rs.getString(6),
                                rs.getString(7), rs.getString(8), rs.getInt(9),
                                rs.getBoolean(10), rs.getString(11),
                                rs.getBoolean(12), rs.getString(13),
                                rs.getInt(14), rs.getBoolean(15),
                                rs.getString(16), rs.getBoolean(17),
                                rs.getString(18)
                        );
                prisoners.add(p);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return prisoners;
    }

    public ArrayList<CellBlock_Head> readHeads()
    {
        ArrayList<CellBlock_Head> heads = new ArrayList<CellBlock_Head>();
        Statement stm;
        try {
            stm = con.createStatement();

            String query = "SELECT * FROM Heads";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                CellBlock_Head head = new CellBlock_Head
                        (
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getInt(4)
                        );
                heads.add(head);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return heads;
    }

    public ArrayList<Prison_Staff> readStaff()
    {
        ArrayList<Prison_Staff> staff = new ArrayList<Prison_Staff>();
        Statement stm;
        try {
            stm = con.createStatement();

            String query = "SELECT * FROM Staff";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                Prison_Staff s = new Prison_Staff
                        (
                                rs.getInt(1),
                                rs.getInt(2),
                                rs.getString(3),
                                rs.getInt(4),
                                rs.getString(5)
                        );
                staff.add(s);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return staff;
    }

    public ArrayList<CellChangeRequests_Record> readCellChangeRecord()
    {
        ArrayList<CellChangeRequests_Record> record = new ArrayList<CellChangeRequests_Record>();
        Statement stm;
        try {
            stm = con.createStatement();

            String query = "SELECT * FROM CellChange_Record";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                CellChangeRequests_Record r = new CellChangeRequests_Record
                        (
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getBoolean(3),
                                rs.getInt(4),
                                rs.getInt(5)
                        );
                record.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return record;
    }

    public ArrayList<MeetingRecord> readMeetingRecord()
    {
        ArrayList<MeetingRecord> record = new ArrayList<MeetingRecord>();
        Statement stm;
        try {
            stm = con.createStatement();

            String query = "SELECT * FROM Meeting_Record";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                MeetingRecord r = new MeetingRecord
                        (
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getBoolean(3)
                        );
                record.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return record;
    }

    public ArrayList<ItemRequestRecord> readItemsRecord()
    {
        ArrayList<ItemRequestRecord> record = new ArrayList<ItemRequestRecord>();
        Statement stm;
        try {
            stm = con.createStatement();

            String query = "SELECT * FROM Items_Record";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                ItemRequestRecord r = new ItemRequestRecord
                        (
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getBoolean(3)
                        );
                record.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return record;
    }

    public ArrayList<TimeTable> readTimeTable()
    {
        ArrayList<TimeTable> record = new ArrayList<TimeTable>();
        Statement stm;
        try {
            stm = con.createStatement();

            String query = "SELECT * FROM Time_Table";
            ResultSet rs = stm.executeQuery(query);
            while (rs.next())
            {
                TimeTable r = new TimeTable
                        (
                                rs.getInt(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4)
                        );
                record.add(r);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return record;
    }

    public void savePrisoner(Prisoner p)
    {
        try
        {
            String query =
                    "INSERT INTO Prisoners (id, pass, prisonerName, blockNo, roomNo, dateOfEnrollment, crimeCommitted, " +
                            "jobTitle, jobPay, jobChangeRequest, jobAppliedFor, " +
                            "cellChangeRequest, cellChangeReason, cellChangeTo, " +
                            "meetingRequest, meetingTime, itemRequest, itemType) " +
                            "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, p.getId());
            stmt.setString(2, p.getPass());
            stmt.setString(3, p.getName());
            stmt.setInt(4, p.getBlockNo());
            stmt.setInt(5, p.getRoomNo());
            stmt.setString(6, p.getDateOfEnrollment());
            stmt.setString(7, p.getCrimeCommitted());
            stmt.setString(8, p.getJobTitle());
            stmt.setInt(9, p.getJobPay());
            stmt.setBoolean(10, p.getJobChangeRequest());
            stmt.setString(11, p.getJobAppliedFor());
            stmt.setBoolean(12, p.getCellChangeRequest());
            stmt.setString(13, p.getCellChangeReason());
            stmt.setInt(14, p.getCellChangeTo());
            stmt.setBoolean(15, p.getMeetingRequest());
            stmt.setString(16, p.getMeetingTime());
            stmt.setBoolean(17, p.getItemRequest());
            stmt.setString(18, p.getItemType());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Prisoner was added...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveHead(CellBlock_Head head)
    {
        try
        {
            String query = "INSERT INTO Heads (serviceNumber, userName, pass, designatedBlock) VALUES (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, head.getServiceNumber());
            stmt.setString(2, head.getUsername());
            stmt.setString(3, head.getPassword());
            stmt.setInt(4, head.getDesignatedBlock());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Cell-block Head was added...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveStaff(Prison_Staff staff)
    {
        try
        {
            String query = "INSERT INTO Staff (id, designatedBlock, designatedJob, pay, dateOfEnrollment) VALUES (?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, staff.getId());
            stmt.setInt(2, staff.getBlock());
            stmt.setString(3, staff.getJob());
            stmt.setInt(4, staff.getPay());
            stmt.setString(5, staff.getDateOfEnrollment());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Prison Staff was added...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveCellChangeRecord(CellChangeRequests_Record record)
    {
        try
        {
            String query = "INSERT INTO CellChange_Record (prisonerId, reason, permission, oldRoomNo, newRoomNo) VALUES (?,?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, record.getPrisonerId());
            stmt.setString(2, record.getReason());
            stmt.setBoolean(3, record.getPermission());
            stmt.setInt(4, record.getOldRoomNo());
            stmt.setInt(5, record.getNewRoomNo());


            int rows = stmt.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Prison Staff was added...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveMeetingRecord(MeetingRecord record)
    {
        try
        {
            String query = "INSERT INTO Meeting_Record (prisonerId, meetingTime, permission) VALUES (?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, record.getId());
            stmt.setString(2, record.getTime());
            stmt.setBoolean(3, record.getPermission());


            int rows = stmt.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Prison Staff was added...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveItemRecord(ItemRequestRecord record)
    {
        try
        {
            String query = "INSERT INTO Items_Record (prisonerId, itemType, permission) VALUES (?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, record.getId());
            stmt.setString(2, record.getType());
            stmt.setBoolean(3, record.getPermission());


            int rows = stmt.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Prison Staff was added...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void saveTimeTable(TimeTable record)
    {
        try
        {
            String query = "INSERT INTO Time_Table (weekNo, wakeUp_Time, outdoor_Time, lightsOut_Time) VALUES (?,?,?,?)";

            PreparedStatement stmt = con.prepareStatement(query);
            stmt.setInt(1, record.getWeekNo());
            stmt.setString(2, record.getWake());
            stmt.setString(3, record.getOutdoor());
            stmt.setString(4, record.getLightsOut());

            int rows = stmt.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Prison Staff was added...");
            }
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public boolean updatePrisoner ( Prisoner p)
    {
        String query =
                "UPDATE Prisoners SET  pass=?, prisonerName=?, blockNo=?, roomNo=?, dateOfEnrollment=?," + " crimeCommitted=?," +
                        " jobTitle=?, jobPay=?, jobChangeRequest=?, " + " jobAppliedFor=?," +
                        " cellChangeRequest=?,  cellChangeReason=?, cellChangeTo=?," +
                        " meetingRequest=?,  meetingTime=?, itemRequest=?,  itemType=?" +
                        " WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString  (1,  p.getPass() );
            ps.setString  (2,  p.getName());
            ps.setInt     (3,  p.getBlockNo());
            ps.setInt     (4,  p.getRoomNo());
            ps.setString  (5,  p.getDateOfEnrollment());
            ps.setString  (6,  p.getCrimeCommitted());
            ps.setString  (7,  p.getJobTitle());
            ps.setInt     (8,  p.getJobPay());
            ps.setBoolean (9,  p.getJobChangeRequest());
            ps.setString  (10, p.getJobAppliedFor());
            ps.setBoolean (11, p.getCellChangeRequest());
            ps.setString  (12, p.getCellChangeReason());
            ps.setInt     (13, p.getCellChangeTo());
            ps.setBoolean (14, p.getMeetingRequest());
            ps.setString  (15, p.getMeetingTime());
            ps.setBoolean (16, p.getItemRequest());
            ps.setString  (17, p.getItemType());
            ps.setInt     (18, p.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Prisoner was updated...");
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    public boolean updateHeads ( CellBlock_Head head)
    {
        String query = "UPDATE Heads SET username=?, pass=?, designatedBlock=? WHERE serviceNumber=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString  (1,  head.getUsername() );
            ps.setString  (2,  head.getPassword());
            ps.setInt     (3,  head.getDesignatedBlock());
            ps.setInt     (4,  head.getServiceNumber());

            int rows = ps.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Cell-block Head was updated...");
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;

    }

    public boolean updateStaff ( Prison_Staff staff)
    {
        String query = "UPDATE Staff SET designatedBlock=?, designatedJob=?, pay=?, dateOfEnrollment=? WHERE id=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt     (1,  staff.getBlock() );
            ps.setString  (2,  staff.getJob());
            ps.setInt     (3,  staff.getPay());
            ps.setString  (4,  staff.getDateOfEnrollment());
            ps.setInt     (5,  staff.getId());

            int rows = ps.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Staff member was updated...");
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean updateTimeTable ( TimeTable t)
    {
        String query = "UPDATE Time_Table SET wakeUp_Time=?, outdoor_Time=?, lightsOut_Time=? WHERE weekNO=?";

        try {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString     (1,  t.getWake() );
            ps.setString  (2,  t.getOutdoor());
            ps.setString     (3,  t.getLightsOut());
            ps.setInt  (4,  t.getWeekNo());

            int rows = ps.executeUpdate();
            if (rows > 0) {
//                System.out.println("A Staff member was updated...");
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean deletePrisoner(int id) {
        String query = "DELETE FROM Prisoners WHERE id=?";
        try
        {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
            {
//                System.out.println("A Prisoner was deleted...");
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteHead(int id) {
        String query = "DELETE FROM Heads WHERE serviceNumber=?";
        try
        {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
            {
//                System.out.println("A Head was deleted...");
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public boolean deleteStaff(int id) {
        String query = "DELETE FROM Staff WHERE id=?";
        try
        {
            PreparedStatement ps = con.prepareStatement(query);
            ps.setInt(1, id);

            int rows = ps.executeUpdate();
            if (rows > 0)
            {
//                System.out.println("A Staff member was deleted...");
                return true;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return false;
    }

    public void closeConnection() {
        try {

            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}
