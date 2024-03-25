package bruno.bank;
import com.sun.jdi.Value;
import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Banco PAM = new Banco("0001");
        while (true){
            System.out.println("O que deseja fazer? C = Criar Conta E = Sair do Programa ");
            String op = scanner.nextLine();

            if (op.equals("C")){
                System.out.println("Digite seu nome: ");
                String name = scanner.nextLine();
                Conta conta = PAM.gerandoConta(name);
                PAM.iserindoConta(conta);


                operaoConta(conta);
            } else if (op.equals("E")) {
                break;
            }else{
                System.out.println("Comando invalido");
            }
        }

        List<Conta> listaContas = PAM.getContas();
        for (Conta cc : listaContas) {
            System.out.println(cc);
        }
        PAM.contadorSaldoGeral();
    }

        static void operaoConta(Conta conta){
            Scanner scanner = new Scanner(System.in);
            while (true){
                System.out.println("O que deseja fazer? D = DEPOSITO, S = SAQUE, E = SAIR");
                String op = scanner.nextLine();

                if (op.equals("D")){
                    System.out.println("Qual Valor deseja depositar? ");
                    double valor = scanner.nextDouble();
                    conta.depositoR((valor));
                } else if (op.equals("S")) {
                    System.out.println("Qual Valor deseja sacar? ");
                    double valor = scanner.nextDouble();
                    if (!conta.sacarR(valor)){
                        System.out.println("Ops! Não foi possivel sacar os:" + valor);}
                }else if (op.equals("E")){
                    break;
                } else{
                    System.out.println("Comando invalido");

                }
                scanner = new Scanner(System.in);

            }

        }
    }

