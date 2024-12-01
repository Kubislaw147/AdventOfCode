import java.io.FileNotFoundException;
import java.util.Arrays;
import java.io.File;
import java.util.Scanner;

import static java.lang.Integer.parseInt;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        // part 1
        int[] arr1 = new int[0];
        int[] arr2 = new int[0];

        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();
            arr1 = push(arr1 , parseInt(data.substring(0, data.length()/2).trim()));
            arr2 = push(arr2,parseInt(data.substring(data.length()/2, data.length()).trim()));
        }
        myReader.close();

        Arrays.sort(arr1);
        Arrays.sort(arr2);
        int sum = 0;

        for(int i=0;i<arr1.length;i++) {
            sum += Math.abs(arr1[i] - arr2[i]);
        }

        System.out.println(sum);

        // part 2
        int sum2=0;
        for(int i=0;i<arr1.length;i++){
            int amount=0;
            for(int j=0;j<arr1.length;j++){
                if(arr1[i]==arr2[j]){
                    amount++;
                }
            }
            sum2+= arr1[i]*amount;
        }
        System.out.println(sum2);

    }

    private static int[] push(int[] array, int push) {
        int[] longer = new int[array.length + 1];
        System.arraycopy(array, 0, longer, 0, array.length);
        longer[array.length] = push;
        return longer;
    }
}