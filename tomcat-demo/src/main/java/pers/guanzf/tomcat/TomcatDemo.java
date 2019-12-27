package pers.guanzf.tomcat;

import org.apache.catalina.core.StandardContext;
import org.apache.catalina.startup.Tomcat;

/**
 * @author Grow-Worm
 * @date 2019/11/08
 */
public class TomcatDemo {

    public static void main(String[] args) throws Exception {
        Tomcat tomcat = new Tomcat();

        tomcat.setPort(8888);
        tomcat.setBaseDir("./");

        StandardContext context = new StandardContext();
        context.setPath("/home");
        context.addLifecycleListener(new Tomcat.FixContextListener());

        tomcat.getHost().addChild(context);

        tomcat.addServlet("/home", "HomeServlet", new HomeServlet());

        context.addServletMappingDecoded("/h", "HomeServlet");

        StandardContext context1 = new StandardContext();
        context1.setPath("/book");
        context1.addLifecycleListener(new Tomcat.FixContextListener());

        tomcat.getHost().addChild(context1);

        tomcat.addServlet("/book", "BookServlet", new BookServlet());

        context1.addServletMappingDecoded("/b", "BookServlet");

        tomcat.start();

        tomcat.getServer().await();
    }

}
