package com.example.lab2.viewmodel;


import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileProcessor {
   /* public static String loadFile(String fileName){
        FileInputStream fin = null;
        try {
            fin = new FileInputStream(fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        byte[] bytes = new byte[0];
        try {
            bytes = new byte[fin.available()];
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            fin.read(bytes);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String text = new String(bytes);
        return text;
    }

    public static void writeToFile(String fileName, String msg, Context ctx){
        FileOutputStream fos = null;
        try {
            fos = ctx.openFileOutput(fileName, Context.MODE_APPEND);
            msg = msg+"\n";
            try {
                fos.write(msg.getBytes());
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(fos!=null)
                    fos.close();
            } catch (IOException e){
                e.printStackTrace();
            }
        }


    } */

    public static String loadFileContent(String fileName) {
        String rezult = "";
        StringBuilder stringBuilder = new StringBuilder();
        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(downloadsDir, fileName);
        try {
            BufferedReader reader = new BufferedReader(new FileReader(myFile));

            String line = null;
            String ls = System.getProperty("line.separator");
            while ((line = reader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(ls);
            }
            stringBuilder.deleteCharAt(stringBuilder.length() - 1);
            reader.close();
        }catch(Exception e){
            e.printStackTrace();
        }

        rezult = stringBuilder.toString();
        return rezult;
    }

    public static void saveToFile(String fileName, String message){
        File downloadsDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File myFile = new File(downloadsDir, fileName);
        try {
            FileWriter out = new FileWriter(myFile, true);
            out.write(message+"\n");
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

