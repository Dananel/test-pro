package com.txd.io;


import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.Arrays;

/**
 * Io测试
 */
public class IoTest {

    /**
     * 测试字节流
     */
    public void testFile() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL path = classLoader.getResource("io");
        File file = new File(path.getPath());
        String[] list = file.list();
        Arrays.stream(list).forEach((u) -> {
            System.out.println(u);
        });
    }

    /**
     * 测试文件名过滤
     */
    public void testFilefilter() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL path = classLoader.getResource("io");
        File file = new File(path.getPath());
        String[] list = file.list((thisFile, fileName) -> {
            return fileName.endsWith("txt");
        });
        Arrays.stream(list).forEach((u) -> {
            System.out.println(u);
        });
    }

    /**
     * 测试字节流
     */
    public void testByteStream() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("io/test1.txt");
        int data;

        try {
            while ((data = in.read()) != -1) {
                System.out.println((char) data);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 字节缓冲流
     */
    public void testBufferedInputstream() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("io/test1.txt");

        BufferedInputStream buffer = new BufferedInputStream(in);

        byte[] data = new byte[1024];

        try {
            int length;
            while ((length = buffer.read(data)) != -1) {
                String result = new String(data, 0, length);
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println(e);
        } finally {
            try {
                buffer.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * 测试字符流
     */
    public void testReader() {
        ClassLoader classLoader = this.getClass().getClassLoader();
        URL path = classLoader.getResource("io/test1.txt");
        File file = new File(path.getPath());
        // FileReader只能按照默认的字符编码
        FileReader fileReader = null;
        try {
            fileReader = new FileReader(file);
            int read;
            while ((read = fileReader.read()) != -1) {
                System.out.println(((char) read));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileReader != null) {
                try {
                    fileReader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    /**
     * 测试转换流
     */
    public void testInputStreamReader() {
        InputStream in = this.getClass().getClassLoader().getResourceAsStream("io/test1.txt");

        InputStreamReader inputStreamReader = new InputStreamReader(in, Charset.forName("UTF-8"));

        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

        String result;
        try {
            while ((result = bufferedReader.readLine()) != null) {
                System.out.println(result);
            }
        } catch (IOException e) {
            System.out.println(e.getCause());
        } finally {
            try {
                bufferedReader.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
