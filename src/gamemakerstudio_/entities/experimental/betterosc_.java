package gamemakerstudio_.entities.experimental;

import gamemakerstudio_.game_;
import gamemakerstudio_.misc.ID;
import gamemakerstudio_.misc.gameobject_;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import static gamemakerstudio_.misc.audiostuff.xtaudio.XtAudio.BUFFER;

public class betterosc_ extends gameobject_ implements KeyListener {
    // TODO: better code, wip
    static float[] pLeftChannel = new float[2048];
    static float[] pRightChannel = new float[2048];

    private static final int DEFAULT_FPS = 70;
    private static final int DEFAULT_SAMPLE_SIZE = 2048;

    //Color oscilloscopeColor = Color.red;
    int colorIndex = 0;
    int colorSize = 360;

    int	halfCanvasHeight = game_.HEIGHT/2;
    int canvasWidth = game_.WIDTH;

    boolean stereo = true;

    game_ game;

    public betterosc_(float x, float y, ID id, game_ game) {
        super(x, y, id);
        this.game = game;
        game.addKeyListener(this);
    }

    @Override
    public void tick() {
        // TODO: WTF IS THIS SHIT?!

    }

    @Override
    public void render(Graphics gc){
        /*System.out.println("\nBYTES (" + BYTES.length + "): " + Arrays.toString(BYTES));
        System.out.println("bytesToFloats (" + bytesToFloats(BYTES).length + "): " + Arrays.toString(bytesToFloats(BYTES)));*/

        if (stereo) {
            float[] pSample1 = bytesToFloats(BUFFER, 1);

            // use this if problem above was fixed
            gc.setColor(Color.WHITE);

            int yLast1 = (int) (pSample1[0] * (float) halfCanvasHeight)
                    + halfCanvasHeight;
            int samIncrement1 = 1;
            for (int a = samIncrement1, c = 0; c < canvasWidth && a < pSample1.length; a += samIncrement1, c+=2) {
                int yNow = (int) (pSample1[a] * (float) halfCanvasHeight)
                        + halfCanvasHeight;
                gc.drawLine(c, yLast1, c + 1, yNow);
                yLast1 = yNow;
            }

            colorIndex = (colorIndex == colorSize - 1) ? 0 : colorIndex + 1;
            gc.setColor(Color.getHSBColor((float) colorIndex / 360f, 1.0f, 1.0f));
//			System.out.println(Color.getHSBColor((float) colorIndex / 360f, 1.0f, 1.0f) + ", colorIndex: " + colorIndex);

            float[] pSample2 = bytesToFloats(BUFFER, 2);

            int yLast2 = (int) (pSample2[0] * (float) halfCanvasHeight)
                    + halfCanvasHeight;
            int samIncrement2 = 1;
            for (int a = samIncrement2, c = 0; c < canvasWidth && a < pSample2.length; a += samIncrement2, c+=2) {
                int yNow = (int) (pSample2[a] * (float) halfCanvasHeight)
                        + halfCanvasHeight;
                gc.drawLine(c, yLast2, c + 1, yNow);
                yLast2 = yNow;
            }
        } else {
            float[] pSample1 = stereoMerge(bytesToFloats(BUFFER, 1), bytesToFloats(BUFFER, 2));
            colorIndex = (colorIndex == colorSize - 1) ? 0 : colorIndex + 1;
            gc.setColor(Color.getHSBColor((float) colorIndex / 360f, 1.0f, 1.0f));
            int yLast1 = (int) (pSample1[0] * (float) halfCanvasHeight)
                    + halfCanvasHeight;
            int samIncrement1 = 1;
            for (int a = samIncrement1, c = 0; c < canvasWidth && a < pSample1.length; a += samIncrement1, c+=2) {
                int yNow = (int) (pSample1[a] * (float) halfCanvasHeight)
                        + halfCanvasHeight;
                gc.drawLine(c, yLast1, c + 1, yNow);
                yLast1 = yNow;
            }
        }
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    public static float[] bytesToFloats(byte[] bytes, int channel){
        float[] floats = new float[bytes.length / 2];
        for (int i = 0; i < bytes.length; i += 2){
            floats[i/2] = (float)(bytes[i] | (bytes[i+1] << 8)) / 32767.0f;
        }

        int limit = 480;
        float[] betterFloats = new float[floats.length / 2];
        float[] clampToLimit = new float[limit];
        if (channel == 1){
            for (int i = 0, j = 0; i < floats.length; i+=2, j++){
                betterFloats[j] = floats[i];
            }
        } else if (channel == 2){
            for (int i = 1, j = 0; i < floats.length; i+=2, j++){
                betterFloats[j] = floats[i];
            }
        } else if (channel == 0)
            return floats;
        for (int i = 0; i < limit; i++){
            clampToLimit[i] = betterFloats[i];
        }

        // find two zero
        /*for (int i = 0; i < betterFloats.length; i++){
            if (i != 0 && betterFloats[i - 1] != 0 && betterFloats[i] == 0 && betterFloats[i + 1] == 0){
                System.out.println("index " + i + " afterwards fucks up the array");
            }
        }*/

        return clampToLimit; // TODO: must return channel
    }

    static float rangeFloat(byte bytes){
        return (float)bytes / 128;
    }

    public float[] stereoMerge(float[] pLeft, float[] pRight) {
        for (int a = 0; a < pLeft.length; a++)
            pLeft[a] = (pLeft[a] + pRight[a]) / 2.0f;

        return pLeft;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_F10)
            if (stereo)
                stereo = false;
            else stereo = true;
    }
}
