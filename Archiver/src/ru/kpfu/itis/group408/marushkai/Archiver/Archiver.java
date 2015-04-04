package ru.kpfu.itis.group408.marushkai.Archiver;

import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

/**
 * Created by unlim_000 on 04.04.2015.
 */
public class Archiver {

    public void unarchive(String name){
        try (ZipInputStream zis = new ZipInputStream(new FileInputStream(name))){
            ZipEntry entry;
            while ((entry = zis.getNextEntry()) != null){
                System.out.println(entry.getName());
                try (FileOutputStream fos = new FileOutputStream(entry.getName())){
                    int smth = 0;

                    while ((smth = zis.read()) != -1){
                        fos.write(smth);
                    }
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (FileNotFoundException e){
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void archive(String outName, String[] files){
        try (ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(outName))){
            for (int i = 0; i < files.length; i++){
                if (!new File(files[i]).isFile()){
                    System.out.println(files[i] + " not found");
                    continue;
                }

                try (FileInputStream fis = new FileInputStream(files[i])){
                    zos.putNextEntry(new ZipEntry(files[i]));
                    int smth;
                    while ((smth = fis.read()) != -1){
                        zos.write(smth);
                    }
                } catch (FileNotFoundException e){
                    e.printStackTrace();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        } catch (IOException e){
            e.printStackTrace();
        }
    }
}
