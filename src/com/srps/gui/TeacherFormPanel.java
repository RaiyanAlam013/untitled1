package com.srps.gui;

import com.srps.database.dbase;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TeacherFormPanel extends  JPanel{
    private JRadioButton Insert;
    private JRadioButton Show;
    private JRadioButton Update;
    private  JButton okBtn;
    private ButtonGroup Choices;
    private com.srps.gui.FormEventListener FormListener;
    public TeacherFormPanel(final dbase database)
    {
        Dimension dim=getPreferredSize();
        dim.width=585;
        setPreferredSize(dim);
        Insert=new JRadioButton("Insert");
        Show=new JRadioButton("Show");
        Update=new JRadioButton("Update");
        Choices=new ButtonGroup();
        okBtn=new JButton("Okay");

        Choices.add(Insert);
        Choices.add(Show);
        Choices.add(Update);

        Insert.setActionCommand("I");
        Update.setActionCommand("U");
        Show.setActionCommand("S");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String Choice =Choices.getSelection().getActionCommand();
                if(Choice=="I")
                {
                    SwingUtilities.invokeLater(new Runnable() {public void run() { new TeacherInsertMainframe(database); }});
                }
                else if(Choice=="U")
                {

                }
                else if(Choice=="S")
                {
                    SwingUtilities.invokeLater(new Runnable() {public void run() { new TeacherShowFormMainframe(database); }});
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

        ///1st row////

        gc.gridx=0;
        gc.gridy=0;
        gc.weightx=1;
        gc.weighty=.1;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,5);
        gc.anchor=GridBagConstraints.LINE_END;
        add(new JLabel("Choose : "),gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.weightx=1;
        gc.weighty=.2;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(Insert,gc);
        ////next row///


        gc.gridx=1;
        gc.gridy=2;
        gc.weightx=1;
        gc.weighty=.1;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(Show,gc);

        ////next row///


        gc.gridx=1;
        gc.gridy=3;
        gc.weightx=1;
        gc.weighty=.1;
        gc.fill=GridBagConstraints.NONE;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(Update,gc);

        ///next row///

        gc.gridx=1;
        gc.gridy=8;
        gc.weightx=1;
        gc.weighty=5;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.FIRST_LINE_START;
        add(okBtn,gc);

    }
    public void setFormListner(com.srps.gui.FormEventListener Listener)
    {
        this.FormListener=Listener;
    }
}
