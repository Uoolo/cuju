package org.cuju.study.oop;

/**
 * @Author: Uoolo
 * @Description: 对象赋值
 * @Date: Create in 14:37 2020/9/17
 */
public class ObjectCopy {

    public static void main(String[] args){
        //对象是引用类型的，所以如果你把一个对象赋值给另一个变量，它实zhi际上只是把内存地址赋值了。

        People people = new People();
        people.setName("小明");
        people.setAge(12);
        people.setGender("男");

        System.out.println(people.getName() + "今年" + people.getAge() + "岁");
        People peopleA = people;
        people.setName("老王");
        people.setAge(90);

        System.out.println(peopleA.getName() + "今年" + peopleA.getAge() + "岁");
        //小明今年12岁
        //老王今年90岁

        changeAge(people);
        System.out.println(peopleA.getName() + "今年" + peopleA.getAge() + "岁");
        //小明今年12岁
        //老王今年90岁
        //老王今年18岁

        People peopleB = new People();
        peopleB = people;
        people.setAge(88);
        System.out.println(peopleB.getName() + "今年" + peopleB.getAge() + "岁");
        //小明今年12岁
        //老王今年90岁
        //老王今年18岁
        //老王今年88岁

        People peopleC = new People();
        peopleC = (People)people.clone();
        peopleB.setName("小王");
        people.setAge(16);
        System.out.println(peopleC.getName() + "今年" + peopleC.getAge() + "岁");
        System.out.println(peopleA.getName() + "今年" + peopleA.getAge() + "岁");

        //这里边b的引用虽然指向了a但是后来的赋值让它指向了新的地址，改变的不是原来地址的值；所以b没有改变。
        String a = "HaHa";
        String b = a;
        a = "WuWu";
        System.out.println("小明：" + b);
        //小明今年12岁
        //老王今年90岁
        //老王今年18岁
        //老王今年88岁
        //老王今年88岁
        //小王今年16岁
        //小明：HaHa

    }

    private static void changeAge(People people){
        if(people != null){
            people.setAge(18);//重回18岁
        }
    }
}
