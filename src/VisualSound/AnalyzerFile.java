package VisualSound;

import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by Green on 30.07.2015.
 */
public class AnalyzerFile {
    final static Logger logger = Logger.getLogger(VisualSound.class);
    Integer[] data = null;
    Integer[] output = null;

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

    AnalyzerFile(String s) {
        logger.info("File name : " + s);

    }

    public static Boolean analyze () {

        // return -> FALSE
        return false;
    }

}
