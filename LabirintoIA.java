import java.util.*;

public class LabirintoIA {
    static final int N = 10;
    static final char LIVRE = '.'; // Espaço livre
    static final char OBSTACULO = '#'; // Obstáculo 
    static final char ENERGIA5 = '5'; // Recupera 5
    static final char ENERGIA10 = 'T'; // Recupera 10
    static final char CAMINHO = '*'; // Mostra o caminho se encontrar 
    static final char INICIO = 'P'; // Partida
    static final char FIM = 'C'; // Chegada


    static class No {
        int x, y, energia;
        List<int[]> caminho;

        No(int x, int y, int energia, List<int[]> caminho) {
            this.x = x;
            this.y = y;
            this.energia = energia;
            this.caminho = new ArrayList<>(caminho);
            this.caminho.add(new int[]{x, y});
        }
    }

    public static void main(String[] args) {
        char[][] labirinto = new char[N][N];
        Random rand = new Random();

        // Inicializar labirinto
        for (char[] linha : labirinto) Arrays.fill(linha, LIVRE);

        // Obstáculos
        int numObstaculos = 15 + rand.nextInt(21);
        adicionarAleatorios(labirinto, numObstaculos, OBSTACULO, rand);

        // Energia
        adicionarAleatorios(labirinto, 5, ENERGIA5, rand);
        adicionarAleatorios(labirinto, 3, ENERGIA10, rand);

        // Início e fim Labirinto
        labirinto[0][0] = INICIO;
        labirinto[N - 1][N - 1] = FIM;

        System.out.println("Labirinto criado:");
        imprimirLabirinto(labirinto);

        System.out.println("\nIniciando...\n");

        List<int[]> caminho = busca(labirinto);
        if (caminho != null) {
            marcarCaminho(labirinto, caminho);
            imprimirLabirinto(labirinto);
            System.out.println("\nCaminho encontrado! Energia restante: " + calcularEnergia(labirinto, caminho));
        } else {
            System.out.println("Caminho não encontrado. O robô morreu :(");
        }
    }

    static List<int[]> busca(char[][] labirinto) {
        boolean[][] visitado = new boolean[N][N];
        Queue<No> fila = new LinkedList<>();
        fila.offer(new No(0, 0, 50, new ArrayList<>()));
        int[][] direcoes = {{-1,0},{1,0},{0,-1},{0,1}};

        while (!fila.isEmpty()) {
            No atual = fila.poll();
            int x = atual.x;
            int y = atual.y;
            int energia = atual.energia;

            if (x == N - 1 && y == N - 1) return atual.caminho;
            if (energia <= 0 || visitado[x][y]) continue;

            visitado[x][y] = true;

            for (int[] dir : direcoes) {
                int nx = x + dir[0];
                int ny = y + dir[1];

                if (nx >= 0 && ny >= 0 && nx < N && ny < N && labirinto[nx][ny] != OBSTACULO) {
                    int novaEnergia = energia - 1;
                    if (labirinto[nx][ny] == ENERGIA5) novaEnergia += 5;
                    if (labirinto[nx][ny] == ENERGIA10) novaEnergia += 10;
                    fila.offer(new No(nx, ny, novaEnergia, atual.caminho));
                }
            }
        }
        return null;
    }

    static void adicionarAleatorios(char[][] labirinto, int quantidade, char tipo, Random rand) {
        int adicionados = 0;
        while (adicionados < quantidade) {
            int i = rand.nextInt(N);
            int j = rand.nextInt(N);
            if ((i == 0 && j == 0) || (i == N - 1 && j == N - 1)) continue;
            if (labirinto[i][j] == LIVRE) {
                labirinto[i][j] = tipo;
                adicionados++;
            }
        }
    }

    static void imprimirLabirinto(char[][] labirinto) {
        for (char[] linha : labirinto) {
            for (char c : linha) {
                System.out.print(c + " ");
            }
            System.out.println();
        }
    }

    static void marcarCaminho(char[][] labirinto, List<int[]> caminho) {
        for (int[] pos : caminho) {
            int x = pos[0], y = pos[1];
            if (labirinto[x][y] == LIVRE) labirinto[x][y] = CAMINHO;
        }
    }

    static int calcularEnergia(char[][] labirinto, List<int[]> caminho) {
        int energia = 50;
        for (int i = 1; i < caminho.size(); i++) {
            int[] pos = caminho.get(i);
            energia--;
            if (labirinto[pos[0]][pos[1]] == ENERGIA5) energia += 5;
            if (labirinto[pos[0]][pos[1]] == ENERGIA10) energia += 10;
        }
        return energia;
    }
}
