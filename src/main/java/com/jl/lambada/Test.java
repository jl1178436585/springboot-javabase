package com.jl.lambada;

public class Test {
    public void myCar(Car car){
        String where = car.run("400米之地");
        System.out.println(where);
    }

    public static void main(String[] args) {
        Test test = new Test();

        Car c1 = new Car() {
            @Override
            public String run(String where) {
                return where + "到哪里";
            }
        };

        Car c = name -> {
            System.out.println(name);
            return name;
        };
        test.myCar(c);
    }

}
