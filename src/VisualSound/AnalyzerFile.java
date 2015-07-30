package VisualSound;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Green on 30.07.2015.
 */
public class AnalyzerFile {
    final static Logger logger = Logger.getLogger(VisualSound.class);

    Integer data[] = null;

    AnalyzerFile(String s) {
        logger.info("File name : " + s);
    }


}
