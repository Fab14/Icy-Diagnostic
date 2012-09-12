package plugins.fab.icydiagnose;

import icy.main.Icy;
import icy.system.SystemUtil;

public class GeneralInfo {

	public static void outPutGeneralInfo(Logger logger) {

		logger.outTitle( "Icy");

		logger.out( "Icy version: " + Icy.version );
		
		logger.outTitle( "Java");
		
		logger.out( "Java name: " + SystemUtil.getJavaName() );
		logger.out( "Java version: " + SystemUtil.getJavaVersion() );
		logger.out( "Java arch data model: " + SystemUtil.getJavaArchDataModel() );
		logger.out( "Java total memory: " + SystemUtil.getJavaTotalMemory() );
		logger.out( "Java max memory: " + SystemUtil.getJavaMaxMemory() );
		logger.out( "Java free memory: " + SystemUtil.getJavaFreeMemory() );
	
		logger.outTitle( "Operating system");
		
		logger.out( "OS Arch: " + SystemUtil.getOSArch() );
		logger.out( "OS Arch id string: " + SystemUtil.getOSArchIdString() );
		logger.out( "OS Name: " + SystemUtil.getOSName() );
		logger.out( "OS Name id: " + SystemUtil.getOSNameId() );
		logger.out( "OS Version: " + SystemUtil.getOSVersion() );

		logger.outTitle( "Hardware");
		
		logger.out( "Available processors: " + SystemUtil.getAvailableProcessors() );
		
	}

}
