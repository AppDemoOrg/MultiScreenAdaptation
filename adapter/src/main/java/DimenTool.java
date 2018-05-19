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
        String w270file = filePre+"src/main/res/values-w270dp/dimens.xml";
        String w320file = filePre+"src/main/res/values-w320dp/dimens.xml";
        String w360file = filePre+"src/main/res/values-w360dp/dimens.xml";
        String w480file = filePre+"src/main/res/values-w480dp/dimens.xml";
        String w540file = filePre+"src/main/res/values-w540dp/dimens.xml";
        String w600file = filePre+"src/main/res/values-w600dp/dimens.xml";
        String w720file = filePre+"src/main/res/values-w720dp/dimens.xml";
        String w800file = filePre+"src/main/res/values-w800dp/dimens.xml";
        String w820file = filePre+"src/main/res/values-w820dp/dimens.xml";

        // 以此文件夹下的dimens.xml文件内容为初始值参照
        File file = new File(filePre+"src/main/res/values/dimens.xml");
        BufferedReader reader = null;
        StringBuilder w240 = new StringBuilder();
        StringBuilder w270 = new StringBuilder();
        StringBuilder w320 = new StringBuilder();
        StringBuilder w360 = new StringBuilder();
        StringBuilder w480 = new StringBuilder();
        StringBuilder w540 = new StringBuilder();
        StringBuilder w600 = new StringBuilder();
        StringBuilder w720 = new StringBuilder();
        StringBuilder w800 = new StringBuilder();
        StringBuilder w820 = new StringBuilder();

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
                    w240.append(start).append(num * 240/240).append(end).append("\r\n");
                    w270.append(start).append(num * 270/240).append(end).append("\r\n");
                    w320.append(start).append(num * 320/240).append(end).append("\r\n");
                    w360.append(start).append(num * 360/240).append(end).append("\r\n");
                    w480.append(start).append(num * 480/240).append(end).append("\r\n");
                    w540.append(start).append(num * 540/240).append(end).append("\r\n");
                    w600.append(start).append(num * 600/240).append(end).append("\r\n");
                    w720.append(start).append(num * 720/240).append(end).append("\r\n");
                    w800.append(start).append(num * 800/240).append(end).append("\r\n");
                    w820.append(start).append(num * 820/240).append(end).append("\r\n");
                } else {
                    w240.append(tempString).append("\r\n");
                    w270.append(tempString).append("\r\n");
                    w320.append(tempString).append("\r\n");
                    w360.append(tempString).append("\r\n");
                    w480.append(tempString).append("\r\n");
                    w540.append(tempString).append("\r\n");
                    w600.append(tempString).append("\r\n");
                    w720.append(tempString).append("\r\n");
                    w800.append(tempString).append("\r\n");
                    w820.append(tempString).append("\r\n");
                }
                line++;
            }

            reader.close();
            System.out.println("<!--  w240 -->");
            System.out.println(w240);
            System.out.println("<!--  w270 -->");
            System.out.println(w270);
            System.out.println("<!--  w320 -->");
            System.out.println(w320);
            System.out.println("<!--  w360 -->");
            System.out.println(w360);
            System.out.println("<!--  w480 -->");
            System.out.println(w480);
            System.out.println("<!--  w540 -->");
            System.out.println(w540);
            System.out.println("<!--  w600 -->");
            System.out.println(w600);
            System.out.println("<!--  w720 -->");
            System.out.println(w720);
            System.out.println("<!--  w800 -->");
            System.out.println(w800);
            System.out.println("<!--  w820 -->");
            System.out.println(w820);

            //将新的内容，写入到指定的文件中去
            //writeFile(w240file, w240.toString());
            writeFile(w270file, w270.toString());
            //writeFile(w320file, w320.toString());
            //writeFile(w360file, w360.toString());
            //writeFile(w480file, w480.toString());
            writeFile(w540file, w540.toString());
            writeFile(w600file, w600.toString());
            writeFile(w720file, w720.toString());
            writeFile(w800file, w800.toString());
            writeFile(w820file, w820.toString());
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
