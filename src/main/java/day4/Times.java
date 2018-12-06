package main.java.day4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Times {
  private String id;
  private HashMap<Integer,Integer> minsValue;
  private int sum;
  private int maxRepeatedValue;

  Times(String id){
    this.id = id;
    minsValue = new HashMap<>();
    sum=0;
    maxRepeatedValue=0;
  }

  public String getId() {
    return id;
  }

  /**
   * Sets new sum.
   *
   * @param sum New value of sum.
   */
  public void setSum(int sum) {
    this.sum = sum;
  }

  /**
   * Gets minsValue.
   *
   * @return Value of minsValue.
   */
  public HashMap<Integer, Integer> getMinsValue() {
    return minsValue;
  }

  /**
   * Gets sum.
   *
   * @return Value of sum.
   */
  public int getSum() {
    return sum;
  }

  /**
   * Gets maxRepeatedValue.
   *
   * @return Value of maxRepeatedValue.
   */
  public int getKeyMaxRepeatedValue() {

    Map.Entry<Integer, Integer> maxEntry = null;
    for(Map.Entry<Integer, Integer> entry : minsValue.entrySet()){
      if(maxEntry==null || entry.getValue() > maxEntry.getValue() ){
        maxEntry = entry;
      }
    }
    if(maxEntry == null)
      return 0;
    return maxEntry.getKey();
  }


  public int getMaxRepeatedValue(){
    return Collections.max(minsValue.values());
  }

  /**
   * Sets new maxRepeatedValue.
   *
   * @param maxRepeatedValue New value of maxRepeatedValue.
   */
  public void setMaxRepeatedValue(int maxRepeatedValue) {
    this.maxRepeatedValue = maxRepeatedValue;
  }

  /**
   * Sets new minsValue.
   *
   * @param mins New value of minsValue.
   */
  public void setMinsValue(Integer mins) {
    if(this.minsValue.get(mins) == null){
      this.minsValue.put(mins,1);
    }else{
      this.minsValue.put(mins, this.minsValue.get(mins)+1);
    }
    this.sum++;
  }
}
