package List;

import java.awt.*;
import java.awt.event.*;

public class listLang extends Frame {
    public listLang() {
        // Set layout manager to GridLayout
        setLayout(new GridLayout(4, 2, 5, 5)); // 4 rows, 2 columns, 10px gaps

        // Set frame size and visibility
        setSize(400, 300);
        setVisible(true);
        setTitle("Language Selector");

        // Create a label
        Label resLabel = new Label();
        add(resLabel);

        // Create and add the first list
        List l1 = new List(4, false);
        l1.add("Java");
        l1.add("JavaScript");
        l1.add("Python");
        l1.add("PHP");
        add(l1);

        // Create and add the second list
        List l2 = new List(4, true);
        l2.add("SpringBoot");
        l2.add("ReactJs");
        l2.add("Flask");
        l2.add("CodeIgniter");
        add(l2);

        // Create and add the button
        Button btn = new Button("Submit");
        add(btn);

        // Button action listener
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String data = "Programming language: " + l1.getItem(l1.getSelectedIndex());
                data += ", Framework selected: ";
                for (String frame : l2.getSelectedItems()) {
                    data += frame + " ";
                }
                resLabel.setText(data);
            }
        });

        // Handle window closing
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }

    public static void main(String[] args) {
        new listLang();
    }
}
