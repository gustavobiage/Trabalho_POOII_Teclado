import javafx.scene.control.RadioButton;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class Frame extends JFrame {
    public int error = 0;
    public int acerto = 0;

    private String alfabeto = "~1234567890-+QWERTYUIOP[]/ASDFGHJKL:'ZXCVBNM,.?";
    private JButton[] teclas;
    private ArrayList<JButton> lista_botoes;

    private int coutErros;

    private Label notas_cabecalho;
    private Label espacamento;

    private String pangram;
    public int index;

    private JLabel pangram_label;
    private JButton selecionar_pangram;

    private JRadioButtonMenuItem[] radio_pangram;
    private ButtonGroup grupo_radio;

    private Map<JRadioButtonMenuItem, String> map_radio_pangram = new HashMap();

    private String[] pangrans;
    private String[] caminhos = {"primeiro_pangram.txt", "segundo_pangram.txt", "terceiro_pangram.txt", "quarto_pangram.txt", "quinto_pangram.txt"};

    private JButton selecionar;
    private final String alf = "ABCDEFGHI";

    private JButton tab, caps, backspace, shift, enter, space, up, down, left, right;
    private JTextArea textArea;

    HistoricoFrame historicoFrame;

    public Frame(HistoricoFrame hf) {
        super("teclado");
        coutErros = 0;
        historicoFrame = hf;
        setLayout(new BorderLayout());
        setSize(900, 560);

        Container container_teclas = new Container();

        GridBagLayout gridBagLayout = new GridBagLayout();

        container_teclas.setLayout(gridBagLayout);

        lista_botoes = new ArrayList();
        int marginX, marginY;

        GridBagConstraints gbc = new GridBagConstraints();
        teclas = new JButton[alfabeto.length()];
        gbc.gridheight = 1;
        gbc.gridwidth= 1;

//        marginX = 1;
        marginX = 0;
        marginY = 0;
        for(int i = 0; i < 13; i++) {
            gbc.gridx = i+marginX;
            gbc.gridy = 0 + marginY;
            teclas[i] = new JButton(alfabeto.charAt(i)+"");
            teclas[i].setMinimumSize(new Dimension(50,50));
            teclas[i].setPreferredSize(new Dimension(100,100));
            container_teclas.add(teclas[i], gbc);
            lista_botoes.add(teclas[i]);
        }

        gbc.gridx = 13 + marginX;
        gbc.gridwidth = 2;
        backspace = new JButton("Backspace");
        backspace.setMinimumSize(new Dimension(100,50));
        backspace.setPreferredSize(new Dimension(100,100));
        container_teclas.add(backspace, gbc);

        gbc.gridwidth = 1;

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 2;
//        gbc.gridwidth = 1;
        tab = new JButton("Tab");
        tab.setMinimumSize(new Dimension(100, 50));
        tab.setPreferredSize(new Dimension(100, 100));
        container_teclas.add(tab, gbc);
        gbc.gridwidth = 1;

//        gbc.gridwidth = 0;

        marginX = 2;
        marginY = 1;
        for(int i = 13; i < 26; i++) {
            gbc.gridx = i-13+marginX;
//            gbc.gridx = ;
            gbc.gridy = 0+marginY;
            teclas[i] = new JButton(alfabeto.charAt(i)+"");
            teclas[i].setMinimumSize(new Dimension(50,50));
            teclas[i].setPreferredSize(new Dimension(100,100));
            container_teclas.add(teclas[i], gbc);
            lista_botoes.add(teclas[i]);
        }

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        caps = new JButton("Caps");
        caps.setMinimumSize(new Dimension(100, 50));
        caps.setPreferredSize(new Dimension(100, 100));
        container_teclas.add(caps, gbc);

        gbc.gridwidth = 1;
//        marginX = 1;
        marginX = 2;
        marginY = 2;

        for(int i = 26; i < 37; i++) {
            gbc.gridx = i-26+marginX;
            gbc.gridy = marginY;
            teclas[i] = new JButton(alfabeto.charAt(i)+"");
            teclas[i].setMinimumSize(new Dimension(50,50));
            teclas[i].setPreferredSize(new Dimension(100,100));
            container_teclas.add(teclas[i], gbc);
            lista_botoes.add(teclas[i]);
        }

        gbc.gridx = 13;
        gbc.gridy = 2;
        gbc.gridwidth = 2;
        enter = new JButton("Enter");
        enter.setMinimumSize(new Dimension(100, 50));
        enter.setPreferredSize(new Dimension(100, 100));
        container_teclas.add(enter, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 3;
        shift = new JButton("Shift");
        shift.setMinimumSize(new Dimension(150, 50));
        shift.setPreferredSize(new Dimension(150, 100));
        container_teclas.add(shift, gbc);

        gbc.gridwidth = 1;
//        marginX = 2;
        marginX = 3;
        marginY = 3;

        for(int i = 37; i < alfabeto.length(); i++) {
            gbc.gridx = i-37+marginX;
            gbc.gridy = marginY;
            teclas[i] = new JButton(alfabeto.charAt(i) + "");
            teclas[i].setMinimumSize(new Dimension(50,50));
            teclas[i].setPreferredSize(new Dimension(100,100));
            container_teclas.add(teclas[i], gbc);
            lista_botoes.add(teclas[i]);
        }

        gbc.gridx = alfabeto.length() - 37 + marginX;
        gbc.gridy = 3;
        up = new JButton("^");
        up.setMinimumSize(new Dimension(50,50));
        up.setPreferredSize(new Dimension(100,100));
        container_teclas.add(up, gbc);

        gbc.gridy = 4;

        gbc.gridx = alfabeto.length() - 37 + marginX - 1;
        left = new JButton("<");
        left.setMinimumSize(new Dimension(50,50));
        left.setPreferredSize(new Dimension(100,100));
        container_teclas.add(left, gbc);

        gbc.gridx += 1;
        down = new JButton("v");
        down.setMinimumSize(new Dimension(50,50));
        down.setPreferredSize(new Dimension(100,100));
        container_teclas.add(down, gbc);

        gbc.gridx += 1;
        right = new JButton(">");
        right.setMinimumSize(new Dimension(50,50));
        right.setPreferredSize(new Dimension(100,100));
        container_teclas.add(right, gbc);


        gbc.gridx = 4;
        gbc.gridwidth = 6;
        space = new JButton(" ");
        space.setMinimumSize(new Dimension(300, 50));
        space.setPreferredSize(new Dimension(300, 50));
        container_teclas.add(space, gbc);

        lista_botoes.add(tab);
        lista_botoes.add(backspace);
        lista_botoes.add(shift);
        lista_botoes.add(enter);
        lista_botoes.add(caps);
        lista_botoes.add(space);
        lista_botoes.add(up);
        lista_botoes.add(down);
        lista_botoes.add(left);
        lista_botoes.add(right);
//        caps, backspace, shift, enter, space, up, down, left, right);

        Container container_area_texto = new Container();
        container_area_texto.setLayout(new BorderLayout());

        textArea = new JTextArea();
        textArea.setRows(3);
        textArea.setFont(new Font("arial",Font.PLAIN, 32));


        textArea.setBorder(new LineBorder(Color.GRAY, 1));
        String primeira_texto_notas_cabecalho = "Type some text using your keyboard. The keys you press will be highlighted and the text will be displayed.";
        String segunda_texto_notas_cabecalho = "\nNote: Clicking the buttons with your mouse will not perform any actions.";

        textArea.setEditable(false);
        pangram = "";
//        notas_cabecalho = new Label(texto_notas_cabecalho);

        Frame este_frame = this;

        selecionar_pangram = new JButton("Pangram");
        selecionar_pangram.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                EscolherPangramFrame escolherPangramFrame = new EscolherPangramFrame(este_frame);
            }
        });

        espacamento = new Label("  ");

        Container borda_botao_selecionar_pangram = new Container();
        borda_botao_selecionar_pangram.setLayout(new BorderLayout());
        borda_botao_selecionar_pangram.add(selecionar_pangram, BorderLayout.CENTER);
        borda_botao_selecionar_pangram.add(new JLabel(espacamento.getText()), BorderLayout.EAST);
        borda_botao_selecionar_pangram.add(new JLabel(espacamento.getText()), BorderLayout.WEST);
        borda_botao_selecionar_pangram.add(new JLabel(espacamento.getText()), BorderLayout.NORTH);
        borda_botao_selecionar_pangram.add(new JLabel(espacamento.getText()), BorderLayout.SOUTH);

        Container container_labels = new Container();
        container_labels.setLayout(new GridLayout(3, 1));
        container_labels.add(new Label(primeira_texto_notas_cabecalho));
        container_labels.add(new Label(segunda_texto_notas_cabecalho));
        container_labels.add(new Label("Clique na area de texto para digitar"));
        pangram_label = new JLabel("");
