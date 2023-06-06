import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Estatistica {

    ArrayList<Questionario> respostas = new ArrayList<>();

    ArrayList<int[]> somatorio = new ArrayList<>();

    ArrayList<int[]> TotalSoma = new ArrayList<>();

    public int somaVetor(int[] vetor){
        int soma = 0;
        for(int elementos:vetor){
            soma += elementos;
        }
        return soma;
    }
    public void inicializarSomatorio() {
        int[] resposta1 = {2, 1, 3}; // Exemplo de respostas da pergunta 1
        int[] resposta2 = {3, 2, 1}; // Exemplo de respostas da pergunta 2
        int[] resposta3 = {2, 2, 2}; // Exemplo de respostas da pergunta 3
        int[] resposta4 = {2, 3, 1}; // Exemplo de respostas da pergunta 4
        int[] resposta5 = {3, 3, 0}; // Exemplo de respostas da pergunta 5
        int[] resposta6 = {2, 2, 2}; // Exemplo de respostas da pergunta 6
        int[] resposta7 = {0, 3, 3}; // Exemplo de respostas da pergunta 7

        somatorio.add(0,resposta1);
        somatorio.add(1,resposta2);
        somatorio.add(2,resposta3);
        somatorio.add(3,resposta4);
        somatorio.add(4,resposta5);
        somatorio.add(5,resposta6);
        somatorio.add(6,resposta7);
    }

    public void ImprimirEstatisticas() {
        inicializarSomatorio();
        for (int i = 0; i < respostas.size(); i++) { // Para cada questionario
            int[] respostaSoma = new int[3];
            respostaSoma = TotalSoma.get(i).clone();
            for (int j = 0; j < respostas.get(i).perguntas.size(); j++) { // Para cada pergunta no questionario
                char resposta = respostas.get(i).perguntas.get(j).resposta; // Resposta da pergunta



                respostaSoma[0] += somatorio.get(j)[0];
                respostaSoma[1] += somatorio.get(j)[1];
                respostaSoma[2] += somatorio.get(j)[2];
                if (resposta == 'A') {
                    respostaSoma[0]++;
                    ///somatorio.get(j)[0] = somatorio.get(j)[0] + 1;
                }
                if (resposta == 'B') {
                    respostaSoma[1]++;
                    //somatorio.get(j)[1] = somatorio.get(j)[1] + 1;
                }
                if (resposta == 'C') {
                    respostaSoma[2]++;
                    //somatorio.get(j)[2] = somatorio.get(j)[2] + 1;
                }

                TotalSoma.add(j,respostaSoma);

            }
        }

        System.out.println("Total de respostas nos questionarios:");
        for (int i = 0; i < TotalSoma.size(); i++) {

                int somatorioVetor = somaVetor(TotalSoma.get(i));


            double porcentagemA = ((double) TotalSoma.get(i)[0] / somatorioVetor) * 100;
            double porcentagemB = ((double) TotalSoma.get(i)[1] / somatorioVetor) * 100;
            double porcentagemC = ((double) TotalSoma.get(i)[2] / somatorioVetor) * 100;

            DecimalFormat df = new DecimalFormat("#.##");

            System.out.println("Pergunta " + (i + 1) + ": " + df.format(porcentagemA) + "% Votaram na alternativa A");
            System.out.println("Pergunta " + (i + 1) + ": " + df.format(porcentagemB) + "% Votaram na alternativa B");
            System.out.println("Pergunta " + (i + 1) + ": " + df.format(porcentagemC) + "% Votaram na alternativa C");
        }
    }
}
