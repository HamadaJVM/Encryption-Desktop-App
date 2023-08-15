package com.example.demo_maven_jihad;
import java.nio.file.Paths;
import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.oned.Code128Writer;
import com.google.zxing.oned.Code39Writer;
import com.google.zxing.oned.Code93Writer;

//LOOK HERE !
// if you need to Generate Barcode you have this class
public class GenerateBarcode {
//
//    public static void main(String[] args) {
//
//        try {
//
//            //String text = "ASDFGHJKL 1234567890 +-/%$.";
//            String text = "J460LJ60-LJA90X-0+XA90X+0-";
//            String path = "C:\\Users\\Hmada_Z\\Desktop\\barcodeTest39.jpg";
//
//            Code39Writer writer = new Code39Writer();
//            BitMatrix matrix = writer.encode(text, BarcodeFormat.CODE_39, 500, 300);
//
//            System.out.println(text.length());
//
//            MatrixToImageWriter.writeToPath(matrix, "jpg", Paths.get(path));
//
//            System.out.println("Barcode created...");
//
//        } catch(Exception e) {
//            System.out.println("Error while creating barcode");
//            System.out.println(e.getMessage());
//        }
//    }

}