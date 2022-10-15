package manos.validation;

public class FindingOutSystemOperation {

    public String OperationSystem() {
        String os = System.getProperty("os.name");
        String SO = "Windows";

        if (os.startsWith("Linux")) {
            SO = "Linux";
        }

        return SO;
    }
}
