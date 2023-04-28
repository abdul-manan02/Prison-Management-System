package Business_Logic;

public class Prison_Staff
{
    private int id;
    private int designatedBlock;
    private String job;
    private int pay;
    private String dateOfEnrollment;

    public Prison_Staff()
    {
        id = -1;
        designatedBlock = -1;
        job = "";
        pay = -1;
        dateOfEnrollment = "";
    }

    public Prison_Staff(int Id, int block, String Job, int Pay, String date)
    {
        id = Id;
        designatedBlock = block;
        job = Job;
        pay = Pay;
        dateOfEnrollment = date;
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

    public void     setId(int Id)                       { id=Id; }
    public int      getId()                             {return id; }
    public void     setBlock(int block)                 { designatedBlock=block; }
    public int      getBlock()                          { return designatedBlock; }
    public void     setJob(String Job)                  { job=Job; }
    public String   getJob()                            { return job; }
    public void     setPay(int Pay)                     { pay=Pay; }
    public int      getPay()                            { return pay; }
    public void     setDateOfEnrollment(String date)    { dateOfEnrollment=date; }
    public String   getDateOfEnrollment()               { return dateOfEnrollment; }

    public void print()
    {
        printSpaces(110);
        System.out.println("ID     : " + id);
        printSpaces(110);
        System.out.println("BLOCK  : " + designatedBlock);
        printSpaces(110);
        System.out.println("JOB    : " + job);
        printSpaces(110);
        System.out.println("PAY    : " + pay);
        printSpaces(110);
        System.out.println("JOINED : " + dateOfEnrollment);
    }
}
