package VisualSound;

import org.apache.log4j.Logger;

import java.io.*;
/**
 * Created by Green on 26.07.2015.
 */
public class VisualSound {
    final static Logger logger = Logger.getLogger(VisualSound.class);

    public static void main(String[] args) {
        logger.info("Program start");

        AnalyzerFile data = new AnalyzerFile("1");

        data.analyze();



    }
}
