package bruno.bank;

public class Conta {
    private String AG;
    private String cc;
    private String name;

    private double balance;

    private Log logger;

    private static final int MAX_LENGTH = 12;
    public Conta(String AG, String cc, String name){
        this.AG = AG;
        this.cc = cc;
        setName(name);
        logger = new Log();
    }
    public double getBalance(){
        return balance;
    }

    public void setName(String name){
        if (name.length() > MAX_LENGTH){
            this.name = name.substring(0,12) + "...";
        }else{
            this.name = name;
        }
    }
    public boolean sacarR(double valor){
        if (balance < valor){
            logger.out("SAQUE - R$ "+ valor +" Seu Saldo è de R$: "+ balance);
            return false;
        }
            balance -= valor;
            logger.out("SAQUE - R$ "+ valor +" Sua Conta agora è de R$: " + balance);
            return true;
    }
    public void depositoR(double valor){
        balance += valor;
        logger.out("DEPOSITO - R$ "+ valor +" Sua Conta tem R$ " + balance);
    }

    @Override
    public String toString() {
        String resultado = "A conta " + this.name + " de Número: " + this.AG + "/" + this.cc + " possui: R$" + balance;
        return resultado;
    }
}
