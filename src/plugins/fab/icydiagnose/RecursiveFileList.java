package plugins.fab.icydiagnose;

import icy.file.FileUtil;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class RecursiveFileList {


	
	
	static void outputIcyFiles(Logger logger) {

		
		logger.outTitle( "Output recursive file list" );
		
		
		ArrayList<File> outPut = new ArrayList<File>();
		
		File startFile = null;
		try {
		
			startFile = new File( new java.io.File(".").getCanonicalPath() );			

		} catch (IOException e) {

			e.printStackTrace();
		}
				
		if ( startFile == null )
		{			
			return;
		}
		
		buildRecursiveFileList( startFile , outPut );

		for ( File file : outPut )
		{
			logger.out( file.toString() );
		}

	}

	private static ArrayList<File> buildRecursiveFileList(File startFile, ArrayList<File> outPutFileList) {
		
		for ( File file : startFile.listFiles() )
		{
			if ( file.isDirectory() )
			{
				buildRecursiveFileList( file , outPutFileList );
			}
			outPutFileList.add( file );					
		}
		return outPutFileList;
		
	}

	
}
