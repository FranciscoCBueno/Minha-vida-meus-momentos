import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class addImagem implements ActionListener{
    private JFrame frame;
    private JPanel panel;
    private JLabel escolha, imagemEscolhida;
    private JButton escolherArquivo, concluido, cancelar;

    private File imagem = null;
    private File novaImagem;
    private ImageIcon icon;

    public addImagem(){
        frame = new JFrame("Adicionar nova foto");
        frame.setSize(400, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationRelativeTo(null);

        panel = new JPanel();
        panel.setLayout(null);
        frame.add(panel);

        escolha = new JLabel("Escolha o arquivo (JPEG):");
        escolha.setBounds(5, 5, 145, 20);
        panel.add(escolha);

        escolherArquivo = new JButton("Escolher");
        escolherArquivo.setBounds(160, 5, 85, 20);
        escolherArquivo.addActionListener(this);
        panel.add(escolherArquivo);

        concluido = new JButton("Concluído");
        concluido.setBounds(1255, 655, 90, 30);
        concluido.addActionListener(this);
        panel.add(concluido);

        cancelar = new JButton("Cancelar");
        cancelar.setBounds(260, 5, 85, 20);
        cancelar.addActionListener(this);
        panel.add(cancelar);

        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == concluido){
            if (imagem != null){
                String nome = JOptionPane.showInputDialog(frame, "Dê um nome para este momento (não use nomes iguais)") + imagem.getName().substring(imagem.getName().lastIndexOf("."));
                frame.dispose();
                copiar(imagem.getPath(), System.getProperty("user.dir"));
                File novoNome = new File(novaImagem.getParent(), nome);
                novaImagem.renameTo(novoNome);
                JOptionPane.showMessageDialog(null, "Foto salva com sucesso!", "Sucesso", 1);
            } else {
                frame.dispose();
            }
        }else if (e.getSource() == escolherArquivo){
            JFileChooser fc = new JFileChooser();
            fc.setFileFilter(new JPEGImageFileFilter());
            int res = fc.showOpenDialog(null);
            if (res == JFileChooser.APPROVE_OPTION){
                imagem = fc.getSelectedFile();
                icon = new ImageIcon(imagem.getPath());
                imagemEscolhida = new JLabel(icon);
                frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
                imagemEscolhida.setBounds(5, 20, 1280, 720);
                panel.add(imagemEscolhida);
                panel.remove(escolherArquivo);
                cancelar.setBounds(1150, 655, 85, 30);
            } else {
                JOptionPane.showMessageDialog(frame,"Você deve selecionar uma foto para ser adicionada", "Atenção",2);
            }
        } else if (e.getSource() == cancelar){
            frame.dispose();
        }
    }

    public void copiar(String origem, String destino){
        File arqOrigem = new File(origem);
        if (arqOrigem.exists()){
            File arqDestino = new File(destino + File.separator + arqOrigem.getName());
            try {
                InputStream fis = new FileInputStream(arqOrigem);
                OutputStream fos = new FileOutputStream(arqDestino);
                byte[] buffer = new byte[1024];
                int length;
                while ((length = fis.read(buffer)) > 0) {
                    fos.write(buffer, 0, length);
                }
                novaImagem = arqDestino;
                fis.close();
                fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}