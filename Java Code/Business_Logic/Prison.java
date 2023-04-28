package Business_Logic;

import Database.DBHandler;

import java.util.ArrayList;
import java.util.Scanner;

public class Prison
{
    private String name;
    private Warden warden;

    public String                       getName()                                               { return name; }
    public void                         setWarden(Warden warden1)                               { warden=warden1; }
    public Warden                       getWarden()                                             { return warden; }
    public Prison()
    {
        name = "G U A N T A N A M O    P R I S  O N ";
        warden = new Warden();


    }


}
