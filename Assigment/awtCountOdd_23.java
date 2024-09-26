package Assigment;
import java.awt.*;
import java.awt.event.*;
public class awtCountOdd_23 extends Frame implements ActionListener{
    private Label labinfo;
    private Button btnup,btndown,btnreset;
    private TextField tfcount;
    int count = 0;
    public awtCountOdd_23(){
        setLayout(new FlowLayout());
        setSize(300,150);
        setVisible(true);

        labinfo = new Label("Count ");
        add(labinfo);
        tfcount = new TextField(""+count);
        tfcount.setEditable(false);
        add(tfcount);
        btnup = new Button("Count Up");
        btnup.addActionListener(this);
        add(btnup);
        btndown = new Button("Count Down");
        btndown.addActionListener(this);
        add(btndown);
        btnreset = new Button("Reset");
        btnreset.addActionListener(this);
        add(btnreset);




    }
    public static void main(String[] args) {
        new awtCountOdd_23();
    }
    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource()==btnup){
            ++count;
            tfcount.setText(count+"");

        }
        else if(e.getSource()==btndown){
            --count;
            tfcount.setText(count+"");
            
        }
        else if(e.getSource()==btnreset){
            count=0;
            tfcount.setText(count+"");
            
        }
    }
    
}
