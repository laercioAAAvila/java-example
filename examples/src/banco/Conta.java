//bank
package banco;

public class Conta {
    private int numero;
    private String titular;
    private int agencia;
    private double saldo;
    //status: true = Active or false = Deactivate
    private boolean status;

    //withdraw money
    public void saque (double valor){
        if (this.saldo >= valor){
            this.saldo = this.saldo - valor;
        }else {
            System.out.println("Saldo insuficiente!");
        }
    }
    //deposit money
    public void desposit (double valor){
        this.saldo = this.saldo+valor;
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
