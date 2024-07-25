package br.com.devleofulco.singleton;

public class Aplication {
    public static void main(String[] args) {
        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println(lazy);


        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println(eager);
        eager = SingletonEager.getInstancia();
        System.out.println(eager);


        SingletonLayHolder holder = SingletonLayHolder.getInstancia();
        System.out.println(holder);
        holder = SingletonLayHolder.getInstancia();
        System.out.println(holder);

    }
}
