/**
 * 
 */
package com.AyJK.gui;

import javax.swing.JFrame;

/**
 * @author AyJK
 *
 */
@SuppressWarnings("serial")
public class JarFrame extends JFrame {

    private JarPanel panelJar;

    public JarFrame() {
    	setBounds(400, 300, 300, 160);
    	this.panelJar = new JarPanel();
    	add(panelJar);
    	setVisible(true);
    }

    public JarPanel getPanelJar() {
    	return panelJar;
    }

}