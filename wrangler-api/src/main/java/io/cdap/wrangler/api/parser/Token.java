package io.cdap.wrangler.api.parser;

import com.google.gson.JsonElement;

/**
 * Interface for all argument tokens used in Wrangler directives.
 */
public interface Token {
    /**
     * @return the raw string representation of the token
     */
    String value();

    /**
     * @return token type
     */
    TokenType type();

    /**
     * @return a JSON representation of the token
     */
    JsonElement toJson();
}
