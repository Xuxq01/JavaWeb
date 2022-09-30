package template2;

public abstract class Person {//模板类通常是抽象类
    public final void day(){
        wakeUp();
        bath();
        eatBrk();
        doSome();
        eatDir();
        sleep();
    }

    public void wakeUp(){
        System.out.println("起床");
    }

    public void bath(){
        System.out.println("洗漱");
    }

    public void eatBrk(){
        System.out.println("吃早餐");
    }

    public abstract void doSome();

    public void eatDir(){
        System.out.println("吃晚饭");
    }

    public void sleep(){
        System.out.println("睡觉");
    }
}
