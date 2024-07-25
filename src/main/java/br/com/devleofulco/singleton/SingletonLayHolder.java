package br.com.devleofulco.singleton;

public class SingletonLayHolder {


    private static class InstanceHolder{
        public static SingletonLayHolder instancia = new SingletonLayHolder();

    }
    private SingletonLayHolder(){
        super();
    }

    public static SingletonLayHolder getInstancia(){

        return InstanceHolder.instancia;
    }
}
