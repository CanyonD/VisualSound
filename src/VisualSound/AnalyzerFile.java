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
    String tempFilePathResult = "Result.txt";

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
                tempValue = dataFile.readUnsignedByte();
                writeFile.writeByte(tempValue & 0xFF);
                output[tempValue]++;
            }
            dataFile.close();
            logger.info("End analyze file " +
                    pathFile +
                    " : tmp to : " +
                    tempFilePathOutput
            );
        }
        catch (ArrayIndexOutOfBoundsException e) {
            logger.error("ArrayIndexOutOfBoundsException : " + e);
            logger.error("Message : " + e.getMessage());
            e.printStackTrace();
            return false;
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

//        Вывод данных на экран
//        for (int i = 0; i < output.length; i++) {
//            System.out.print(output[i] + "\t");
//            // Перенос строки
//            if(((i+1) % 32) == 0)
//                System.out.println();
//        }

        // Вывод данных в 32 столбца


        // Вывод данных в файл
        try {
            RandomAccessFile writeFile = new RandomAccessFile(
                    tempFilePathResult,
                    "rw");
            for (int i = 0; i < output.length; i++) {
                writeFile.writeInt(output[i]);
            }
        }
        catch (FileNotFoundException e) {
            logger.error("File Not Found Exception : " + e);
            logger.error("Message : " + e.getMessage());
            e.printStackTrace();
        }
        catch (IOException e) {
            logger.error("File Exception : " + e);
            logger.error("Message : " + e.getMessage());
            e.printStackTrace();
        }
    }
}
