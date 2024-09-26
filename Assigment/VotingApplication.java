package Assigment;
import java.awt.*;
import java.awt.event.*;

public class VotingApplication extends Frame implements ActionListener {
    // Candidates and their vote counts
    private String[] candidates = {"Candidate A", "Candidate B", "Candidate C"};
    private int[] votes = new int[candidates.length];

    // Buttons for each candidate
    private Button[] voteButtons = new Button[candidates.length];
    private Button submitButton = new Button("Submit");

    public VotingApplication() {
        // Setting up the frame
        setTitle("Voting Application");
        setSize(300, 200);
        
        setResizable(false);
        setLayout(new BorderLayout()); // Use BorderLayout for the main frame

        // Panel 1: Holds candidate vote buttons in GridLayout
        Panel panel1 = new Panel();
        panel1.setLayout(new GridLayout(candidates.length, 2, 10, 10)); // 2 columns (Candidate, Button)

        for (int i = 0; i < candidates.length; i++) {
            Label candidateLabel = new Label(candidates[i]); // Label for the candidate
            voteButtons[i] = new Button("Vote for " + candidates[i]);
            voteButtons[i].addActionListener(this);
            
            // Add label and button to panel1
            panel1.add(candidateLabel);
            panel1.add(voteButtons[i]);
        }

        // Panel 2: Holds the submit button
        Panel panel2 = new Panel();
        panel2.setLayout(new FlowLayout(FlowLayout.CENTER)); // Center-align the submit button
        submitButton.addActionListener(this);
        panel2.add(submitButton);

        // Add both panels to the frame
        add(panel1, BorderLayout.CENTER);
        add(panel2, BorderLayout.SOUTH);

        // Closing the application
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.exit(0);
            }
        });

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // Check if a vote button was clicked
        for (int i = 0; i < candidates.length; i++) {
            if (e.getSource() == voteButtons[i]) {
                votes[i]++;
                System.out.println("Voted for: " + candidates[i]);
            }
        }

        // Check if the submit button was clicked
        if (e.getSource() == submitButton) {
            displayResults();
        }
    }

    private void displayResults() {
        int maxVotes = -1;
        String winner = "";

        // Determine the winner
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > maxVotes) {
                maxVotes = votes[i];
                winner = candidates[i];
            }
        }

        // Create a dialog to display the results
        StringBuilder results = new StringBuilder("Vote Counts:\n");
        for (int i = 0; i < candidates.length; i++) {
            results.append(candidates[i]).append(": ").append(votes[i]).append("\n");
        }
        
        results.append("\nWinner: ").append(winner).append(" with ").append(maxVotes).append(" votes.");

        // Show results in a dialog box
        Dialog dialog = new Dialog(this, "Voting Results", true);
        dialog.setLayout(new GridLayout(3, 1)); // Use GridLayout for results
        dialog.setSize(300, 200);
        
        dialog.add(new Label(results.toString()));
        
        Label winnerLabel = new Label(winner + " wins with " + maxVotes + " votes!");
        winnerLabel.setForeground(Color.RED);
        dialog.add(winnerLabel);
        
        Button closeButton = new Button("Close");
        closeButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ae) {
                dialog.dispose();
            }
        });
        dialog.add(closeButton);
        
        dialog.setVisible(true);
    }

    public static void main(String[] args) {
        new VotingApplication();
    }
}
