package com.srps.gui;




import java.util.EventObject;

public class FormEvent extends EventObject {
    private String ID;
    private String Password;


    public FormEvent(Object Source)
    {
        super(Source);
    }
    public FormEvent(Object Source, String ID, String password)
    {
        super(Source);
        this.ID=ID;
        this.Password=Password;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getPassword() {
        return Password;
    }
    /*public void setPassword(char[] password) {
        Password = password;
    }*/
}
