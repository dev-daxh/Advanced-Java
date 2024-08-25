import java.awt.*;
import java.awt.event.*;

public class CounterAWT extends Frame {
    private Button tfButton;
    private TextField tfTextField;
    private Label tfLabel;
    private int count = 0;

    CounterAWT() {
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(300, 100);

        tfLabel = new Label("Count : ");
        add(tfLabel);

        tfTextField = new TextField("Count", 10);
        tfTextField.setEditable(false);
        add(tfTextField);

        tfButton = new Button("Count");
        add(tfButton);

        tfButton.addActionListener(new ActionCount());

        setVisible(true);

    }

    public static void main(String[] args) {
        CounterAWT count = new CounterAWT();
    }

    private class ActionCount implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            ++count;
            tfTextField.setText(count + "");
            System.out.println("Button clicked, count is " + count);
        }
    }
}
