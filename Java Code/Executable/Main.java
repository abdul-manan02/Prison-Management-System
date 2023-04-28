package Executable;

import Database.*;
import Business_Logic.*;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Handler;


public class Main
{
    static void printSpaces(int j)
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

    public static void main(String[] args)
    {
        Prison prison = new Prison();
        int index=-1;
        DBHandler db = new DBHandler();
        Scanner intScan = new Scanner(System.in);
        Scanner strScan = new Scanner(System.in);
        Scanner boolScan = new Scanner(System.in);
        while(true)
        {
            System.out.println("\n");
            printSpaces(45);
            printStars(70);
            System.out.println();
            printSpaces(61);
            System.out.println(prison.getName());
            printSpaces(45);
            printStars(70);
            System.out.println("\n");

            printSpaces(45);
            System.out.println("USER TYPE");
            printSpaces(55);
            System.out.println("0) EXIT");
            printSpaces(55);
            System.out.println("1) WARDEN");
            printSpaces(55);
            System.out.println("2) CELL-BLOCK HEAD");
            printSpaces(55);
            System.out.println("3) PRISONER ");

            int userChoice = -1;
            printSpaces(45);
            System.out.print("ENTER : ");
            userChoice = intScan.nextInt();
            System.out.println();

            switch (userChoice)
            {
                case 0:
                        return;
                case 1:
                        prison.getWarden().mainFunction();
                        break;
                case 2:
                        CellBlock_Head h = prison.getWarden().HeadLogin();
                        if (h==null){ break;}
                        h.mainFunction(prison.getWarden().getPrisoners());

                        break;
                case 3:
                        Prisoner p = prison.getWarden().prisonerLogin();
                        if (p==null){ break;}
                        p.mainFunction();

                        index = -1;
                        for(int i=0; i<prison.getWarden().getPrisoners().size(); i++)
                        {
                            if(prison.getWarden().getPrisoners().get(i).getId() == p.getId())
                            {
                                index=i;
                            }
                        }
                        db.updatePrisoner(prison.getWarden().getPrisoners().get(index));
                        break;
                default:
                        break;
            }
        }

    }

}