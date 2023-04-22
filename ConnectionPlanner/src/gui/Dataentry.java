package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Dataentry extends JDialog {
    private JButton btnSubmit;
    private JPanel panelMain;
    private JTextField tfFirstName;
    private JTextField tfLastName;
    private JComboBox cbGroup;
    private JCheckBox discordCheckBox;
    private JCheckBox linkedInCheckBox;
    private JCheckBox slackCheckBox;
    private JCheckBox skypeCheckBox;
    private JCheckBox emailCheckBox;
    private JCheckBox facebookCheckBox;
    private JCheckBox snapchatCheckBox;
    private JCheckBox telephoneCheckBox;
    private JCheckBox twitterCheckBox;
    private JCheckBox whatsappCheckBox;
    private JCheckBox instagramCheckBox;
    private JCheckBox speaksGermanCheckBox;
    private JTextField tfOtherLanguages;
    private JTextField tfPreferredLanguages;


    public Dataentry() {
        cbGroup.addItem("No Group");
        cbGroup.addItem("Group A");
        cbGroup.addItem("Group B");
        btnSubmit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addContact();
            }
        });
    }

    private void addContact() {
        String firstName = tfFirstName.getText();
        String lastName = tfLastName.getText();
        String group = cbGroup.getSelectedItem().toString();
        boolean hasDiscord = discordCheckBox.isSelected();
        boolean hasEmail = emailCheckBox.isSelected();
        boolean hasFacebook = facebookCheckBox.isSelected();
        boolean hasInstagram = instagramCheckBox.isSelected();
        boolean hasLinkedIn = linkedInCheckBox.isSelected();
        boolean hasSkype = skypeCheckBox.isSelected();
        boolean hasSlack = slackCheckBox.isSelected();
        boolean hasSnapchat = snapchatCheckBox.isSelected();
        boolean hasTelephone = telephoneCheckBox.isSelected();
        boolean hasTwitter = twitterCheckBox.isSelected();
        boolean hasWhatsapp = whatsappCheckBox.isSelected();

        if (firstName.isEmpty() && lastName.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Must have at least a first name or a last name!");
            return;
        }
        if (!hasDiscord && !hasEmail && !hasFacebook && !hasInstagram && !hasLinkedIn && !hasSkype && !hasSlack && !hasSnapchat && !hasTelephone && !hasTwitter && !hasWhatsapp) {
            JOptionPane.showMessageDialog(this, "Select at least one Connection!");
            return;
        }

        
        JOptionPane.showMessageDialog(this, "Placeholder for Code, which would actually do stuff!");

    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Data entry");
        frame.setContentPane(new Dataentry().panelMain);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }
}
