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
    private Analyzer analyzer;
    
    public ReadAL(String route) {
    	this.route = route;
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
	try {
	    setAnalyzer(new Analyzer(route));
	} catch (IOException e) {
	    e.printStackTrace();
	}
	
    }

	/**
	 * @return the analyzer
	 */
	public Analyzer getAnalyzer() {
		return analyzer;
	}

	/**
	 * @param analyzer the analyzer to set
	 */
	private void setAnalyzer(Analyzer analyzer) {
		this.analyzer = analyzer;
	}
    
}