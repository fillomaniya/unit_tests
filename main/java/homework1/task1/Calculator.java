package homework1.task1;

/*
* В классе Calculator создайте метод calculateDiscount,
* который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
* Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
* Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать
* исключение ArithmeticException. Не забудьте написать тесты для проверки этого поведения.
*/

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class Calculator {
//    public static void main(String[] args) {
//        System.out.println("Итоговая стоимость покупки равна: " + calculateDiscount(100, 5));
//        System.out.println("Итоговая стоимость покупки равна: " + calculateDiscount(100, -5));
//    }

    /**
     * Рассчет итоговой стоимости покупки
     * @param purchaseAmount базвоая стоимость покупки
     * @param discountAmount скидка на покупку
     * @return итоговая стоимость покупки
     */
    public static double calculateDiscount(double purchaseAmount, double discountAmount) {
        if (purchaseAmount <= 0) {
            throw new ArithmeticException("стоимость не может быть меньше или равна 0");
        }
        if (discountAmount > 100) {
            throw new ArithmeticException("Скидка не может быть больше 100%");
        }
        if (discountAmount < 0) {
            throw new ArithmeticException("Скидка не может быть отрицательной");
        }
        return purchaseAmount * ((100 - discountAmount) / 100);
    }
}

class CalculatorTest {
    public static void main(String[] args) {
        assertThat(Calculator.calculateDiscount(100.0, 20.0)).isEqualTo(80.0);
        assertThat(Calculator.calculateDiscount(1.0, 10.0)).isEqualTo(0.9);
        assertThat(Calculator.calculateDiscount(100.0, 0)).isEqualTo(100.0);
        assertThat(Calculator.calculateDiscount(100.0, 100.0)).isEqualTo(0.0);
        assertThatThrownBy(
                () -> Calculator.calculateDiscount(-100, 10))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(
                () -> Calculator.calculateDiscount(100, -5))
                .isInstanceOf(ArithmeticException.class);

        assertThatThrownBy(
                () -> Calculator.calculateDiscount(100, 101))
                .isInstanceOf(ArithmeticException.class);
    }
}
