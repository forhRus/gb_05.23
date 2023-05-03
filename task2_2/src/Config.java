import db.*;
public class Config {
    private String myPrizes = "./db/myPrizes.csv";
    private String pathPrizeList = "./db/prizeList.csv";

    public String getMyPrizes() {
        return myPrizes;
    }

    public String getPathPrizeList() {
        return pathPrizeList;
    }
}
