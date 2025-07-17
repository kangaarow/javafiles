import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class FormValidation extends JFrame implements ActionListener{
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
    FormValidation(){
            setSize(400,400);
            setLayout(new GridBagLayout());
            GridBagConstraints gbc = new GridBagConstraints();

            JLabel Labelname = new JLabel("Name: ");
            gbc.gridx = 0;
            gbc.gridy = 0;
            gbc.gridwidth = 1;
            gbc.weightx = 1;
            gbc.fill = GridBagConstraints.HORIZONTAL;
            add(Labelname,gbc); 
            Textname = new JTextField(15);
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
            Txtaddress = new JTextField(15);
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

            femalebtn = new JRadioButton("Female");
            malebtn = new JRadioButton("Male");
            otherbtn = new JRadioButton("Others");

            group = new ButtonGroup();
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
            String[] countries = {"select country","Nepal", "India", "USA", "UK", "China"};
            combo = new JComboBox<>(countries);
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
            dancing = new JCheckBox("Dancing");
            reading = new JCheckBox("Reading");
            others = new JCheckBox("Others");

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
            submitButton.addActionListener(this);
            text = new JTextArea();
            gbc.gridx = 0;
            gbc.gridy = 6; 
            gbc.gridwidth = GridBagConstraints.REMAINDER;
            add(text, gbc);
            
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
            new FormValidation();
        }
}