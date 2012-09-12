package plugins.fab.icydiagnose;

import icy.file.FileUtil;
import icy.gui.dialog.MessageDialog;
import icy.plugin.abstract_.PluginActionable;

import java.io.File;
import java.util.Date;

import javax.swing.JFileChooser;

public class IcyDiagnose extends PluginActionable {

		
	@Override
	public void run() {

		File diagnoseFile = getOutPutFile();
		if (diagnoseFile == null )
		{
			MessageDialog.showDialog( "No output file: diagnose canceled.", MessageDialog.INFORMATION_MESSAGE );
			return;
		}
		
		Logger logger = new Logger( diagnoseFile );
				
		logger.outTitle( "Icy diagnose file generated on " + new Date( ).toString() );
		
		GeneralInfo.outPutGeneralInfo( logger );
		
		WriteAccessTest.writeAccessTest( logger );
		RecursiveFileList.outputIcyFiles( logger );
		
		
		logger.close();
		
	}

	File getOutPutFile()
	{

		JFileChooser fileChooser = new JFileChooser();
		fileChooser.setDialogType(JFileChooser.SAVE_DIALOG);
		int returnValue = fileChooser.showDialog( null , "Save Diagnose file");
		if(returnValue == JFileChooser.APPROVE_OPTION)
		{
			File XMLAppendfile = fileChooser.getSelectedFile();	
			XMLAppendfile = new File ( FileUtil.setExtension( XMLAppendfile.getAbsolutePath() , ".txt" ) );
			return XMLAppendfile;
		}
		return null;
	}
	
}
