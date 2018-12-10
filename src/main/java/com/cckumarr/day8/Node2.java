package main.java.com.cckumarr.day8;

import java.util.ArrayList;
import java.util.Queue;

public class Node2 {
  int nodeName;
  int numChildLeftToProcess;
  int numOfMetaDataEntries;
  ArrayList<Node2> children;
  ArrayList<Integer> metadata;

  public Node2(int nodeName, int numChildLeftToProcess, int numOfMetaDataEntries){
    this.nodeName = nodeName;
    this.numChildLeftToProcess = numChildLeftToProcess;
    this.numOfMetaDataEntries = numOfMetaDataEntries;
    this.children = new ArrayList<>();
    this.metadata = new ArrayList<>();
  }

  public void childMinus1(){
    this.numChildLeftToProcess = this.numChildLeftToProcess - 1;
  }

  public void addChild(Node2 n){
    this.children.add(n);
  }

  public void addMetadata(Integer i){
    metadata.add(i);
  }

  public ArrayList<Node2> getChildren(){
    return children;
  }
}
