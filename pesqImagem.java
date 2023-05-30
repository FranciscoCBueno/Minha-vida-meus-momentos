import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class pesqImagem implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JLabel imagem;
    private JButton retornar;

    private File dir;
    private ImageIcon icon;

    public pesqImagem(String arquivo){
        frame = new JFrame("Pesquisar Imagem");
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        dir = new File(System.getProperty("user.dir"));
        File[] arquivos = dir.listFiles(new JPEGImageFileFilter());

        if (arquivos != null){
            for (File x : arquivos){
                if(x.getName().equals(arquivo+".jpg") || x.getName().equals(arquivo+".jpeg")){
                    frame = new JFrame(arquivo);
                    frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    
                    panel = new JPanel();
                    panel.setLayout(null);
                    frame.add(panel);

                    icon = new ImageIcon(x.getPath());
                    imagem = new JLabel(icon);
                    imagem.setBounds(0, 0, 1000, 700);
                    panel.add(imagem);

                    retornar = new JButton("Voltar");
                    retornar.setBounds(1280, 665, 70, 25);
                    retornar.addActionListener(this);
                    panel.add(retornar);

                    frame.setVisible(true);
                    return;
                }
            } JOptionPane.showMessageDialog(null, "Arquivo não encontrado", "Erro", 0);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhuma foto salva");
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        frame.dispose();
    }
}