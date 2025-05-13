🧠 Labirinto IA - Em Java
📋 Descrição
Este projeto é uma simulação de um robô inteligente que deve encontrar o caminho de saída em um labirinto, gerenciando sua energia para não "morrer" no processo. O programa foi desenvolvido em Java e utiliza uma busca em largura (BFS) para explorar o labirinto, considerando obstáculos, pontos de recarga de energia e restrições de movimento.

O robô inicia no canto superior esquerdo (P) e deve chegar ao canto inferior direito (C), evitando obstáculos e coletando energia ao longo do caminho.

🛠️ Funcionalidades
✅ Geração aleatória do labirinto (10x10)
✅ Posicionamento aleatório de obstáculos e pontos de energia
✅ Busca inteligente (BFS) para encontrar o caminho viável
✅ Gestão de energia do robô (começa com 50 unidades)
✅ Recolhimento de energia (+5 ou +10)
✅ Exibição visual do labirinto e do caminho encontrado
✅ Mensagens de sucesso ou fracasso

🧩 Regras do Jogo
Símbolo	Descrição
.	Espaço livre
#	Obstáculo (bloqueia passagem)
5	Recarrega +5 de energia
T	Recarrega +10 de energia
P	Ponto de partida do robô
C	Chegada (destino final)
*	Caminho percorrido pelo robô

🚀 Como Executar
✅ Pré-requisitos:
Java JDK 8 ou superior

IDE ou terminal para compilar/executar (ex: NetBeans, Eclipse, VS Code)

✅ Passos:
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/seu-usuario/labirinto-ia.git
Compile o código:

bash
Copiar
Editar
javac LabirintoIA.java
Execute:

bash
Copiar
Editar
java LabirintoIA
🧮 Lógica da Solução
O labirinto é uma matriz 10x10 preenchida com espaços livres.

São adicionados aleatoriamente:

15 a 35 obstáculos (#)

5 pontos de energia 5 (+5 de energia)

3 pontos de energia T (+10 de energia)

O robô inicia com 50 unidades de energia e gasta 1 unidade a cada passo.

Se a energia zerar antes de chegar à saída, o robô "morre".

O algoritmo de busca em largura (BFS) explora todas as rotas possíveis até encontrar o caminho viável ou detectar que não há saída.

O caminho encontrado é marcado com * no labirinto final.

📊 Exemplo de Saída
r
Copiar
Editar
Labirinto criado:
P . . . # . . 5 . . 
. # . . . . . # T . 
. . . . . # . . . . 
. # . # # # # . . . 
. . . . . . . . . 5 
. . . . # . . . . . 
. . . . . . 5 . . . 
. . # # . # . . . . 
. . . . . . . . . . 
. . . . . T . . . C 

Iniciando...

P * * * # . . 5 . . 
. # . . . . . # T . 
. . . . . # . . . . 
. # . # # # # . . . 
. . . . . . . . . 5 
. . . . # . . . . . 
. . . . . . 5 . . . 
. . # # . # . . . . 
. . . . . . . . . . 
. . . . . T . . . C 

Caminho encontrado! Energia restante: 18
⚠️ Limitações e Melhorias Futuras
🚧 Labirinto fixo em 10x10 (pode ser parametrizado)

🚧 BFS simples (pode ser otimizado com A* para melhor performance)

🚧 Sem interface gráfica (possível evolução para Swing ou JavaFX)

🚧 Energia como fator crítico pode ser expandida (ex: armadilhas, bônus)
