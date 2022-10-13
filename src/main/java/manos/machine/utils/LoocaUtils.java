package manos.machine.utils;

import java.util.Locale;

public class LoocaUtils {

    public Double ConvertToDoubleGb(Long value, Integer decimalNumbers) {
        String decimalCounter = "%." + decimalNumbers + "f";
        Double divisor = Math.pow(1024, 3);
        String limitDecimals = String.format(Locale.US, decimalCounter, value / divisor);
        Double convertToDouble = Double.parseDouble(limitDecimals);
        return convertToDouble;
    }
}
