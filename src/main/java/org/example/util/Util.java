package org.example.util;

import org.example.Motivation;

import java.util.List;

public class Util {

    public static Motivation foundMotivationById(String cmd, List<Motivation> motivations) {
        int id = Integer.parseInt(cmd.split("=")[1].trim());

        Motivation foundMotivation = null;

        for (Motivation motivation : motivations) {
            if (motivation.getId() == id) {
                foundMotivation = motivation;
            }
        }
        return foundMotivation;
    }
}
