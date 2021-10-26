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

        float aNext = a + deltaA;
        float beta = 0.0f;
        while (beta == 0.0) {
            deltaA += 1.0;
            aNext = a + deltaA;
            beta = aNext - a;
        }
        return beta;
    }

    /* Процедура определения разрядности мантиссы и машинной точности */
    static void epsMach(float beta) {
        float eps = 1.0f;
        int counter = 0;
        while (1.0f + eps > 1.0f) {
            eps /= beta;
            counter++;
        }
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
    }
}
