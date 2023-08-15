package com.example.demo_maven_jihad;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class InfoConverter {
    private static BiMap<Character, String> biMapDepartment = HashBiMap.create();

    static {
        biMapDepartment.put('0', "أدارة القسم الفني");
        biMapDepartment.put('1', "شعبة الاحصاء");
        biMapDepartment.put('2', "شعبة الصيدلة");
        biMapDepartment.put('3', "شعبة المختبر");
        biMapDepartment.put('4', "شعبة الكلية الصناعيه/مختبر الديلزة");
        biMapDepartment.put('5', "شعبة الكلية الصناعيه/صيديلة الديلزة");
        biMapDepartment.put('6', "شعبة الكلية الصناعيه/الكادر التمريضي");

        biMapDepartment.put('A', "وحدة مكافحة العدوى");
        biMapDepartment.put('B', "وحدة الصحة العامة");
        biMapDepartment.put('C', "وحدة الأعاشة");
        biMapDepartment.put('D', "وحدة فحص المياه");
        biMapDepartment.put('E', "وحدة الأجهزة الطبية");
        biMapDepartment.put('F', "وحدة السيطرة على المضادات ");
        biMapDepartment.put('G', "وحدة الأجازات و التقارير");
        biMapDepartment.put('H', "وحدة فحص الجثث");
        biMapDepartment.put('I', "وحدة العوز المناعي");
        biMapDepartment.put('K', "وحدة قضايا الشرطة");


    }

    private static BiMap<Character, String> biMapTitle = HashBiMap.create();

    static {
        biMapTitle.put('0', "م.صيدلي");
        biMapTitle.put('1', "م.بايلوجي");
        biMapTitle.put('2', "م.كيماوي");
        biMapTitle.put('3', "م.مختبر");
        biMapTitle.put('4', "م.محلل مختبر");
        biMapTitle.put('5', "م.باحث صحة بيئية");
        biMapTitle.put('6', "م.طبي");
        biMapTitle.put('7', "م.ماهر");
        biMapTitle.put('8', "م.جامعي");
        biMapTitle.put('9', "م.فني");
        biMapTitle.put('A', "م.اغذيه");

        biMapTitle.put('B', "معالج طبيعي");
        biMapTitle.put('C', "كيمياوي");
        biMapTitle.put('D', "بايلوجي");
        biMapTitle.put('E', "صيدلاني");
        biMapTitle.put('F', "طبيب اختصاص");
        biMapTitle.put('G', "ملاحظ");
        biMapTitle.put('H', "مهندس");
        biMapTitle.put('I', "تقني بصريات");
        biMapTitle.put('K', "تقني احيائي");
        biMapTitle.put('L', "ت.طبي");
        biMapTitle.put('M', "ت.تحليلات");
    }


    public static String titleEncryption(String title) {
        return ""+biMapTitle.inverse().get(title);
    }

    public static String departmentEncryption(String department) {
        return ""+biMapDepartment.inverse().get(department);
    }

    public static String nameEncryption(String name) {
        return NamesConverter.encryption(name);
    }

    public static String titleDecryption(Character title) {
        return biMapTitle.get(title);
    }

    public static String departmentDecryption(Character department) {
        return biMapDepartment.get(department);
    }

    public static String nameDecryption(String  name) {
        return NamesConverter.decryption(name);
    }


}
