import java.io.*;
import java.net.MalformedURLException;
import java.net.URL;

public class SaveFromNet {

    public static void saveImage(String imageURL){
        InputStream is = null;
        OutputStream os = null;

        try {
            @SuppressWarnings("deprecation")
            URL url = new URL(imageURL);
            String fileName = url.getFile();
            String destName = "./" + fileName.substring(fileName.lastIndexOf("/"));
            
            // File file = new File(destName);
            // file.createNewFile();
            // System.out.println("File was created");

            is = url.openStream();
            os = new FileOutputStream(destName, false);

            byte[] b = new byte[2048];
            int length;

            while ((length = is.read(b)) != -1){
                os.write(b, 0, length);
            }
            System.out.println("Operation successful");
        
        } catch (MalformedURLException e){
            System.out.println("malformed url: " + e.getMessage());
        } catch (FileNotFoundException e){
            System.out.println("file not found: " + e.getMessage());
        } catch (IOException e) {
            System.out.println("I/O Error: " + e.getMessage());
        } finally {
            if (is != null){
                try {
                    is.close();
                } catch (IOException e){
                    System.out.println("Failed to close output: " + e.getMessage());
                }
            }
        }

    }

    public static void main(String[] args) {
        saveImage("https://physicsworld.com/wp-content/uploads/2023/08/2023-08-Space-Pride.jpg");
    }
    
}
