package log4j;

import org.apache.log4j.Logger;

public class Log4JQ {
	private static Logger logger = Logger.getLogger(Log4JQ.class);

	public static void main(String[] args) {
		// Properties props = new Properties();
		// try {
		// InputStream istream = Log4JQ.class.getResourceAsStream("/log4j.properties");
		// props.load(istream);
		// istream.close();
		// props.setProperty("log4j.appender.logfile.File", "log/"+Log4JQ.class.getSimpleName()+".log");
		// PropertyConfigurator.configure(props);
		// } catch (Exception e) {
		// logger.error("装入属性文件异常:", e);
		// }
		logger.debug("调试");
		Exception exception = new Exception("Exception");
		logger.debug("调试", exception);
		logger.debug("调试" + exception);

	}
}
