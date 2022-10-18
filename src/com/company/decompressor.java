package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class decompressor {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        GZIPInputStream gzipInputStream = new GZIPInputStream(fis);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/Decompressed.txt");
        byte[] buffer = new byte[1024];
        int len;
        while((len=gzipInputStream.read(buffer))!=-1){
            System.out.println(len);
            fos.write(buffer,0,len);
        }
        gzipInputStream.close();
        fis.close();
        fos.close();
    }

    public static void main(String[] args)throws IOException {
File path = new File("D:/Projects/textFiles/Compressedfile.gz");
method(path);
    }

}
