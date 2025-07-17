import java.awt.*;
import javax.swing.*;

public class UserRegistrationGrid extends JFrame{
        UserRegistrationGrid(){
            setSize(800,400);
            setLayout(new GridLayout(9,1,10,10));

            JLabel Labelname = new JLabel("Name: ");
            JTextField Textname = new JTextField(15);

            JLabel Labeladdress = new JLabel("Address: ");
            JTextField Txtaddress = new JTextField(15);

            JLabel gender = new JLabel("Gender:");
            JRadioButton femalebtn = new JRadioButton("Female");
            JRadioButton malebtn = new JRadioButton("Male");
            JRadioButton otherbtn = new JRadioButton("Others");

            ButtonGroup group = new ButtonGroup();
            group.add(femalebtn);
            group.add(malebtn);
            group.add(otherbtn);

            JLabel country = new JLabel("Select Country: ");
            String[] countries = {"Nepal", "India", "USA", "UK", "China"};
            JComboBox<String> combo = new JComboBox<>(countries);

            JLabel label = new JLabel("Select Hobbies:");
            JPanel checkbox = new JPanel(new FlowLayout());
            JCheckBox dancing = new JCheckBox("Dancing");
            JCheckBox singing = new JCheckBox("singing");
            JCheckBox reading = new JCheckBox("Reading");
            JCheckBox others = new JCheckBox("Others");

            checkbox.add(dancing);
            checkbox.add(singing);
            checkbox.add(reading);
            checkbox.add(others);

            JButton submitButton = new JButton("Submit");


            add(Labelname);
            add(Textname);
            add(Labeladdress);
            add(Txtaddress);
            add(gender);
            add(femalebtn);
            add(malebtn);
            add(otherbtn);
            add(country);
            add(combo);
            add(label);
            add(checkbox);
            add(submitButton);

            setVisible(true);
        }

        public static void main(String[] args){
            new UserRegistrationGrid();
        }
}