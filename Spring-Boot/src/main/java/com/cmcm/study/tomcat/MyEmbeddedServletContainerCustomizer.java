package com.cmcm.study.tomcat;

import org.apache.catalina.connector.Connector;
import org.apache.catalina.valves.AccessLogValve;
import org.apache.catalina.valves.Constants;
import org.apache.coyote.http11.Http11NioProtocol;
import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatConnectorCustomizer;
import org.springframework.boot.context.embedded.tomcat.TomcatEmbeddedServletContainerFactory;
import org.springframework.stereotype.Component;

import java.io.File;

/**
 * SpringBoot中定制Tomcat的第一种方法
 * @author hongfei
 * @create 2018-06-06 下午2:43
 */
//@Component
public class MyEmbeddedServletContainerCustomizer implements EmbeddedServletContainerCustomizer {

    private static final String PATH = "/opt/idea/workspace/Spring-Cloud-Study/Spring-Boot/src/main/resources/";

    @Override
    public void customize(ConfigurableEmbeddedServletContainer container) {
        System.out.println(container.getClass());
        TomcatEmbeddedServletContainerFactory factory = (TomcatEmbeddedServletContainerFactory) container;
        factory.setPort(10003);
        factory.setBaseDirectory(new File(PATH));
        factory.addContextValves(getAccessLogValve());
        factory.addConnectorCustomizers(new MyTomcatConnectorCustomizer());
    }

    private AccessLogValve getAccessLogValve() {
        AccessLogValve accessLogValve = new AccessLogValve();
        accessLogValve.setDirectory(PATH);
        accessLogValve.setPattern(Constants.AccessLog.COMMON_ALIAS);
        accessLogValve.setEnabled(true);
        accessLogValve.setPrefix("accessLog");
        accessLogValve.setSuffix(".txt");
        return accessLogValve;
    }

    private class MyTomcatConnectorCustomizer implements TomcatConnectorCustomizer {

        @Override
        public void customize(Connector connector) {
            System.out.println(connector.getProtocol());
            System.out.println(connector.getProtocolHandler());
            Http11NioProtocol protocol = (Http11NioProtocol) connector.getProtocolHandler();
            protocol.setMaxConnections(100);
            protocol.setMaxThreads(10);
        }
    }
}

