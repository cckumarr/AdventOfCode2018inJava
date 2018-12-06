package main.java.day4;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Times {
  //id of the guard
  private String id;
  //a map of the min and the number of times the guard has slept at that particular minute
  private HashMap<Integer,Integer> minsValue;
  //the total number of mins a guard has slept
  private int sum;

  Times(String id){
    this.id = id;
    minsValue = new HashMap<>();
    sum=0;
  }

  public String getId() {
    return id;
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
    if(minsValue.isEmpty()){
      return 0;
    }
    for(Map.Entry<Integer, Integer> entry : minsValue.entrySet()){
      if(maxEntry==null || entry.getValue() > maxEntry.getValue() ){
      //if(maxEntry==null || entry.getValue().compareTo(maxEntry.getValue()) > 0 ){
        maxEntry = entry;
      }
    }
    return maxEntry.getKey();
  }


  public int getMaxRepeatedValue(){
    //check if there were no values set
    if(minsValue.isEmpty())
      return 0;
    //return the max value in the hashmap, value here is the number of times the guard slept in the same min
    return Collections.max(minsValue.values());
  }

  /**
   * Sets new minsValue.
   *
   * @param mins New value of minsValue.
   */
  public void setMinsValue(Integer mins) {
    //if there was no hit then put, else add 1 to what ever value was present
    if(this.minsValue.get(mins) == null){
      this.minsValue.put(mins,1);
    }else{
      this.minsValue.put(mins, this.minsValue.get(mins)+1);
    }
    this.sum++;
  }
}
