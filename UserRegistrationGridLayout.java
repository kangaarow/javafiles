import java.awt.*;
import javax.swing.*;

public class UserRegistrationGridLayout extends JFrame{
        UserRegistrationGridLayout(){
            setSize(800,400);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JLabel Labelname = new JLabel("Name: ");
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(Labelname,gbc); 
            JTextField Textname = new JTextField(15);
            gbc.gridx = 1;
            gbc.gridy = 0;
            gbc.gridwidth = 3;
            gbc.weightx = 2;
            add(Textname,gbc);

            JLabel Labeladdress = new JLabel("Address: ");
            gbc.gridx = 0;
            gbc.gridy = 1;
            gbc.gridwidth = 1;
            gbc.weightx = 1;
            add(Labeladdress,gbc);
            JTextField Txtaddress = new JTextField(15);
            gbc.gridx = 1;
            gbc.gridy = 1;
            gbc.gridwidth = 3;
            gbc.weightx = 2;
            add(Txtaddress,gbc);

            JLabel gender = new JLabel("Gender:");
            gbc.gridx = 0;
            gbc.gridy = 2;
            gbc.gridwidth = 1;
            gbc.weightx = 1;
            add(gender,gbc);

            JRadioButton femalebtn = new JRadioButton("Female");
            JRadioButton malebtn = new JRadioButton("Male");
            JRadioButton otherbtn = new JRadioButton("Others");

            ButtonGroup group = new ButtonGroup();
            group.add(femalebtn);
            group.add(malebtn);
            group.add(otherbtn);

            gbc.gridx = 1;
            gbc.gridy = 2;
            add(femalebtn, gbc);

            gbc.gridx = 2;
            gbc.gridy = 2;
            add(malebtn, gbc);

            gbc.gridx = 3;
            gbc.gridy = 2;
            add(otherbtn, gbc);

            JLabel country = new JLabel("Select Country: ");
            gbc.gridx = 0;
            gbc.gridy = 3;
            gbc.gridwidth = 1;
            gbc.weightx = 1;
            add(country,gbc); 
            String[] countries = {"Nepal", "India", "USA", "UK", "China"};
            JComboBox<String> combo = new JComboBox<>(countries);
            gbc.gridx = 1;
            gbc.gridy = 3;
            gbc.gridwidth = 3;
            gbc.weightx = 1;
            add(combo,gbc); 

            JLabel label = new JLabel("Select Hobbies:");
            gbc.gridx = 0;
            gbc.gridy = 4;
            gbc.gridwidth = 1;
            gbc.weightx = 1;
            add(label,gbc); 
            
            JPanel checkbox = new JPanel(new FlowLayout());
            JCheckBox dancing = new JCheckBox("Dancing");
            JCheckBox reading = new JCheckBox("Reading");
            JCheckBox others = new JCheckBox("Others");

            checkbox.add(dancing);
            checkbox.add(reading);
            checkbox.add(others);
            gbc.gridx = 1;
            gbc.gridy = 4;
            gbc.gridwidth = 3;
            gbc.weightx = 1;
            add(checkbox,gbc);  

            JButton submitButton = new JButton("Submit");
            gbc.gridx = 0;
            gbc.gridy = 5;
            gbc.gridwidth = 1;
            gbc.weightx = 1;
            add(submitButton,gbc); 
            
            setVisible(true);
        }

        public static void main(String[] args){
            new UserRegistrationGridLayout();
        }
}