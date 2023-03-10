package cn.j3code.config.util;

import cn.hutool.core.io.FileUtil;
import cn.hutool.core.io.IoUtil;
import cn.j3code.config.exception.LdException;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.CharEncoding;

import java.io.FileInputStream;

/**
 * @program: luck-draw
 * @description:
 * @author: lyj
 * @create: 2023-02-07 21:30
 **/
@Slf4j
public class FileLoad {

    public static String read(String fileName){
        String val = "";
        try {
            // val = IoUtil.read(new FileInputStream(fileName),"UTF-8");
            // new FileInputStream(new file)
            val = IoUtil.read(new FileInputStream(FileUtil.file(fileName)), CharEncoding.UTF_8);
        }catch (Exception e){
            // 错误处理
            log.error("文件路径读取失败：{}", fileName, e);
            throw new LdException(String.format("文件路径读取失败: %s", fileName));
        }
        // 返回lua脚本
        return val;
    }
}
