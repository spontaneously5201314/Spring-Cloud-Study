package com.cmcm.study.jar;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.jar.Attributes;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * 测试通过java.util.jar下面的类获得jar包中的MANIFEST信息
 *
 * @author Spontaneously
 * @time 2018-11-21 下午3:05
 */
public class TestManifest {

    public static void main(String[] args) throws IOException {
        JarFile jar = new JarFile(new File("/home/hongfei/account-api-1.0.0-SNAPSHOT.jar"));
        Manifest manifest = jar.getManifest();
        Attributes mainAttributes = manifest.getMainAttributes();
        for (Map.Entry<Object, Object> attrEntry : mainAttributes.entrySet()) {
            System.out.println("main\t" + attrEntry.getKey() + "-->" + attrEntry.getValue());
        }
        Map<String, Attributes> entries = manifest.getEntries();
        for (Map.Entry<String, Attributes> entry : entries.entrySet()) {
            Attributes values = entry.getValue();
            for (Map.Entry<Object, Object> attrEntry : values.entrySet()) {
                System.out.println(attrEntry.getKey() + "-->" + attrEntry.getValue());
            }
        }
    }
}
