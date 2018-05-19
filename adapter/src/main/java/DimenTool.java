import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @描述： @快速生成适配工具类
 * @作者： @黄卫旗
 * @创建时间： @19/05/2018
 */
public class DimenTool {

    public static void main(String[] args) {
        generateDimens();
    }

    public static void generateDimens() {
        String filePre = "/Users/huangweiqi/StudioProjects/MultiScreenAdaptation/adapter/";
        String w240file = filePre+"src/main/res/values-w240dp/dimens.xml";
        String w480file = filePre+"src/main/res/values-w480dp/dimens.xml";
        String sw600file = filePre+"src/main/res/values-w600dp/dimens.xml";
        String sw720file = filePre+"src/main/res/values-w720dp/dimens.xml";
        String sw800file = filePre+"src/main/res/values-w800dp/dimens.xml";
        String sw820file = filePre+"src/main/res/values-w820dp/dimens.xml";

        // 以此文件夹下的dimens.xml文件内容为初始值参照
        File file = new File(filePre+"src/main/res/values/dimens.xml");
        BufferedReader reader = null;
        StringBuilder sw240 = new StringBuilder();
        StringBuilder w480 = new StringBuilder();
        StringBuilder sw600 = new StringBuilder();
        StringBuilder sw720 = new StringBuilder();
        StringBuilder sw800 = new StringBuilder();
        StringBuilder sw820 = new StringBuilder();

        try {
            System.out.println("生成不同分辨率：");
            if (!file.exists()) {
                file.createNewFile();
            }
            reader = new BufferedReader(new FileReader(file));
            String tempString;
            int line = 1;
            // 一次读入一行，直到读入null为文件结束

            while ((tempString = reader.readLine()) != null) {
                if (tempString.contains("</dimen>")) {
                    //tempString = tempString.replaceAll(" ", "");
                    String start = tempString.substring(0, tempString.indexOf(">") + 1);
                    String end = tempString.substring(tempString.lastIndexOf("<") - 2);
                    //截取<dimen></dimen>标签内的内容，从>右括号开始，到左括号减2，取得配置的数字
                    Double num = Double.parseDouble
                            (tempString.substring(tempString.indexOf(">") + 1,
                                    tempString.indexOf("</dimen>") - 2));

                    //根据不同的尺寸，计算新的值，拼接新的字符串，并且结尾处换行。
                    sw240.append(start).append(num * 0.75).append(end).append("\r\n");
                    w480.append(start).append(num * 480/240).append(end).append("\r\n");
                    sw600.append(start).append(num * 1.87).append(end).append("\r\n");
                    sw720.append(start).append(num * 2.25).append(end).append("\r\n");
                    sw800.append(start).append(num * 2.5).append(end).append("\r\n");
                    sw820.append(start).append(num * 2.56).append(end).append("\r\n");
                } else {
                    sw240.append(tempString).append("\r\n");
                    w480.append(tempString).append("\r\n");
                    sw600.append(tempString).append("\r\n");
                    sw720.append(tempString).append("\r\n");
                    sw800.append(tempString).append("\r\n");
                    sw820.append(tempString).append("\r\n");
                }
                line++;
            }

            reader.close();
            System.out.println("<!--  sw240 -->");
            System.out.println(sw240);
            System.out.println("<!--  w480 -->");
            System.out.println(w480);
            System.out.println("<!--  sw600 -->");
            System.out.println(sw600);
            System.out.println("<!--  sw720 -->");
            System.out.println(sw720);
            System.out.println("<!--  sw800 -->");
            System.out.println(sw800);

            //将新的内容，写入到指定的文件中去
            //writeFile(sw240file, sw240.toString());
            writeFile(w480file, w480.toString());
            //writeFile(sw600file, sw600.toString());
            //writeFile(sw720file, sw720.toString());
            //writeFile(sw800file, sw800.toString());
            //writeFile(sw820file, sw820.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    /**
     * 写入文件
     */
    public static void writeFile(String file, String text) {
        PrintWriter out = null;
        try {
            File temp = new File(file);
            if (!temp.exists()) {
                new File(file.substring(0,file.lastIndexOf("/"))).mkdirs(); // 创建目录
                new File(file).createNewFile(); // 创建文件
            }
            out = new PrintWriter(new BufferedWriter(new FileWriter(file)));
            out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
        out.close();
    }

}
