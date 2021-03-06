package java_jichu.testdemo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class AnimalProxy implements InvocationHandler {
    // JDK 代理类
    private Object target; // 代理对象

    public Object getInstance(Object target) {
        this.target = target;
        // 取得代理对象
        return Proxy.newProxyInstance(target.getClass().getClassLoader(),
                        target.getClass().getInterfaces(), this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用前");
        Object result = method.invoke(target, args); // 方法 调用
        System.out.println("调用后");
        return result;
    }

    public static void main(String[] args) {
        // JDK 动态代理调用
        AnimalProxy proxy = new AnimalProxy();
        Animal dogProxy = (Animal) proxy.getInstance(new Dog());
        dogProxy.eat();
    }
}

interface Animal {
    void eat();
}

class Dog implements Animal {
    @Override
    public void eat() {
        System.out.println("The dog is eating");
    }
}

class Cat implements Animal {
    @Override
    public void eat() {
        System.out.println("The cat is eating");
    }
}
