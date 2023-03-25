import java.util.*;
public class MergeSort1
{
    ArrayList getInput(ArrayList<Integer> al)
    {
        System.out.println("Enter number you want in array");//Asking user for array
        Scanner sc= new Scanner(System.in);
        int z=sc.nextInt();
        while (z>0)
        {
                System.out.println("enter the number");
                al.add(sc.nextInt());
                z=z-1;
        }
         return al;
    }
     void getOutput(ArrayList<Integer> al) {
                System.out.println("Unsorted Array List: ");
                System.out.println(al);
                sort(al, 0, al.size()-1);
                System.out.println("Sorted Array List: ");
                System.out.println(al);
    }
    void merge(ArrayList<Integer> al, int beg, int mid, int end) {
        
        ArrayList < Integer > merged= new ArrayList <> (); 
        int g = beg;
        int h = mid+1;
        int sc=0;
        while(g<=mid && h<=end){
            if(al.get(g)<=al.get(h)){
                merged.add(al.get(g));
                g++;
            }else{
                  merged.add(al.get(h));
                  h++;
              }
          }
        for ( sc= g; sc <= mid; sc++)
                {
                merged.add(al.get(sc)); 
                }
        for ( sc = 0; sc < merged.size(); sc++) 
                {
                al.set(beg + sc, merged.get(sc));
                }
                }
        void sort(ArrayList<Integer> al, int beg, int end) {
        
        if(beg>=end){
          return;
                 }
        int mid = beg+(end-beg)/2;
        sort(al,beg,mid);
        sort(al,mid+1,end);
        merge(al,beg,mid,end);
    }
    public static void main(String[] args) {
        MergeSort1 value = new MergeSort1();
        ArrayList < Integer > al = new ArrayList<>();
                value.getInput(al);
                value.getOutput(al);
    }
}