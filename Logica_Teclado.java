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
                case 14:
                    if (lista.get(i).getText().equals("Shift")) return lista.get(i);
                    break;
                case 32:
                    if (lista.get(i).getText().equals(" ")) return lista.get(i);
                    break;
                case 8:
                    if (lista.get(i).getText().equals("Backspace")) return lista.get(i);
                    break;
                case 13:
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

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }
}