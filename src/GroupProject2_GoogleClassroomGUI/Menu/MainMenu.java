package GroupProject2_GoogleClassroomGUI.Menu;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import static javax.swing.SwingUtilities.invokeLater;

public class MainMenu extends JFrame {
    /** instance variables */
    private RoundButton login, signup, exit;
    private JFrame frame;
    private JPanel panel;
    private JLabel feed;
    private static RoundJTextField userText;
    private static RoundJPasswordField passText;

    /**
     * Main menu GUI constructor
     */

    /** Setting up the main frame and panel */
    MainMenu() {
        frame = new JFrame();
        panel = new JPanel();
        frame.add(panel);
        panel.setLayout(null);

        /** Ensure the application exits */
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        /** Logo properties */
        JLabel picture = new JLabel();
        ImageIcon icon = new ImageIcon("picture/classroomPicture.png");
        picture.setIcon(icon);
        picture.setBounds(100, 200, icon.getIconWidth(), icon.getIconHeight());
        panel.add(picture);

        /** Background color */
        Color yellow = new Color(255, 242, 178);
        panel.setBackground(yellow);

        /** Frame properties */
        frame.setTitle("Main Menu");
        frame.setSize(850, 650);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
        frame.setResizable(false);

        /** Title properties */
        JLabel title = new JLabel("SLU Classroom");
        title.setBounds(250, 70, 500, 100);
        title.setFont(new Font("Comic Sans", Font.BOLD, 50));
        Color blue = new Color(1, 98, 175);
        title.setForeground(blue);
        panel.add(title);

        /** Login button properties */
        login = new RoundButton("Login");
        login.setBounds(550, 350, 100, 25);
        login.addActionListener(new ButtonHandler());
        login.setBorderPainted(false);
        panel.add(login);

        /** Signup button properties */
        signup = new RoundButton("Sign Up");
        signup.setBounds(660, 350, 100, 25);
        signup.addActionListener(new ButtonHandler());
        panel.add(signup);

        /** Exit button properties */
        exit = new RoundButton("Exit");
        exit.setBounds(600, 390, 100, 25);
        exit.addActionListener(new ButtonHandler());
        panel.add(exit);

        /** User label properties */
        JLabel user = new JLabel("Username ");
        user.setBounds(500, 230, 80, 25);
        panel.add(user);

        /** User text field properties */
        userText = new RoundJTextField(20); //max size of the characters
        userText.setBounds(560, 250, 200, 25);
        panel.add(userText);

        /** Password label properties */
        JLabel pass = new JLabel("Password ");
        pass.setBounds(500, 280, 80, 25);
        panel.add(pass);

        /** Password text field properties */
        passText = new RoundJPasswordField(20); //max size of the characters
        passText.setBounds(560, 300, 200, 25); //560 x 300
        panel.add(passText);

        /** Label for the error messages */
        feed = new JLabel("");
        feed.setBounds(560, 410, 300, 50);
        panel.add(feed);

        /** Setting the icon */
        Image Icon = Toolkit.getDefaultToolkit().getImage("picture/classroomPicture.png");
        frame.setIconImage(Icon);

        /** Detects Enter key */
        userText.addKeyListener(new EnterKeyListener(this::performLogin));
        passText.addKeyListener(new EnterKeyListener(this::performLogin));
    }


    /**
     * EnterKeyListener is a custom key adapter that listens for the Enter key press.
     * Upon detecting an Enter key press, it runs a specified action.
     */
    public class EnterKeyListener extends KeyAdapter {
        private Runnable action;

        /**
         * Constructor that initializes the key listener with a specified action.
         */
        public EnterKeyListener(Runnable action) {
            this.action = action;
        }

        /**
         * Handles the key pressed event. Executes the action if Enter key is pressed.
         */
        @Override
        public void keyPressed(KeyEvent e) {
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                action.run();
            }
        }
    }

    /**
     * Attempts to log the user in using the provided credentials.
     * Checks the 'Accounts.txt' file for matching username and password.
     * If the credentials match, disposes the current frame and opens the Classroom.
     */
    private void performLogin() {
        String user = userText.getText();
        String pass = passText.getText();
        boolean matched = false;

        if (user.isBlank() || pass.isBlank()) { //Check if any of the fields are blank
            feed.setText("      Fields must not be empty");
        } else {
            try {
                FileReader fr = new FileReader("Accounts.txt"); //Read the 'Accounts.txt' file to verify login credentials
                BufferedReader br = new BufferedReader(fr);
                String line;
                while ((line = br.readLine()) != null) {
                    if (line.equals(user + "\t" + pass)) {
                        matched = true;
                        break;
                    }
                }

                if (matched) {  //If credentials matched, proceed to the Classroom
                    Classroom classroom = new Classroom();
                    System.out.println("Login successful");
                    frame.dispose();
                } else if (!matched) {  //If credentials didn't matched, display error message
                    feed.setText("Username or Password is incorrect");
                }
                fr.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
    }

    /**
     * In charge of the GUI's button functions
     */
    class ButtonHandler implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == login) { //Creates a login Frame and closes the main menu
                performLogin();
            } else if (e.getSource() == signup) { //Creates a registration Frame and closes the main menu
                frame.dispose();
                RegistrationAndLoginApp reg = new RegistrationAndLoginApp();
            } else if (e.getSource() == exit) { //Exits the GUI and terminates the program
                System.exit(0);
            }
        }
    }


    /**
     * Main method
     */
    public static void main(String[] args) {
        invokeLater(new Runnable() {
            public void run() {
                MainMenu gui = new MainMenu();
            }
        });
    }

    /**
     * Rectangle Design Text Field
     */
    class RoundJTextField extends JTextField {
        public RoundJTextField(int size) {
            super(size);
            setOpaque(false);
        }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        }
    }

    /**
     * Round Design Password Field
     */
    class RoundJPasswordField extends JPasswordField {
        public RoundJPasswordField(int size) {
            super(size);
            setOpaque(false);
        }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 10, 10);
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 10, 10);
        }

    }

    /**
     * Round Buttons
     */
    class RoundButton extends JButton {
        public RoundButton(String label) {
            super(label);
            setContentAreaFilled(false);
            setFocusPainted(false); //Used for focus border painting
            setBorderPainted(false);
            setOpaque(false);
        }
        protected void paintComponent(Graphics g) {
            g.setColor(getBackground());
            g.fillRoundRect(0, 0, getWidth(), getHeight(), 20, 20); // The last two arguments determine the roundness
            super.paintComponent(g);
        }
        protected void paintBorder(Graphics g) {
            g.setColor(getForeground());
            g.drawRoundRect(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
        }
        //Hit detection for round buttons
        public boolean contains(int x, int y) {
            if (shape == null || !shape.getBounds().equals(getBounds())) {
                shape = new java.awt.geom.RoundRectangle2D.Float(0, 0, getWidth() - 1, getHeight() - 1, 20, 20);
            }
            return shape.contains(x, y);
        }
        private Shape shape;

    }
}
