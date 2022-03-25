import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.*;


public class Sistema extends JFrame 
                                    implements ActionListener {
    private static final long serialVersionUID = 1L;
    
    JLabel lValor1, lValor2, lRes;
    JTextField tfValor1, tfValor2, tfRes;
    JButton bSoma, bSub, bMult, bDiv, bLimpar, bSair;
    Calculadora c = new Calculadora();                                      

    public Sistema() {
        setLayout(new FlowLayout());
        setSize(400, 500);
        setVisible(true);
        setTitle("Sistema");

        lValor1 = new JLabel("Valor 1");
        add(lValor1);
        tfValor1 = new JTextField(5);
        tfValor1.setToolTipText("Digite o Valor 1");
        add(tfValor1);

        lValor2 = new JLabel("Valor 2");
        add(lValor2);
        tfValor2 = new JTextField(5);
        add(tfValor2);

        lRes = new JLabel("Resposta");
        add(lRes);
        tfRes = new JTextField(5);
        tfRes.setEditable(false); //Tira e edição do campo de texto.
        add(tfRes);

        bSoma = new JButton("Somar");
        bSoma.addActionListener(this);
        add(bSoma);
        
        bSub = new JButton("Subtrair");
        bSub.addActionListener(this);
        add(bSub);
        
        bMult = new JButton("Multiplicar");
        bMult.addActionListener(this);
        add(bMult);

        bDiv = new JButton("Dividir");
        bDiv.addActionListener(this);
        add(bDiv);
        
        bLimpar = new JButton("Limpar");
        bLimpar.addActionListener(this);
        add(bLimpar);
        
        bSair = new JButton("Sair");
        bSair.addActionListener(this);
        add(bSair);
    }



    public static void main(final String[] args) throws Exception {
        final Sistema s = new Sistema();
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        
        if (ae.getSource() == bSoma) {
            int valor1 = Integer.parseInt(tfValor1.getText()); // Transforma uma String em int (Em um valor);
            int valor2 = Integer.parseInt(tfValor2.getText());
            
            int res = c.soma(valor1, valor2);            

            tfRes.setText(String.valueOf(res)); //Transforma um  valor em em String;
        }

        if (ae.getSource() == bSub) {
            int valor1 = Integer.parseInt(tfValor1.getText()); // Transforma uma String em int (Em um valor);
            int valor2 = Integer.parseInt(tfValor2.getText());
            
            int res = c.sub(valor1, valor2);
            
            tfRes.setText(String.valueOf(res));
        }
       
        if (ae.getSource() == bMult) {
            int valor1 = Integer.parseInt(tfValor1.getText());
            int valor2 = Integer.parseInt(tfValor2.getText());

            int res = c.mult(valor1, valor2);

            tfRes.setText(String.valueOf(res));
        }

        if (ae.getSource() == bDiv) {
            double valor1 = Double.valueOf(tfValor1.getText());
            double valor2 = Double.valueOf(tfValor2.getText());

            double res = c.div(valor1, valor2);

            tfRes.setText(String.valueOf(res));
        }

        if (ae.getSource() == bLimpar) {
            tfValor1.setText(""); // Para limpar a caixa de texto
            tfValor2.setText("");
            tfRes.setText("");
        }

        if (ae.getSource() == bSair) {
            System.exit(0);
        }
    }
}