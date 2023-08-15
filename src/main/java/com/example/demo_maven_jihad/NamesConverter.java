package com.example.demo_maven_jihad;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class NamesConverter {

    private static BiMap<Character, Character> biMap = HashBiMap.create();

    static {
        biMap.put(' ','0');
        biMap.put('ا', 'A');
        biMap.put('ب', 'B');
        biMap.put('ت', 'C');
        biMap.put('ث', 'D');
        biMap.put('ج', 'E');
        biMap.put('ح', 'F');
        biMap.put('خ', 'G');
        biMap.put('د', 'H');
        biMap.put('ذ', 'I');
        biMap.put('ر', 'J');
        biMap.put('ز', 'K');
        biMap.put('س', 'L');
        biMap.put('ش', 'M');
        biMap.put('ص', 'N');
        biMap.put('ض', 'P');
        biMap.put('ط', 'Q');
        biMap.put('ظ', 'R');
        biMap.put('ع', 'S');
        biMap.put('غ', 'T');
        biMap.put('ف', 'U');
        biMap.put('ق', 'V');
        biMap.put('ك', 'W');
        biMap.put('ل', 'X');
        biMap.put('م', 'Y');
        biMap.put('ن', 'Z');
        biMap.put('ه', '1');
        biMap.put('و', '2');
        biMap.put('ي', '3');
        biMap.put('ؤ', '4');
        biMap.put('ئ', '5');
        biMap.put('ى', '6');
        biMap.put('أ', '7');
        biMap.put('ة', '8');
        biMap.put('ء', '9');
        biMap.put('آ','+');
        biMap.put('إ','-');
    }

    public static String encryption(String name) {
        StringBuilder encryptionName = new StringBuilder();

        for (int i = 0; i < name.length(); i++) {
            char currentChar = name.charAt(i);
            char Equivalent = biMap.get(currentChar);
            encryptionName.append(Equivalent);
        }

        return encryptionName.toString();
    }
    public static String decryption(String name){
        StringBuilder unencryptedName = new StringBuilder();

        for (int i = 0; i < name.length(); i ++){
            char currentChar = name.charAt(i);
            char Equivalent = biMap.inverse().get(currentChar);
            unencryptedName.append(Equivalent);
        }
        return unencryptedName.toString();
    }


}
