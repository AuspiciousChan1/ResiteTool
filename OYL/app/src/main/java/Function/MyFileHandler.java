package Function;

import android.app.Activity;
import android.content.Context;
import android.os.Environment;

import java.io.*;

public class MyFileHandler {
    //读数据
    public static String readTxtFromInnerStorage(String fileName, Context context){
        try {
            FileInputStream fileInputStream = context.openFileInput(fileName);
            int len = fileInputStream.available();//获取文件字节数
            byte[] data = new byte[len];
            fileInputStream.read(data);
            fileInputStream.close();
            return new String(data);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
    //写数据
    public static boolean writeTxtToInnerStorage(String fileName, String detail, Context context) {
        try {
//            String innerPath = Environment.getExternalStorageState();
//            FileOutputStream fileOutputStream = context.openFileOutput(innerPath + fileName, Activity.MODE_PRIVATE);
//            fileOutputStream.write(detail.getBytes());
//            fileOutputStream.flush();
//            fileOutputStream.close();
//            return true;

            File file = new File(Environment.getExternalStorageState() + fileName);
            if(!file.exists()){
                file.createNewFile();
            }
            else {
                file.delete();
                file.createNewFile();
            }
            return true;
        }
        catch (FileNotFoundException fnfe) {
            fnfe.printStackTrace();
            System.out.println("FileNotFoundException：" + fnfe);
            return false;
        }
        catch (IOException ioe) {
            ioe.printStackTrace();
            System.out.println("IOException：" + ioe);
            return false;
        }
    }
    public static boolean writeTxtToExternalStorage(String fileName, String detail, Context context ) {
        File file = new File(Environment.getExternalStorageDirectory(), fileName);
        System.out.println("Dir：" + Environment.getExternalStorageDirectory());
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file, false);
            fileOutputStream.write(detail.getBytes());
            fileOutputStream.flush();
            fileOutputStream.getFD().sync();
            fileOutputStream.close();
            return true;
        } catch (FileNotFoundException e) {
            System.out.println("FileNotFoundException：" + e);
            e.printStackTrace();
            return false;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("IOException：" + e);
            return false;
        }
    }
}