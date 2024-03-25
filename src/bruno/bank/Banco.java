package bruno.bank;
import java.util.List;
import java.util.ArrayList;

public class Banco {

    private String AG;
    private List<Conta> contas;
    private int ultimaConta = 1;

    public Banco(String AG){
        this.AG = AG;
        this.contas = new ArrayList<>();
    }

    public List<Conta> getContas() {
        return contas;
    }

    public void iserindoConta(Conta conta){
        contas.add(conta);
    }

    public Conta gerandoConta(String name) {
        Conta conta = new Conta(AG, "" + ultimaConta, name);
        ultimaConta ++;
        return conta;
    }
    public void contadorSaldoGeral(){
        double total = 1;
        for (Conta conta : contas){
            double balance = conta.getBalance();
            total += balance;
        }
        System.out.println("Banco Possui " + total);
    }
}
