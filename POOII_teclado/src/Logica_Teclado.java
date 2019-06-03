import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

public class Logica_Teclado extends JFrame implements KeyListener {

    private ArrayList<JButton> lista;
    private Color corpadrao;
    private Frame frame;

    public Logica_Teclado(ArrayList<JButton> lista, Frame frame) {
        this.setFocusable(true);
        this.lista = lista;
        corpadrao = lista.get(0).getBackground();
        this.frame = frame;
    }

    public JButton checaBotao(int asc2) {
        for (int i = 0; i < lista.size(); i++) {
            if (asc2 >= 97 && asc2 <= 122) {
                asc2 -= 32;
            }
            if (lista.get(i).getText().equals((char) asc2 + "")) {
                return lista.get(i);
            }
        }

        for (int i = 0; i < lista.size(); i++) {
            switch (asc2) {
                case 9:
                    if (lista.get(i).getText().equals("Tab")) return lista.get(i);
                    break;
                case 20:
                    if (lista.get(i).getText().equals("Caps")) return lista.get(i);
                    break;
                case 65535:
                    if (lista.get(i).getText().equals("Shift")) return lista.get(i);
                    break;
                case 32:
                    if (lista.get(i).getText().equals(" ")) return lista.get(i);
                    break;
                case 8:
                    if (lista.get(i).getText().equals("Backspace")) return lista.get(i);
                    break;
                case 10:
                    if (lista.get(i).getText().equals("Enter")) return lista.get(i);
                    break;
                case 60:
                    if (lista.get(i).getText().equals("<")) return lista.get(i);
                    break;
                case 62:
                    if (lista.get(i).getText().equals(">")) return lista.get(i);
                    break;
                case 94:
                    if (lista.get(i).getText().equals("^")) return lista.get(i);
                    break;
                case 118:
                    if (lista.get(i).getText().equals("v")) return lista.get(i);
                    break;
            }

        }
        return null;
    }

    @Override
    public void keyPressed(KeyEvent e) {
//        System.out.println(frame.index+"asdasdsa");
        char keyPressed = e.getKeyChar();

        JButton botao = checaBotao((int)keyPressed);
        char c = ' ';
        if(keyPressed != 65535) {
            c = frame.pegarLetra();
        }
        JTextArea textArea = frame.getTextArea();
        if(botao != null) {

            if(botao != null && botao.getText().equals("Backspace")) {
                textArea.setText(textArea.getText().substring(0, Math.max(textArea.getText().length() - 1, 0)));
                botao.setBackground(Color.magenta);
                frame.decrementarIndice();
                frame.decrementarIndice();
            } else if (botao != null && botao.getText().equals("Caps")) {
                frame.decrementarIndice();
                botao.setBackground(Color.magenta);
            } else if (botao != null && botao.getText().equals("Enter")) {
                frame.compare_final();
                frame.historicoFrame.addToHistory(frame.getPangram(), frame.getTextArea().getText()
                        , frame.error + Math.max(frame.getPangram().length() - frame.getTextArea().getText().length(), 0)
                        , frame.acerto);
                frame.getTextArea().setText("");
                frame.selecionarPangram(frame.getPangram());
                botao.setBackground(Color.magenta);
            } else if (botao != null && botao.getText().equals("Shift")) {
                botao.setBackground(Color.magenta);
                //frame.decrementarIndice();
            } else if (botao.getText().equals(c + "")) {
                textArea.setText(textArea.getText() + keyPressed);
                botao.setBackground(Color.magenta);
                if(frame.getPangram().length() != 0)frame.compare();
            } else if (botao != null) {
                textArea.setText(textArea.getText() + keyPressed);
                botao.setBackground(Color.magenta);
                if(frame.getPangram().length() != 0)frame.compare();
            }
        } else {
            new NoButtonException().printStackTrace();
            frame.decrementarIndice();
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        JButton botao = checaBotao((int)e.getKeyChar());
        if(botao != null) botao.setBackground(corpadrao);
    }

    @Override
    public void keyTyped(KeyEvent e) {
//        System.out.println("asdasdsa");
//        char keyPressed = e.getKeyChar();
//
//        JButton botao = checaBotao((int)keyPressed);
//        char c = frame.pegarLetra();
//        JTextArea textArea = frame.getTextArea();
//        if(botao != null && botao.getText().equals("Backspace")) {
//            textArea.setText(textArea.getText().substring(0, textArea.getText().length() - 1));
//        } else if(botao.getText().equals(c + "")) {
//            textArea.setText(textArea.getText() + c);
//            botao.setBackground(Color.GREEN);
//        } else if (botao != null) {
//            textArea.setText(textArea.getText() + keyPressed);
//            botao.setBackground(Color.RED);
//        }
    }
}