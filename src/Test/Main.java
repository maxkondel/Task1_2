package Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;


public class Main {
    public static void main (String[] args) throws InvocationTargetException, IllegalAccessException {

        Container container = new Container();

        Class<?> cls = container.getClass();

        SaveTo saveTo = cls.getAnnotation(SaveTo.class);

        String path = saveTo.path();

        Method[] methods = cls.getDeclaredMethods();

        for (Method method:methods) {
            if (method.isAnnotationPresent(Saver.class)) {
                method.invoke(container, path);
                System.out.println("Done1");
                break;
            }
        }
    }
}
