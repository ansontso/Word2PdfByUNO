package com.word2pdf;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.ConnectException;
import com.sun.star.lang.*;
import org.*;

import com.artofsolving.jodconverter.DocumentConverter;
import com.artofsolving.jodconverter.openoffice.connection.OpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.connection.SocketOpenOfficeConnection;
import com.artofsolving.jodconverter.openoffice.converter.OpenOfficeDocumentConverter;

public class Word2PdfUNO {
	public static int word2PDF(String sourceFile , String destFile){
		try{
			File inputFile = new File(sourceFile);
			if(!inputFile.exists()){
				return -1;
			}
			
			File outputFile = new File(destFile);
			if(!outputFile.getParentFile().exists()){
				outputFile.getParentFile().mkdirs();
			}
			
			String OpenOffice_HOME = "D:\\Program Files (x86)\\OpenOffice 4";
			if(OpenOffice_HOME.charAt(OpenOffice_HOME.length()-1) !='\\'){
				OpenOffice_HOME +="\\";
			}
			
			String command = OpenOffice_HOME + "program\\soffice.exe -headless -accept=\"socket,host=127.0.0.1,port=9100;urp;\"";
			Process pro = Runtime.getRuntime().exec(command);
			OpenOfficeConnection connection = new SocketOpenOfficeConnection("127.0.0.1",8100);
			connection.connect();
			
			DocumentConverter converter = new OpenOfficeDocumentConverter(connection);
			converter.convert(inputFile, outputFile);
			
			connection.disconnect();
			pro.destroy();
			return 0;
			
		}catch(FileNotFoundException e){
			e.printStackTrace();
			return -1;
		}catch(ConnectException e){
			e.printStackTrace();
		}catch(IOException e){
			e.printStackTrace();
		}
		return 1;
	}
	
	public static void main(String[] args){
		String sourceFile = "D:\\word.docx";
		String destFile = "D:\\word\\word.pdf";
		Word2PdfUNO.word2PDF(sourceFile, destFile);
	}
}
