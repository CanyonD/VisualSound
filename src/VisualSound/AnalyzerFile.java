package VisualSound;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by Green on 30.07.2015.
 */
public class AnalyzerFile {
    final static Logger logger = Logger.getLogger(VisualSound.class);
    static Integer[] data;
    static Integer[] output;
    public String pathFile;
    String tempFilePathOutput = "c:\\VisualSound\\tmp_out.txt";

    public AnalyzerFile () {
        logger.info("Class null constructor start");
    }

    public AnalyzerFile(String s) {
        logger.info("Class constructor start with path");
        logger.info("File name : " + s);
        pathFile = s;
        output = new Integer[256];
        for (int i = 0; i < 256; i++) {
            output[i] = 0;
        }
    }

    public Boolean analyze () throws IOException {
        Integer tempValue;
        try {
            logger.info("Start analyze file : " + pathFile);
            FileInputStream file = new FileInputStream(pathFile);
            DataInputStream dataFile = new DataInputStream(file);
            RandomAccessFile writeFile = new RandomAccessFile(
                            tempFilePathOutput ,
                            "rw");
        // Find end file
            while (file.available() != 0) {
                tempValue = (int) dataFile.readByte();
                writeFile.writeChar(tempValue);
                output[tempValue]++;
            }
            dataFile.close();
            logger.info("End analyze file " +
                    pathFile +
                    " : tmp to :" +
                    tempFilePathOutput
            );
        }
        catch (EOFException e) {
            logger.error("EOFException : " + e);
            logger.error("Message : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        catch (FileNotFoundException e) {
            logger.error("File Not Found Exception : " + e);
            logger.error("Message : " + e.getMessage());
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            logger.error("File Exception : " + e);
            logger.error("Message : " + e.getMessage());
            e.printStackTrace();
            return false;
        }

        // return -> FALSE
        return false;
    }

    public void result() {
        logger.info("Result write, length : " + output.length);
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + " ");
            // Перенос строки
            if(((i+1) % 64) == 0)
                System.out.println();
        }
    }
}
