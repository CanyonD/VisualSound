package VisualSound;

import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;

/**
 * Created by Green on 08.08.2015.
 */
public class convert {
    private Integer data[];
    private File nameOutput;
    private File nameInput;

    public convert(File nameInput, File nameOutput) {
        this(nameInput);
        this.nameOutput = nameOutput;
    }

    public convert(File nameInput) {

        this.nameInput = nameInput;
//        data = new Integer[];

        try
        {
            // Open the wav file specified as the first argument
            WavFile wavFile = WavFile.openWavFile(nameInput);

            // Display information about the wav file
            wavFile.display();

            // Get the number of audio channels in the wav file
            int numChannels = wavFile.getNumChannels();
            System.out.println("Frames : " + wavFile.getNumFrames());
            data = new Integer[(int)wavFile.getNumFrames()];

            // Create a buffer of 100 frames
            int[] buffer = new int[100 * numChannels];

            int framesRead;
            double min = Double.MAX_VALUE;
            double max = Double.MIN_VALUE;

            do
            {
                // Read frames into buffer
                framesRead = wavFile.readFrames(buffer, 100);

                // Loop through frames and look for minimum and maximum value
                for (int s=0 ; s<framesRead * numChannels ; s++)
                {
                    if (buffer[s] > max) max = buffer[s];
                    if (buffer[s] < min) min = buffer[s];
                }

//                for (int i = 0; i < buffer.length; i++) {
//                    System.out.print(buffer[i] + " ");
//                }
//                System.out.println();
            }
            while (framesRead != 0);



            // Close the wavFile
            wavFile.close();

            // Output the minimum and maximum value
//            System.out.printf("Min: %f, Max: %f\n", min, max);
        }
        catch (Exception e)
        {
            System.err.println(e);
        }

    }

    public void playSound(){
        try {
            Clip clip = AudioSystem.getClip();
            clip.open(AudioSystem.getAudioInputStream(nameInput));
            clip.start();

            Thread.sleep( clip.getMicrosecondLength()/1000 );

        } catch (Exception e)  {
            e.getStackTrace();
        }

    }

}
