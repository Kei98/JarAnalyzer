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
 * @author AyJK
 *
 */
@SuppressWarnings("serial")
public class JarPanel extends JPanel {

    private JTextField field;
    private JButton search;
    private JButton read;
    private String directory;
    private ReadAL readAl;

    public JarPanel() {
    	JLabel text = new JLabel("Seleccione Jar por analizar");
    	add(text);
    	field = new JTextField(20);
    	add(field);
    	search = new JButton("BUSCAR");
    	Search searching = new Search();
    	search.addActionListener(searching);
    	add(search);
    	
    	read = new JButton("ANALIZAR");
    	add(read);
    	
    }

   
    private class Search implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent arg0) {
	    JFileChooser selectorArchivos = new JFileChooser();
	    selectorArchivos.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
	    int val = selectorArchivos.showOpenDialog(null);

	    if (val == JFileChooser.OPEN_DIALOG) {
		String pathAbsoluto = selectorArchivos.getSelectedFile().getAbsolutePath();
		directory = pathAbsoluto;
		directory = directory.replace("\\", "/");
		field.setText(directory);
		
		readAl = new ReadAL(directory);
		read.addActionListener(readAl);
		
		
	    }
	}
    }

    public String getDirectory() {
	return directory;
    }

	public ReadAL getReadAl() {
		return readAl;
	}
    

}