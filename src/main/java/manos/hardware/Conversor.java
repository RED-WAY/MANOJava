package manos.hardware;
public class Conversor {

    private static final long KIBI = 1L << 10;
    private static final long MEBI = 1L << 20;
    private static final long GIBI = 1L << 30;
    private static final long TEBI = 1L << 40;
    private static final long PEBI = 1L << 50;
    private static final long EXBI = 1L << 60;

    public static String formatarBytes(long bytes) {
        if (bytes == 1L) { // bytes
            return String.format("%d byte", bytes);
        } else if (bytes < KIBI) { // bytes
            return String.format("%d bytes", bytes);
        } else if (bytes < MEBI) { // KiB
            return formatarUnidades(bytes, KIBI, "KiB");
        } else if (bytes < GIBI) { // MiB
            return formatarUnidades(bytes, MEBI, "MiB");
        } else if (bytes < TEBI) { // GiB
            return formatarUnidades(bytes, GIBI, "GiB");
        } else if (bytes < PEBI) { // TiB
            return formatarUnidades(bytes, TEBI, "TiB");
        } else if (bytes < EXBI) { // PiB
            return formatarUnidades(bytes, PEBI, "PiB");
        } else { // EiB
            return formatarUnidades(bytes, EXBI, "EiB");
        }
    }
    private static String formatarUnidades(long valor, long prefixo, String unidade) {
        if (valor % prefixo == 0) {
            return String.format("%d %s", valor / prefixo, unidade);
        }
        return String.format("%.1f %s", (double) valor / prefixo, unidade);
    }

}