package VisualSound;

import java.util.Arrays;

/**
 * Created by Green on 07.08.2015.
 */
public class analyzer {
    private Integer data[];
    private Integer numVariable;
    private Integer dataAnalyze[];

    public analyzer() {
    }

    public analyzer(Integer[] data, Integer numVariable) {
        this.data = data;
        this.numVariable = numVariable;
        dataAnalyze = new Integer[numVariable];
        Arrays.fill(dataAnalyze, 0);
    }

    public void start() {
        for (int i = 0; i < data.length; i++) {
            dataAnalyze[data[i]]++;
        }
    }


    public Integer[] result() {
        return dataAnalyze;
    }

    public Integer[] result( Integer count ) {
        Integer dataCount[] = new Integer[count];
        Arrays.fill(dataCount,0);
        for (Integer i = 0, k = 0; i < dataAnalyze.length; i++) {
            if ((i%(dataAnalyze.length/count)) == 0) k++;
            dataCount[k - 1] = dataCount[k - 1] + dataAnalyze[i];
        }
        return dataCount;
    }

}
