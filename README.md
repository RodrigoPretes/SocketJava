# Projeto SocketJava

Este projeto foi desenvolvido para a disciplina de Redes de Computadores I 
com o objetivo de explorar o conceito de sockets em redes de computadores.
O projeto implementa um servidor de chat simples que permite a conexão de vários clientes,
envio de mensagens e participação em um questionário. O servidor coleta e analisa as respostas para gerar estatísticas.

## Funcionalidades

- Permite a conexão de vários clientes ao servidor de chat simultaneamente.
- Implementa um questionário com perguntas de múltipla escolha.
- Armazena as respostas de cada cliente e calcula estatísticas com base nos dados coletados.

## Como Usar

1. Clone o repositório usando o seguinte comando:

```
https://github.com/RodrigoPretes/SocketJava.git

```

2. Compile o código Java usando o ambiente de desenvolvimento Java de sua preferência ou ferramentas de linha de comando.

3. Inicie o servidor de chat executando a classe `ChatServer`.

4. Os clientes podem se conectar ao servidor usando um programa cliente de socket ou um cliente telnet. O servidor está configurado para ouvir na porta 4000 por padrão.

5. Após a conexão, os clientes receberão o questionário e poderão responder a cada pergunta enviando a letra correspondente (A, B ou C) como mensagem para o servidor.

6. O servidor coletará as respostas e gerará estatísticas com base nos dados coletados. As estatísticas podem ser visualizadas na saída do console do servidor.

## Licença

Este projeto está licenciado sob a Licença MIT. Consulte o arquivo [LICENSE](LICENSE) para obter mais detalhes.
