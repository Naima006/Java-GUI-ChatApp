/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ChatApp;

/**
 *
 * @author Naima Rahman
 */
import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Chat extends JFrame {
    private Container c;
    private ImageIcon icon;
    private JLabel label;
    private JLabel label1;
    private JLabel label2;
    private JButton sendUser1;
    private JButton sendUser2;
    private JButton clear;
    private JTextArea textbox;
    private JScrollPane scroll;
    private JTextField fieldUser1;
    private JTextField fieldUser2;

    Chat() {
        initComponents();
    }

    public void initComponents() {
        label = new JLabel("User 1:");
        label1 = new JLabel("User 2:");
        label2 = new JLabel("Chat Log:");
        

        sendUser1 = new JButton("Send");
        sendUser2 = new JButton("Send");
        clear = new JButton("Clear all");
        textbox = new JTextArea();
        scroll = new JScrollPane(textbox);

        fieldUser1 = new JTextField();
        fieldUser2 = new JTextField();

        c = this.getContentPane();
        c.setLayout(null);
        
        c.setBackground(Color.orange);
        c.add(label);
        c.add(label1);
        c.add(label2);

        c.add(sendUser1);
        c.add(sendUser2);
        c.add(clear);
        c.add(scroll);

        c.add(fieldUser1);
        c.add(fieldUser2);

        label.setBounds(10, 20, 100, 10);
        label1.setBounds(10, 55, 100, 10);
        label2.setBounds(40, 110, 100, 80);

        fieldUser1.setBounds(90, 15, 170, 20);
        sendUser1.setBounds(280, 15, 70, 20);

        fieldUser2.setBounds(90, 50, 170, 20);
        sendUser2.setBounds(280, 50, 70, 20);

        clear.setBounds(150, 90, 90, 30);
        scroll.setBounds(40, 170, 320, 150);
        textbox.setEditable(false);

        label.setHorizontalAlignment(JTextField.CENTER);
        label1.setHorizontalAlignment(JTextField.CENTER);
        
        
        label.setToolTipText("User 1: Type your message.");
        label1.setToolTipText("User 2: Type your message.");

        icon = new ImageIcon(getClass().getResource("image.png"));
        this.setIconImage(icon.getImage());

        sendUser1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("User 1", fieldUser1.getText());
                fieldUser1.setText("");
            }
        });

        sendUser2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                sendMessage("User 2", fieldUser2.getText());
                fieldUser2.setText("");
            }
        });

        clear.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fieldUser1.setText("");
                fieldUser2.setText("");
                textbox.setText("");
            }
        });
    }

    public void sendMessage(String user, String message) {
        String userMessage = user + ": " + message;
        String currentText = textbox.getText();

        textbox.setText(currentText + userMessage + "\n");
    }

    public static void main(String[] args) {
        Chat frame = new Chat();
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(200, 50, 420, 380);
        frame.setResizable(true);
        frame.setTitle("CHAT");
    }
}
