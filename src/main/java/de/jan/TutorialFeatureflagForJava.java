package de.jan;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Properties;

public class TutorialFeatureflagForJava {

   public static void main(String args[]) throws IOException {

      Properties propertyDictionary = readPropertiesFile("flags.properties");
   
      if (   propertyDictionary.getProperty("isPHV").equals("true") ) {
         System.out.println("Hello PHV");
      }
      else {
         System.out.println("Welcome back, KFZ");
      }
   }

   public static Properties readPropertiesFile(String fileName) throws IOException {
      FileInputStream fileStreamFlags = null;
      Properties propertyDictionary = null;
      try {
         fileStreamFlags = new FileInputStream(fileName);
         propertyDictionary = new Properties();
         propertyDictionary.load(fileStreamFlags);
      } catch(FileNotFoundException flagFileNotFoundException) {
         flagFileNotFoundException.printStackTrace();
      } catch(IOException ioe) {
         ioe.printStackTrace();
      } finally {
         fileStreamFlags.close();
      }
      return propertyDictionary;
   }

}
