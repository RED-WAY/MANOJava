package manos.hardware;

import java.util.List;
import java.util.Locale;
import java.util.Map;

public class Utils {

    public Double ConvertToDoubleGb(Long value, Integer decimalNumbers) {
        String decimalCounter = "%." + decimalNumbers + "f";
        Double divisor = Math.pow(1024, 3);
        String limitDecimals = String.format(Locale.US, decimalCounter, value / divisor);
        Double convertToDouble = Double.parseDouble(limitDecimals);
        return convertToDouble;
    }

    public String extractIdMachine(List<Map<String, Object>> list) {
        return list.get(0)
                .toString()
                .replace("{idMachine=", "")
                .replace("}", "");
    }
}
