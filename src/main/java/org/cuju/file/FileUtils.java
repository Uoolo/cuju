package org.cuju.file;

import com.sun.org.slf4j.internal.Logger;
import com.sun.org.slf4j.internal.LoggerFactory;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.http.entity.ContentType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.util.FileCopyUtils;
import org.springframework.util.StreamUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;

/**
 * @Author: Charles
 * @Description: 文件处理
 * @Date: Create in 17:27 2020/4/26
 */
public class FileUtils {
    private static Logger log = LoggerFactory.getLogger(FileUtils.class);

    public static boolean packageZip(File zipFile, List<String> listKey){
        //图片打包操作
        ZipOutputStream zipStream = null;
        FileInputStream zipSource = null;
        BufferedInputStream bufferStream = null;
        try {
            zipStream = new ZipOutputStream(new FileOutputStream(zipFile));// 用这个构造最终压缩包的输出流
//            zipSource = null;// 将源头文件格式化为输入流

            for (String picKey : listKey) {

                File file = new File(picKey);
                //log.info("uppic zipFile: " + picKey );
                zipSource = new FileInputStream(file);

                byte[] bufferArea = new byte[1024 * 10];// 读写缓冲区

                // 压缩条目不是具体独立的文件，而是压缩包文件列表中的列表项，称为条目，就像索引一样
                ZipEntry zipEntry = new ZipEntry(file.getName());
                zipStream.putNextEntry(zipEntry);// 定位到该压缩条目位置，开始写入文件到压缩包中

                bufferStream = new BufferedInputStream(zipSource, 1024 * 10);// 输入缓冲流
                int read = 0;

                // 在任何情况下，b[0] 到 b[off] 的元素以及 b[off+len] 到 b[b.length-1]
                // 的元素都不会受到影响。这个是官方API给出的read方法说明，经典！
                while ((read = bufferStream.read(bufferArea, 0, 1024 * 10)) != -1) {
                    zipStream.write(bufferArea, 0, read);
                }
            }
        } catch (Exception e) {
            // TODO: handle exception
            log.error("zipStream下载文件报错：", e);
            return false;
        } finally {
            // 关闭流
            try {
                if (null != bufferStream)
                    bufferStream.close();
                if (null != zipStream)
                    zipStream.close();
                if (null != zipSource)
                    zipSource.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                //e.printStackTrace();
                log.error("close stream下载文件报错：", e);
                return false;
            }
        }
        return true;
    }

