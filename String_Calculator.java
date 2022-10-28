import java.util.ArrayList;

class StringCalculator {
     public int sum = 0;
     public int count_neg=0;
     public ArrayList<String> arr_neg=new ArrayList<>();
     public int add(String numbers) {

         if (numbers.length() == 0) {
             return sum;
         }

         if (numbers.indexOf(",") == -1) {
             if(Integer.parseInt(numbers)<0){
                 arr_neg.add(numbers);
                 count_neg++;
                 return sum;
             }
             if(Integer.parseInt(numbers)>1000){
                 return sum;
             }
             else {
                 return sum + Integer.parseInt(numbers);
             }
         }

         int i=Integer.parseInt(numbers.substring(0, numbers.indexOf(",")));
         if(i<0){
             arr_neg.add(numbers.substring(0, numbers.indexOf(",")));
             count_neg++;

         }
         else {
             if(i<=1000){
                 sum += i;
             }

         }
         return add(numbers.substring(numbers.indexOf(",") + 1, numbers.length()));
     }


     //    String[] arr =numbers.split("/n");
     //        for(int i=0; i<arr.length; i++){
     //        arr[i]=arr[i]
     //       }
 }