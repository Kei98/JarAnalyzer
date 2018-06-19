/**
 * 
 */
package com.AyJK.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import com.AyJK.analyzer.Analyzer;

/**
 * @author AyJK
 *
 */
public class ReadAL implements ActionListener {

	private String route;

	public ReadAL(String route) {
		this.route = route;
	}

	@SuppressWarnings("unused")
	@Override
	public void actionPerformed(ActionEvent arg0) {
		try {
			Analyzer analyzer = new Analyzer(route);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("enviar a read pos pa que lo lea");
	}
}