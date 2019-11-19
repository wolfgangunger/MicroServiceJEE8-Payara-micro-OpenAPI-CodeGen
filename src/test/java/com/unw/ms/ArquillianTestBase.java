package com.unw.ms;

import com.unw.ms.UnwDataSource;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.Filters;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.runner.RunWith;
import com.unw.ms.config.ConfigTestController;
import com.unw.ms.metric.MetricController;

/**
 * extend this class for container tests
 * @author XUNGEW
 */
@RunWith(Arquillian.class)
public abstract class ArquillianTestBase {

  /**
   * @return a java archive with the classes to deploy
   */
  @Deployment
  public static JavaArchive createDeployment() {
    return ShrinkWrap
            .create(JavaArchive.class)
            .addPackages(true, Filters.exclude(UnwDataSource.class, ConfigTestController.class, MetricController.class), "com.unw")
            .addAsResource("test-persistence.xml",
                    "META-INF/persistence.xml");
  }

}
