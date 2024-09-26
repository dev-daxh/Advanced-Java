import java.awt.*;
import java.awt.event.*;

public class MenuExample extends Frame implements ActionListener {

    public MenuExample() {
        // Frame setup
        setTitle("AWT Menu Example");
        setSize(400, 300);
        setLayout(new FlowLayout());

        // Create MenuBar
        MenuBar menuBar = new MenuBar();

        // Create Menu
        Menu fileMenu = new Menu("File");
        Menu editMenu = new Menu("Edit");
        Menu viewMenu = new Menu("View");

        // Create MenuItems
        MenuItem newItem = new MenuItem("New");
        MenuItem openItem = new MenuItem("Open");

        // Add MenuItems to File Menu
        fileMenu.add(newItem);
        fileMenu.add(openItem);

        // Add Menus to MenuBar
        menuBar.add(fileMenu);
        menuBar.add(editMenu);
        menuBar.add(viewMenu);

        // Set MenuBar to Frame
        setMenuBar(menuBar);

        // Add ActionListeners
        newItem.addActionListener(this);
        openItem.addActionListener(this);

        // Window close behavior
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        // Make the frame visible
        setVisible(true);
    }

    // Handle menu item actions
    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand();
        if (command.equals("New")) {
            System.out.println("New file created.");
        } else if (command.equals("Open")) {
            System.out.println("Open file dialog.");
        }
    }

    public static void main(String[] args) {
        new MenuExample();
    }
}
