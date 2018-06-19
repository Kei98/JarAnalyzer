/**
 * 
 */
package com.AyJK.analyzer;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author AyJK
 *
 */
public class Analyzer {

    private String ruta;
    private ArrayList<String> list = new ArrayList<>();

    public Analyzer(String rute) throws IOException {
	this.ruta = rute;
	
	@SuppressWarnings("resource")
	ZipFile zipFile = new ZipFile(ruta);

	// String donde se almacenará la información del JAR.
	String allString = "";

	Enumeration<? extends ZipEntry> entries = zipFile.entries();

	while (entries.hasMoreElements()) {
	    ZipEntry zipEntry = entries.nextElement();
	    InputStream inputStream = zipFile.getInputStream(zipEntry);
	    BufferedReader bufferedReader = new BufferedReader(
		    new InputStreamReader(inputStream, Charset.forName("UTF-8")));
	    String string = null;

	    while ((string = bufferedReader.readLine()) != null) {
		allString += "\n" + string;
	    }
	}

	// Array de Strings que separa hasta encontrar lo que está contenido en
	// <project.
	String[] parts = allString.split("<project");

	// El String html será igual a lo contenido en parts[1] que es la info que se
	// encuentra despues de <project.
	String html = parts[1];

	// Se agrega en <project para que sea el XML completo
	html = "<project" + html;

	// System.out.println(html);

	html = html.replaceAll("\n", "").replaceAll("\r", "").replaceAll("\\s{2,}", " ").trim();

	// *Muestra el html/
	// System.out.println(html);

	Pattern pDescript = Pattern.compile("<artifactId>(.*?)</artifactId>", Pattern.MULTILINE);
	Matcher mDescrip = pDescript.matcher(html);

	while (mDescrip.find()) {
	    System.out.println(mDescrip.group(1));
	    list.add(mDescrip.group(1));
	}
    }
}