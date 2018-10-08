package com.srps.gui;

import com.srps.database.dbase;
import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.sql.ResultSet;
import java.sql.SQLException;

public class TeacherShowFromPanel extends JPanel {


    private JLabel StudentId;
    private JLabel StudentName;
    private JLabel CourseId;
    private JLabel CourseTitle;
    private JLabel MidMark;
    private JLabel FinalMark;
    private com.srps.gui.FormEventListener FormListener;


   public TeacherShowFromPanel(dbase database)
   {
       ResultSet rs;
       Dimension dim=getPreferredSize();
       dim.width=585;
       setPreferredSize(dim);

       StudentId=new JLabel("Student ID");
       StudentName=new JLabel("Student Name");
       CourseId=new JLabel("Course ID");
       CourseTitle=new JLabel("Course Title");
       MidMark=new JLabel("Mid Mark");
       FinalMark=new JLabel("Final Mark");


       try {

            /* Please un-comment these lines if you want to test for the very first time*/
       /* But please be careful about Constraints check on database (e.g.: Repetition of Primary key)*/


           /*rs = DataBaseConnectionCheck.listGetAllStudent(); //checking all student table result
            if (rs == null)
                System.out.println("NO RESULT FOUND !");
            else {
                System.out.println("Student ID\tStudent Name\tStudent Dept.\tStudent Address\tStudent Contact\n");
                while (rs.next()) {

                    System.out.print(rs.getString(1) + "\t");
                    System.out.print(rs.getString(2) + "\t");
                    System.out.print(rs.getString(3) + "\t");
                    System.out.print(rs.getString(4) + "\t");
                    System.out.print(rs.getString(5) + "\t\n");
                }
            }
            System.out.println("\n-------------------------------------------------");*/

            rs = database.listSelectedStudentFromMarksDeatils("160041014");
            if (rs == null)
                System.out.println("NO RESULT FOUND !");
            else {

                Border innerBorder = BorderFactory.createTitledBorder("Teacher Page");
                Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
                setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));


                setLayout(new GridBagLayout());

                GridBagConstraints gc=new GridBagConstraints();

                gc.weightx=1;
                gc.weighty=1;


                ////1st row////

                gc.gridx=0;
                gc.gridy=0;
                gc.weightx=1;
                gc.weighty=.1;
                gc.fill=GridBagConstraints.NONE;
                gc.insets=new Insets(0,0,0,3);
                //gc.anchor=GridBagConstraints.LINE_START;
                add(StudentId,gc);

                gc.gridx=1;
                gc.gridy=0;
                gc.weightx=1;
                gc.weighty=.1;
                gc.fill=GridBagConstraints.NONE;
                gc.insets=new Insets(0,0,0,3);
                //gc.anchor=GridBagConstraints.LINE_START;
                add(StudentName,gc);


                gc.gridx=2;
                gc.gridy=0;
                gc.weightx=1;
                gc.weighty=.1;
                gc.fill=GridBagConstraints.NONE;
                gc.insets=new Insets(0,0,0,3);
                add(CourseId,gc);

                gc.gridx=3;
                gc.gridy=0;
                gc.weightx=1;
                gc.weighty=.1;
                gc.fill=GridBagConstraints.NONE;
                gc.insets=new Insets(0,0,0,3);
                //gc.anchor=GridBagConstraints.LINE_START;
                add(CourseTitle,gc);

                gc.gridx=4;
                gc.gridy=0;
                gc.weightx=1;
                gc.weighty=.1;
                gc.fill=GridBagConstraints.NONE;
                gc.insets=new Insets(0,0,0,3);
                //gc.anchor=GridBagConstraints.LINE_START;
                add(MidMark,gc);

                gc.gridx=5;
                gc.gridy=0;
                gc.weightx=1;
                gc.weighty=.1;
                gc.fill=GridBagConstraints.NONE;
                gc.insets=new Insets(0,0,0,3);
                //gc.anchor=GridBagConstraints.LINE_START;
                add(FinalMark,gc);
                int i=1;
                while (rs.next()) {
                    for (int n = 1; n <= 6; n++) // 6 cols. in STD_MARK_DETAILS so iterating 1 to 6
                        System.out.print(rs.getString(n) + "\t");

                    gc.gridx=0;
                    gc.gridy=i;
                    gc.weightx=1;
                    gc.weighty=.1;
                    gc.fill=GridBagConstraints.NONE;
                    gc.insets=new Insets(0,0,0,3);
                    add(new JLabel(rs.getString(1)),gc);

                    gc.gridx=1;
                    gc.gridy=i;
                    gc.weightx=1;
                    gc.weighty=.1;
                    gc.fill=GridBagConstraints.NONE;
                    gc.insets=new Insets(0,0,0,3);
                    add(new JLabel(rs.getString(2)),gc);

                    gc.gridx=2;
                    gc.gridy=i;
                    gc.weightx=1;
                    gc.weighty=.1;
                    gc.fill=GridBagConstraints.NONE;
                    gc.insets=new Insets(0,0,0,3);
                    add(new JLabel(rs.getString(3)),gc);

                    gc.gridx=3;
                    gc.gridy=i;
                    gc.weightx=1;
                    gc.weighty=.1;
                    gc.fill=GridBagConstraints.NONE;
                    gc.insets=new Insets(0,0,0,3);
                    add(new JLabel(rs.getString(4)),gc);


                    gc.gridx=4;
                    gc.gridy=i;
                    gc.weightx=1;
                    gc.weighty=.1;
                    gc.fill=GridBagConstraints.NONE;
                    gc.insets=new Insets(0,0,0,3);
                    add(new JLabel(rs.getString(5)),gc);


                    gc.gridx=5;
                    gc.gridy=i;
                    gc.weightx=1;
                    gc.weighty=.1;
                    gc.fill=GridBagConstraints.NONE;
                    gc.insets=new Insets(0,0,0,3);
                    add(new JLabel(rs.getString(6)),gc);
                    i++;
                    System.out.println("\n");
                }
            }

            System.out.println("\n-------------------------------------------------");

            /*//DataBaseConnectionCheck.updateMidMarks("160041014", "60.02");
            DataBaseConnectionCheck.deleteStudent("154383");
            System.out.println("\n-------------------------------------------------");*/
        }
        catch (SQLException ex){
            ex.printStackTrace(); // Exception handled and printed
        }
        finally {
            database.close(); // finally statement makes sure database is always closed at end regardless of the occurrence of exception
        }


   }
    public void setFormListner(com.srps.gui.FormEventListener Listener)
    {
        this.FormListener=Listener;
    }

}
