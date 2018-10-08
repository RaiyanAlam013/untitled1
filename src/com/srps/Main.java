package com.srps;

import com.srps.database.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import com.srps.gui.*;

import javax.swing.*;


/**
 * main function to start the SRPS app.
 * Can be used for Demo testing.
 * @author MD. Fakhruddin Gazzali
 * @version 1.0
 * @since 2018-10-28
 */

public class Main {

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {public  void run() { new Mainframe(); }});

    }
}

