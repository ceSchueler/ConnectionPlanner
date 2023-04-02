//Usually you will require both swing and awt packages
// even if you are working with just swings.
import javax.swing.*;
import java.awt.*;

class Gui {
    public static void main(String args[]) {

        JFrame frame = new JFrame("Connection Planner");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);

        JPanel panel = new JPanel();
        JLabel label = new JLabel("Click Button");
        JButton dothething = new JButton("Get Random Contact");
        panel.add(label); // Components Added using Flow Layout
        panel.add(dothething);
        JTextArea out = new JTextArea();

        frame.getContentPane().add(BorderLayout.NORTH, panel);
        frame.getContentPane().add(BorderLayout.SOUTH, out);

        frame.setVisible(true);
       }
}