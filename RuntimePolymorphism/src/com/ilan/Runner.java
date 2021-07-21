package com.ilan;

public class Runner {

    public void login(Fruit fruit){
        fruit.talk();
    }


    public static void main(String args[]){

        Runner school=new Runner();

        school.login(new Apple());
        school.login(new Orange());

    }

}


