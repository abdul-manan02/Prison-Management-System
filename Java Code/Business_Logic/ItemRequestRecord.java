package Business_Logic;

import java.security.Permission;

public class ItemRequestRecord
{
    private int prisonerId;
    private String itemType;
    private Boolean permission;

    public ItemRequestRecord(){
        prisonerId=-1; itemType=""; permission=false;
    }

    public ItemRequestRecord(int id, String type, Boolean Permission){
        prisonerId=id; itemType=type; permission=Permission;
    }

    public void     setId(int id)                       { prisonerId=id; }
    public int      getId()                             { return prisonerId;}
    public void     setType(String type)                { itemType=type; }
    public String   getType()                           { return itemType; }
    public void     setPermission(Boolean Permission)   { permission=Permission; }
    public Boolean  getPermission()                     { return permission; }

}