    /**
     * @Description : 下载图片并打包
     * FileUtils
     * @Return :
     * @Author : Charles
     * @Date : 2020/4/27 10:15
    */
    public void downloadImgZip(String downloadFilename,String localUrl,String[] imgs){
        try {
            HttpServletResponse response = null;
            downloadFilename = URLEncoder.encode(downloadFilename, "UTF-8");//转换中文否则可能会产生乱码
            response.setContentType("application/octet-stream");// 指明response的返回对象是文件流
            response.setHeader("Content-Disposition", "attachment;filename=" + downloadFilename);// 设置在下载框默认显示的文件名
            ZipOutputStream zos = new ZipOutputStream(response.getOutputStream());

            if (imgs != null && imgs.length > 0) {
                try {
                    String[] files = imgs;
                    for (int i = 0; i < files.length; i++) {
                        URL url = new URL(files[i]);
                        zos.putNextEntry(new ZipEntry(localUrl + i + ".jpg"));
                        //FileInputStream fis = new FileInputStream(new File(files[i]));
                        InputStream fis = url.openConnection().getInputStream();
                        byte[] buffer = new byte[1024];
                        int r = 0;
                        while ((r = fis.read(buffer)) != -1) {
                            zos.write(buffer, 0, r);
                        }
                        fis.close();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            zos.flush();
            zos.close();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally {

        }
    }

    /**
     * 压缩文件并转流
     * @param fileUrl 文件地址
     * @param scale 压缩比例
     * @return 字节数组
     */
    public static byte[] compressToByte(String fileUrl, float scale) {
        return compressToByte(FileUtils.urlToByte(fileUrl), scale);
    }


    /**
     * 压缩文件并转流
     * @param bytes 字节数组
     * @param scale 压缩比例
     * @return 字节数组
     */
    public static byte[] compressToByte(byte[] bytes, float scale) {
        if (scale > 0) {
            return compressToByte(new ByteArrayInputStream(bytes), scale);
        } else {
            return bytes;
        }
    }

    /**
     * 压缩文件并转流
     * @param fileUrl 文件地址
     * @param scale 压缩比例
     * @return 输入流
     */
    public static InputStream compress(String fileUrl, float scale) {
        return compress(FileUtils.urlToByte(fileUrl), scale);
    }

    /**
     * 压缩文件并转流
     * @param bytes 字节数组
     * @param scale 压缩比例
     * @return 输入流
     */
    public static InputStream compress(byte[] bytes, float scale) {
        return compress(new ByteArrayInputStream(bytes), scale);
    }

    /**
     * 压缩文件
     * @param inputStream 文件流
     * @param scale 压缩比例
     * @return 输入流
     */
    public static InputStream compress(InputStream inputStream, float scale) {
        if (scale <= 0) {
            return inputStream;
        }
        ByteArrayOutputStream baos = null;
        try {
            if (inputStream != null) {
                int size = inputStream.available();
                if (size > 2 * 1024 * 1024) {   //压缩2M以上图片文件大小
                    baos = new ByteArrayOutputStream();
                    Thumbnails.Builder<? extends InputStream> builder = Thumbnails.of(inputStream).scale(scale);
                    builder.toOutputStream(baos);
                    inputStream.close();
                    return new ByteArrayInputStream(baos.toByteArray());
                } else {
                    return inputStream;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        byte[] EMPTY_CONTENT = new byte[0];
        return new ByteArrayInputStream(EMPTY_CONTENT);
    }

    /**
     * 压缩文件
     * @param inputStream 文件流
     * @param scale 压缩比例
     * @return 字节数组
     */
    public static byte[] compressToByte(InputStream inputStream, float scale) {
        ByteArrayOutputStream baos = null;
        try {
            if (inputStream != null) {
                int size = inputStream.available();
                if (size > 2 * 1024 * 1024) {   //压缩2M以上图片文件大小
                    baos = new ByteArrayOutputStream();
                    Thumbnails.Builder<? extends InputStream> builder = Thumbnails.of(inputStream).scale(scale);
                    builder.toOutputStream(baos);
                    return baos.toByteArray();
                } else if(size == 0){
                    return null;
                } else {
                    return StreamUtils.copyToByteArray(inputStream);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (baos != null) {
                    baos.flush();
                    baos.close();
                }

                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * url转变为 MultipartFile对象
     * @param url 文件地址
     * @param fileName 文件名称
     * @return 文件对象
     */
    public static MultipartFile urlToMultipartFile(String url, String fileName) {
        return urlToMultipartFile(url, fileName, 0f);
    }


    /**
     * url转变为 MultipartFile对象并压缩
     * @param url 文件地址
     * @param fileName 文件名称
     * @return 文件对象
     */
    public static MultipartFile urlToMultipartFile(String url, String fileName, float scale){
        InputStream is = null;
        try {
            is = compress(url, scale);
            return new MockMultipartFile(fileName, fileName, ContentType.APPLICATION_OCTET_STREAM.toString(), is);
        } catch (IOException e) {
            throw new RuntimeException("文件下载失败", e);
        } finally {
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 下载图片地址转成字节流
     * @param url 文件网络地址
     * @return 输入流
     */
    public static InputStream urlToInputStream(String url) {
        return new ByteArrayInputStream(urlToByte(url));
    }

    /**
     * 下载图片地址转成字节流
     * @param url 文件网络地址
     * @return 字节数组
     */
    public static byte[] urlToByte(String url) {
        try {
            HttpURLConnection conn = getHttpURLConnection(url, "GET");
            if (conn.getResponseCode() == HttpURLConnection.HTTP_OK) {
                return FileCopyUtils.copyToByteArray(conn.getInputStream());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new byte[0];
    }

    /**
     *
     * @param inputStream 输入流
     * @param fileName 文件名称
     * @param savePath 保存路径
     * @return 文件对象
     */
    public static File downloadFileFromInputStream(InputStream inputStream, String fileName, String savePath) {
        File file = null;
        try {
            String path = savePath + File.separatorChar + fileName;
            file = new File(path);
            if (!file.getParentFile().exists()) {
                boolean mkdir = file.getParentFile().mkdirs();
                System.out.println(mkdir);
            }
            OutputStream out = new FileOutputStream(file);
            int size;
            byte[] buf = new byte[1024];
            while ((size = inputStream.read(buf)) != -1) {
                out.write(buf, 0, size);
            }
            inputStream.close();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    private static HttpURLConnection getHttpURLConnection(String path, String method) throws IOException {
        // 统一资源
        URL url = new URL(path);
        // 连接类的父类，抽象类
        URLConnection urlConnection = url.openConnection();
        // http的连接类
        urlConnection.setDoInput(true);
        HttpURLConnection httpURLConnection = (HttpURLConnection) urlConnection;
        // 设定请求的方法，默认是GET
        httpURLConnection.setRequestMethod(method);
        // 设置字符编码
        httpURLConnection.setRequestProperty("Charset", "UTF-8");
        // 打开到此 URL 引用的资源的通信链接（如果尚未建立这样的连接）。
        httpURLConnection.connect();
        httpURLConnection.setConnectTimeout(2 * 1000);
        httpURLConnection.setReadTimeout(3 * 1000);
        return httpURLConnection;
    }

    /**
     * 图片压缩转base64
     * @param url
     * @param scale
     * @return
     */
    public static String imageToBase64(String url,float scale){
        byte[] str = compressToByte(url, scale);
        String encoded = DatatypeConverter.printBase64Binary(str);
        return encoded;
    }
}
