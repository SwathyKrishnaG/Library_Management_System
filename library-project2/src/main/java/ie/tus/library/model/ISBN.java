package ie.tus.library.model;

public final class ISBN {
    private final String code;
    private ISBN(String code) { this.code = code; }
    public static ISBN of(String code) {
        if (code == null) throw new IllegalArgumentException("ISBN null");
        var cleaned = code.replaceAll("[^0-9]", "");
        if (!(cleaned.length() == 10 || cleaned.length() == 13)) throw new IllegalArgumentException("Invalid ISBN format");
        return new ISBN(cleaned);
    }
    public String asString() { return code; }
    @Override public String toString() { return code; }
}
