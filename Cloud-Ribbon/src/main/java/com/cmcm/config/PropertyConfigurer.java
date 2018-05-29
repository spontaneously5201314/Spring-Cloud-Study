//package com.cmcm.config;
//
//importannotation com.ctrip.framework.apollo.Config;
//importannotation com.ctrip.framework.apollo.ConfigService;
//importannotation org.slf4j.Logger;
//importannotation org.slf4j.LoggerFactory;
//
//importannotation java.io.IOException;
//importannotation java.io.StringReader;
//importannotation java.text.MessageFormat;
//importannotation java.util.Enumeration;
//importannotation java.util.Properties;
//
///**
// * @project 账户体系相关
// * @Author yangzq
// * @Date 18-1-12 下午3:22
// * @desc 全局配置中心
// **/
//public class PropertyConfigurer {
//
//    public static Logger logger = LoggerFactory.getLogger(PropertyConfigurer.class);
//
//    private static Properties props = null;
//
//    private static Config config;
//
//    public static void load(StringReader reader) {
//        if (null == props) {
//            props = new Properties();
//        }
//        try {
//            props.load(reader);
//        } catch (IOException ex) {
//            logger.error("配置文件加载异常", ex);
//        }
//    }
//
//    public static void load(Properties defaultProps) {
//        if (null == props) {
//            props = new Properties();
//            convertProperties(defaultProps);
//        } else {
//            convertProperties(defaultProps);
//        }
//    }
//
//    public static void load(Config apolloConfig) {
//        PropertyConfigurer.config = apolloConfig;
//        if (null == props) {
//            props = new Properties();
//        }
//    }
//
//    public static void convertProperties(Properties defaultProps) {
//        Enumeration<?> propertyNames = defaultProps.propertyNames();
//        while (propertyNames.hasMoreElements()) {
//            String propertyName = (String) propertyNames.nextElement();
//            String propertyValue = defaultProps.getProperty(propertyName);
//            if (isNotEmpty(propertyName)) {
//                props.setProperty(propertyName, propertyValue);
//                System.setProperty(propertyName, propertyValue);
//            }
//        }
//    }
//
//    public static boolean isEmpty(String str) {
//        return (str == null) || "".equals(str) || (str.trim().length() == 0);
//    }
//
//
//    private static boolean isNotEmpty(String str) {
//        return !isEmpty(str);
//    }
//
//    public static Object getProperty(String key) {
//        Object result;
//        if (config != null) {
//            result = config.getProperty(key, null);
//            if (result == null) {
//                result = ConfigService.getAppConfig().getProperty(key, null);
//            }
//        } else {
//            result = ConfigService.getAppConfig().getProperty(key, null);
//        }
//        if (result == null) {
//            result = props.getProperty(key);
//        }
//        if (result == null) {
//            return null;
//        }
//        return result;
//    }
//
//    public static String getValue(String key) {
//        Object object = getProperty(key);
//        if (null != object) {
//            return (String) object;
//        } else {
//            logger.warn("配置项为" + key + "的配置未在Apollo中添加或设置的内容为空");
//            return null;
//        }
//    }
//
//    public static String getValue(String key, String defaultValue) {
//        Object object = getProperty(key);
//        if (null != object) {
//            return (String) object;
//        } else {
//            logger.warn("配置项为" + key + "的配置未在Apollo中添加或设置的内容为空");
//            return defaultValue;
//        }
//    }
//
//    public static String getString(String key) {
//        Object object = getProperty(key);
//        if (null != object) {
//            return (String) object;
//        } else {
//            logger.warn("配置项为" + key + "的配置未在Apollo中添加或设置的内容为空");
//            return null;
//        }
//    }
//
//    public static String getString(String key, String defaultString) {
//        Object object = getProperty(key);
//        if (null != object) {
//            return (String) object;
//        } else {
//            logger.warn("配置项为" + key + "的配置未在Apollo中添加或设置的内容为空");
//            return defaultString;
//        }
//    }
//
//    public static Long getLong(String key) {
//        Object object = getProperty(key);
//        if (null != object) {
//            return Long.parseLong(object.toString());
//        } else {
//            logger.warn("配置项为" + key + "的配置未在Apollo中添加或设置的内容为空");
//            return null;
//        }
//    }
//
//    public static Long getLong(String key, long defaultLong) {
//        Object object = getProperty(key);
//        if (null != object) {
//            return Long.parseLong(object.toString());
//        } else {
//            logger.warn("配置项为" + key + "的配置未在Apollo中添加或设置的内容为空");
//            return defaultLong;
//        }
//    }
//
//    public static Integer getInteger(String key) {
//        Object object = getProperty(key);
//        if (null != object) {
//            return Integer.parseInt(object.toString());
//        } else {
//            logger.warn("配置项为" + key + "的配置未在Apollo中添加或设置的内容为空");
//            return null;
//        }
//    }
//
//    public static Integer getInteger(String key, int defaultInt) {
//        Object object = getProperty(key);
//        if (null != object) {
//            return Integer.parseInt(object.toString());
//        } else {
//            logger.warn("配置项为" + key + "的配置未在Apollo中添加或设置的内容为空");
//            return defaultInt;
//        }
//    }
//
//    public static String getString(String key, Object[] array) {
//        String message = getValue(key);
//        if (null != message) {
//            return MessageFormat.format(message, array);
//        } else {
//            return null;
//        }
//    }
//
//    public static String getValue(String key, Object... array) {
//        String message = getValue(key);
//        if (null != message) {
//            return MessageFormat.format(message, array);
//        } else {
//            return null;
//        }
//    }
//
//    public static Properties getProps() {
//        return props;
//    }
//
//    public void setProps(Properties props) {
//        PropertyConfigurer.props = props;
//    }
//
//}