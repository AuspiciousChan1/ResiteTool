package MyType;

import java.util.HashMap;
import java.util.LinkedList;

public class Word {
    private String name;
    private String explanation;
    private LinkedList<Long> time;

    public Word(String name, String explanation){
        this.name = "" + name;
        this.explanation = "" + explanation;
        this.time = new LinkedList<Long>();
    }
    public String getName(){
        return this.name;
    }
    public String getExplanation(){
        return this.explanation;
    }
    public void resiteWorld(){
        this.time.add(System.currentTimeMillis());
    }
    //y=1-0.56x^0.06        x为记忆后的小时数，y为记忆率
    public double getMemoryLevel(){
        long currentTime = System.currentTimeMillis();
        double sum = 0;
        for (Long t:
                this.time) {
            sum += this.getMemoryLevel(currentTime - t);
        }
        return sum;
    }
    private double getMemoryLevel(long t){
        return 1-0.56 * Math.pow(((double)t) / 3600 / 1000, 0.06);
    }
}
