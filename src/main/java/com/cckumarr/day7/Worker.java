package main.java.com.cckumarr.day7;

public class Worker {
  private String nodeName;
  private int secondsLeft;

  public Worker(String nodeName, int secondsLeft){
    this.nodeName = nodeName;
    this.secondsLeft = secondsLeft;
  }


  /**
   * Gets secondsLeft.
   *
   * @return Value of secondsLeft.
   */
  public int getSecondsLeft() {
    return secondsLeft;
  }

  /**
   * Gets nodeName.
   *
   * @return Value of nodeName.
   */
  public String getNodeName() {
    return nodeName;
  }

  /**
   * Sets new secondsLeft.
   *
   * @param secondsLeft New value of secondsLeft.
   */
  public void setSecondsLeft(int secondsLeft) {
    this.secondsLeft = secondsLeft;
  }

  /**
   * Sets new nodeName.
   *
   * @param nodeName New value of nodeName.
   */
  public void setNodeName(String nodeName) {
    this.nodeName = nodeName;
  }
}
