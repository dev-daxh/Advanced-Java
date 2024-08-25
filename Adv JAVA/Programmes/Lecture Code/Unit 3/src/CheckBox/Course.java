package CheckBox;
import java.awt.*;
import java.awt.event.*;
public class Course extends Frame implements ActionListener,ItemListener {
    private Checkbox cm301g,cm302g,es301g,cm304g,it304g;
    private Button btnsubmit;
    private Label labselect;
    private TextArea resArea;
    public Course(){
        setLayout(new GridLayout(1,2 ));
        setSize(650,300);
        setVisible(true);

        Panel p1 = new Panel(new FlowLayout(FlowLayout.LEFT));
        Label l1 = new Label("Choose Courses For Odd-24");
        p1.add(l1);
        cm301g = new Checkbox("cm301g");
        p1.add(cm301g);
        cm302g = new Checkbox("cm302g");
        p1.add(cm302g);
        es301g = new Checkbox("es301g");
        p1.add(es301g);
        cm304g = new Checkbox("cm304g");
        p1.add(cm304g);
        it304g = new Checkbox("it304g");
        p1.add(it304g);
        labselect = new Label();
        p1.add(labselect);
        add(p1);

        cm301g.addItemListener(this);
        cm302g.addItemListener(this);
        es301g.addItemListener(this);
        cm304g.addItemListener(this);
        it304g.addItemListener(this);

        Panel p2 = new Panel(new FlowLayout(FlowLayout.RIGHT));
        btnsubmit = new Button("Submit");
        p2.add(btnsubmit);
        btnsubmit.addActionListener(this);

        resArea = new TextArea(5,30);
        resArea.setEditable(false);
        p2.add(resArea);
        
        add(p2);

        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we ){
                dispose();
                System.exit(0);
            }
        });


    }
    @Override
    public void itemStateChanged(ItemEvent e){
        Checkbox source = (Checkbox) e.getSource();
        String label= source.getLabel();
        String state = (e.getStateChange()==ItemEvent.SELECTED) ? "checked":"unchecked";
        labselect.setText(label + "Checkbox "+ state);
    }
    @Override 
    public void actionPerformed(ActionEvent e){
        resArea.setText("Selected Course :"+"\n");
        if(cm301g.getState()){
            resArea.append(cm301g.getLabel()+ "\n");
        }
        if (cm302g.getState()){
            resArea.append(cm302g.getLabel()+ "\n");
        }
        if (es301g.getState()){
            resArea.append(es301g.getLabel()+ "\n");
        }
       if (cm304g.getState()){
            resArea.append(cm304g.getLabel()+ "\n");
        }
        if(it304g.getState()){
            resArea.append(it304g.getLabel()+ "\n");
        }

    }

    public static void main(String[] args) {
        new Course();
    }
    
}
