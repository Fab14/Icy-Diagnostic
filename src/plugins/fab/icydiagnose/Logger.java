package plugins.fab.icydiagnose;

import icy.gui.dialog.MessageDialog;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	BufferedWriter outBuffer = null;
	boolean failWriteDiagnoseFile = false;

	public Logger( File logFile ) {
		FileWriter fstream;

		try {
			fstream = new FileWriter( logFile , false );
			outBuffer = new BufferedWriter(fstream);
		} catch (IOException e) {			
			faileWriteDiagnoseFile();
		}
		}
	
	private void faileWriteDiagnoseFile() {
		failWriteDiagnoseFile = true;		
	}
	
	void out( String string )
	{
		try {
			outBuffer.write( string );
			outBuffer.write( '\r' );
			outBuffer.write( '\n' );			
		} catch (IOException e) {
			faileWriteDiagnoseFile();			
		}
	}

	void outTitle( String string )
	{
		String str ="";
		for (int i = 0 ; i < string.length() ; i++ )
		{
			str=str+"*";
		}

		out( str );
		out( string );
		out( str );
	}

	void close()
	{
		try {
			outBuffer.close();
		} catch (IOException e) {
			faileWriteDiagnoseFile();
		}

		if ( failWriteDiagnoseFile )
		{
			MessageDialog.showDialog( "Error: Diagnose can't write the diagnose file.", MessageDialog.ERROR_MESSAGE );
		}else
		{
			MessageDialog.showDialog( "Diagnose file created.", MessageDialog.INFORMATION_MESSAGE );
		}

	}

}
