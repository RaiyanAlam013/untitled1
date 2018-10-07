package com.srps.gui;

import com.srps.gui.StringListener;
import com.srps.gui.TextPanel;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class toolbar extends JPanel implements ActionListener{
    private JButton Hellobutton;
    private JButton goodbyebutton;
    private StringListener textListener;
    private TextPanel textPanel;
    public toolbar() {
        setBorder(BorderFactory.createEtchedBorder());
        Hellobutton = new JButton("Hello");
        goodbyebutton = new JButton("Bye");
        Hellobutton.addActionListener(this);
        goodbyebutton.addActionListener(this);
        setLayout(new FlowLayout(FlowLayout.LEFT));
        add(Hellobutton);
        add(goodbyebutton);
    }
    public void setStringListener (StringListener listener){
                this.textListener=listener;

    }
    public  void setTextPanel(TextPanel textPanel){
        this.textPanel=textPanel;
    }
    public void actionPerformed(ActionEvent e) {
        JButton clicked=(JButton)e.getSource();
        if(clicked == Hellobutton)
        {
            if(textListener !=null)
                textListener.textEmitted("Hello\n");
        }
        else if(clicked ==goodbyebutton){
            if(textListener !=null)
                textListener.textEmitted("Bye\n");
        }
    }
}




