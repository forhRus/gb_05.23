package MVP;

import base.Prize;
import db.Config;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Model{
    private Config conf;
    private ArrayList<Prize> prizeList;
    private ArrayList<Prize> myPrizes;
    public Model(Config conf) {
        this.conf = conf;
        try{
            File filePrizeList = new File(conf.getPathPrizeList());
            prizeList = loadList(filePrizeList);
            File fileMyPrizes = new File(conf.getMyPrizes());
            myPrizes = loadList(fileMyPrizes);
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public ArrayList<Prize> getMyPrizes() {
        return myPrizes;
    }

    public ArrayList<Prize> getPrizeList() {
        return prizeList;
    }

    public ArrayList<Prize> loadList(File file){
        ArrayList<Prize> l = new ArrayList<>();
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bf = new BufferedReader(fr);
            String line = bf.readLine();
            while (line != null){
                l.add(parseLine(line));
                line = bf.readLine();
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return l;
    }

    private Prize parseLine(String line){
        int idInt = Integer.valueOf(line.substring(0, line.indexOf(',')));
        String name = line.substring(line.indexOf(',')+1, line.lastIndexOf(','));
        int count = Integer.valueOf(line.substring(line.lastIndexOf(',')+1));
        Prize prize = new Prize(idInt, name, count);
        return prize;
    }



//            while (line != null) {
//                list.add(parseLine(line));
//                line = bf.readLine();
//            }
//            fr.close();
//            bf.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return list;
//    }

//    public void saveResult(List<String> list){
//        Config c = new Config();
//        try{
//            FileWriter fw = new FileWriter(c.getPathSave(), false);
//            for (String str: list) {
//                fw.write(str);
//            }
//            fw.close();
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
}
