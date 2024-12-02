import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {

        File myObj = new File("input.txt");
        Scanner myReader = new Scanner(myObj);
        int result = 0;
        while (myReader.hasNextLine()) {
            String data = myReader.nextLine();

            String[] reportString = data.split(" ");
            int[] report = new int[reportString.length];
            for(int i=0;i<reportString.length;i++){
                report[i] = Integer.parseInt(reportString[i]);
            }

            int temp = report[0],numberOfFailures=0;
            boolean isIncreasing,isGood=true;
            if(report[0]<report[1]){
                isIncreasing=true;
            }else{
                isIncreasing=false;
            }

            for(int i=1;i<report.length;i++){
                if(isIncreasing){
                    if(report[i]-temp<=3 && report[i]-temp>=1){}else{
                        numberOfFailures++;
                    }
                }else{
                    if(temp-report[i]<=3 && temp-report[i]>=1){}else{
                        numberOfFailures++;
                    }
                }
                temp = report[i];
            }
            if(numberOfFailures<2){result++;}
        }
        System.out.println(result);
        myReader.close();
    }
}