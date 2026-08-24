package irelia;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.lang.reflect.Method;

public class IreliaTestUtils {


    public static void modelIsFull(Object o) throws Exception{
        for(Method m : o.getClass().getDeclaredMethods()){
            if(m.getParameterCount() == 0 && m.getName().startsWith("get")){
                assertNotNull(m.invoke(o));
            }
        }
    }

}
