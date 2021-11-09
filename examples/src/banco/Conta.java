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
    public void saque (double valor){
        if (this.saldo >= valor){
            this.saldo = this.saldo - valor;
        }else {
            System.out.println("Saldo insuficiente!");
        }
    }
    //money deposit
    public void deposito (double valor){
        this.saldo = this.saldo+valor;
    }
    public void conta(){
        System.out.println("Número da conta: "+this.numero);
        System.out.println("Titular da conta: "+this.titular);
        System.out.println("Número da Agencia: "+this.agencia);
        System.out.println("Saldo: R$"+this.saldo);
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
            contaDestino.deposito(valor);
            System.out.println("Transferência feita com Sucesso!");
        }else {
            System.out.println("Saldo insuficiente!");
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
