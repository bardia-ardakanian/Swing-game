package com.company.view;

import java.util.HashMap;
import java.util.Map;

public class TextureReference {

    /**
     * This hashmap relates each game texture to its corresponding path for easier access and modification
     */
    private final static Map<String, String> textureMap = new HashMap<>() {
        {
           // Note: Its actually Rick Roll LMAO
            put("rick", "resources\\RickRoll\\Rick-Astley-Never-Gonna-Give-You-Up.png");
        }
    };

    /**
     * This method returns the corresponding path using its Key
     *
     * @param texture Texture name
     * @return Path to file
     * @throws Exception NullPointerException - Texture does not exist!
     */
    public static String getPath(String texture) throws Exception {
        if (textureMap.containsKey(texture))
            return textureMap.get(texture);
        else
            throw new Exception("Texture does not exist!");
    }
}