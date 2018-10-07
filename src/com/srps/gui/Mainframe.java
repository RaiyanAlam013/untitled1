package com.srps.gui;

import javax.swing.*;
import java.awt.*;

public class Mainframe extends JFrame {
    private JTextArea textArea;
    private JButton btn;
    private com.srps.gui.toolbar toolbar;
    private com.srps.gui.TextPanel textpanel;
    private FormPanel formpanel;
    public Mainframe(){
        super("Student Result processing System");
        setLayout(new BorderLayout());
        toolbar =new toolbar();
        textArea=new JTextArea();
        textpanel=new com.srps.gui.TextPanel();
        formpanel=new FormPanel();
        toolbar.setStringListener(new com.srps.gui.StringListener() {

            public void textEmitted(String text) {
                    textpanel.appendText(text);
            }
        });
        btn=new JButton("Hello");
        /*btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0 ) {
                textArea.append("bye\n");
            }
        });*/
        formpanel.setFormListner(new FormEventListener() {


            public void FormEventOccuder(FormEvent e) {



            }


        });
        add(formpanel,BorderLayout.WEST);
        //add(toolbar,BorderLayout.NORTH);
        add(textArea,BorderLayout.CENTER);
        add(textpanel,BorderLayout.CENTER);
        //add(btn,BorderLayout.SOUTH);
        setSize(600,500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

}
