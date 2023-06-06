import java.util.ArrayList;
//questionario
public class Questionario {

    //Pergunta[] perguntas;

    String mensagem;
    boolean respondido;

    ArrayList<Pergunta> perguntas = new ArrayList<>();


    public void adicionarPergunta(Pergunta pergunta){
        perguntas.add(pergunta);
    }

    public boolean responder(int indexPergunta, char resposta){
        return perguntas.get(indexPergunta).responder(resposta);
        //[indexPergunta].responder(resposta);
    }


    private boolean verificarRespostas(){

        //se tudo foi respondido

        return this.respondido;
    }

    public void imprimirQuestionario(){
        for(int i = 0; i < perguntas.size(); i++){
            System.out.println("\n ======== " + (i+1) + " ======== ");
            System.out.println(perguntas.get(i).pergunta);
            for(int j = 0; j < perguntas.get(i).alternativas.size(); j++){
                System.out.println(perguntas.get(i).alternativas.get(j).alternativa + " - " + perguntas.get(i).alternativas.get(j).enunciado);
            }
        }
    }

    public String perguntaToString(int i){
        String pergunta;
        pergunta =  "\n ======== " + (i+1) + " ======== \n";
        pergunta += perguntas.get(i).pergunta + "\n";
        for(int j = 0; j < perguntas.get(i).alternativas.size(); j++){
            pergunta+= perguntas.get(i).alternativas.get(j).alternativa + " - " + perguntas.get(i).alternativas.get(j).enunciado + "\n";
        }
        return pergunta;
    }


    /**
     * Adicionar Perguntas Prontas
     */
    public void iniciarPerguntas(){
        this.mensagem = "\n\n == Questionário - Pesquisa de satisfação entre os alunos da PUC Minas == \n" +
                "Antes de continuarmos, esteja ciente que essa pesquisa abrange somente os\n" +
                "alunos do curso de Engenharia de Computação da PUC Minas, dos períodos 1-3 e\n" +
                "jovens entre 18-30 anos.\n\n" +
                "OBS.: os seus dados estarão seguros, essa é uma pesquisa anônima.\n";

        //Pergunta 01
        Pergunta pergunta = new Pergunta("Qual é o seu gênero?");
        pergunta.adicionarAlternativa('A', " Feminino ");
        pergunta.adicionarAlternativa('B', " Masculino ");
        pergunta.adicionarAlternativa('C', " Prefiro não identificar ");
        adicionarPergunta(pergunta);

        //Pergunta 02
        pergunta = new Pergunta("Em qual período você está?");
        pergunta.adicionarAlternativa('A', " 1° período ");
        pergunta.adicionarAlternativa('B', " 2° período ");
        pergunta.adicionarAlternativa('C', " 3° período ");
        adicionarPergunta(pergunta);

        //Pergunta03
        pergunta = new Pergunta("Selecione a categoria de idade a qual você pertence:");
        pergunta.adicionarAlternativa('A', " 18-24 anos ");
        pergunta.adicionarAlternativa('B', " 25-30 anos ");
        pergunta.adicionarAlternativa('C', " 31-45 anos ");
        adicionarPergunta(pergunta);

        //Pergunta04
        pergunta = new Pergunta("Você recomendaria esta Universidade para outras pessoas?");
        pergunta.adicionarAlternativa('A', " Sim ");
        pergunta.adicionarAlternativa('B', " Não ");
        pergunta.adicionarAlternativa('C', " Prefiro não responder ");
        adicionarPergunta(pergunta);

        //Pergunta05
        pergunta = new Pergunta("Quão satisfeito você está com os métodos de ensino dos professores?");
        pergunta.adicionarAlternativa('A', " Satisfeito ");
        pergunta.adicionarAlternativa('B', " Neutro ");
        pergunta.adicionarAlternativa('C', " Insatisfeito ");
        adicionarPergunta(pergunta);

        //Pergunta06
        pergunta = new Pergunta("Quão satisfeito você está com a limpeza da universidade?");
        pergunta.adicionarAlternativa('A', " Satisfeito ");
        pergunta.adicionarAlternativa('B', " Neutro ");
        pergunta.adicionarAlternativa('C', " Insatisfeito ");
        adicionarPergunta(pergunta);

        //Pergunta07
        pergunta = new Pergunta("Quão satisfeito você está com a biblioteca da universidade?");
        pergunta.adicionarAlternativa('A', " Satisfeito ");
        pergunta.adicionarAlternativa('B', " Neutro ");
        pergunta.adicionarAlternativa('C', " Insatisfeito ");
        adicionarPergunta(pergunta);
    }


}
