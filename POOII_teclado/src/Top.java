import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.KeyListener;

public class Top extends JFrame {
    JTabbedPane tabbedPane;

    JLabel label_escritor;
//    Container pabel_escritor;

    public Top() {
        super("Trabalho POO");
        setSize(new Dimension(900, 550));

        //setLayout(new BorderLayout());

        JTabbedPane tabbedPane = new JTabbedPane();
        HistoricoFrame historicoFrame = new HistoricoFrame();

//        JLabel label_escritor = new JLabel("PUNHETAA");
        Frame frame = new Frame(historicoFrame);
        Container panel_escritor = frame.getContentPane();
        Container escolher_pangram_frame = new EscolherPangramFrame(frame).getContentPane();

        Container contentPane = getContentPane();
        contentPane.setLayout(new BoxLayout(contentPane, BoxLayout.Y_AXIS));

//       frame.requestFocus();

//        Frame panel_escritor2 = new Frame();
        Container historicoFrameContainer = historicoFrame.getContentPane();

        tabbedPane.addTab("Teclado", null, panel_escritor, "Treino");
        tabbedPane.addTab("Pangramas", null, escolher_pangram_frame, "Treino");
        tabbedPane.addTab("Historico", null, historicoFrameContainer, "Treino");

//        Logica_Teclado lt = new Logica_Teclado(frame.getLista_botoes(), frame);
//        lt.requestFocus();
//        panel_escritor.addKeyListener(lt);

//        panel_escritor.focus;
        this.transferFocus();
//        tabbedPane.setSelectedComponent(panel_escritor);
//        this.setFocusable(false);
//        this.setFocusTraversalKeysEnabled(false);
//        panel_escritor.requestFocus();

        add(tabbedPane);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

//        for(int i = 0; i < this.getFocusListeners().length; i++) {
//            this.removeFocusListener(this.getFocusListeners()[i]);
//        }
//        this.addKeyListener(lt);
//        setFocusTraversalKeysEnabled(false);0
    }
}
