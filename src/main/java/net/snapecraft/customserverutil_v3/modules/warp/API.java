package net.snapecraft.customserverutil_v3.modules.warp;

public class API {

    public static Boolean isInt(String s) {
        try {
            Integer.parseInt(s);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

}