package manos.validation;

import com.github.britooo.looca.api.core.Looca;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

public class FindingOutSerial {

    FindingOutSystemOperation System = new FindingOutSystemOperation();

    public String serial() {
        String so = System.OperationSystem();
        String hd = null;

        switch (so) {
            case "Windows":
                hd = getMotherboardSerialWindows();
                break;
            case "Linux":
                hd = getProcessorIdLinux();
                break;
            default:
                break;
        }
        return hd;
    }

    public String getProcessorIdLinux() {
        Looca looca = new Looca();
        String result;       
        result = looca.getProcessador().getId();
        
        return result;
    }

    public String getMotherboardSerialWindows() {
        String result = "";
        try {
            File file = File.createTempFile("realhowto", ".vbs");
            file.deleteOnExit();
            FileWriter fw = new java.io.FileWriter(file);

            String vbs = "Set objWMIService = GetObject(\"winmgmts:\\\\.\\root\\cimv2\")\n"
                    + "Set colItems = objWMIService.ExecQuery _ \n"
                    + "   (\"Select * from Win32_BaseBoard\") \n"
                    + "For Each objItem in colItems \n"
                    + "    Wscript.Echo objItem.SerialNumber \n"
                    + "    exit for  ' do the first cpu only! \n" + "Next \n";

            fw.write(vbs);
            fw.close();
            Process p = Runtime.getRuntime().exec(
                    "cscript //NoLogo " + file.getPath());
            BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String line;
            while ((line = input.readLine()) != null) {
                result += line;
            }
            input.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result.trim();
    }

}
