// import java.io.FileInputStream;
// import java.io.FileNotFoundException;
// import java.io.FileOutputStream;
// import java.io.IOException;


// public class Main {

//     public static void main(String[] args){
//         try (FileInputStream in = new FileInputStream("input.txt")) {
//             byte[] buffer = new byte[in.available()];
//             in.read(buffer, 0, buffer.length);

//             // Get integers from file
//             String[] input = new String(buffer).split(" ");
//             int a = Integer.parseInt(input[0]);
//             int b = Integer.parseInt(input[1]);

//             // Divide the numbers
//             int quotient = a/b;
//             System.out.println("Success");

//         } catch(FileNotFoundException e) {
//             System.out.println("Input file not found");
//         } catch (NumberFormatException e){
//             System.out.println("Error when parsing integer");
//         } catch (ArrayIndexOutOfBoundsException e) {
//             System.out.println("FIle has less than two integers");
//         } catch (ArithmeticException e){
//             System.out.println("Trying to divide by zero");
//         } catch (IOException e){
//             System.out.println(e.getMessage());
//         } catch (Exception e){
//             System.out.println(e.getMessage());
//         }
//     }
    
// }


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Main {

    private static int divideFromFile(String inputFile) throws RuntimeException, IOException{
        try(FileInputStream in = new FileInputStream("input.txt")) {
            byte[] buffer = new byte[in.available()];
            in.read(buffer, 0, buffer.length);

            String[] input = new String(buffer).split("");
            int a = Integer.parseInt(input[0]);
            int b = Integer.parseInt(input[1]);
            
            return (int)a/b;

        } catch(FileNotFoundException e) {
            System.out.println("input file does not found");
            throw new FileNotFoundException(e.getMessage());
        } catch(NumberFormatException e) {
            System.out.println("error during parsing integer");
            throw new NumberFormatException(e.getMessage());
        } catch(ArrayIndexOutOfBoundsException e) {
            System.out.println("file has less than two integers");
            throw new ArrayIndexOutOfBoundsException(e.getMessage());
        } catch(ArithmeticException e) {
            System.out.println("divide by zero");
            throw new ArithmeticException(e.getMessage());
        } catch(IOException e) {
            System.out.println("error during I/O operations");
            throw new IOException(e.getMessage());
        } catch(Exception e) {
            System.out.println(e.getMessage());
            throw new RuntimeException("unknown error");
        }
    }

    

    public static void main(String[] args){
        try{
            System.out.println(divideFromFile("input.txt"));
        } catch (Exception e) {
            System.out.println("Error while running the app:- " + e.getMessage());
        }

        System.out.println("But life continues");
    }
  
}