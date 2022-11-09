package manos.machine;

import com.github.britooo.looca.api.core.Looca;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.*;
import java.lang.String;
import manos.log.LogLevel;
import manos.log.Logger;

public class FindingOutSerial {

    private FindingOutSystemOperation System = new FindingOutSystemOperation();

    public String serial() {
        if (System.OperationSystem().equals("Windows")) {
            return getMotherboardSerialWindows();
        }
        return getProcessorIdLinux();
    }

    public String getProcessorIdLinux() {
        return new Looca().getProcessador().getId();
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
            Logger.log("Falha ao pegar serial da placa mãe do windows ", e.getMessage(), LogLevel.ERROR);
        }

        return result.trim();
    }

}
