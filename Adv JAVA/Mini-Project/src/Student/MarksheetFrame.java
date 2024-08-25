package Student;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MarksheetFrame extends Frame {

    public MarksheetFrame() {
        setTitle("Statement of Marks");
        setLayout(new BorderLayout(10, 20)); // BorderLayout with some spacing

        // Creating a title panel
        Panel titlePanel = new Panel(new GridLayout(2, 2));
        titlePanel.setBackground(Color.RED);

        Label programmeLabel = new Label("Programme: Diploma in Computer Engineering", Label.LEFT);
        programmeLabel.setFont(new Font("Serif", Font.BOLD, 16));
        titlePanel.add(programmeLabel);

        Label nameLabel = new Label("Name: TITARMARE DAKSH RAJU", Label.LEFT);
        nameLabel.setFont(new Font("Serif", Font.BOLD, 16));
        titlePanel.add(nameLabel);

        Label examinationLabel = new Label("Examination: SUMMER (2024)", Label.LEFT);
        examinationLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        titlePanel.add(examinationLabel);

        Label enrollmentLabel = new Label("Enrollment No.: 2213063", Label.LEFT);
        enrollmentLabel.setFont(new Font("Serif", Font.PLAIN, 16));
        titlePanel.add(enrollmentLabel);

        add(titlePanel, BorderLayout.NORTH);

        // Creating a data grid panel
        Panel dataPanel = new Panel(new GridLayout(10, 8, 5, 5));
        dataPanel.setBackground(Color.WHITE);

        // Creating and styling labels
        String[] headers = {"Cr.Code", "Course Title", "TH / TH-SA", "PT / CT / TH-FA", "TW / CP / PR-FA", "PR / PR-SA", "Total", "Result"};
        Font headerFont = new Font("Serif", Font.BOLD, 14);

        for (String header : headers) {
            Label label = new Label(header, Label.CENTER);
            label.setFont(headerFont);
            label.setBackground(Color.GRAY);
            label.setForeground(Color.WHITE);
            dataPanel.add(label);
        }

        // Rows with data
        String[][] data = {
                {"AE213G", "INDUSTRIAL MANAGEMENT", "46", "31", "", "", "77", "P"},
                {"CM206G", "INFORMATION AND CYBER SECURITY", "53", "39", "", "", "92", "P"},
                {"CM207G", "JAVA PROGRAMMING", "52", "40", "49", "", "166", "P"},
                {"CM208G", "MICROPROCESSOR", "48", "40", "45", "", "157", "P"},
                {"CM209G", "ADVANCED COMPUTER NETWORK", "49", "40", "40", "", "144", "P"},
                {"CM211G", "DIGITAL MARKETING", "54", "40", "49", "", "166", "P"},
                {"CM251G", "WEB PROGRAMMING USING PHP", "54", "40", "48", "", "166", "P"},
                {"IT206G", "SOFTWARE ENGINEERING", "51", "36", "48", "", "158", "P"},
        };

        // Creating and adding text fields
        Font dataFont = new Font("Serif", Font.PLAIN, 12);
        for (String[] row : data) {
            for (String value : row) {
                TextField textField = new TextField(value);
                textField.setFont(dataFont);
                textField.setEditable(false); // make non-editable for display purposes
                textField.setBackground(Color.LIGHT_GRAY);
                textField.setForeground(Color.BLACK);
                dataPanel.add(textField);
            }
        }

        add(dataPanel, BorderLayout.CENTER);

        // Set frame properties
        setSize(800, 600);
        setVisible(true);

        // Handle window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });
    }
}
