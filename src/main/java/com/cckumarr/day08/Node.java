package main.java.com.cckumarr.day08;

public class Node {
  int nodeName;
  int childNodes;
  int metadataEntries;

  public Node(int nodeName,int childNodes, int metadataEntries){
    this.nodeName = nodeName;
    this.childNodes = childNodes;
    this.metadataEntries = metadataEntries;
  }

  public void childNodesMinus1(){
    this.childNodes--;
  }

  public int getChildNodes() {
    return childNodes;
  }

  public int getMetadataEntries() {
    return metadataEntries;
  }
}
