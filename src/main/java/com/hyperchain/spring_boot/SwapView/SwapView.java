/**
 * Copyright (C), 2016-2018, 趣链科技有限有限公司
 * FileName: SwapView
 * Author:   lixuanfeng
 * Date:     2018/11/21 下午8:44
 * Description:
 * History:
 * <author>          <time>          <version>          <desc>
 * 作者姓名           修改时间           版本号              描述
 */
package com.hyperchain.spring_boot.SwapView;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 * 〈一句话功能简述〉<br>
 * 〈〉
 *
 * @author lixuanfeng
 * @create 2018/11/21
 * @since 1.0.0
 */
public class SwapView {
    public int pid;
    public double size;
    public String comm;

    public SwapView(int p, double s, String c) {
        pid = p;
        size = s;
        comm = c;
    }

    public static String filesize(double size) {
        String units = "KMGT";
        double left = Math.abs(size);
        int unit = -1;
        while (left > 1100 && unit < 3) {
            left /= 1024;
            unit++;
        }
        if (unit == -1) {
            return String.format("%dB", (int) size);
        } else {
            if (size < 0) left = -left;
            return String.format("%.1f%ciB", left, units.charAt(unit));
        }
    }

    public static SwapView getSwapFor(int pid) {
        try {
            String comm = new String(Files.readAllBytes(
                    Paths.get(String.format("/Users/lixuanfeng/Desktop/项目搭建/spring_boot/proc/%d/cmdline", pid))),
                    StandardCharsets.UTF_8);
            comm = comm.replace('\0', ' ');

            if (comm.charAt(comm.length() - 1) == ' ')
                comm = comm.substring(0, comm.length() - 1);
            double s = 0;
            for (String l : Files.readAllLines(
                    Paths.get(String.format("/Users/lixuanfeng/Desktop/项目搭建/spring_boot/proc/%d/smaps", pid)),
                    StandardCharsets.UTF_8)) {
                if (l.startsWith("Swap:")) {
                    String[] a = l.split(" ");
                    s += Integer.parseInt(a[a.length - 2]);
                }
            }
            return new SwapView(pid, s * 1024, comm);
        } catch (Exception e) {
            return new SwapView(pid, 0, "");
        }
    }

    public static List<SwapView> getSwap() {
        List<SwapView> ret = new ArrayList<>();
        for (File fpid : new File("/Users/lixuanfeng/Desktop/项目搭建/spring_boot/proc").listFiles()) {
            try {
                //获取/dev下的文件的文件名（该文件名以进程号作为文件名）
                int pid = Integer.parseInt(fpid.getName());
                SwapView s = getSwapFor(pid);
                if (s.size > 0) ret.add(s);
            } catch (NumberFormatException e) {
            } // do nothing for parse error
        }
        ret.sort((a, b) -> Double.compare(a.size, b.size));
        return ret;
    }

    public static void main(String[] argv) {
        List<SwapView> results = getSwap();
        System.out.printf("%5s %9s %s\n", "PID", "SWAP", "COMMAND");
        double t = 0.0;
        for (SwapView s : results) {
            System.out.printf("%5d %9s %s\n", s.pid, filesize(s.size), s.comm);
            t += s.size;
        }
        System.out.printf("Total: %8s\n", filesize(t));
    }

}