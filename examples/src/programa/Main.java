package programa;

import banco.Conta;

public class Main {
    public static void main(String[] args) {
        Conta c1 = new Conta("João");
        Conta c2 = new Conta("Jorge");


        c1.conta();
        c2.conta();

        c1.deposito( 179.55);
        c1.transferencia(c2,50);
        c1.saque(29);
        c2.deposito(1000);

        c1.conta();
        c2.conta();

    }
}
