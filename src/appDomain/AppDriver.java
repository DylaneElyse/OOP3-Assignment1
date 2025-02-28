package appDomain;

import manager.SortManager;

/**
 * Main driver of the app
 */
public class AppDriver
{

	/**
	 * Creates the main driver class for the app
	 * @param args Arguments passed into the code from the CLI
	 */
	public static void main( String[] args )
	{
		new SortManager(args);
	}

}
