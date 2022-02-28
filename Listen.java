import jm.music.data.Note;
import jm.util.Play;

import jm.JMC;

import java.util.TimerTask;

public class Music extends TimerTask implements JMC {
   private static final int[] SONG = {78, 78, 78, 72, 76, 79, 67, 72, 67, 64, 69, 71, 70, 69, 67, 76, 79, 81, 77, 79, 76};

    private static int note;

    @Override
    public void run() {
        try {
                for (int i = 0; i < SONG.length; i++) {
                    note = SONG[i];
                    Play.midi(new Note(note, 0.01));
                }
        } catch(Exception ex) {
            System.out.println("Error!");;
        }
    }
}