/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package manos.validation;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author pedro
 */
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
                hd = getMotherboardSerialLinux();
                break;
            default:
                break;
        }
        return hd;
    }

    public String getMotherboardSerialLinux() {
        String result = "";
        try {
            String[] args = {"bash", "-c", "lshw -class bus | grep serial"};
            Process p = Runtime.getRuntime().exec(args);
            try ( BufferedReader input = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                String line;
                while ((line = input.readLine()) != null) {
                    result += line;
                }
            }

        } catch (IOException e) {
        }
        if (result.trim().length() < 1 || result == null) {
            result = "NO_DISK_ID";

        }

        return filtraString(result, "serial: ");

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
        }

        return result.trim();
    }

    private static String filtraString(String result, String serial_) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
