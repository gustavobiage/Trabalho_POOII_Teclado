import javax.swing.*;
import java.awt.*;

public class HistoricoFrame extends JFrame {

    JTextArea textArea;

    public HistoricoFrame() {
        super("Historico");
        setSize(400, 400);

        setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setEditable(false);

        add(textArea, BorderLayout.CENTER);

//        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }


    public void addToHistory(String pangram, String text, int error, int acerto) {

        String s = new String();

        s = textArea.getText();
        s = "Pangram: " + pangram + "\n" + "Texto Digitado: " + text + "\nErro: " + error + "\nAcerto: " + acerto + "\n\n" + s;

        textArea.setText(s);
    }

}
