package a3_jianzhi_offer;

import java.util.Arrays;

/**
 * 打印从1到最大的 n 位数
 */
public class code_17 {
    public void print1ToMaxOfNDigits(int n) {
        if (n <= 0) {
            return;
        }
        char[] num = new char[n];
        Arrays.fill(num,'0');
        num[n-1] = '8';  //test 数
        num[n-2] = '9';
        while (!inCreatement(num)) {
            printNum(num);
        }
    }

    //打印number 去掉前面多余的0
    private void printNum(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        //不打印全0
        if (index == number.length){
            return;
        }
        char[] chars = Arrays.copyOfRange(number, index, number.length);
        //while (index < number.length)
        //    System.out.print(number[index++]);
        System.out.println(chars);
    }

    //有没有加到最高位
    private boolean inCreatement(char[] num) {
        boolean isOverFlow= false;
        int sum;
        int carry = 0;  //进位
        int len = num.length - 1;
        for(int i = len; i >= 0; i--) {
            sum = num[i] - '0'  + carry ;
            if (i == len){
                sum++;
            }
            if (i == 0 && sum >=10){
                isOverFlow = true;
                break;
            }
            carry = sum / 10;
            sum = sum % 10;
            num[i] = (char) (sum +'0');
            if (carry  == 0){
                break;
            }
        }
        return isOverFlow ;
    }



    //2. ???
    public void print1ToMaxOfNDigits2(int n) {
        if (n <= 0)
            return;
        char[] number = new char[n];
        print1ToMaxOfNDigits2(number, 0);
    }

    private void print1ToMaxOfNDigits2(char[] number, int digit) {
        if (digit == number.length) {
            printNumber(number);
            return;
        }
        for (int i = 0; i < 10; i++) {
            number[digit] = (char) (i + '0');
            print1ToMaxOfNDigits2(number, digit + 1);
        }
    }

    private void printNumber(char[] number) {
        int index = 0;
        while (index < number.length && number[index] == '0')
            index++;
        while (index < number.length)
            System.out.print(number[index++]);
        System.out.println();
    }
    public static void main(String[] args) {
        new code_17().print1ToMaxOfNDigits(2);
    }
}
