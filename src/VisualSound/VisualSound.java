package VisualSound;

import org.apache.log4j.Logger;

import java.io.*;
/**
 * Created by Green on 26.07.2015.
 */
public class VisualSound {
    final static Logger logger = Logger.getLogger(VisualSound.class);

    public static void main(String[] args) throws IOException {

        // Check arguments -> start
        if (args.length < 1) {
            logger.error("Program start without arguments!");
            return;
        }
        else {
            String allArguments = "";
            for(int i = 0; i < args.length; i++) {
                allArguments = allArguments + args[i];
                allArguments = allArguments + " ";
            }
            logger.info("Program start with arguments : " + allArguments);
        }
        // Check arguments -> end

        // Output path program
        logger.info("Path program : " + System.getProperty("user.dir"));


//        AnalyzerFile data = new AnalyzerFile("c:\\VisualSound\\tmp_input.txt");

        // Initialize analyzer file
        AnalyzerFile data = new AnalyzerFile(System.getProperty("user.dir") + "\\" + args[0]);

        // Start analyze
        data.analyze();

        // Show result analyze
        data.result();

    }
}
