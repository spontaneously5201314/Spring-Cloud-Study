package com.cmcm.study.importer.registry;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

/**
 * @author hongfei
 * @create 2018-05-22 下午3:32
 */
public class MyImportSelector implements ImportSelector {
    @Override
    public String[] selectImports(AnnotationMetadata importingClassMetadata) {
        return new String[]{
                MyImportBeanDefinitionRegistrar.class.getName()
        };
    }
}
