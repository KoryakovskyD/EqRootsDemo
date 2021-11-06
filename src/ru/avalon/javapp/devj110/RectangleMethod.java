package ru.avalon.javapp.devj110;


public class RectangleMethod {
    public static final int STEP = 100;
    public static void main(String[] args) {

        // вложенный класс
        Func f1 = new lnX();
        System.out.println(findIntegral(f1, 2,5, STEP));


        // анонимный класс
        Func f2 = new Func() {
            @Override
            public double f(double x) {
                return x*2 + x;
            }
        };
        System.out.println(findIntegral(f2, 3, 4, STEP));



        //ссылка на статический метод
        expMinus obj = new expMinus();
        Func f3 = obj::exp;
        System.out.println(findIntegral(f3, 0.01, 2 ,STEP));


        // ссылка на метод экземпляра
       Func f4 = powX::pow;
       System.out.println(findIntegral(f4,1,3,STEP));


        // лямбда
        Func f5 = x -> (x*Math.sin(x));
        System.out.println(findIntegral(f5,0,1,STEP));
            }


    public static double findIntegral(Func func, double left, double right, int STEP) {
        double res = 0;
        double h = (right-left)/STEP;
        for(int i = 0; i < STEP; i++)
        {
            res += h*func.f(left + i*h);
        }
        return res;
    }

    private static class lnX implements Func {
        @Override
        public double f(double x) {
            return Math.log10(x);
        }
    }

    private static class expMinus {
        double exp (double x) {
            return Math.exp(-x);
        }
    }

    private static class powX {
        static double pow(double x) {
            return Math.pow(x, 2);
        }
    }


}
