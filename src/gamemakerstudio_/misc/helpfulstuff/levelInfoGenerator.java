package gamemakerstudio_.misc.helpfulstuff;
import gamemakerstudio_.misc.util_;

import java.util.ArrayList;

public class levelInfoGenerator {
    public static void main(String[] args) {
        // assign
        ArrayList<String> title = new ArrayList<>();
        ArrayList<Double> bpm = new ArrayList<>();
        ArrayList<Integer> end = new ArrayList<>();
        String bigString = util_.loadFileAsString("C:\\Users\\ACER\\Desktop\\automate update.txt");
        String[] split = bigString.split("\\s+");
        for (int i = 0; i < split.length; i++){
            /*System.out.print(split[i] + " ");
            if (i != 0 && split[i - 1].equals("end")) {
                System.out.print("\n");
            }*/
            if (split[i].equals("end")){
                // bpm
                String tempBpm = split[i-1];
                String[] stringBpm = tempBpm.split("bpm");
                Double ogBpm = Double.parseDouble(stringBpm[0]);
                bpm.add(ogBpm);
                // end
                String tempEnd = split[i + 1];
                end.add(Integer.parseInt(tempEnd));
                // title
                String addString = "";
                int startAt = 0;
                for (int afterEqualsSign = 3, test = 0;
                     (i - afterEqualsSign)-test != 0 && !split[((i - afterEqualsSign)-test)-1].equals("end"); test++){

//                    System.out.print(split[(i - afterEqualsSign)-test]);

                    startAt = (i - afterEqualsSign)-test;

                }
                for (int index = 0; index <= 4 && !split[startAt+index].equals("="); index++){
                    if (index == 0) addString = split[startAt];
                    else addString = addString + "_" + split[startAt+index];
                }
                title.add(addString);
                /*System.out.print(addString);
                System.out.print("\n");*/
            }
        }
        /*for (int i = 0; i < bpm.size(); i++){
            System.out.println("Title: " + title.get(i) + ", BPM: " + bpm.get(i) + ", End: " + end.get(i));
        }*/

        // level info
        int limitX = 550, limitY = 650;

        // MODIFY THIS!
        int levelid = 271;
        int index = 1;

        for (int y = 350; y <= limitY; y += 100){
            for (int x = 50; x <= limitX; x += 100){
                System.out.println("if (mouseOver(mx, my, " + x + ", " + y + ", 50, 50)) {");
                System.out.println("\tlevelid = " + levelid + ";");
                System.out.println("\tSystem.out.println(\"world \" + levelid);");
                System.out.println("\tif (game_.music) audioplayer_.getMusic(\"" + title.get(index) + "\").play();");
                System.out.println("\t// world misc");
                System.out.println("\tbpm = " + bpm.get(index) + ";");
                System.out.println("\tendBar = " + end.get(index) + ";");
                System.out.println("\t// reset method");
                System.out.println("\tresetMethod();");
                System.out.println("}");
                // increment
                index++;
                levelid++;
            }
        }

        // audioplayer
        /*for (int i = 0; i < title.size(); i++){
            String namespace = title.get(i).replace('_', ' ');
            System.out.println("case \"" + title.get(i) + "\":");
            System.out.println("\tmusicMap.put(key, new Music(\"resources_/music_/" + namespace + ".ogg\"));");
            System.out.println("\tbreak;");
        }*/
    }
}
