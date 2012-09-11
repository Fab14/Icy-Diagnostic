package plugins.fab.icydiagnose;

import icy.plugin.abstract_.PluginActionable;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class IcyDiagnose extends PluginActionable {

	

	@Override
	public void run() {

		
		outputIcyFiles();

	}

	private void outputIcyFiles() {

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
			System.out.println( file );
		}

	}

	private ArrayList<File> buildRecursiveFileList(File startFile, ArrayList<File> outPutFileList) {
		
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
