
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ProjectProp {

    private static final Properties projectProperties = new Properties();
    private static final String RESOURCE_FILE_NAME = "project.properties";


    static {
        InputStream resourceInputStream = null;
        try {
            resourceInputStream = ObjectRepo.class.getClassLoader().getResourceAsStream(RESOURCE_FILE_NAME);
            projectProperties.load(resourceInputStream);
        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (resourceInputStream != null) {
                try {
                    resourceInputStream.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    public static String getUserEmail(String role){
        return projectProperties.getProperty(role.toUpperCase()+"_EMAIL",null);
    }
    public static String getUserPassword(String role){
        return projectProperties.getProperty(role.toUpperCase()+"_PASSWORD",null);
    }
    public static String getUserUrl(String role){
        return projectProperties.getProperty(role.toUpperCase()+"_URL",null);
    }

    }
}