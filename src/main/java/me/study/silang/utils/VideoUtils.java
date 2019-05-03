package me.study.silang.utils;
//
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class VideoUtils {
//
    public static void getVideoHead(String videoSrc, String headSrc) throws Exception {
        long start = System.currentTimeMillis();
        File targetFile = new File(headSrc);
        if (!targetFile.exists()) targetFile.createNewFile();
        FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videoSrc);
        ff.start();
        int lenght = ff.getLengthInFrames();
        int i = 0;
        Frame f = null;
        while (i < lenght) {
            // 过滤前5帧，避免出现全黑的图片，依自己情况而定
            f = ff.grabFrame();
            if ((i > 0) && (f.image != null)) {
                break;
            }
            i++;
        }

        Java2DFrameConverter converter =new Java2DFrameConverter();
        BufferedImage img =converter.getBufferedImage(f);
        int owidth = img.getWidth();
        int oheight = img.getHeight();
        // 对截取的帧进行等比例缩放
        int width = 800;
        int height = (int) (((double) width / owidth) * oheight);
        BufferedImage bi = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
        bi.getGraphics().drawImage(img.getScaledInstance(width, height, Image.SCALE_SMOOTH),0, 0, null);
        ImageIO.write(bi, "jpg", targetFile);
        //ff.flush();
        ff.stop();
        System.out.println(System.currentTimeMillis() - start);
    }

    public static void getVideoHead2(String videoSrc, String headSrc){
        List<String> cutpic = new ArrayList<>();
        cutpic.add("sudo");
        cutpic.add("/home/ff/ffmpeg/");
        cutpic.add("-i");
        cutpic.add(videoSrc); // 同上（指定的文件即可以是转换为flv格式之前的文件，也可以是转换的flv文件）
        cutpic.add("-y");
        cutpic.add("-f");
        cutpic.add("image2");
        cutpic.add("-ss"); // 添加参数＂-ss＂，该参数指定截取的起始时间
        cutpic.add("0"); // 添加起始时间为第17秒
        cutpic.add("-t"); // 添加参数＂-t＂，该参数指定持续时间
        cutpic.add("0.001"); // 添加持续时间为1毫秒
        cutpic.add("-s"); // 添加参数＂-s＂，该参数指定截取的图片大小
        cutpic.add("500*400"); // 添加截取的图片大小为350*240
        cutpic.add(headSrc); // 添加截取的图片的保存路径

        ProcessBuilder builder = new ProcessBuilder();
        try {

            builder.command(cutpic);
            builder.redirectErrorStream(true);
            // 如果此属性为 true，则任何由通过此对象的 start() 方法启动的后续子进程生成的错误输出都将与标准输出合并，
            // 因此两者均可使用 Process.getInputStream() 方法读取。这使得关联错误消息和相应的输出变得更容易
            builder.start();
        } catch (Exception e) {
            System.out.println(e);
            e.printStackTrace();
        }

    }
}