//        container_labels.add(pangram_label);
        container_area_texto.add(pangram_label, BorderLayout.SOUTH);

        Container container_escolher_pangram = new Container();
        container_escolher_pangram.setLayout(new BorderLayout());

        container_escolher_pangram.add(container_labels, BorderLayout.CENTER);
//        container_escolher_pangram.add(selecionar_pangram, BorderLayout.EAST);
//        container_escolher_pangram.add(borda_botao_selecionar_pangram, BorderLayout.EAST);

        container_area_texto.add(textArea, BorderLayout.CENTER);
        container_area_texto.add(container_escolher_pangram, BorderLayout.NORTH);

        this.add(container_area_texto, BorderLayout.NORTH);
        this.add(container_teclas, BorderLayout.CENTER);
//        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        this.add(new Label(espacamento.getText()), BorderLayout.WEST);
        this.add(new Label(espacamento.getText()), BorderLayout.EAST);
        container_area_texto.add(new Label(espacamento.getText() + espacamento.getText()), BorderLayout.WEST);
        container_area_texto.add(new Label(espacamento.getText() + espacamento.getText()), BorderLayout.EAST);

        Logica_Teclado lt = new Logica_Teclado(lista_botoes, this);
        lt.setFocusable(true);
        lt.requestFocus();

        textArea.addKeyListener(lt);

        this.addKeyListener(lt);
        this.setFocusable(true);
