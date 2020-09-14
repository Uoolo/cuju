package org.cuju.file;

import sun.misc.BASE64Encoder;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

/***
 * @description: 图片转base64
 *
 * @author: Uoolo
 * @version: 2020-08-19
 **/
public class ImageToBase64Utils {

    private static String strNetImageToBase64;
    /**
     * 网络图片转换Base64的方法
     *
     * @param netImagePath
     */
    public static String NetImageToBase64(String netImagePath) {
        final ByteArrayOutputStream data = new ByteArrayOutputStream();
        try {
            // 创建URL
            URL url = new URL(netImagePath);
            final byte[] by = new byte[1024];
            // 创建链接
            final HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("GET");
            conn.setConnectTimeout(5000);


            InputStream is = conn.getInputStream();
            // 将内容读取内存中
            int len = -1;
            while ((len = is.read(by)) != -1) {
                data.write(by, 0, len);
            }
            // 对字节数组Base64编码
            BASE64Encoder encoder = new BASE64Encoder();
            strNetImageToBase64 = encoder.encode(data.toByteArray());
            //System.out.println("网络图片转换Base64:" + strNetImageToBase64);
            // 关闭流
            is.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

        return strNetImageToBase64;
    }

}
