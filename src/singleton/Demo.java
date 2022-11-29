package singleton;

import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class Demo {
    public static void main(String[] args) throws NoSuchMethodException,
            InvocationTargetException, InstantiationException, IllegalAccessException, IOException, ClassNotFoundException {
        SimpleSingleton instance = SimpleSingleton.INSTANCE;
        System.out.println(instance.getMessage());
        instance.setMessage("hallo");
        System.out.println(instance.getMessage());

//        Constructor<? extends SimpleSingleton> constructor =
//                instance.getClass().getDeclaredConstructor(new Class[0]);
//        constructor.setAccessible(true);
//
//        SimpleSingleton instance2 = constructor.newInstance();
//
//        System.out.println(instance2.getMessage());
//
//        System.out.println(instance == instance2);

        FileOutputStream fileOut = new FileOutputStream("singleton.out");
        ObjectOutputStream out = new ObjectOutputStream(fileOut);
        out.writeObject(instance);
        out.close();
        fileOut.close();

        SimpleSingleton instance2 = null;

        FileInputStream fileIn = new FileInputStream("singleton.out");
        ObjectInputStream in = new ObjectInputStream(fileIn);
        instance2 = (SimpleSingleton) in.readObject();

        instance2.setMessage("ich bin wer neues.");

        System.out.println(instance.getMessage());
        System.out.println(instance2.getMessage());
    }
}
