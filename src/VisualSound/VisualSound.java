package VisualSound;

import org.apache.log4j.Logger;

import java.io.*;
/**
 * Created by Green on 26.07.2015.
 */
public class VisualSound {
    final static Logger logger = Logger.getLogger(VisualSound.class);

    public static void main(String[] args) throws IOException {
        logger.info("Program start");
        logger.info("Path program : " + System.getProperty("user.dir"));

        AnalyzerFile data = new AnalyzerFile("c:\\VisualSound\\tmp_input.txt");

        data.analyze();
        data.result();

    }
}
