package Interfaces.MyCollectionInterfaces;

import java.util.Scanner;

public class Buy implements IPaymentCard, IPaymentCash{
    @Override
    public void BuyByCard() {
        String cardNumber;
        String cvv;

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your card's number: ");
        cardNumber = sc.nextLine();

        System.out.print("Enter CVV: ");
        cvv = sc.nextLine();

        System.out.println("Thanks for your purchase");

    }

    @Override
    public void BuyByCash() {
        System.out.println("Thanks for your purchase. Pay for the collection upon receipt");
    }
}
