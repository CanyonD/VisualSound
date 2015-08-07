package VisualSound;

import org.apache.log4j.Logger;

import java.io.*;
import java.util.Random;

/**
 * Created by Green on 26.07.2015.
 */
public class VisualSound {
    final static Logger logger = Logger.getLogger(VisualSound.class);
    final static Random random = new Random();

    public static void main(String[] args) throws IOException {

        // Check arguments -> start
        if (args.length < 1) {
            logger.error("Program start without arguments!");

            Integer num = 65536;
            Integer data[] = new Integer[num];
            analyzer analyzer = new analyzer(data, num);
            Integer result[];

            for (int i = 0; i < data.length; i++) {
                data[i] = random.nextInt(num);
            }

            analyzer.start();
            result = analyzer.result(128);

//            for (int i = 0; i < data.length; i++) {
//                System.out.print(data[i] + "\t");
//                if (((i+1)%16) == 0) System.out.println();
//            }
//            System.out.println(" = = = = = = = = = = = = = = = = ");

            for (int i = 0; i < result.length; i++) {
                System.out.print(result[i] + "\t");
                if (((i+1)%16) == 0) System.out.println();
            }
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
