package constants;

import utils.ConfigReader;

public class GlobalParams {

    //Execution modes
    public static final boolean IS_FROM_MAVEN = Boolean.parseBoolean(ConfigReader.getInstance().getValue(PropertyConfigs.FROM_MAVEN));
    public static final boolean IS_REMOTE = Boolean.parseBoolean(ConfigReader.getInstance().getValue(PropertyConfigs.SELENIUM_REMOTE));

    //Selenium parameters
    public static final String SELENIUM_DRIVER = ConfigReader.getInstance().getValue(PropertyConfigs.SELENIUM_DRIVER);
    public static final String SELENIUM_HUB_LINK = ConfigReader.getInstance().getValue(PropertyConfigs.SELENIUM_HUB_LINK);

    //Wait constants
    public static final int WAIT_SELENIUM_IMPLICIT = Integer.parseInt(ConfigReader.getInstance().getValue(PropertyConfigs.SELENIUM_IMPLICITLY_WAIT));
    public static final int WAIT_APP = Integer.parseInt(ConfigReader.getInstance().getValue(PropertyConfigs.APP_WAIT));

    //Application parameters
    public static final String APP_URL = ConfigReader.getInstance().getValue(PropertyConfigs.APP_URL);
}
