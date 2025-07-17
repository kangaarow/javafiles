import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EventHandling extends JFrame implements ActionListener{
    JTextField Textname;
    JTextField Txtaddress;
    ButtonGroup group;
    JRadioButton femalebtn;
    JRadioButton otherbtn;
    JRadioButton malebtn;
    JComboBox<String> combo;
    JCheckBox dancing;
    JCheckBox reading;
    JCheckBox others;
    JTextArea text;
    EventHandling(){
            setSize(400,400);
            setLayout(new GridLayout(0,2));

            JLabel Labelname = new JLabel("Name: ");
            add(Labelname);  
            Textname = new JTextField(15);
            add(Textname);

            JLabel Labeladdress = new JLabel("Address: ");
            add(Labeladdress);
            Txtaddress = new JTextField(15);
            add(Txtaddress);

            JLabel gender = new JLabel("Gender:");
            add(gender);

            femalebtn = new JRadioButton("Female");
            malebtn = new JRadioButton("Male");
            otherbtn = new JRadioButton("Others");

            group = new ButtonGroup();
            group.add(femalebtn);
            group.add(malebtn);
            group.add(otherbtn);
            add(femalebtn);
            add(malebtn);
            add(otherbtn);

            String[] countries = {"select country","Nepal", "India", "USA", "UK", "China"};
            combo = new JComboBox<>(countries);
            add(combo); 

            JLabel label = new JLabel("Select Hobbies:");
            add(label); 
            
            JPanel checkbox = new JPanel(new FlowLayout());
            dancing = new JCheckBox("Dancing");
            reading = new JCheckBox("Reading");
            others = new JCheckBox("Others");

            checkbox.add(dancing);
            checkbox.add(reading);
            checkbox.add(others);
            add(checkbox);  

            JButton submitButton = new JButton("Submit");
            add(submitButton); 
            submitButton.addActionListener(this);
            text = new JTextArea();
            add(text);
            
            setVisible(true);
    }
        public void actionPerformed(ActionEvent e){
            StringBuilder error = new StringBuilder();
            if (Textname.getText().isEmpty()) {
                error.append("Please fill your name.\n");
            }
            if (Txtaddress.getText().isEmpty()) {
                error.append("Please fill your address.\n");
            }
            if (group.getSelection() == null) {
                error.append("Please select gender.\n");
            }
            if (combo.getSelectedItem().equals("select country")) {
                error.append("Please select the country.\n");
            }
            if (!reading.isSelected() && !dancing.isSelected() && !others.isSelected()) {
                error.append("Please select hobbies.\n");
            }

            if (error.length() > 0) {
                text.setText(error.toString());
                text.setForeground(Color.RED);
                text.setEditable(false);
                text.setOpaque(false);
                text.setBorder(null);
                text.setFocusable(false);
            } else {
                StringBuilder message = new StringBuilder();
                message.append(Textname.getText());
                message.append("\n");
                message.append(Txtaddress.getText());
                message.append("\n");
                if(group.getSelection().equals(femalebtn.getModel()))
                {
                    message.append("gender: female");
                }
                else if(group.getSelection().equals(malebtn.getModel())){
                    message.append("gender: male");
                }
                else{
                    message.append("gender: others");
                }
                message.append("\n");
                message.append(combo.getSelectedItem());
                message.append("\nhobbies: ");
                if(reading.isSelected()){
                    message.append("reading ");
                }
                if(dancing.isSelected()){
                    message.append("dancing ");
                }
                if(others.isSelected()){
                    message.append("others");
                }
                text.setText(message.toString());
                text.setEditable(false);
                text.setOpaque(false);
                text.setBorder(null);
                text.setFocusable(false);
                text.setForeground(Color.GREEN);
            }
        }

        public static void main(String[] args){
            new EventHandling();
        }
}