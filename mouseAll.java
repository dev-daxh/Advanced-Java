import java.awt.*;
import java.awt.event.*;

public class mouseAll extends Frame implements MouseListner, MouseMotionListner {
    private String msg = "";
    private int mx = 10, my = 40;
    private int mvx = 0, mvy = 0;

    public mouseAll(String msg) {
        super(msg);

        addWindowListner(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                dispose();
                System.exit(0);
            }
        });

        addMouseListner(this);
        addMouseMotionListner(this);

        setLayout(new FlowLayout());
        setSize(500, 300);
        setVisible(true);
    }

    public void MouseClicked(MouseEvent me) {
        msg = "Mouse Clicked";
        mx = 10;
        my = 54;
        repaint();
    }

    public void MouseEntered(MouseEvent me) {
        msg = "Mouse Entered";
        mx = 10;
        my = 54;
        repaint();
    }

    public void MouseExited(MouseEvent me) {
        msg = "Mouse Exited";
        mx = 10;
        my = 54;
        repaint();
    }

    public void MousePressed(MouseEvent me) {
        msg = "Mouse up";
        mx = 10;
        my = 54;
        repaint();
    }

    public void MouseReleased(MouseEvent me) {
        msg = "Mouse down";
        mx = 10;
        my = 54;
        repaint();
    }

    public void MouseDragged(MouseEvent me) {
        msg = "*";
        mx = me.getX();
        my = me.getY();
        repaint();
    }

    public void MouseMoved(MouseEvent me) {
        msg = "Mouse moving";
        mx = me.getX();
        my = me.getY();
        mvx = mx;
        mvy = my;
        repaint();
    }

    public void repaint(Graphics g) {
        super.paint(g);
        g.drawString(msg, mx, my);
        g.drawString("mouse at " + mvx + " " + mvy, 10, 40);
    }

    public void main(String[] args) {
        new mouseAll();
    }
}
