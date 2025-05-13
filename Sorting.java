import java.util.ArrayList;

public class Sorting {

    /*************Bubble Sort********************/
    public static void bubbleSort(int[] arr)
    {
        int n = arr.length;
        for(int i=0; i<n; i++){
            for(int j=0; j<n-i-1; j++){
                if(arr[j] > arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }        
        for(int i : arr){
            System.out.print(i + " ");
        }
    }
    /********************** SELECTION SORT *************************/
    public static void selectionSort(int[] arr){
        
        int n = arr.length;
        for(int i=0; i<n-1; i++){
            int min = i;
            for(int j=i+1; j<n; j++){
                if(arr[j] < arr[min]){
                    min = j;
                }
            }
            if(i != min){
                int temp = arr[min];
                arr[min] = arr[i];
                arr[i] = temp;
            }
        }
        for(int i:arr){
            System.out.print(i + " ");
        }
    }

    /************************* INSERTION SORT *******************************/ 
    public static void insertionSort(int[] arr)
    {
        int n = arr.length;
        for(int i=1; i<n; i++){
            int temp = arr[i];
            int j = i-1;
            while(j>=0 && arr[j] > temp){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = temp;
        }
        for(int i:arr){
            System.out.print(i + " ");
        }
    }


    /***************************** MERGE SORT ************************************/
    // TC = O(N Log N) SC = O(N)
    public static void mergeSort(int[] arr, int lb, int ub){
        if(lb >= ub){
            return;
        }
        int mid = (lb+ub)/2;
        mergeSort(arr, lb, mid);
        mergeSort(arr, mid+1, ub);
        merge(arr, lb, mid, ub);

    }

    public static void merge(int[] arr, int lb, int mid, int ub){
        int i = lb;
        int j = mid+1;
        ArrayList<Integer> temp = new ArrayList<>();
        
        while(i<=mid && j<=ub){
            if(arr[i] <= arr[j]){
                temp.add(arr[i]);
                i++;
            }
            else{
                temp.add(arr[j]);
                j++; 
            }
        }
        while(i<=mid){
            temp.add(arr[i]);
            i++; 
        }
        while(j<=ub){
            temp.add(arr[j]);
            j++;
        }
        for(int k=lb; k<=ub; k++){
            arr[k] = temp.get(k-lb);
        }
    }

    
    /*************************** QUICK SORT ***********************************/

    public static void quickSort(int[] arr, int lb, int ub){
        if(lb < ub){
            int par = partation(arr, lb, ub);
            quickSort(arr, lb, par-1);
            quickSort(arr, par+1, ub);                                                                                                                                                         
        }
    }

    public static int  partation(int[] arr, int lb, int ub){
        int i=lb;
        int j=ub;
        int piv = arr[lb];
        while(i < j){
            while(i <= ub-1 && arr[i] <= piv) {
                i++;
            }
            while(j >= lb+1 && arr[j] > piv){
                j--;
            }
            if(i < j){
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[lb];
        arr[lb] = arr[j];
        arr[j] = temp;
        return j;
    }


    public static void main(String[] arrgs){
        System.out.println("Hello World");
        int[] arr = {6, 1, 5, 3, 7 ,7, 2, 4};
        bubbleSort(arr);
        selectionSort(arr);
        insertionSort(arr);
        mergeSort(arr, 0, arr.length-1);
        quickSort(arr, 0, arr.length-1);
        for(int i:arr)
        {
            System.out.print(i + " ");
        }
    }
}














