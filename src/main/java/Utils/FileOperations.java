package Utils;


import java.io.*;
import java.util.Properties;

public class FileOperations {
    private static final String DIR_PATH_PROPERTIES = System.getProperty("user.dir") + File.separator + "src" +
            File.separator + "main" + File.separator + "java" + File.separator + "resources" + File.separator + "Properties";

    public static void createFile(String fileName){
        try {
            File myFile = new File(DIR_PATH_PROPERTIES + File.separator + fileName + ".properties");

            if (myFile.createNewFile()) {
                System.out.println("File created: " + myFile.getName());
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }

    public static Properties getProperties(String fileName){
        InputStream inputStream = null;
        Properties properties = new Properties();

        try{
            inputStream = new FileInputStream(DIR_PATH_PROPERTIES + File.separator + fileName + ".properties");
            properties.load(inputStream);

            inputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
        return properties;
    }

    public static void setProperties(String fileName, String propKey, String propValue){
        Properties properties = getProperties(fileName);

        try{
            OutputStream outputStream = new FileOutputStream(DIR_PATH_PROPERTIES + File.separator + fileName
                    + ".properties");

            properties.setProperty(propKey, propValue);
            properties.store(outputStream, null);

            outputStream.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
