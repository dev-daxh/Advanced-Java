import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class CardLayoutExample {
    public static void main(String[] args) {
        // Create the main frame
        Frame frame = new Frame("CardLayout Example");
        frame.setSize(400, 300);
        frame.setLayout(new BorderLayout());

        // Create a panel with CardLayout
        Panel cardPanel = new Panel(new CardLayout());
        
        // Create the first panel
        Panel panel1 = new Panel();
        panel1.add(new Label("This is Panel 1"));
        Button switchToPanel2 = new Button("Go to Panel 2");
        panel1.add(switchToPanel2);
        
        // Create the second panel
        Panel panel2 = new Panel();
        panel2.add(new Label("This is Panel 2"));
        Button switchToPanel1 = new Button("Go to Panel 1");
        panel2.add(switchToPanel1);
        
        // Add panels to the CardLayout container
        cardPanel.add(panel1, "Panel1");
        cardPanel.add(panel2, "Panel2");
        
        // Set initial visible panel
        CardLayout cardLayout = (CardLayout) cardPanel.getLayout();
        cardLayout.show(cardPanel, "Panel1");
        
        // ActionListener to switch panels
        switchToPanel2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel2");
            }
        });
        
        switchToPanel1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cardPanel, "Panel1");
            }
        });
        
        // Add card panel to frame
        frame.add(cardPanel, BorderLayout.CENTER);
        
        // Set frame visibility
        frame.setVisible(true);
        
        // Handle window closing
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
    }
}
