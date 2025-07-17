import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.String;

public class ActionListenerDemo extends JFrame implements ActionListener{
    JTextField txt;
    JButton btn1;
    JButton btn2;
    ActionListenerDemo(){
        setLayout(new FlowLayout());
        txt = new JTextField(20);
        btn1 = new JButton("uppercase");
        btn2 = new JButton("clear");
        btn1.addActionListener(this);
        btn2.addActionListener(this);

        add(txt);
        add(btn1);
        add(btn2);
        setSize(400,400);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent e)
    {
        Object Src = e.getSource();
        if( Src == btn1){
            String upperCase = txt.getText();
            txt.setText(upperCase.toUpperCase());
        } 
        else{
            txt.setText("");
        }
    }
    public static void main(String[] args){
        new ActionListenerDemo();
    }
}