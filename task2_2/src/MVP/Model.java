package MVP;

import db.Config;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class Model{
    Config conf;
    public Model(Config conf) {
        this.conf = conf;
        try{
            File filePrizeList = new File(conf.getPathPrizeList());
            File fileMyPrizes = new File(conf.getMyPrizes());
        }catch(Exception e){
            e.printStackTrace();
        }
    }


//    public List<int[]> loadVariables() {
//        Config c = new Config();
//        List<int[]> list = new ArrayList<>();
//        try {
//            FileReader fr = new FileReader(c.getPathLoad());
//            BufferedReader bf = new BufferedReader(fr);
//            String line = bf.readLine();
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
//    private int[] parseLine(String str) {
//        int[] arr = new int[2];
//        int iA = str.indexOf("a");
//        int iB = str.indexOf("b");
//        String s0 = iA < iB ? str.substring(iA+1, iB) : str.substring(iA+1);
//        String s1 = iA < iB ? str.substring(iB+1) : str.substring(iB+1, iA);
//        arr[0] = Integer.valueOf(s0);
//        arr[1] = Integer.valueOf(s1);
//        return arr;
//    }
//    public String stringPower(int a, int b){
//        String result;
//        if (a == 0 && b == 0) {
//            result = "Не определено";
//        } else if (b < 0) {
//            b *= -1;
//            double p = 1. / power(a, b);
//            result = Double.toString(p);
//        } else {
//            int p = power(a, b);
//            result = Integer.toString(p);
//        }
//        return result;
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
