package com.ter.CellularAutomaton.main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.ter.CellularAutomaton.vue.MainWindow1D;
import com.ter.CellularAutomaton.vue.MainWindow2D;



/**
 * The Class Main.
 */
public class Main {

	// For the logging.
	private static final Logger logger = LogManager.getLogger(Main.class.getName()); // TestLog4j1.class.getName() must be change in yourClassName.class.getName().
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		
		/******REMINDER FOR THE LOGGING******/
		
//		if(logger.isDebugEnabled()){
//			System.out.println("debug test"); // Will not be display if the logger isn't in debug priority because of the if statement.
//			logger.debug("msg de debogage");
//		}
//		if(logger.isInfoEnabled()){
//			logger.info("msg d'information");
//		}
//		if(logger.isWarnEnabled()){
//			logger.warn("msg d'avertissement");
//		}
//		if(logger.isErrorEnabled()){
//			logger.error("msg d'erreur");
//		}
//		if(logger.isFatalEnabled()){
//			logger.fatal("msg d'erreur fatale");
//		}
		
		
		// The logging.
		if(logger.isDebugEnabled()){
			logger.debug("The main method begin.");
		}
		if(logger.isInfoEnabled()){
			logger.info("The application starts.");
		}
		
		// Start the application.
		
		//MainWindow2D SimulatorWindow2D = new MainWindow2D();//Create window 2D
		MainWindow1D SimulatorWindow1D = new MainWindow1D();//Create window 1D
	}
}
