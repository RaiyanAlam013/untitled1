package com.srps.gui;
import com.srps.database.*;


import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormPanel extends JPanel {
    private JLabel IDLevel;
    private JLabel PasswordLevel;
    private JTextField IDField;
    private JPasswordField PasswordField;
    private JButton okBtn;
    private com.srps.gui.FormEventListener FormListener;
    public FormPanel(){
        Dimension dim=getPreferredSize();
        dim.width=585;
        setPreferredSize(dim);


        IDLevel =new JLabel("ID: ");
        PasswordLevel =new JLabel("Password: ");
        IDField =new JTextField(10);
        PasswordField =new JPasswordField(10);
        //PasswordField.setEchoChar('*');
        okBtn=new JButton("Login");
        okBtn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String ID=IDField.getText();
                String Password= PasswordField.getText();
                final dbase DataBaseConnectionCheck = new dbase(ID, Password);
                if(!DataBaseConnectionCheck.isConnected())
                {
                    JOptionPane.showMessageDialog(FormPanel.this,"Login Failed");
                }
                else
                {

                    SwingUtilities.invokeLater(new Runnable() {public void run() { new TeacherMainframe(DataBaseConnectionCheck); }});
                }

                FormEvent ev = new FormEvent(this,ID,Password);
                if(FormListener !=null)
                {
                    FormListener.FormEventOccuder(ev);
                }
            }
        });

        Border innerBorder = BorderFactory.createTitledBorder("Login Page:");
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

        add(IDLevel,gc);

        gc.gridx=1;
        gc.gridy=0;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(IDField,gc);



        ////2nd row//
        gc.gridx=0;
        gc.gridy=1;
        gc.weightx=1;
        gc.weighty=.1;
        gc.insets=new Insets(0,0,0,5);
        gc.anchor=GridBagConstraints.LINE_END;
        add(PasswordLevel,gc);

        gc.gridx=1;
        gc.gridy=1;
        gc.insets=new Insets(0,0,0,0);
        gc.anchor=GridBagConstraints.LINE_START;
        add(PasswordField,gc);


        ////3rd row///
        gc.gridx=1;
        gc.gridy=2;
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
