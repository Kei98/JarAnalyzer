package com.AyJK.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import com.AyJK.analyzer.*;

import javax.swing.JFrame;
import javax.swing.JScrollPane;

public class Main {

	public static void main(String[] args) throws Exception {
		//aqui la GUI de solo el grafo...
        EventQueue.invokeLater(new Runnable() {

            public void run() {
                JFrame f = new JFrame("GraphPanel");
                f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                Draw gp = new Draw();
                f.add(gp.control, BorderLayout.NORTH);
                f.add(new JScrollPane(gp), BorderLayout.CENTER);
                f.getRootPane().setDefaultButton(gp.control.defaultButton);
                f.pack();
                f.setLocationByPlatform(true);
                f.setVisible(true);
            }
        });
    
		/////////////////////////////////////
        //aqui esta la otra GUI
		//JarFrame frame = new JarFrame();
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		//Analyzer analyzer = new Analyzer(frame.getPanelJar().getDirectory());
		
	}
}

// class JarFrame extends JFrame {
//
// public JarFrame() {
//
// setBounds(400, 300, 300, 150);
//
// JarPanel panel = new JarPanel();
//
// add(panel);
//
// setVisible(true);
// }
//
// }

// class JarPanel extends JPanel {
//
// private JTextField field;
//
// private JButton search;
//
// private JButton read;
//
// public JarPanel(){
//
// JLabel text=new JLabel("Seleccione Jar por analizar");
//
// add(text);
//
// field=new JTextField(20);
//
// add(field);
//
// search=new JButton("BUSCAR");
//
// read=new JButton("ANALIZAR");
//
// Search searching = new Search();
//
// ReadAL reading = new ReadAL();
//
//
// search.addActionListener(searching);
//
// read.addActionListener(reading);
//
// add(search);
//
// add(read);
//
// }
//
// private class Search implements ActionListener{
//
// @Override
// public void actionPerformed(ActionEvent arg0) {
// // TODO Auto-generated method stub
// System.out.println("buscando la mierda");
// //buscar el archivo
// JFileChooser selectorArchivos = new JFileChooser();
// selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
// int val = selectorArchivos.showOpenDialog(null);
//
// if (val == JFileChooser.OPEN_DIALOG) {
// String pathAbsoluto = selectorArchivos.getSelectedFile().getAbsolutePath();
// System.out.println(pathAbsoluto);
// String directorioActual = selectorArchivos.getCurrentDirectory().getPath();
// System.out.println(directorioActual);
//
// /*JOptionPane.showMessageDialog(null, "Directorio: " + pathAbsoluto+ "path:
// "+directorioActual);
//
// boolean isArchivoRenombrado = selectorArchivos.getSelectedFile().renameTo(new
// File(directorioActual + "\\text1.png"));//este ultimo puede ser una variable
// y que la consultes por consola o con un dialogo.
//
// if (isArchivoRenombrado){
// JOptionPane.showMessageDialog(null, "exito al renombrar archivo");
// }
//
// } else if (val == JFileChooser.CANCEL_OPTION) {
// JOptionPane.showMessageDialog(null, "Proceso cancelado ");
// }*/
// }
// }
// }

// private class ReadAL implements ActionListener{
// @Override
// public void actionPerformed(ActionEvent arg0) {
// // TODO Auto-generated method stub
// System.out.println("enviar a read pos pa que lo lea");
// }
// }
// }
