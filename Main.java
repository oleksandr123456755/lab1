import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
       int total_res=0;
       //ArrayList<String> arr_del=new ArrayList<>();
       StringCalculator s=new StringCalculator();
       Scanner sc = new Scanner(System.in);
       System.out.println("Уведіть рядок:");
       String st=sc.nextLine();
       String del="\n";
       //arr_del.add(del);
       st=st.replaceAll("\\\\n", "\n");
       int in1=st.indexOf("\n");
       if(st.length()<2){
           total_res=s.add(st);
           System.out.print("Отримано сума дорівнює: "+total_res);
           return;
       }
        if(st.charAt(0)=='/' && st.charAt(1)=='/') {
            if(st.charAt(2)!='['){
                del = st.substring(2,in1);
            }
            else{
                int i1=st.indexOf(']'), i2=st.indexOf('[');
                del = st.substring(i2+1, i1);

               // arr_del.add(del);
                while(st.charAt(i1+1)=='['){
                    i1=st.indexOf(']', i1+1);
                    i2=st.indexOf('[', i2+1);
                    del = st.substring(i2+1, i1);

                }

            }
            st=st.substring(in1+1, st.length());
       }
        int c =st.length();
        while(c>0){
            st.replaceAll(del+del, del);
            c--;
        }
        st.replaceAll(del, "\n");




       String[] arr =st.split(del);
       for(int i=0; i<arr.length; i++){
           total_res+=s.add(arr[i]);
           s.sum=0;
       }
       if(s.count_neg==0) {
           System.out.print("Отримано сума дорівнює: " + total_res);
       }
       else{
           System.out.print("Недозволені від'ємні числа!\nСписок від'ємних чисел: ");
           for(int i=0; i<s.arr_neg.size(); i++){
               System.out.print(s.arr_neg.get(i)+"; ");
           }
       }
    }
}
