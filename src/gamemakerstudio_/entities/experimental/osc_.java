package gamemakerstudio_.entities.experimental;

import gamemakerstudio_.misc.ID;
import gamemakerstudio_.misc.audiostuff.streamplayer.*;
import gamemakerstudio_.misc.audiostuff.visualizer.Oscilloscope;
import gamemakerstudio_.misc.gameobject_;

import java.awt.*;
import java.io.File;
import java.util.Map;

public class osc_ extends gameobject_ implements StreamPlayerListener {
    Oscilloscope oscilloscope = new Oscilloscope();
    StreamPlayer streamPlayer = new StreamPlayer(); // this is static, pls fix this

    public osc_(float x, float y, ID id) {
        super(x, y, id);
        streamPlayer.addStreamPlayerListener(this);
        playSong(new File("C:\\Users\\ACER\\Desktop\\programming\\java\\JohnKennedyPeña\\" +
                "resources_\\music_\\fireflies remix.ogg"));
    }

    @Override
    public void tick() {

    }

    @Override
    public void render(Graphics g) {
        oscilloscope.drawOscilloscope(g);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    public void playSong (File file){
        try {
            // ----------------------Open the Media
            System.out.println("Opening ...");
            streamPlayer.open(file);

            // ---------------------- Play the Media
            System.out.println("Starting to play ...");
            streamPlayer.play();

//            oscilloscope.setShowFPS(true);

        } catch (StreamPlayerException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void opened(Object dataSource, Map<String, Object> properties) {

    }

    @Override
    public void progress(int nEncodedBytes, long microsecondPosition, byte[] pcmData, Map<String, Object> properties) {
        // write the data to the visualizer
        oscilloscope.writeDSP(pcmData);
    }

    @Override
    public void statusUpdated(StreamPlayerEvent event) {
        System.out.println("Player Status is:" + streamPlayer.getStatus());

        // player is opened
        if (event.getPlayerStatus() == Status.OPENED && streamPlayer.getSourceDataLine() != null) {

            oscilloscope.setupDSP(streamPlayer.getSourceDataLine());
            oscilloscope.startDSP(streamPlayer.getSourceDataLine());

            // player is stopped
        } else if (event.getPlayerStatus() == Status.STOPPED) {

            oscilloscope.stopDSP();

        }
    }

}
