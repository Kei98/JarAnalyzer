/**
 * 
 */
package com.AyJK.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 * @author Jonathan
 *
 */
@SuppressWarnings("serial")
public class JarPanel extends JPanel {

    private JTextField field;
    private JButton search;
    private JButton read;
    private String directory;

    public JarPanel() {

	JLabel text = new JLabel("Seleccione Jar por analizar");
	add(text);
	field = new JTextField(20);
	add(field);
	search = new JButton("BUSCAR");
	read = new JButton("ANALIZAR");
	Search searching = new Search();
	ReadAL reading = new ReadAL();
	search.addActionListener(searching);
	read.addActionListener(reading);
	add(search);
	add(read);
    }

    private class Search implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
	    // TODO Auto-generated method stub
	    System.out.println("buscando la mierda");
	    // buscar el archivo
	    JFileChooser selectorArchivos = new JFileChooser();
	    selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    int val = selectorArchivos.showOpenDialog(null);

	    if (val == JFileChooser.OPEN_DIALOG) {
		String pathAbsoluto = selectorArchivos.getSelectedFile().getAbsolutePath();
		directory = pathAbsoluto;
		System.out.println(pathAbsoluto);
		String directorioActual = selectorArchivos.getCurrentDirectory().getPath();
		System.out.println(directorioActual);

		/*
		 * JOptionPane.showMessageDialog(null, "Directorio: " + pathAbsoluto+
		 * "path: "+directorioActual);
		 * 
		 * boolean isArchivoRenombrado = selectorArchivos.getSelectedFile().renameTo(new
		 * File(directorioActual + "\\text1.png"));//este ultimo puede ser una variable
		 * y que la consultes por consola o con un dialogo.
		 * 
		 * if (isArchivoRenombrado){ JOptionPane.showMessageDialog(null,
		 * "exito al renombrar archivo"); }
		 * 
		 * } else if (val == JFileChooser.CANCEL_OPTION) {
		 * JOptionPane.showMessageDialog(null, "Proceso cancelado "); }
		 */
	    }
	}
    }

    public String getDirectory() {
	return directory;
    }
}