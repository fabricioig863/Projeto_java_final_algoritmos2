package Algoritmos2;

import javax.swing.*;
import java.util.Arrays;

public class Algoritmos2 {

    static final int Tamanho_Linha=3;
    static final int Tamanho_Coluna=3;
    static int n1, n2;
    static String mensagem_ordenar;

    static class Informacoes_Correntista{
        String correntista;
        int numero_correntista;
        double saldo_correntista;
    }

    static double[] Saldos_Ordenados = new double[Tamanho_Linha * Tamanho_Coluna];
    static Informacoes_Correntista[][] Correntistas = new Informacoes_Correntista[Tamanho_Linha][Tamanho_Coluna];

    public static void Dados(){
        for (int i = 0; i < Tamanho_Linha; i++) {
            for (int j = 0; j < Tamanho_Coluna; j++) {
                Correntistas[i][j] = new Informacoes_Correntista();
            }
        }
        Correntistas[0][0].correntista = "Tibúrcio";
        Correntistas[0][1].correntista = "Ricardo";
        Correntistas[0][2].correntista = "João";
        Correntistas[1][0].correntista = "Felisbino";
        Correntistas[1][1].correntista = "Seu Zé";
        Correntistas[1][2].correntista = "Dona Maria";
        Correntistas[2][0].correntista = "Gedonstrôncio";
        Correntistas[2][1].correntista = "Batman";
        Correntistas[2][2].correntista = "Homem de Ferro";
        Correntistas[0][0].numero_correntista = 111;
        Correntistas[0][1].numero_correntista = 222;
        Correntistas[0][2].numero_correntista = 333;
        Correntistas[1][0].numero_correntista = 444;
        Correntistas[1][1].numero_correntista = 555;
        Correntistas[1][2].numero_correntista = 666;
        Correntistas[2][0].numero_correntista = 777;
        Correntistas[2][1].numero_correntista = 888;
        Correntistas[2][2].numero_correntista = 999;
        Correntistas[0][0].saldo_correntista = 0.0;
        Correntistas[0][1].saldo_correntista = 0.0;
        Correntistas[0][2].saldo_correntista = 0.0;
        Correntistas[1][0].saldo_correntista = 0.0;
        Correntistas[1][1].saldo_correntista = 0.0;
        Correntistas[1][2].saldo_correntista = 0.0;
        Correntistas[2][0].saldo_correntista = 0.0;
        Correntistas[2][1].saldo_correntista = 0.0;
        Correntistas[2][2].saldo_correntista = 0.0;
    }
    /*1 – Inserir Recebimento (+): Solicite ao usuário o número da conta e depois o valor. Some o
    recebimento ao saldo da conta deste usuário e depois mostre o saldo desta pessoa usando o
    seguinte formato:
            “(CORRENTISTA) seu saldo atual é de: ”+ SALDO.*/
    public static double Recebimento_Saldo(int numero, double valor){
        for (int i=0;i<Tamanho_Linha;i++) {
            for (int j=0;j<Tamanho_Coluna;j++) {
                if (numero == Correntistas[i][j].numero_correntista) {
                    n1 = i;
                    n2 = j;
                    Correntistas[n1][n2].saldo_correntista = Correntistas[n1][n2].saldo_correntista + valor;
                }
            }
        }
        return Correntistas[n1][n2].saldo_correntista;
    }
    /*2 – Inserir Pagamento (-): Solicite ao usuário o número da conta e depois o valor. Subtraia o
    pagamento do salto atual e depois mostre o novo saldo desta pessoa usando o seguinte
    formato:
            “(CORRENTISTA) seu saldo atual é de: ”+ SALDO.*/
    public static double Pagamento_Saldo(int numero, double valor){
        for (int i=0;i<Tamanho_Linha;i++) {
            for (int j=0;j<Tamanho_Coluna;j++) {
                if (numero == Correntistas[i][j].numero_correntista) {
                    n1 = i;
                    n2 = j;
                    Correntistas[n1][n2].saldo_correntista = Correntistas[n1][n2].saldo_correntista - valor;
                }
            }
        }
        return Correntistas[n1][n2].saldo_correntista;
    }
    /*3 – Mostre em apenas uma mensagem todos os Números de Conta, Correntistas e Saldos
    respectivos.*/
    public static String Mostrar_Dados(String mensagem){
        for(int i=0;i<Tamanho_Linha;i++){
            for(int j=0;j<Tamanho_Coluna;j++){
                mensagem += "| Nome: "+Correntistas[i][j].correntista + ", Número: " + Correntistas[i][j].numero_correntista + ", Saldo: " + Correntistas[i][j].saldo_correntista +"\n";
            }
        }
        return mensagem;
    }
    /*4 – Mostre em apenas uma mensagem o Número da Conta, o Nome do Correntista e o saldo
    do correntista mais RICO.*/
    public static double Maior_Saldo_Correntista(double maior_saldo){
        for (int i=0;i<Tamanho_Linha;i++) {
            for (int j=0;j<Tamanho_Coluna;j++) {
                if (Correntistas[i][j].saldo_correntista > maior_saldo) {
                    maior_saldo = Correntistas[i][j].saldo_correntista;
                    n1 = i;
                    n2 = j;
                }
            }
        }
        return maior_saldo;
    }
    /*5 – Mostre em apenas uma mensagem todos os saldos ordenados do menor para o maior.
    Para isso coloque todos os saldos dentro de um vetor e ordene usando BubbleSort.*/
    public static void Ordenar_Saldos(){
        int k=0;
        for (int i=0;i<Tamanho_Linha;i++){
            for (int j=0;j<Tamanho_Coluna;j++){
                Saldos_Ordenados[k] = Correntistas[i][j].saldo_correntista;
                k++;
            }
        }
        Arrays.sort(Saldos_Ordenados);
        mensagem_ordenar = "";
        for (int i=0;i<Tamanho_Coluna*Tamanho_Linha;i++){
            mensagem_ordenar += "\n"+Saldos_Ordenados[i];
        }
    }
    public static void main(String[] args){
        int control, numero;
        double valor;
        Dados();
        do{
            control = Integer.parseInt(JOptionPane.showInputDialog("Escolha uma das opções: \n1- Inserir recebimento\n2- Efetuar pagamento\n3- Informações dos correntistas\n4- Correntista mais rico\n5- Saldos ordenados\n6- Sair"));
            switch (control){
                case 1:
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Por favor insira o número da conta para inserir o recebimento: "));
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Por favor insira o valor a ser creditado: "));
                    Recebimento_Saldo(numero, valor);
                    JOptionPane.showMessageDialog(null,Correntistas[n1][n2].correntista+" seu saldo atual é de: "+Correntistas[n1][n2].saldo_correntista);
                    break;
                case 2:
                    numero = Integer.parseInt(JOptionPane.showInputDialog("Por favor insira o número da conta da qual será debitado: "));
                    valor = Double.parseDouble(JOptionPane.showInputDialog("Por favor insira o valor a ser pago: "));
                    Pagamento_Saldo(numero, valor);
                    JOptionPane.showMessageDialog(null,Correntistas[n1][n2].correntista+" seu saldo atual é de: "+Correntistas[n1][n2].saldo_correntista);
                    break;
                case 3:
                    String mensagem="";
                    mensagem = Mostrar_Dados(mensagem);
                    JOptionPane.showMessageDialog(null, "Informações dos Correntistas: \n"+mensagem);
                    break;
                case 4:
                    double maior_saldo=0;
                    maior_saldo = Maior_Saldo_Correntista(maior_saldo);
                    JOptionPane.showMessageDialog(null,"Correntista mais rico: \nNome: "+Correntistas[n1][n2].correntista+"\nNúmero: "+Correntistas[n1][n2].numero_correntista+"\nSaldo: "+maior_saldo);
                    break;
                case 5:
                    Ordenar_Saldos();
                    JOptionPane.showMessageDialog(null,"Saldos ordenados: \n"+mensagem_ordenar);
                    mensagem_ordenar = "";
                    break;
                /*6 - Sair*/
                case 6:
                    break;
                default:
                    JOptionPane.showMessageDialog(null,"Essa opção não existe");
            }
        }while(control != 6);
    }
}
