import java.util.Random;
class Main {
  public static int N=10;
  private static int[] array = new int[N];
  private static Random generator = new Random();

  public static void initArray(){
    for (int i=0; i<N;i++){
      array[i]=generator.nextInt(100);
    }
  }
  public static void printArray() {
        for (int i=0; i<N-1; i++) {
            System.out.print(array[i] + ", ");
        }
        System.out.println(array[N-1]);
    }
  public static void quickSort() {
        int temp;
        int i3=0;
        int j = 0;
        for(int i=0;i<N;i++){
           if (array[i] % 3 == 0 && array[i]!=0){             
             temp = array[j];
             array[j]=array[i];
             array[i]=temp;             
             j++;
             i3=i;
           } 
        }
        doSort(0, j-1);
        doSort(j, N-1);
    }  

  private static void doSort(int start, int end) {
        if (start >= end)
            return;
        int i = start, j = end;
        int cur = i - (i - j) / 2;
        while (i < j) {
            while (i < cur && (array[i] <= array[cur])) {
                i++;
            }
            while (j > cur && (array[cur] <= array[j])) {
                j--;
            }
            if (i < j) {
                int temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                if (i == cur)
                    cur = j;
                else if (j == cur)
                    cur = i;
            }
        }
        doSort(start, cur);
        doSort(cur+1, end);
    }

  public static void main(String[] args) {
    initArray();
    printArray();
    quickSort();
    printArray();
  }
}