package MouseEvent;

import java.awt.*;
import java.awt.event.*;

public class MouseAll extends Frame implements MouseListener, MouseMotionListener {
    private String msg = "";
    private int mx = 10, my = 40;
    private int mvx = 0, mvy = 0;

    MouseAll(String title) {
        super(title);

        // Set up window close event
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        // Register mouse listeners
        addMouseListener(this);
        addMouseMotionListener(this);

        // Set layout and size
        setLayout(new FlowLayout(FlowLayout.CENTER));
        setSize(400, 500);
        setVisible(true);
    }

    // MouseListener methods
    public void mouseClicked(MouseEvent me) {
        msg = "mouse Clicked";
        mx = 10;
        my = 54;
        repaint();
    }

    public void mouseEntered(MouseEvent me) {
        msg = "mouse Entered";
        mx = 10;
        my = 54;
        repaint();
    }

    public void mouseExited(MouseEvent me) {
        msg = "mouse just Exited";
        mx = 10;
        my = 54;
        repaint();
    }

    public void mousePressed(MouseEvent me) {
        msg = "down";
        mx = me.getX();
        my = me.getY();
        repaint();
    }

    public void mouseReleased(MouseEvent me) {
        msg = "up";
        mx = me.getX();
        my = me.getY();
        repaint();
    }

    // MouseMotionListener methods
    public void mouseDragged(MouseEvent me) {
        msg = "*";
        mx = me.getX();
        my = me.getY();
        repaint();
    }

    public void mouseMoved(MouseEvent me) {
        mx = me.getX();
        my = me.getY();
        mvx = mx;
        mvy = my;
        repaint();
    }

    // Override the paint method to draw on the Frame
    @Override
    public void paint(Graphics g) {
        super.paint(g);
        g.drawString(msg, mx, my);
        g.drawString("Mouse at " + mvx + " " + mvy, 10, 40);
    }

    public static void main(String[] args) {
        new MouseAll("Sample");
    }
}
