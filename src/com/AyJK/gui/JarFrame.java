/**
 * 
 */
package com.AyJK.gui;

import javax.swing.JFrame;

/**
 * @author Jonathan
 *
 */
@SuppressWarnings("serial")
public class JarFrame extends JFrame {

    public JarFrame() {
	setBounds(400, 300, 300, 150);
	JarPanel panel = new JarPanel();
	add(panel);
	setVisible(true);
    }
}