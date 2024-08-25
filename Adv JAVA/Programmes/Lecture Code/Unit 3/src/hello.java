import java.awt.*;
public class hello {
    
    hello(){
        Frame f = new Frame("First Frame");
        f.setSize(300, 300);
        Button b = new Button("Click Me");
        Label l = new Label("Hello World",1);
        f.add(b);
        f.add(l);
        f.setVisible(true);
        f.setLayout(null);

    }
    public static void main(String[] args) {
        hello h = new hello();
    }
}
