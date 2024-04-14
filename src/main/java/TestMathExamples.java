public class TestMathExamples {
    public static void main(String[] args) {
        //    1) поупражняться с математическими и логическими операторами, добиться переполнения при вычислениях, посмотреть результаты (вывести в консоль)
        short a = Short.MAX_VALUE;

        for (int i = 0; i < 3; i++) {
            System.out.println("Value: "+ a + i);
            if (a + i <=a){
                System.out.println("its ok");
            }else {
                System.out.println("The value can be stored in long type");
            }
        }

        a = (short)(a+1);
        System.out.println(a);

        boolean b_a = true;
        boolean b_b = false;

        if ((b_a || b_b) == false){
            System.out.println("true");
        }else System.out.println("false");


        int iValue = 5;
        double dValue = 3.14;
        dValue += iValue;
        System.out.println("double + int: " + dValue);

//    2) попробовать вычисления комбинаций типов данных (int и double)
        double d_a = 3/2;
        int i_a = 2;
        System.out.println(d_a+i_a);

        int i_c = 5;
        double d_v = 3.14;
        d_v += i_c;
        System.out.println("double + int: " + d_v);

        i_c = 5;
        d_v = 3.14;
        i_c += d_v;
        System.out.println("int + double: " + i_c);
    }

}
