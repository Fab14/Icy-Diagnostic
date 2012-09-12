package plugins.fab.icydiagnose;

import icy.file.FileUtil;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class WriteAccessTest {

	public static void writeAccessTest(Logger logger) {

		logger.outTitle( "Write access in root folder of icy" );

		boolean testOk = true;
		
		try {
			File testFile = new File( new java.io.File(".").getCanonicalPath()+FileUtil.separator + "icy diagnose test file.txt" );
			
			logger.out( "Test file: " + testFile.toString() );
			
			// write in it.
			
			FileWriter fstream = new FileWriter( testFile , false );
			BufferedWriter outBuffer = new BufferedWriter(fstream);
			outBuffer.write("test");
			outBuffer.close();
			
			// delete it.
			
			testFile.delete();
					
		} catch (IOException e) {
			logger.out( "Error" );
			logger.out( e.getStackTrace().toString() );
			testOk = false;
		}
				
		logger.out( "Test success: " + testOk );

		
	}

}
