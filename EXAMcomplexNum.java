/**
 * Класс EXAMcomplexNum представляет собой комплексное число с действительной и мнимой частями.
 * Он предоставляет методы для сложения, вычитания и умножения комплексных чисел.
 */
public class EXAMcomplexNum {
    private double real;
    private double imaginary;


    /**
     * Главный метод создает два объекта EXAMcomplexNum, выполняет сложение, вычитание и умножение
     * этих объектов и выводит результаты на консоль.
     */
    public static void main(String[] args){
        EXAMcomplexNum num1 = new EXAMcomplexNum(2, 3);
        EXAMcomplexNum num2 = new EXAMcomplexNum(4, -1);

        EXAMcomplexNum sum = num1.add(num2);
        EXAMcomplexNum difference = num1.subtract(num2);
        EXAMcomplexNum product = num1.multiply(num2);

        System.out.println("Sum: " + sum);
        System.out.println("Difference: " + difference);
        System.out.println("Product: " + product);
    }
    /**
     * Создает объект EXAMcomplexNum с указанными действительной и мнимой частями.
     * @param real действительная часть комплексного числа
     * @param imaginary мнимая часть комплексного числа
     */
    public EXAMcomplexNum(double real, double imaginary) {
        this.real = real;
        this.imaginary = imaginary;
    }

    /**
     * Добавляет указанное комплексное число к этому комплексному числу.
     * @param number комплексное число, которое нужно добавить к этому комплексному числу
     * @return новый объект EXAMcomplexNum, который является суммой двух комплексных чисел
    */

    public EXAMcomplexNum add(EXAMcomplexNum number) {
        double realSum = this.real + number.real;
        double imaginarySum = this.imaginary + number.imaginary;
        return new EXAMcomplexNum(realSum, imaginarySum);
    }

    /**
     * /
     * Вычитает указанное комплексное число из этого комплексного числа.
     * @param number комплексное число, которое нужно вычесть из этого комплексного числа
     * @return новый объект EXAMcomplexNum, который является разностью двух комплексных чисел
     */
    public EXAMcomplexNum subtract(EXAMcomplexNum number) {
        double realDifference = this.real - number.real;
        double imaginaryDifference = this.imaginary - number.imaginary;
        return new EXAMcomplexNum(realDifference, imaginaryDifference);
    }

    /**
     * Умножает это комплексное число на указанное комплексное число.
     * @param number комплексное число, на которое нужно умножить это комплексное число
     * @return новый объект EXAMcomplexNum, который является произведением двух комплексных чисел
     */
    public EXAMcomplexNum multiply(EXAMcomplexNum number) {
        double realProduct = this.real * number.real - this.imaginary * number.imaginary;
        double imaginaryProduct = this.real * number.imaginary + this.imaginary * number.real;
        return new EXAMcomplexNum(realProduct, imaginaryProduct);
    }

    /**
     * Возвращает строковое представление этого комплексного числа.
     * @return строковое представление этого комплексного числа
    */
    public String toString() {
        return String.format("%.2f + %.2fi", this.real, this.imaginary);
    }
}

