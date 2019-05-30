public class PrimeNum {
    public static void main(String[] args) {

        long startTime = System.currentTimeMillis(); // засекаем время начала программы

        int count;

        Thread1 foo1 = new Thread1();
        Thread t1 = new Thread(foo1);

        Thread2 foo2 = new Thread2();
        Thread t2 = new Thread(foo2);

        Thread3 foo3 = new Thread3();
        Thread t3 = new Thread(foo3);

        Thread4 foo4 = new Thread4();
        Thread t4 = new Thread(foo4); //создаем 4 потока

        t1.start();
        t2.start();
        t3.start();
        t4.start(); // запускаем потоки

        try {
            t1.join();
        }
        catch (Exception e) {
            System.out.println("Ошибка потока 1" + e);
        }
        int count1 = foo1.getCount();

        try {
            t2.join();
        }
        catch (Exception e) {
            System.out.println("Ошибка потока 2" + e);
        }
        int count2 = foo2.getCount();

        try {
            t3.join();
        }
        catch (Exception e) {
            System.out.println("Ошибка потока 3" + e);
        }
        int count3 = foo3.getCount();

        try {
            t4.join();
        }
        catch (Exception e) {
            System.out.println("Ошибка потока 4" + e);
        }
        int count4 = foo4.getCount();

        count = 1 + count1 + count2 + count3 + count4; // учитываем 2ку + количество на каждом из диапазонов

        long timeSpent = System.currentTimeMillis() - startTime; // получаем время выполнения програмы

        System.out.println("Полученное количество простых чисел: " + count);
        System.out.println("Процент простых чисел от общего количества = " + (count*100)/Integer.MAX_VALUE);
        System.out.println("Программа выполнялась: " + timeSpent + " миллисекунд.");
    }
}

class Thread1 implements Runnable {

    private volatile int count;

    @Override
    public void run() {

        MethodPrimeNumbers ob = new MethodPrimeNumbers();
        count = ob.SearchPrimeNumbers(3, 536870912); // 1 - не простое, 2ку учтем, начинам с 3 до max int /4
    }

    public int getCount() {
        return count;
    }
}

class Thread2 implements Runnable {

    private volatile int count;

    @Override
    public void run() {

        MethodPrimeNumbers ob = new MethodPrimeNumbers();
        count = ob.SearchPrimeNumbers(536870913, 1073741824);
    }

    public int getCount() {
        return count;
    }
}

class Thread3 implements Runnable {

    private volatile int count;

    @Override
    public void run() {

        MethodPrimeNumbers ob = new MethodPrimeNumbers();
        count = ob.SearchPrimeNumbers(1073741824, 1610612736);
    }

    public int getCount() {
        return count;
    }
}

class Thread4 implements Runnable {

    private volatile int count;

    @Override
    public void run() {

        MethodPrimeNumbers ob = new MethodPrimeNumbers();
        count = ob.SearchPrimeNumbers(1610612737, Integer.MAX_VALUE);
    }

    public int getCount() {
        return count;
    }
}
