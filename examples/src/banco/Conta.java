//bank
package banco;

public class Conta {
    private int numero;
    private String titular;
    private int agencia;
    private double saldo;
    private static int nConta = 0;
    //status: true = Active or false = Deactivate
    private boolean status;

    public Conta(String titular) {
        nConta++;
        this.numero = nConta;
        this.titular = titular;
        this.agencia = 0001;
        this.saldo = 0;
        this.status = true;
    }

    //money withdraw
    public void saque (float valor){
        if (this.saldo >= valor){
            this.saldo = this.saldo - valor;
            System.out.println("Valor: " + valor);
            System.out.println("Saque feito com sucesso!\n");
        }else {
            System.out.println("Saldo insuficiente!\n");
        }
    }
    //money deposit
    public void deposito (double valor){
        this.saldo = this.saldo+valor;
        System.out.println("Valor: " + valor);
        System.out.println("Deposito feito com sucesso!\n");
    }

    public void conta(){
        System.out.println("Número da conta: "+this.numero);
        System.out.println("Titular da conta: "+this.titular);
        System.out.println("Número da Agencia: "+this.agencia);
        System.out.printf("Saldo: R$ %.2f %n",this.saldo);
        if (this.status==true)
            System.out.println("Estado da conta: Ativa!");
        else
            System.out.println("Estado da conta: Desativada!");
        System.out.println("\n");
    }

    //money transfer
    public void transferencia(Conta contaDestino, double valor){
        if (this.saldo >= valor){
            this.saldo = this.saldo - valor;
            contaDestino.saldo = contaDestino.saldo+valor;
            System.out.println("Valor: " + valor);
            System.out.println("Transferência feita com Sucesso!\n");
        }else {
            System.out.println("Valor: " + valor);
            System.out.println("Saldo insuficiente!\n");
        }

    }

    public int getNumero() {
        return numero;
    }

    public String getTitular() {
        return titular;
    }

    public void setTitular(String titular) {
        this.titular = titular;
    }

    public int getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
