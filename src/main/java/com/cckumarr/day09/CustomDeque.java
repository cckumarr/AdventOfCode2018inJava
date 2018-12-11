package main.java.com.cckumarr.day09;

public class CustomDeque {
  int value;
  CustomDeque current;
  CustomDeque next;
  CustomDeque previous;

  CustomDeque(int value){
    this.value = value;
    this.current = null;
    this.next = null;
    this.previous = null;
  }

  public void setNext(CustomDeque cd){
    this.next = cd;
  }

  public void setPrevious(CustomDeque cd){
    this.previous = cd;
  }

  public CustomDeque getNext(){
    return(this.next);
  }

  public CustomDeque getPrevious(){
    return(this.previous);
  }
}
