package com.zaurtregulov.spring.rest.configuration;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

    // Так как мы не используем web.xml, мы должны сами создать:

    /*
      <servlet>
        <servlet-name>dispatcher</servlet-name>
        <servlet-class>org.springframework.web.servlet.DispatcherServlet</servlet-class>
        <init-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>/WEB-INF/applicationContext.xml</param-value>
        </init-param>
        <load-on-startup>1</load-on-startup>
      </servlet>

      <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
      </servlet-mapping>
     */

public class MyWebInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    // Должны переопределить ТРИ основных метода

    //Никаких RootClass у нас не будет, по-этому возвращаем null
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return null;
    }

    /*
        <init-param>
          <param-name>contextConfigLocation</param-name>
          <param-value>/WEB-INF/applicationContext.xml</param-value>
        </init-param>
    */
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class[] {MyConfig.class};
    }

    /*
      <servlet-mapping>
        <servlet-name>dispatcher</servlet-name>
        <url-pattern>/</url-pattern>
      </servlet-mapping>
     */
    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
