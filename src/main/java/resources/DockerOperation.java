package resources;

import java.awt.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class DockerOperation {
    public static void startDocker() throws IOException, InterruptedException {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/startDocker.sh");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 30);
        boolean hubStarted = false;
        Thread.sleep(3000);

        while (System.currentTimeMillis() < calendar.getTimeInMillis()){
            if(hubStarted){
                break;
            }

            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/output.txt"));
            String line;
            while((line = br.readLine())!=null){
                if(line.contains("Started Selenium Hub")){
                    System.out.println("Selenium Hub started successfully");
                    hubStarted = true;
                    break;
                }
            }

            br.close();
        }
    }

    public static void stopDocker() throws InterruptedException, IOException {
        Runtime.getRuntime().exec(System.getProperty("user.dir")+"/stopDocker.sh");
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.SECOND, 10);
        boolean hubStarted = false;
        Thread.sleep(3000);

        while (System.currentTimeMillis() < calendar.getTimeInMillis()){
            if(hubStarted){
                break;
            }

            BufferedReader br = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/output.txt"));
            String line;
            while((line = br.readLine())!=null){
                if(line.contains("Removing selenium-hub")){
                    System.out.println("Selenium Hub removed successfully");
                    hubStarted = true;
                    break;
                }
            }

            br.close();
        }
    }
}
