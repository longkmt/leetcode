import ImplementingClass.DatabaseWriter;

import java.lang.reflect.Constructor;
import java.lang.reflect.Parameter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class DIContainer {

    //this DIContainer must have some sort of dictionary to store the definition for each interfaces

    private static HashMap<Type,Object> registeredModules = new HashMap<Type,Object>();

    public static void setModule(Type interfaceType, Class<?> moduleType) throws Exception {
        //check if the object already implemented the interface or not
        if (!interfaceType.getClass().isAssignableFrom(moduleType.getClass())){
            throw new Exception("Invalid type assignment");
        }

        //get the default constructor of the module
        Constructor<?> firstConstructor = moduleType.getConstructors()[0];
        Object module = null;

        //default constructor has no parameter
        if (firstConstructor.getParameterCount() == 0){
            module = firstConstructor.newInstance(); //new DatabaseWriter(), new EmailSender()
        }
        else{
            Parameter[] constructorParameters = firstConstructor.getParameters();
            List<Object> moduleDependencies = new ArrayList<Object>();
            for (Parameter p : constructorParameters){
               Object dependency = getModule(p.getType());
               moduleDependencies.add(dependency);
            }
            //instantiate a module with parameters (aka injecting the dependencies into constructor of the module)
            module = firstConstructor.newInstance(moduleDependencies.toArray());
        }

        registeredModules.put(interfaceType, module);

    }


    public static Object getModule(Type interfaceType) throws Exception {
        if (registeredModules.containsKey(interfaceType)){
            return registeredModules.get(interfaceType);
        }

        throw new Exception("Module is not registered!");
    }
}
