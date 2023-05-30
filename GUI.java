import javax.swing.*;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class GUI implements ActionListener {
    private JFrame frame;
    private JPanel panel;
    private JButton sair, exibirImagens, pesquisarImagem, addImg;
    private JLabel welcome, nome;

    public GUI(){
        //cria frame
        frame = new JFrame("Minha vida, meus momentos");
        frame.setSize(800, 600);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);
        
        //cria painel
        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);
        
        //cria botões
        sair = new JButton("Sair");
        sair.setBounds(285, 450, 240, 70);
        sair.addActionListener(this);
        panel.add(sair);

        exibirImagens = new JButton("Ver todas as fotos");
        exibirImagens.setBounds(285, 150, 240, 70);
        exibirImagens.addActionListener(this);
        panel.add(exibirImagens);

        pesquisarImagem = new JButton("Pesquisar por uma foto");
        pesquisarImagem.setBounds(285, 250, 240, 70);
        pesquisarImagem.addActionListener(this);
        panel.add(pesquisarImagem);

        addImg = new JButton("Adicionar nova foto");
        addImg.setBounds(285, 350, 240, 70);
        addImg.addActionListener(this);
        panel.add(addImg);


        //adiciona textos
        welcome = new JLabel();
        welcome.setFont(new Font("Dialog", Font.PLAIN, 30));
        welcome.setText("Bem-Vindo(a)");
        welcome.setBounds(320, 55, 800, 50);
        panel.add(welcome);

        nome = new JLabel("Login: FranciscoBueno");
        nome.setBounds(5, 545, 250, 15);
        panel.add(nome);

        //torna a janela visível
        frame.setVisible(true);
        frame.setResizable(false);
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == sair){
            frame.dispose();
        } else if (e.getSource() == addImg){
            new addImagem();
        } else if (e.getSource() == exibirImagens){
            new exibirImagens();
        } else if (e.getSource() == pesquisarImagem){
            new pesqImagem(JOptionPane.showInputDialog(frame, "Digite o nome do momento que está procurando", "Busca", 3));
        }
    }
}