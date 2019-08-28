package utils;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * 验证码生成器
 * link: https://www.cnblogs.com/chiangchou/p/VCodeGenerator.html
 */
public class VCodeGenerator {

    /**
     * 验证码来源
     */
    final private char[] code = {
            '2', '3', '4', '5', '6', '7', '8', '9',
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j',
            'k', 'm', 'n', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F',
            'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q', 'R',
            'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'
    };
    /**
     * 字体
     */
    final private String[] fontNames = new String[]{
            "黑体", "宋体", "Courier", "Arial",
            "Verdana", "Times", "Tahoma", "Georgia"};
    /**
     * 字体样式
     */
    final private int[] fontStyles = new int[]{
            Font.BOLD, Font.ITALIC|Font.BOLD
    };

    /**
     * 验证码长度
     * 默认4个字符
     */
    private int vcodeLen = 4;
    /**
     * 验证码图片字体大小
     * 默认17
     */
    private int fontsize = 21;
    /**
     * 验证码图片宽度
     */
    private int width = (fontsize+1)*vcodeLen+10;
    /**
     * 验证码图片高度
     */
    private int height = fontsize+12;

    /**
     * 生成验证码图片
     */
    private BufferedImage generatorVCodeImage(String vcode){
        //创建验证码图片
        BufferedImage vcodeImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        Graphics g = vcodeImage.getGraphics();
        //填充背景色
        g.setColor(new Color(246, 240, 250));
        g.fillRect(0, 0, width, height);
        drawDisturbLine(g);
        //用于生成伪随机数
        Random ran = new Random();
        //在图片上画验证码
        for(int i = 0;i < vcode.length();i++){
            //设置字体
            //noinspection MagicConstant
            g.setFont(new Font(fontNames[ran.nextInt(fontNames.length)], fontStyles[ran.nextInt(fontStyles.length)], fontsize));
            //随机生成颜色
            g.setColor(getRandomColor());
            //画验证码
            g.drawString(vcode.charAt(i)+"", i*fontsize+10, fontsize+5);
        }
        //释放此图形的上下文以及它使用的所有系统资源
        g.dispose();

        return vcodeImage;
    }
    /**
     * 生成验证码
     * @return 验证码
     */
    private String generatorVCode(){
        int len = code.length;
        Random ran = new Random();
        StringBuilder sb = new StringBuilder();
        for(int i = 0;i < vcodeLen;i++){
            int index = ran.nextInt(len);
            sb.append(code[index]);
        }
        return sb.toString();
    }
    /**
     * 为验证码图片画一些干扰线
     */
    private void drawDisturbLine(Graphics g){
        Random ran = new Random();
        int disturbLine = 3;
        for(int i = 0; i < disturbLine; i++){
            int x1 = ran.nextInt(width);
            int y1 = ran.nextInt(height);
            int x2 = ran.nextInt(width);
            int y2 = ran.nextInt(height);
            g.setColor(getRandomColor());
            //画干扰线
            g.drawLine(x1, y1, x2, y2);
        }
    }
    /**
     * @return 返回一个随机颜色
     */
    private Color getRandomColor(){
        Random ran = new Random();
        return new Color(ran.nextInt(220), ran.nextInt(220), ran.nextInt(220));
    }

    public void getVCode(HttpServletRequest request, HttpServletResponse response) {
        //验证码不能缓存
        response.setHeader("Expires", "-1");
        response.setHeader("cache-control", "no-cahce");
        response.setHeader("pragma", "no-cache");

        String vcode = this.generatorVCode();
        //获取验证码图片
        BufferedImage vcodeImage = this.generatorVCodeImage(vcode);
        //将验证码保存到session域对象
        request.getSession().setAttribute("vcode", vcode);
        //输出验证码图片
        try {
            ImageIO.write(vcodeImage, "gif", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
