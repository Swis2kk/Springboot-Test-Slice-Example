package org.example.common.custom;

import org.example.common.custom.CustomTestAnnotation;
import org.example.anntatioins.CustomAnnotation;
import org.springframework.boot.test.autoconfigure.filter.AnnotationCustomizableTypeExcludeFilter;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.annotation.AnnotatedElementUtils;

import java.util.Collections;
import java.util.Set;

public class CustomTestExcludeFilter extends AnnotationCustomizableTypeExcludeFilter {

    //Will catch any annotation specified in set
    private static final Set<Class<?>> DEFAULT_INCLUDES = Set.of(CustomAnnotation.class);

    private CustomTestAnnotation annotation;

    CustomTestExcludeFilter(Class<?> testClass) {
        this.annotation = AnnotatedElementUtils.getMergedAnnotation(testClass, CustomTestAnnotation.class);
    }

    @Override
    protected boolean hasAnnotation() {
        return annotation != null;
    }

    @Override
    protected ComponentScan.Filter[] getFilters(FilterType type) {
        switch (type) {
            case INCLUDE:
                return annotation.includeFilters();
            case EXCLUDE:
                return annotation.excludeFilters();
        }
        throw new IllegalStateException("Unsupported type " + type);
    }

    @Override
    protected boolean isUseDefaultFilters() {
        return annotation.useDefaultFilters();
    }

    @Override
    protected Set<Class<?>> getDefaultIncludes() {
        return DEFAULT_INCLUDES;
    }

    @Override
    protected Set<Class<?>> getComponentIncludes() {
        return Collections.emptySet();
    }
}
