package ua.dp.skillsup.reflection;

import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;

import java.lang.annotation.Annotation;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Set;

public class Executor {
    public static void execute(String packageName){
        Reflections reflections = new Reflections(packageName,new  SubTypesScanner(false));
        Set<Class<? extends Object>> set = reflections.getSubTypesOf(Object.class);
        for (Class clss : set)
            for (Method method : clss.getDeclaredMethods()){
            if(method.isAnnotationPresent(Execute.class)){
                try {
                    Annotation annotation[][] = method.getParameterAnnotations();
                    for (Annotation annotation1[] : annotation) {
                        for (Annotation annotation2 : annotation1) {
                            if(annotation2 instanceof Env){
                                Env env = (Env)annotation2;
                                method.invoke(clss.newInstance(),System.getenv(env.value()));
                            }
                        }
                    }
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (InvocationTargetException e) {
                    e.printStackTrace();
                }
            }}
    }
}
