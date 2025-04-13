package io.cdap.wrangler.api.parser;

import com.google.gson.JsonPrimitive;
import com.google.gson.JsonElement;

public class TimeDuration implements Token {
    private final long millis;
    private final String value;

    public TimeDuration(String value) {
        this.value = value;
        this.millis = parse(value);
    }

    private long parse(String input) {
        input = input.trim().toLowerCase();
        if (input.endsWith("ms")) return (long)(Double.parseDouble(input.replace("ms", "")));
        if (input.endsWith("s")) return (long)(Double.parseDouble(input.replace("s", "")) * 1000);
        if (input.endsWith("m")) return (long)(Double.parseDouble(input.replace("m", "")) * 60 * 1000);
        if (input.endsWith("h")) return (long)(Double.parseDouble(input.replace("h", "")) * 3600 * 1000);
        throw new IllegalArgumentException("Invalid TimeDuration: " + input);
    }

    public long getMilliseconds() {
        return millis;
    }
    @Override
    public String value() {
        return value;
    }

    @Override
    public TokenType type() {
        return TokenType.BYTE_SIZE;
    }

    @Override
    public JsonElement toJson() {
        return new JsonPrimitive(millis);
    }
}
