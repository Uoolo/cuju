package org.cuju.file;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @Author: Uoolo
 * @Description: 文件读取
 * @Date: Create in 19:08 2020/3/17
 */
public class FileReader {

    /**
     * @Description : 读取文件数据流
     * FileReader
     * @Return :
     * @Author : Uoolo
     * @Date : 2020/3/17 19:17
    */
    public static byte[] getFileByte(String pubCerPath) throws IOException {
        //读取resources文件夹下面的资源
        InputStream inputStream = FileReader.class.getClassLoader().getResourceAsStream(pubCerPath);
        BufferedInputStream bufin = new BufferedInputStream(inputStream);
        int buffSize = 1024;
        ByteArrayOutputStream out = new ByteArrayOutputStream(buffSize);

        byte[] temp = new byte[buffSize];
        int size = 0;
        while ((size = bufin.read(temp)) != -1) {
            out.write(temp, 0, size);
        }
        bufin.close();

        byte[] content = out.toByteArray();
        return content;
    }

}

