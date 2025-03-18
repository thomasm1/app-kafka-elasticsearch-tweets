package xyz.cryptomaven.rest.config.logger;

import java.io.Serializable;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class CliLogger implements Serializable, Cloneable  {

	private static final long serialVersionUID = 1L;
	private static Logger instanceLogger = null; // create & store singleton
	private CliLogger() { }; // prevent from alter-creation

//	// ONLY Public API for logger  returns singleton
	public static synchronized Logger getInstance() {
					// Class Locked Thread Safe
			synchronized(CliLogger.class) {
					setInstance(  LogManager.getLogger(CliLogger.class));
		}
		return instanceLogger;
	}

    // private
	private static void setInstance(Logger cliLogger) {
		CliLogger.instanceLogger = cliLogger;
	}

	//   Serializable-Safe
	protected Object readResolve() {
		return getInstance();
	}

	// Not Cloneable
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

	// Not Reflection-Safe, otherwise  -
	// CLIENT:
	//	EnumSingleton instance = EnumSingleton.INSTANCE;
	//	instance.setName("singularname");
}
