package ink.cyz.use.music;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

/**
 * DATE: 2019/5/19 13:13
 * AUTHOR: cyz.ink
 **/
public class Demo1 {
    public static void main(String[] args) {
        Demo1 d = new Demo1();
        d.play("C:\\Users\\xiaomi\\Desktop\\1.m4a");
    }
    public void play(String filePath){
        File file = new File(filePath);
        try {
            AudioInputStream in = AudioSystem.getAudioInputStream(file);
            AudioFormat outFormat = getOutFormat(in.getFormat());
            DataLine.Info info = new DataLine.Info(SourceDataLine.class,outFormat);
            final SourceDataLine line = (SourceDataLine) AudioSystem.getLine(info);
            if (line != null) {
                line.open(outFormat);
                line.start();
                stream(AudioSystem.getAudioInputStream(outFormat, in), line);
                line.drain();
                line.stop();
            }

        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    private AudioFormat getOutFormat(AudioFormat inFormat) {
        final int ch = inFormat.getChannels();
        final float rate = inFormat.getSampleRate();
        return new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, rate, 16, ch, ch * 2, rate, false);
    }

    private void stream(AudioInputStream in, SourceDataLine line)
            throws IOException {
        final byte[] buffer = new byte[65536];
        for (int n = 0; n != -1; n = in.read(buffer, 0, buffer.length)) {
            line.write(buffer, 0, n);
        }
    }
}




















