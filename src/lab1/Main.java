package lab1;

public class Main {

    /* Процедура определения основания системы счисления */
    static float getRadix() {
        float deltaA = 1.0f;
        float a = 1.0f;
        float b = a + deltaA;
        while (a != b) {
            a *= 2.0f;
            b += deltaA;
        }

        float beta = b - a;
        float aNext = a + deltaA;
        while (beta == 0.0f) {
            deltaA += 1.0f;
            aNext = a + deltaA;
            beta = aNext - a;
        }
        return beta;
    }

    /* Процедура определения разрядности мантиссы и машинной точности */
    static void epsMach(float beta) {
        float eps = 1.0f;
        int counter = -1;
        while (1.0f + eps > 1.0f) {
            eps /= beta;
            counter++;
        }
        eps *= beta;
        System.out.println("Разрядность мантиссы = " + counter);
        System.out.println("Машинный эпсилон = " + eps);
    }

    public static void main(String[] args) {

        float a = 0.8f;
        float b = 0.1f;
        float result1 = a + b;
        float result2 = 0.9f;

        float absolute_error = Math.abs(result1 - result2);
        float relative_error = absolute_error / result1;

        System.out.println("\nresult1 = " + result1);
        System.out.println("Абсолютная ошибка округления = " + absolute_error);
        System.out.println("Относительная ошибка округления = " + relative_error);

        float beta = getRadix();
        System.out.println("Система счисления = " + (int)beta);
        epsMach(beta);

        System.out.println("\n2^-23 = " + Math.pow(2, -23));
        System.out.println("2^-24 = " + Math.pow(2, -24));

    }
}
