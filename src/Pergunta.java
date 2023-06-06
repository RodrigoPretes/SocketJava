import java.util.ArrayList;

public class Pergunta {

    String pergunta;
    int quantAlternativas;
    //Alternativa[] alternativas;

    ArrayList<Alternativa> alternativas = new ArrayList<>();
    boolean respondida;
    char resposta;


    public Pergunta(String pergunta){
        this.pergunta = pergunta;
    }

    public void adicionarAlternativa(char letra, String enunciado){
        Alternativa alternativa = new Alternativa(letra, enunciado);
        this.alternativas.add(alternativa);
    }

    /**
     * Responder a Pergunta
     * @return
     */
    public boolean responder(char resposta){
        this.respondida = validarResposta(resposta);
        if(this.respondida){
            this.resposta = resposta;
        }
        return this.respondida;
    }


    /**
     * Valida a resposta recebida
     * @return
     */
    private boolean validarResposta(char resposta){
        boolean respondida = false;
        for(int i = 0; i < alternativas.size(); i++){
            if(resposta == alternativas.get(i).alternativa){
                respondida = true;
                break;
            }
        }
        return respondida;
    }







}
