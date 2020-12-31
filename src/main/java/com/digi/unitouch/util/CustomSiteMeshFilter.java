package com.digi.unitouch.util;

import org.sitemesh.builder.SiteMeshFilterBuilder;
import org.sitemesh.config.ConfigurableSiteMeshFilter;

public class CustomSiteMeshFilter extends ConfigurableSiteMeshFilter {
    @Override
    protected void applyCustomConfiguration(SiteMeshFilterBuilder builder) {
          // Assigning default decorator if no path specific decorator found
            builder.addDecoratorPath("/*", "/WEB-INF/sitemesh/Decorator.jsp")
           // Map decorators to specific path patterns. 
            .addDecoratorPath("/", "/WEB-INF/sitemesh/simpleDecorator.jsp")
      .addDecoratorPath("/login", "/WEB-INF/sitemesh/simpleDecorator.jsp")
      .addDecoratorPath("/autoLoder", "/WEB-INF/sitemesh/simpleDecorator.jsp")
      .addDecoratorPath("/forgotPasswordToken", "/WEB-INF/sitemesh/simpleDecorator.jsp")
      .addDecoratorPath("/forgotPassword", "/WEB-INF/sitemesh/simpleDecorator.jsp")
      .addDecoratorPath("/validate", "/WEB-INF/sitemesh/simpleDecorator.jsp")
       // Exclude few paths from decoration.
      .addExcludedPath("/resources/**")                
      .addExcludedPath("/brochures/*");
    }
}