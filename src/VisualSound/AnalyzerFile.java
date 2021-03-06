package VisualSound;

import org.apache.log4j.Logger;

import java.io.*;

/**
 * Created by Green on 30.07.2015.
 */
public class AnalyzerFile {
    final static Logger logger = Logger.getLogger(VisualSound.class);
    static Integer[] data;
    static int[] output;
    public String pathFile;
    String tempFilePathOutput = "c:\\VisualSound\\tmp_out.txt";
    String tempFilePathResult = System.getProperty("user.dir") + "\\" + "Result.txt";

    public AnalyzerFile () {
        logger.info("Class null constructor start");
    }

    public AnalyzerFile(String s) {
        logger.info("Class constructor start.");
        logger.info("File name : " + s);
        pathFile = s;

//        // Reset and initialize data[]
        output = new int[256];
//        for (int i = 0; i < 256; i++) {
//            output[i] = 0;
//        }
    }

    public Boolean analyze () throws IOException {
        Integer tempValue;
        Integer num = 0;
        try {
            logger.info("Start analyze file ");
            FileInputStream file = new FileInputStream(pathFile);
            DataInputStream dataFile = new DataInputStream(file);
            RandomAccessFile writeFile = new RandomAccessFile(
                            tempFilePathOutput,
                            "rw");
        // Find end file
            while (file.available() != 0) {
                tempValue = dataFile.readUnsignedByte();
                writeFile.writeByte(tempValue & 0xFF);
                output[tempValue]++;
                num++;
            }
            dataFile.close();
            logger.info("End analyze file | "
                            + "file size : " + num + " bytes"
                            + " | tmp to : " + tempFilePathOutput
            );
            return true;
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
    }

    public void result() {
        logger.info("Result write, length : " + output.length);

//        ����� ������ �� �����
        for (int i = 0; i < output.length; i++) {
            System.out.print(output[i] + "\t");
            // ������� ������
            if(((i+1) % 32) == 0)
                System.out.println();
        }

        // ����� ������ � 32 �������


        // ����� ������ � ����
        try {
            RandomAccessFile writeFile = new RandomAccessFile(
                    tempFilePathResult,
                    "rw");
            for (int i = 0; i < output.length; i++) {
                writeFile.writeInt(output[i]);
            }
            logger.info("Result write to file : " + tempFilePathResult);
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
