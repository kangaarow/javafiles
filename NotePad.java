import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;


public class NotePad extends JFrame implements KeyListener,ActionListener{
    JMenuItem SaveItem;
    JMenuItem OpenItem;
    JTextArea textArea;
    NotePad(){
        setLayout(new FlowLayout());

        JMenuBar Menu = new JMenuBar();

        JMenu FileMenu = new JMenu("File");
        JMenu ViewMenu = new JMenu("View");
        JMenu HelpMenu = new JMenu("Help");

        OpenItem = new JMenuItem("Open");
        SaveItem = new JMenuItem("Save");

        FileMenu.setMnemonic(KeyEvent.VK_F);
        OpenItem.setMnemonic(KeyEvent.VK_O);
        SaveItem.setMnemonic(KeyEvent.VK_S);
        SaveItem.setEnabled(false);

        OpenItem.addActionListener(this);
        SaveItem.addActionListener(this);

        FileMenu.add(OpenItem);
        FileMenu.add(SaveItem);
        Menu.add(FileMenu);
        Menu.add(ViewMenu);
        Menu.add(HelpMenu);
        setJMenuBar(Menu);

        textArea = new JTextArea(20, 35);
        textArea.addKeyListener(this);

        JScrollPane scrollPane = new JScrollPane(textArea,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS,JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(scrollPane);
        setSize(400,400);
        setVisible(true);

    }
    public void keyTyped(KeyEvent e){
        SaveItem.setEnabled(true);
    }
    public void keyPressed(KeyEvent e){

    }
    public void keyReleased(KeyEvent e){

    }
    public void actionPerformed(ActionEvent e){
        if(e.getSource()== OpenItem){
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showOpenDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedReader br = new BufferedReader(new FileReader(file))) {
                textArea.read(br, null);
                } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "File could not be opened!");
                }
            }
        }
        else{
            JFileChooser fileChooser = new JFileChooser();
            int option = fileChooser.showSaveDialog(this);
            if (option == JFileChooser.APPROVE_OPTION) {
                File file = fileChooser.getSelectedFile();
                try (BufferedWriter bw = new BufferedWriter(new FileWriter(file))) {
                textArea.write(bw);
                } catch (IOException ex) {
                JOptionPane.showMessageDialog(this, "File could not be saved!");
                }
            }
        }
    }
    public static void main(String[] args){
        new NotePad();
    }
    
}
