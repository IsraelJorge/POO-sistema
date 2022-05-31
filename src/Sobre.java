import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.*;

public class Sobre extends JFrame implements ActionListener, MouseInputListener {
    
    JTextArea ta, teste;
    JButton bSair;

    public Sobre() {
        setLayout(new FlowLayout());
        setSize(300, 400);
        setVisible(true);

        ta = new JTextArea();
        ta.setText("Sistema 1.0\nCriado em " + "25/05/2022");
        ta.setEditable(false);
        add(ta);

        teste = new JTextArea();
        add(teste);

        bSair = new JButton("SAIR");
        bSair.addActionListener(this);
        add(bSair);

        addMouseListener(this);

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == bSair) {
            setVisible(false);
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        teste.setText("Clique");
    
    }

    @Override
    public void mousePressed(MouseEvent me) {
        teste.setText("Segura");
    }

    @Override
    public void mouseReleased(MouseEvent me) {
        teste.setText("Soltando");
    }
    
    @Override
    public void mouseEntered(MouseEvent me) {
        teste.setText("Entrou");
    }

    @Override
    public void mouseExited(MouseEvent me) {
        teste.setText("Saiu");
    }

    @Override
    public void mouseDragged(MouseEvent me) {
        teste.setText("Arrastando");
    }

    @Override
    public void mouseMoved(MouseEvent me) {
        teste.setText("Se mexendo");
    }
    

}
