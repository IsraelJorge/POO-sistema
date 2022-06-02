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
    JCheckBox cbListar;
    JTextArea taListar;
    Calculadora c = new Calculadora();
    
    JMenuBar mbBarra;
    JMenu mArquivo, mDuvidas;
    JMenuItem miLimpar, miSair, miSobre;

    JComboBox cbEstado, cbCidade;
    String[] ma = { "", "Imperatriz", "Açailândia", "São Luis" };
    String[] pa = { "", "Belém", "Marabá", "Satarém" };
    String[] pi = { "", "Canto da Serra", "Bom Jesus", "Floriano" };
 
    public Sistema() {
        setLayout(new FlowLayout());
        setSize(500, 500);
        setVisible(true);
        setTitle("Sistema");

        miLimpar = new JMenuItem("Limpar");
        miLimpar.addActionListener(this);
        
        miSair = new JMenuItem("Sair");
        miSair.addActionListener(this);

        miSobre = new JMenuItem("Sobre");
        miSobre.addActionListener(this);
        
        mArquivo = new JMenu("Arquivo");
        mArquivo.add(miLimpar);
        mArquivo.addSeparator();
        mArquivo.add(miSair);

        mDuvidas = new JMenu("Duvidas");
        mDuvidas.add(miSobre);
        
        mbBarra = new JMenuBar();
        mbBarra.add(mArquivo);
        mbBarra.add(mDuvidas);
        setJMenuBar(mbBarra);

        lValor1 = new JLabel("Valor 1");
        add(lValor1);
        tfValor1 = new JTextField(5);
        tfValor1.setDocument(new SoNumeros());
        tfValor1.setToolTipText("Digite o Valor 1");
        tfValor1.addActionListener(this);
        add(tfValor1);

        lValor2 = new JLabel("Valor 2");
        add(lValor2);
        tfValor2 = new JTextField(5);
        tfValor2.setDocument(new SoNumeros());
        tfValor2.addActionListener(this);;
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

        cbListar = new JCheckBox("Listar");
        cbListar.addActionListener(this);;
        add(cbListar);

        taListar = new JTextArea(10, 20);
        taListar.setEditable(false);
        add(taListar);

        String[] estado = { "", "Maranhão", "Pará", "Piauí" };
        cbEstado = new JComboBox(estado);
        cbEstado.addActionListener(this);
        add(cbEstado);

        cbCidade = new JComboBox();
        add(cbCidade);


    }



    public static void main(final String[] args) throws Exception {
        final Sistema s = new Sistema();
        s.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getSource() == tfValor1) {
            tfValor2.requestFocus();
        }

        if (ae.getSource() == tfValor2) {
            tfValor1.requestFocus();
        }

        if (ae.getSource() == bSoma) {
            if(tfValor1.getText().length() > 0 && tfValor2.getText().length() > 0 ){
                int valor1 = Integer.parseInt(tfValor1.getText()); // Transforma uma String em int (Em um valor);
                int valor2 = Integer.parseInt(tfValor2.getText());
                
                int res = c.soma(valor1, valor2);            

                tfRes.setText(String.valueOf(res)); //Transforma um  valor em em String;

                if (cbListar.isSelected()) {
                    taListar.setText(taListar.getText() + valor1 + " + " + valor2 + " = " + res + "\n");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Campo Vazio.", 
                    "Digite um valor inteiro.", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (ae.getSource() == bSub) {
            if (tfValor1.getText().length() > 0 && tfValor2.getText().length() > 0) {
                int valor1 = Integer.parseInt(tfValor1.getText()); // Transforma uma String em int (Em um valor);
                int valor2 = Integer.parseInt(tfValor2.getText());

                int res = c.sub(valor1, valor2);

                tfRes.setText(String.valueOf(res));

                if(cbListar.isSelected()){
                    taListar.setText(taListar.getText() + valor1 + " - " + valor2 + " = " + res +"\n");
                }

            } else {
                JOptionPane.showMessageDialog(null, 
                    "Campo Vazio.", 
                    "Digite um valor inteiro.", 
                    JOptionPane.INFORMATION_MESSAGE);    
            }
        }
       
        if (ae.getSource() == bMult) {
            if (tfValor1.getText().length() > 0 && tfValor2.getText().length() > 0) {
                int valor1 = Integer.parseInt(tfValor1.getText());
                int valor2 = Integer.parseInt(tfValor2.getText());

                int res = c.mult(valor1, valor2);

                tfRes.setText(String.valueOf(res));

                if (cbListar.isSelected()) {
                    taListar.setText(taListar.getText() + valor1 + " * " + valor2 + " = " + res +"\n");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Campo Vazio.", 
                    "Digite um valor inteiro.", 
                    JOptionPane.INFORMATION_MESSAGE); 
            }
        }

        if (ae.getSource() == bDiv) {
            if (tfValor1.getText().length() > 0 && tfValor2.getText().length() > 0) {
                double valor1 = Double.valueOf(tfValor1.getText());
                double valor2 = Double.valueOf(tfValor2.getText());

                double res = c.div(valor1, valor2);

                tfRes.setText(String.valueOf(res));

                if (cbListar.isSelected()) {
                    taListar.setText(taListar.getText() + valor1 + " / " + valor2 + " = " + res + "\n");
                }
                
            } else {
                JOptionPane.showMessageDialog(null, 
                    "Campo Vazio.", 
                    "Digite um valor inteiro.", 
                    JOptionPane.INFORMATION_MESSAGE);
            }
        }

        if (ae.getSource() == bLimpar || ae.getSource() == miLimpar) {
            tfValor1.setText(""); // Para limpar a caixa de texto
            tfValor2.setText("");
            tfRes.setText("");
            
            taListar.setText("");

            tfValor1.requestFocus();
        }

        if (ae.getSource() == bSair || ae.getSource() == miSair) {
            System.exit(0);
        }

        if (ae.getSource() == cbListar) {
            taListar.setText("");
        }

        if (ae.getSource() == miSobre) {
            Sobre s = new Sobre();
        }

        if (ae.getSource() == cbEstado) {
            switch (cbEstado.getSelectedIndex()) {
                case 0:
                    cbCidade.removeAllItems();
                    break;
                
                case 1:
                    cbCidade.removeAllItems();
                    for (int i = 0; i <= 3; i++) {
                        cbCidade.insertItemAt(ma[i], i);
                    }
                    break;
                
                case 2:
                    cbCidade.removeAllItems();
                    for (int i = 0; i <= 3; i++) {
                        cbCidade.insertItemAt(pa[i], i);
                    }
                    break;

                case 3:
                    cbCidade.removeAllItems();
                    for (int i = 0; i <= 3; i++) {
                        cbCidade.insertItemAt(pi[i], i);
                    }
                    break;
                    
                
            }
        }
    }
}