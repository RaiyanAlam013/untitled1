package com.srps.gui;

import com.srps.database.dbase;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import com.srps.database.*;
public class TeacherInsertFormPanel extends JPanel {
    private JLabel StudentIDLevel;
    private JLabel DepartmentLevel;
    private JLabel CourseIDLevel;
    private JLabel MidExamLevel;
    private JLabel FinalExamLevel;
    private JTextField StudentField;
    private JTextField DepartmentField;
    private JTextField CourseField;
    private JTextField MidExamField;
    private JTextField FinalExamField;
    private JButton okBtn;
    private dbase teach;
    private com.srps.gui.FormEventListener FormListener;
    public TeacherInsertFormPanel(final dbase database){
        Dimension dim=getPreferredSize();
        dim.width=585;
        setPreferredSize(dim);

        StudentIDLevel =new JLabel("Student ID: ");
        DepartmentLevel =new JLabel("Department ID: ");
        CourseIDLevel =new JLabel("Course ID: ");
        MidExamLevel=new JLabel("Mid Mark: ");
        FinalExamLevel=new JLabel("Final Mark:");
        StudentField =new JTextField(10);
        DepartmentField =new JTextField(10);
        CourseField=new JTextField(10);
        MidExamField=new JTextField(10);
        FinalExamField=new JTextField(10);
        //DepartmentField.setEchoChar('*');
        okBtn=new JButton("Save");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ID= StudentField.getText();
                String Dept = DepartmentField.getText();
                String Course =CourseField.getText();
                String Mid=MidExamField.getText();
                String Final=FinalExamField.getText();
                database.insertMarks(ID,Dept,Course,Mid,Final);
                FormEvent ev = new FormEvent(this,ID, Dept);
                if(FormListener !=null)
                {
                    FormListener.FormEventOccuder(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Teacher Page");
        Border outerBorder = BorderFactory.createEmptyBorder(5,5,5,5);
        setBorder(BorderFactory.createCompoundBorder(outerBorder,innerBorder));


        setLayout(new GridBagLayout());

        GridBagConstraints gc=new GridBagConstraints();

        gc.weightx=1;
        gc.weighty=1;

        ////1st row//////

        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=1;
        gc.weighty=.1;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,5);
        gc.anchor=GridBagConstraints.LINE_END;

        add(StudentIDLevel,gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(StudentField,gc);



        ////next row//
        gc.gridx=0;
        gc.gridy=1;
        gc.weightx=1;
        gc.weighty=.1;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,5);
        gc.anchor=GridBagConstraints.LINE_END;
        add(DepartmentLevel,gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(DepartmentField,gc);

        ///next row///
        gc.gridx=0;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty=.1;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,5);
        gc.anchor=GridBagConstraints.LINE_END;
        add(CourseIDLevel,gc);

        gc.gridx=1;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty=.1;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(CourseField,gc);

        /////next Row////

        gc.gridx=0;
        gc.gridy=3;
        gc.weightx=1;
        gc.weighty=.1;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,5);
        gc.anchor=GridBagConstraints.LINE_END;
        add(MidExamLevel,gc);

        gc.gridx=1;
        gc.gridy=3;
        gc.weightx=1;
        gc.weighty=.0;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(MidExamField,gc);


        ////next row///

        gc.gridx=0;
        gc.gridy=4;
        gc.weightx=1;
        gc.weighty=.1;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,5);
        gc.anchor=GridBagConstraints.LINE_END;
        add(FinalExamLevel,gc);


        gc.gridx=1;
        gc.gridy=4;
        gc.weightx=1;
        gc.weighty=.0;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(FinalExamField,gc);

        ////3rd row///
        gc.gridx=1;
        gc.gridy=5;
        gc.weightx=1;
        gc.weighty=2;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(okBtn,gc);
    }
    public void setFormListner(com.srps.gui.FormEventListener Listener)
    {
        this.FormListener=Listener;
    }
}
