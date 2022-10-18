package com.company;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.GZIPOutputStream;

public class compressor {
    public static void method(File file) throws IOException{
        String fileDirectory = file.getParent();
        FileInputStream fis = new FileInputStream(file);
        FileOutputStream fos = new FileOutputStream(fileDirectory+"/Compressed.gz");
        GZIPOutputStream gzipOutputStream = new GZIPOutputStream(fos);

        byte [] buffer = new byte[1024];
        int len;
        while((len=fis.read(buffer)) != -1){
            gzipOutputStream.write(buffer,0,len);
        }
        gzipOutputStream.close();
        fos.close();
        fis.close();
    }

    public static void main(String[] args) throws IOException {
        File path = new File("D:/Projects/textFiles/textfile.txt");
        method(path);
    }
}
