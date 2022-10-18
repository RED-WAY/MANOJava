package manos.views;

import manos.process.Processes;
import java.util.*;
import org.jutils.jprocesses.JProcesses;
import org.jutils.jprocesses.model.ProcessInfo;
//import sun.jvm.hotspot.debugger.ProcessInfo;

public class App {

    public static void main(String[] args) {
//        View view = new View();
//
//        try {
//            Thread.sleep(1000);
//            view.setVisible(true);
//            view.startupApp();
//        } catch (InterruptedException ex) {
//            ex.printStackTrace();
//        }

//        Processes process = new Processes();
//        process.getProcess();
        List<ProcessInfo> processesList = JProcesses.getProcessList();

        for (ProcessInfo processInfo : processesList) {
            System.out.println("Process PID: " + processInfo.getPid());
            System.out.println("Process Name: " + processInfo.getName());
            System.out.println("Process Used Time: " + processInfo.getTime());
            System.out.println("Full command: " + processInfo.getCommand());
            System.out.println("------------------");
        }
    }

}
