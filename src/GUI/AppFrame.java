package GUI;

import com.company.compressor;
import com.company.decompressor;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

public class AppFrame extends JFrame implements ActionListener {
    JButton compressButton;
    JButton decompressButton;
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        compressButton = new JButton("select file to compress");
        compressButton.addActionListener(this);
        compressButton.setBounds(20,100,200,30);

        decompressButton = new JButton("select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);

        this.add(compressButton);
        this.add(decompressButton);
        this.setSize(500,200);
        this.getContentPane().setBackground(Color.black);
        this.setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==compressButton){
            JFileChooser fileChooser = new JFileChooser();
            int response = fileChooser.showSaveDialog(null);

            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    compressor.method(file);
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
        if(e.getSource()==decompressButton){
            JFileChooser filechooser = new JFileChooser();
            int response = filechooser.showSaveDialog(null);
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                } catch (Exception excp) {
                    JOptionPane.showMessageDialog(null,excp.toString());
                }
            }
        }
    }
}