//        iniciarMenu();
    }

    public void compare() {
        if(pangram.substring(0, index).equals(textArea.getText())) {

        } else {
            System.out.println(pangram.substring(0, index) + " vs " + textArea.getText());
            error++;
        }
    }

    public void compare_final() {
        for(int i = 0; i < Math.min(textArea.getText().length(), pangram.length()); i++) {
            if(pangram.charAt(i) == textArea.getText().charAt(i)) {
                acerto++;
            }
        }
    }

    public String getPangram() {
        return pangram;
    }
    public ArrayList<JButton> getLista_botoes() {
        return lista_botoes;
    }

    public void selecionarPangram(String text) {
        pangram = text;
        pangram_label.setText(pangram);
        index = 0;
        error = 0;
        acerto = 0;
    }

    public void decrementarIndice() {

        index = Math.max(0, index-1);
    }

    public char pegarLetra() {
        index++;
        if(index-1 < pangram.length()) {
            return pangram.charAt(index-1);
        }
        return '0';
    }

//    private void iniciarMenu() {
//        JMenu pangramMenu = new JMenu("Pangram");
//        pangramMenu.setMnemonic('p');
//
//        carregarPangrans();
//        radio_pangram = new JRadioButtonMenuItem[caminhos.length];
//
//        grupo_radio = new ButtonGroup();
//
//        for(int i = 0; i < radio_pangram.length; i++) {
//            radio_pangram[i] = new JRadioButtonMenuItem(alf.charAt(i) + " - " + pangrans[i]);
//            grupo_radio.add(radio_pangram[i]);
//            pangramMenu.add(radio_pangram[i]);
//            map_radio_pangram.put(radio_pangram[i], pangrans[i]);
//            radio_pangram[i].addActionListener(new ActionListener() {
//                @Override
//                public void actionPerformed(ActionEvent e) {
//                    selecionarPangram(map_radio_pangram.get(e.getSource()));
//                }
//            });
//        }
//
//        JMenuBar bar = new JMenuBar();
//        this.setJMenuBar(bar);
//
//        bar.add(pangramMenu);
//    }

    private void iniciarTab() {
        Container escolherPangramFrame = new EscolherPangramFrame(this);

    }
    private void carregarPangrans() {
        pangrans = new String[caminhos.length];
        LeitorArquivos fileHandler = new LeitorArquivos();

        for(int i = 0; i <caminhos.length; i++) {
            pangrans[i] = fileHandler.readFile(caminhos[i]);
        }
    }

    public JTextArea getTextArea() {
        return textArea;
    }

    public void comopare() {
        if(textArea.getText().equals(pangram)) {
            coutErros++;
        }
    }
}


class EscolherPangramFrame extends JFrame {

    private JRadioButton[] botoesRadio;
    private ButtonGroup grupo_de_botoes;

    private String[] pangrans;
    private String[] caminhos = {"primeiro_pangram.txt", "segundo_pangram.txt", "terceiro_pangram.txt", "quarto_pangram.txt", "quinto_pangram.txt"};

    private JButton selecionar;
    private final String alf = "ABCDEFGHI";

    public EscolherPangramFrame(Frame frame) {
        super("Escolher Pangram\n");
        setSize(400, 400);

        setLayout(new GridLayout(caminhos.length*2+1, 1));
        botoesRadio = new JRadioButton[caminhos.length];

        carregarPangrans();
        grupo_de_botoes = new ButtonGroup();

        for(int i = 0; i < pangrans.length; i++) {
            System.out.println(i + pangrans[i]);
            this.add(new Label(alf.charAt(i) + " - " + pangrans[i]));
        }

        for(int i = 0; i < botoesRadio.length; i++) {
            botoesRadio[i] = new JRadioButton(alf.charAt(i)+"");
            grupo_de_botoes.add(botoesRadio[i]);
            this.add(botoesRadio[i]);
        }

        selecionar = new JButton("Selecionar");

        selecionar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.getTextArea().setText("");
                for(int i = 0; i < grupo_de_botoes.getButtonCount(); i++) {
                    if(botoesRadio[i].isSelected()) fecharJanela(frame, pangrans[i]);
                }
            }
        });
        this.add(selecionar);

//        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }

    private void fecharJanela(Frame frame, String pangram) {
        frame.selecionarPangram(pangram);
//        this.dispatchEvent(new WindowEvent(this, WindowEvent.WINDOW_CLOSED));
        dispose();
    }

    private void carregarPangrans() {
        pangrans = new String[caminhos.length];
        LeitorArquivos fileHandler = new LeitorArquivos();

        for(int i = 0; i <caminhos.length; i++) {
            pangrans[i] = fileHandler.readFile(caminhos[i]);
        }
    }

}

