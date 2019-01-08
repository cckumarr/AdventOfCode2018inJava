package main.java.com.cckumarr.day14;

import java.util.ArrayList;

public class Day14Part2 {
    public static void main(String args[]) {
      int recipeCount = 5;

      ArrayList<Integer> recipes = new ArrayList<>();
      int elf1 = 0;
      int elf2 = 1;
      String answer="";
      String complete = new String();

      recipes.add(3);
      recipes.add(7);

      int count=2;
      boolean found =false;
      while(!found){
        int sum = recipes.get(elf1) + recipes.get(elf2);
        //as the sum is not going to be greater that 10
        if(sum >= 10){
          recipes.add(1);
          complete = complete + 1;
          count++;
          if(count > recipeCount) {
            answer = answer + "1";
          }
          recipes.add(sum%10);
          complete = complete + sum%10;
          count++;
          if(count > recipeCount){
            answer = answer + sum%10;
          }
        }else{
          recipes.add(sum);
          complete = complete + sum;
          count++;
          if(count > recipeCount) {
            answer = answer + sum;
          }
        }

        int elf1value = elf1;
        elf1 = recipes.get(elf1) + 1;
        int elf2value = elf2;
        elf2 = recipes.get(elf2) + 1;

        if(elf1 + elf1value >= recipes.size()){
          elf1 = elf1 - (recipes.size() - elf1value);
          elf1 = elf1 % recipes.size();
        }else{
          elf1 = elf1 + elf1value;
        }

        if(elf2 + elf2value >= recipes.size()){
          elf2 = elf2 - (recipes.size() - elf2value);
          elf2 = elf2 % recipes.size();
        }else{
          elf2 = elf2 + elf2value;
        }

        if(complete.contains("825401")){
          System.out.println("appears after : " + (complete.length()-6 + 2));
          found =true;
        }
        System.out.println(count);

      }

    }


}
