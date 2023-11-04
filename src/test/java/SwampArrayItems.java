import java.sql.SQLOutput;

public class SwampArrayItems {
 public static void main(String[] args) {
  String[] initialArr = {"aa", "bb", "cc", "dd", "ee"};
  System.out.println("Initial array: ");
  for (String item: initialArr) {
   System.out.println(item);
  }
  revertArray(initialArr);

 }

 public static String[] revertArray (String[] array) {

  for (int i = 0; i < array.length / 2; i++) {
   String tmp = array[i];
   array[i] = array[array.length - i - 1];
   array[array.length - i - 1] = tmp;
  }
  for (String item: array) {
   System.out.println(item);
  }
 return array;
 }
 }
