package ScrollTextArea;
import java.awt.*;
import java.awt.event.*;
public class Count extends Frame {
    public Count(){
        setLayout(new FlowLayout(FlowLayout.CENTER,10,10));
        setVisible(true);
        setSize(490,500);
        Label wordLabel = new Label("Word: "); 
        add(wordLabel);
        Label characterLabel = new Label("Character: ");
        add(characterLabel);
        Label numbersLabel = new Label("Number of Line: ");
        add(numbersLabel);

        TextArea txt = new TextArea(25,50);
        add(txt);

        Button btn = new Button("count");
        btn.addActionListener(new ActionListener() {
           public void actionPerformed(ActionEvent e){
            String areaText = txt.getText();
            int word =areaText.split("\\s").length;
            int line= areaText.split("\\n").length;
            int charcount = areaText.length();

            wordLabel.setText("Word: "+word);
            numbersLabel.setText("Number of Line: "+line);
            characterLabel.setText("Character :"+charcount);

           } 
        });
        add(btn);

    }
    public static void main(String[] args) {
        new Count();
    }
    
}
