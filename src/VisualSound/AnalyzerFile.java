package VisualSound;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by Green on 30.07.2015.
 */
public class AnalyzerFile {
    final static Logger logger = Logger.getLogger(VisualSound.class);
    Integer[] data = null;
    Integer[] output = null;
    public String pathFile;

    public Integer[] getData() {
        return data;
    }

    public void setData(Integer[] data) {
        this.data = data;
    }

    public Integer[] getOutput() {
        return output;
    }

    public void setOutput(Integer[] output) {
        this.output = output;
    }

    public AnalyzerFile () {
        logger.info("Class null constructor start");
    }

    public AnalyzerFile(String s) {
        logger.info("Class constructor start with path");
        logger.info("File name : " + s);
        pathFile = s;
    }

    public Boolean analyze () throws IOException {
        Character tempValue;
        String tempFilePathOutput = "c:\\VisualSound\\tmp_out.txt";
        try {
            logger.info("Start analyze file : " + pathFile);
            FileInputStream file = new FileInputStream(pathFile);
            DataInputStream dataFile = new DataInputStream(file);
            RandomAccessFile writeFile = new RandomAccessFile(
                            tempFilePathOutput ,
                            "rw");
            while (file.available() != 0) {
                tempValue = dataFile.readChar();
                writeFile.writeChar(tempValue);
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
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            logger.error("File Exception : " + e);
            e.printStackTrace();
            return false;
        }

        // return -> FALSE
        return false;
    }

}
