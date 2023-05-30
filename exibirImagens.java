import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;

public class exibirImagens implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JButton escolher, retornar;
    private JLabel msgEscolha, exibicao;

    private File imagem;
    private ImageIcon icon;

    public exibirImagens(){
        frame = new JFrame();
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        msgEscolha = new JLabel("Escolha uma das fotos salvas:");
        msgEscolha.setBounds(5, 5, 175, 20);
        panel.add(msgEscolha);

        escolher = new JButton("Escolher");
        escolher.setBounds(185, 5, 90, 20);
        escolher.addActionListener(this);
        panel.add(escolher);

        retornar = new JButton("Voltar");
        retornar.setBounds(285, 5, 90, 20);
        retornar.addActionListener(this);
        panel.add(retornar);

        frame.setVisible(true);
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == escolher){
            JFileChooser fc = new JFileChooser(System.getProperty("user.dir"));
                fc.setFileFilter(new JPEGImageFileFilter());
                int res = fc.showOpenDialog(null);
                if (res == JFileChooser.APPROVE_OPTION){
                    imagem = fc.getSelectedFile();
                    frame.setTitle(imagem.getName());
                    icon = new ImageIcon(imagem.getPath());
                    try {
                        BufferedImage foto = ImageIO.read(imagem);
                        frame.setSize(foto.getWidth(), foto.getHeight());
                        exibicao = new JLabel(icon);
                        exibicao.setBounds(0, 0, frame.getWidth(), frame.getHeight());
                        panel.add(exibicao);
                        panel.remove(msgEscolha);
                        panel.remove(escolher);
                        retornar.setBounds(1280, 665, 70, 25);
                        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                } else {
                    JOptionPane.showMessageDialog(frame,"Você deve selecionar uma foto para ser exibida", "Atenção",2);
                }
        } else if (e.getSource() == retornar){
            frame.dispose();
        }
    }
}