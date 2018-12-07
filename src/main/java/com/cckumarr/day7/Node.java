package main.java.com.cckumarr.day7;

import java.util.ArrayList;
import java.util.HashMap;

public class Node implements Comparable<Node>{
  private String name;
  private HashMap<String,Node> connectsTo;
  private HashMap<String,Node> requirements;

  public Node(String name){
    this.name = name;
    connectsTo = new HashMap<>();
    requirements = new HashMap<>();
  }

  /**
   * Sets new connectsTo.
   *
   * @param connectsToNode New value of connectsTo.
   */
  public void setConnectsTo(Node connectsToNode) {
    this.connectsTo.putIfAbsent(connectsToNode.name,connectsToNode);
  }

  /**
   * Gets connectsTo.
   *
   * @return Value of connectsTo.
   */
  public ArrayList<Node> getConnectsTo() {
    return new ArrayList<>(connectsTo.values());
  }


  /**
   * Sets new requirements.
   *
   * @param requirements New value of requirements.
   */
  public void setRequirements(Node requirements) {
    this.requirements.putIfAbsent(requirements.name,requirements);
  }

/*  *//**
   * Gets requirements.
   *
   * @return Value of requirements.
   */
  public ArrayList<Node> getRequirements() {
    return new ArrayList<>(requirements.values());
  }

  @Override
  public int compareTo(Node o) {
    String nodeName = o.name;
    return this.name.compareTo(nodeName);
  }

  /**
   * Gets name.
   *
   * @return Value of name.
   */
  public String getName() {
    return name;
  }
}
