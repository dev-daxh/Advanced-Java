package CheckBoxGroup;
import java.awt.*;
import java.awt.event.*;
public class Gender extends Frame {
    private Label resLabel;
    private Button btnsubmit;
    private CheckboxGroup GenderGroup;
    private Checkbox male,female,other;
    public Gender(){
        setLayout(new GridLayout(5,2));
        setSize(500,300);
        setVisible(true);
        Panel p1 = new Panel();
        p1.setLayout(new FlowLayout(FlowLayout.LEFT));
        Label l1 = new Label("Choose Gender: ");
        p1.add(l1);
        GenderGroup = new CheckboxGroup();
        male = new Checkbox("Male", GenderGroup, false);
        p1.add(male);
        female = new Checkbox("Female",GenderGroup,false);
        p1.add(female);
        other = new Checkbox("other",GenderGroup,false);
        p1.add(other);
        resLabel = new Label("\n");
        p1.add(resLabel);

        btnsubmit = new Button("Submit");
        btnsubmit.addActionListener(new genderAction());
        p1.add(btnsubmit);
        add(p1);
        addWindowListener(new WindowAdapter(){
        public void windowClosing(WindowEvent we){
            dispose();
            System.exit(0);
        }
    });


    }

    private class genderAction implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e){
            Checkbox selectCheckbox  = GenderGroup.getSelectedCheckbox();
            if(selectCheckbox!=null){
                resLabel.setText("Your gender is : "+selectCheckbox.getLabel());
            }

            else{
                resLabel.setText("No gender selected.");
            }

        }
    }
    public static void main(String[] args) {
        new Gender();
    }

    
}
