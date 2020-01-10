package factory;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class BeansFactory {

    static Properties props = new Properties();
    static Map<String, Object> container = new HashMap<String, Object>();
    static {
        try {
            props.load(BeansFactory.class.getClassLoader().getResourceAsStream("beans.propertis"));
            props.keySet().stream().forEach(key -> {
                String object = props.getProperty((String) key);
                try {
                    container.put((String) key, Class.forName(object).newInstance());
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static Object getObject(String className) {
        return container.get(className);
    }
}
