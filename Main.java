import java.util.Arrays;

//В последовательности неотрицательных целых чисел не превышающих 10000,
// размером 1000 элементов найти число R удовлетворяющие следующим условиям:
//R минимально;
//R кратно 21;
//R произведение 2х различных элементов последовательности;
//если такого числа нет вывести -1
//
//Поверяемые критерии
//0%
//
//1 Реализован однопроходный алгоритм
//
//2 Учтены все случаи образования кратного числа
//
//3 Наличие сообщений в выводе
//
//4 Вынесение констант
//
//Имена переменных "говорящие"
//
//Наличие коментариев
public class Main {
    public static void main(String[] args) {
        int R=0;//искомое число
        int size = 1000;//размер массива
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = (int) (Math.random() * 10000);//генерируются числа от 0 до 10000
        }
        int min=10000;// минимальное число не кратное 21, 7, 3
        int min7=10000;// минимальное число кратное 7
        int min3=10000;//минимальное число кратное 3
        int min21=10000;//минимальное число кратное 21
        for (int i = 0; i < size; i++) {
            if (arr[i] % 21 == 0 && arr[i] < min21) { // поиск минимального числа кратного 21 и присвоение его переменной с этим именем
                min21 = arr[i];
            } else if (arr[i] % 7 == 0 && arr[i] < min7) { //поиск минимального числа кратного 7 и присвоение его переменной с этим именем
                min7 = arr[i];
            } else if (arr[i] % 3 == 0 && arr[i] < min3) {  //поиск минимального числа кратного 3 и присвоение его переменной с этим именем
                min3 = arr[i];
            } else if (arr[i] < min) {  //поиск минимального числа не кратного 21,7,3 и присвоение его переменной с этим именем
                min = arr[i];
            }
        }
        int result=0; //переменная для результата умножения чисел кратных 7 и 3
        int result2=0; //переменная для результата умножения чисел кратных 21 и не кратных 21,7,3
        if(min7!=0 && min3!=0){
            result = min7*min3;
        }
        if(min21!=0 && min!=0){
            result2 = min21*Math.min(min7,Math.min(min,min3));
        }
        R=result2*result; //искомое число состоящее из произведения 2 минимальных чисел и кратное 21
        if(R!=0) { //
            System.out.println("числом,удовлетворяющим всем требованиям является: " + R);
        }
        else{
            System.out.println(-1);
        }
    }
}