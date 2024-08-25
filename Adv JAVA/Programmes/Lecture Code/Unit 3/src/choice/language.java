package choice;

import java.awt.*;
import java.awt.event.*;

public class language extends Frame {
    public language() {
        Label resLabel = new Label();
        resLabel.setAlignment(Label.LEFT);
        add(resLabel);

        Choice c1 = new Choice();
        c1.add("Java");
        c1.add("C++");
        c1.add("Python");
        c1.add("PHP");

        add(c1);
        setSize(300, 300);
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setVisible(true);

        Button btnsubmit = new Button("Submit");
        btnsubmit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                resLabel.setText("Choosen Language: " + c1.getItem(c1.getSelectedIndex()));
            }
        });
        add(btnsubmit);
    }

    public static void main(String[] args) {
        new language();
    }
}
