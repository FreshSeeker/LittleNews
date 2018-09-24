package com.freshseeker.android.littlenews;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileUtil {

    /**
     * 复制文件
     *
     * @param source 输入文件
     * @param target 输出文件
     */
    public static void copy(Context context, File source, File target) throws IOException {
        FileInputStream fileInputStream = null;
        FileOutputStream fileOutputStream = null;
        try {
            fileInputStream = new FileInputStream(source);
            fileOutputStream = new FileOutputStream(target);
            byte[] buffer = new byte[1024];
            while (fileInputStream.read(buffer) > 0) {
                fileOutputStream.write(buffer);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fileInputStream!=null){
                fileInputStream.close();
            }
            if (fileOutputStream!=null){
                fileOutputStream.flush();
                fileOutputStream.close();

                Toast.makeText(context, "保存成功", Toast.LENGTH_SHORT).show();

//                //把文件插入到系统图库
//                try {
//                    MediaStore.Images.Media.insertImage(context.getContentResolver(),
//                            target.getAbsolutePath(), target.getName(), null);
//                } catch (FileNotFoundException e) {
//                    e.printStackTrace();
//                }

                // 最后通知图库更新
                context.sendBroadcast(new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, Uri.parse("file://" + target)));
            }
        }
    }
}