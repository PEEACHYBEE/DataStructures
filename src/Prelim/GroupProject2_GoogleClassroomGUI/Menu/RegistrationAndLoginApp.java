package Prelim.GroupProject2_GoogleClassroomGUI.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;

import static javax.swing.SwingUtilities.invokeLater;

public class RegistrationAndLoginApp extends JFrame {

    /**Instance variables */
    private static RoundJTextField FNameText;
    private static RoundJPasswordField passText;
    private static RoundJConfirmPasswordField confirmText;
    private static RoundButton register, login;
    private static JFrame frame;
    private static JLabel feed;
    private static JPanel panel;


    /**
     * Registration frame constructor which contains the buttons, text fields and labels
     */

    public RegistrationAndLoginApp() {
        frame = new JFrame();
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        /** Ensure the application exits */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** Background color */
        Color yellow = new Color(255,242,178);
        panel.setBackground(yellow);

        /** Frame properties */
        frame.setSize(850,650);
        frame.setTitle("User Registration");
        frame.setLocationRelativeTo(null);
        frame.setResizable(false);
        frame.setVisible(true);

        /** Title properties */
        JLabel title = new JLabel("Registration Form");
        title.setBounds(210,70,500,100);
        title.setFont(new Font("Comic Sans", Font.BOLD, 50));
        Color blue = new Color(1, 98, 175);
        title.setForeground(blue);
        panel.add(title);

        /** Registration name label */
        JLabel FName = new JLabel("Full Name: ");
        FName.setBounds(280,230,80,25);
        panel.add(FName);

        /**Registration name text field */
        FNameText = new RoundJTextField(50);
        FNameText.setBounds(410,230,165,25);
        panel.add(FNameText);

        /** Password label */
        JLabel pass = new JLabel("Password: ");
        pass.setBounds(280,260,115,25);
        panel.add(pass);

        /** Password text field */
        passText = new RoundJPasswordField(20);
        passText.setBounds(410,260,165,25);
        panel.add(passText);

        /** Confirm password label */
        JLabel confirm = new JLabel("Confirm Password: ");
        confirm.setBounds(280,290,115,25);
        panel.add(confirm);

        /** Confirm password text field */
        confirmText = new RoundJConfirmPasswordField(20);
        confirmText.setBounds(410,290,165,25); //125
        panel.add(confirmText);

        /** Register button properties */
        register = new RoundButton("Register");
        register.setBounds(320, 330, 100,25);
        register.addActionListener(new ButtonHandler());
        panel.add(register);

        /** Login button properties */
        login = new RoundButton("Login");
        login.setBounds(450,330,100,25);
        login.addActionListener(new ButtonHandler());
        panel.add(login);

        /** Label for the error message */
        feed = new JLabel("");
        feed.setBounds(330,370,390,25);
        panel.add(feed);

        /** Setting the icon */
        Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
        frame.setIconImage(Icon);
    }

    /** This class is in charge of handling the buttons' functions */
    public static class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e){
            //for clear button
            if (e.getSource() == login){
                frame.dispose();
                MainMenu main = new MainMenu();

            } else if (e.getSource() == register){ //for register button
                //local variables for register button function
                String user;
                String pass;
                String cPass;
                user = FNameText.getText();
                pass = passText.getText();
                cPass = confirmText.getText();

                //checks if one of the fields are blank
                if (pass.isBlank() || cPass.isBlank() || user.isBlank()){
                    feed.setText("Fields must not be empty please try again.");
                } else if (!pass.equals(cPass)) { //checks if password and confirm password doesn't match
                    feed.setText("Passwords do not match, please try again.");
                } else { //executes when fields are not empty and passwords match
                    try { //writes the registered accounts into a txt file and displays feedback for successful registration
                        FileWriter fw = new FileWriter("Accounts.txt", true);
                        fw.write(user + "\t" + pass + "\n");
                        fw.close();
                        feed.setText("Registration Successful!");
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                }
            }
        }
    }

    /**Main method*/
    public static void main(String[] args) {
        invokeLater(new Runnable() {
            public void run() {
                RegistrationAndLoginApp gui = new RegistrationAndLoginApp();
            }
        });
    }

    /**Round Buttons*/
    class RoundButton extends JButton{
        public RoundButton(String label){
            super(label);
            setContentAreaFilled(false);
            setFocusPainted(false); //Used for focus border painting
            setBorderPainted(false);
            setOpaque(false);
        }
        protected void paintComponent(Graphics g){
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // The last two arguments determine the roundness
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g){
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        //Hit detection for round buttons
        public boolean contains(int x, int y){
            if (shape == null || !shape.getBounds().equals(getBounds())){
                shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
            return shape.contains(x, y);
        }
        private Shape shape;
    }

    /**Rectangle Design Text Field*/
    class RoundJTextField extends JTextField{
        public RoundJTextField(int size){
            super(size);
            setOpaque(false);
        }
        protected void paintComponent(Graphics g){
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g){
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
    }

    /**Rectangle Design Password Field*/
    class RoundJPasswordField extends JPasswordField{
        public RoundJPasswordField(int size){
            super(size);
            setOpaque(false);
        }
        protected void paintComponent(Graphics g){
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g){
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
    }

    /**Rectangle Design Confirm Password Field*/
    class RoundJConfirmPasswordField extends JPasswordField{
        public RoundJConfirmPasswordField(int size){
            super(size);
            setOpaque(false);
        }
        protected void paintComponent(Graphics g){
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g){
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth()-1, getHeight()-1, 10, 10);
        }
    }
}
