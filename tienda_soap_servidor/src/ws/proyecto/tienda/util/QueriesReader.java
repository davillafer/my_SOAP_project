package ws.proyecto.tienda.util;

import java.io.IOException;
import java.text.MessageFormat;
import java.util.Properties;

import org.apache.log4j.Logger;

public class QueriesReader {

	static Logger logger = Logger.getLogger("QueriesReader");

	private static Properties prop;
	private static QueriesReader myInstance = new QueriesReader();

	private QueriesReader() {
		logger.debug("Creating the queries reader");
		prop = new Properties();
	}

	public static QueriesReader getQueriesReader() {
		if (myInstance == null) {
			myInstance = new QueriesReader();
		}
		return myInstance;
	}

	public String getProperty(String name, String...args) {
		try {
			logger.debug("Loading 'queries.properties'");
			prop.load(getClass().getResourceAsStream("/queries.properties"));
		} catch (IOException ex) {
			logger.debug("Error reading 'queries.properties' file");
			ex.printStackTrace();
		}
		logger.debug("Getting property " + name);
		return MessageFormat.format((String) prop.get(name), ((Object[]) args));
	}

}
