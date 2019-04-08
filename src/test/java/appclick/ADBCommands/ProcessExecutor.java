package appclick.ADBCommands;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class ProcessExecutor {

    public String getDeviceID() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("adb", "devices");
        String result = processProcessing(pb);
        result = result.substring(24,result.length()-11);
        //System.out.println(result);
        return result;
    }

    public String getAndroidVersion() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("adb", "shell","getprop","ro.build.version.release");
        String result = processProcessing(pb);
        //System.out.println(result);
        return result;
    }

    public String getOperator() throws IOException, InterruptedException {
        ProcessBuilder pb = new ProcessBuilder("adb", "shell","getprop","gsm.operator.alpha"); //gsm.operator.alpha
        String result = processProcessing(pb);
        System.out.println(result);
        return result;
    }

    public String getAPKName(){
        String APKName ="";
        return APKName;
    }

    private String processProcessing(ProcessBuilder pb) throws IOException, InterruptedException {
        Process pc = pb.start();
        BufferedReader reader = new BufferedReader(new InputStreamReader(pc.getInputStream()));
        StringBuilder builder = new StringBuilder();
        String line = null;
        while ( (line = reader.readLine()) != null) {
            builder.append(line);
            builder.append(System.getProperty("line.separator"));
        }
        String result = builder.toString();
        pc.waitFor();
        return result;
    }
}
