package com.github.newtonjose.ufg.cs.aula01;

/**
 * <h1>Algoritmos Matemáticos.</h1>
 * Classe que implementa vários algoritmos acerca de propriedades matemáticas
 * e operações com números.
 * <p>Os algoritmos implementados estão disponíveis na
 * <a href="https://drive.google.com/file/d/1zCxtSyjkEvF6T3ieJ0r3_BJii9kx-FMI"/>
 * aula 01.</p>
 * <p></p>
 *
 * @author Josenilton Santos
 * @version 1.0
 * @since 2019-03-15
 */
public final class Algoritmos {

    /**
     * Contrutor privado.
     */
    private Algoritmos() {

    }

    /**
     * Verifica se um dado número é primo usando o método
     * Crivo de Erastóstenes.
     *
     * @param n Número inteiro natural.
     * @param a Array de inteiros, com valores iguais a zero.
     * @throws IllegalArgumentException Se o argumento estiver
     * for do intervalo: n > 1.
     * @throws IllegalArgumentException Se o argumento array tiver valor
     * diferente de zero.
     * @return boolean Retorna {true} caso o valor da n possição do array
     * seja diferente de 1, {false} caso contrario.
     **/
    public static boolean calculaCrivoErastostenes(final int[] a, final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "maior que 1");
        }

        for (int i = 0; i < n; i++) {
            if (a[i] != 0) {
                throw new IllegalArgumentException("Existe valores em a, onde "
                        + "nao sao iguais a zero");
            }
        }

        int multiplo;
        final double limite = Math.sqrt(n);

        int i = 2;
        while (i <= limite) {
            if (a[i] == 0) {
                multiplo = i + 1;

                while (multiplo <= n) {
                    a[multiplo] = 1;
                    multiplo += i;
                }
            }
            i += 1;
        }

        return a[n] != 1;
    }

    /**
     * Constante que representa o máximo dia de um mês.
     */
    private static final int DIA_MAX = 31;

    /**
     * Constante que representa o máximo dia de um ano.
     */
    private static final int MES_MAX = 12;

    /**
     * Constante que representa o menor ano permitido.
     */
    private static final int ANO_MIN = 1753;

    /**
     * Número de dias na semana.
     */
    private static final int DIAS_SEMANA = 7;

    /**
     * Número auxiliar que representa o número de meses de um ano.
     */
    private static final int NUM_MESES = 12;

    /**
     * Função auxiliar para validar uma data.
     *
     * @param d Dia do mês.
     * @param m Mês do ano.
     * @param a Ano depois de 1753.
     * @return boolean Verdadeiro caso a data seja valida, false caso contrário.
     */
    private static boolean dataInvalida(final int d, final int m, final int a) {
        return ((d < 1 || d > DIA_MAX) || (m < 1 || m > MES_MAX)
                || (a <= ANO_MIN));
    }

    /**
     * A função recebe uma data e calcula qual o dia da semana,
     * 1 - segunda; 2 - terça, 3 ...
     *
     * @param dia Numero natural menor ou igual a 31.
     * @param mes Número natural menor ou igual a 12.
     * @param ano Número natural maior ou igual a 1753.
     * @return int Retorna um número que equivale ao dia da semana da data
     * passada como paramêtro.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     *                                  seguintes intervalos: 1 <= dia <= 31;
     *                                  1 <= mes <= 12 e ano > 1753.
     */
    public static int getDiaDaSemana(final int dia, final int mes,
                                     final int ano) {
        if (dataInvalida(dia, mes, ano)) {
            throw new IllegalArgumentException("O numeros devem ser: "
                    + "1 <= dia <= 31, 1 <= mes <= 12 e ano > 1753!");
        }

        // FINDMORE: como funciona isso em Java
        final boolean janeiroOuFevereiro = mes == 1 || mes == 2;

        final int m;
        if (!janeiroOuFevereiro) {
            m = mes;
        } else {
            m = mes + NUM_MESES;
        }

        final int a;
        if (!janeiroOuFevereiro) {
            a = ano;
        } else {
            a = ano - 1;
        }

        final int drDobbsExpr = (((dia + (2 * m) + ((3 * (m + 1)) / 5)
                + a + (a / 4)) - (a / 100)) + (a / 400));

        return drDobbsExpr % DIAS_SEMANA;
    }

    /**
     * Calcula o fatorial de um dado numero natural sem usar
     * recursividade.
     *
     * @param n Número inteiro natural.
     * @return int Fatorial do número n.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     */
    static long calculaFatorial(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "n >= 1.");
        }

        long fatorial = 1;
        int i = 2;
        while (i <= n) {
            fatorial = fatorial * i;
            i = i + 1;
        }

        return fatorial;
    }

    /**
     * Calcula o número de Fibonacci sem usar recursividade.
     *
     * @param n Número inteiro natural.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     * intervalo: n >= 0.
     * @return long Número inteiro natural.
     **/
    public static long fibonacci(final int n) {
        if (n < 0) {
            throw new IllegalArgumentException("O numero 'n' tem que ser n>=0");
        }

        long t;
        long a = 0;

        if (n == 0 || n == 1) {
            return n;
        }

        int fibo = 1;
        int i = 1;
        while (i <= n) {
            t = fibo;
            fibo += a;
            a = t;
            i += 1;
        }

        return fibo;
    }

    /**
     * Avalia um polinônimo por meio de somas, produtos e potências.
     *
     * @param x Número real.
     * @param g Número real.
     * @param a Array de numeros rais.
     * @throws IllegalArgumentException Se o segundo argumento estiver for do
     * intervalo: g > 1.
     * @return int Número real.
     **/
    public static int regraHorner(final int x, final int g, final int[] a) {
        if (g < 1) {
            throw new IllegalArgumentException("g deve ser maior que zero");
        }

        int p = a[g - 1];
        int i = g - 1;
        while (i >= 0) {
            p = p * x + a[i];
            i -= 1;
        }

        return p;
    }

    /**
     * Calcula o logaritmo natural de um dado número usando uma
     * aproximação.
     *
     * @param n Numero inteiro natural.
     * @param k Numero inteiro nartual usado como o fator de aproximação.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     * intervalos: n >= 1; k >= 2.
     * @return double Logaritmo do parâmetro.
     */
    public static double calculaLogNatural(final int n, final int k) {
        if (n < 1 || k < 2) {
            throw new IllegalArgumentException("O numeros tem que ser n >= 1 "
                    + "&& k >= 2");
        }

        double logNatural = n + 1;
        int numerador = n;
        int denominador = 1;

        int i = 2;
        while (i <= k) {
            numerador = numerador * numerador;
            denominador = denominador * i;
            logNatural += (numerador / denominador);
            i += 1;
        }

        return logNatural;
    }

    /**
     * Calcula qual o maior divisor comum entre dois números inteiros.
     *
     * @param a Número inteiro natural.
     * @param b Número inteiro natural.
     * @return int Máximo divisor comum de a e b.
     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
     *                                  intervalos: a >= b e b > 0.
     **/
    public static int maiorDivisorComum(final int a, final int b) {
        if (b > a && b < 0) {
            throw new IllegalArgumentException("Os numeros deverao ser a >= b"
                    + " e b > 0");
        }

        int maiorDc;
        int auxA = a;
        int auxB = b;
        while (auxB != 0) {
            maiorDc = auxA % auxB;
            auxA = auxB;
            auxB = maiorDc;
        }

        return auxA;
    }

    /**
     * Calcula qual o maior divisor comum entre dois números inteiros
     * sem usar resto da divisão inteira.
     *
     * @param b Número inteiro natural.
     * @param a Array de números inteiros naturais.
     * @return int Máximo divisor comum de a e b.
     * @throws IllegalArgumentException Se o primeiro argumento estiver
     *                                  fora do intervalo: b > 0.
     **/
    public static int maiorDivisorComumSemResto(final int a, final int b) {
        if (b < 0) {
            throw new IllegalArgumentException("Os numero deverao 'b' tem que "
                    + "ser maior que zero!");
        }

        int auxA = a;
        int auxB = b;
        while (auxA != auxB) {
            if (auxA > auxB) {
                auxA -= auxB;
            } else {
                auxB -= auxA;
            }
        }

        return auxA;
    }

    /**
     * Constante usada como multiplicador no método numeroPi.
     */
    private static final int MULT = 4;
    /**
     * Retorna o valor de Pi aproximado pelo um dado número.
     *
     * @param n Numero inteiro natural.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     * intervalo: n >= 1.
     * @return double Valor do número Pi aproximado.
     */
    public static double numeroPi(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero n tem que ser n >= 1");
        }

        double numPi = 0;
        int i = 1;
        int s = -1;
        int d = -1;

        while (i <= n) {
            d = d + 2;
            s = -1 * s;
            numPi = numPi + (s * MULT) / d;
            i = i + 1;
        }

        return numPi;
    }

    /**
     * Verifica se um número é primo quando seus únicos divisores são 1
     * ou ele mesmo.
     *
     * @param n Número inteiro natural.
     * @return boolean Retorna {true} caso n é primo, {false} caso contrario.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     **/
    public static boolean numeroPrimo(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "maior que 1");
        }

        int interator = 2;

        while (interator < n) {
            if (n % interator == 0) {
                return false;
            }

            interator += 1;
        }

        return true;
    }

    /**
     * Calcula a potência de dois numeros usando apenas somas.
     *
     * @param x Numero inteiro natural.
     * @param y Número inteiro natural.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     * intervalos: x >= 0; y >= 0.
     * @return int Potência dos parâmetros.
     */
    public static int calculaPotencia(final int x, final int y) {
        if (x <= 0 || y <= 0) {
            throw new IllegalArgumentException("Os numeros x e y deverão "
                    + "ser x >=0 e y >=0.");
        }

        int i = 1;
        int produtorio = 1;

        while (i <= y) {
            produtorio = calculaProdutoInteiros(produtorio, x);
            i = i + 1;
        }

        return produtorio;
    }

    /**
     * Dado dois numeros inteiros a função calcula o produto dos dois
     * usando somatório.
     *
     * @param a Número inteiro natural.
     * @param b Número inteiro natural.
     * @return int Produto dos dois parâmetros.
     * @throws IllegalArgumentException Se os argumentos estiverem fora
     *                                  dos intervalos: a >= 0; b >= 0.
     */
    public static int calculaProdutoInteiros(final int a, final int b) {
        if (a < 0 || b < 0) {
            throw new IllegalArgumentException("Os numeros a e b tem que ser "
                    + "maior ou igual a zero");
        }

        int totalParcelas = a;
        int parcela = b;

        if (b < a) {
            totalParcelas = b;
            parcela = a;
        }

        int i = 1;
        int produto = 0;

        while (i <= totalParcelas) {
            produto = produto + parcela;
            i = i + 1;
        }

        return produto;
    }

    /**
     * Maior valor válido para propriedade 153.
     */
    private static final int MAX = 999;

    /**
     * Menor valor válido para propriedade 153.
     */
    private static final int MIN = 100;

    /**
     * Número usado como divisor para obter centena.
     */
    private static final int DIVISOR_CEM = 100;

    /**
     * Número usado como divisor para obter dezena.
     */
    private static final int DIVISOR_DEZ = 10;

    /**
     * Verifica se a soma dos cubos dos digitos de um dado número é
     * igual ao número dado.
     *
     * @param n Numero inteiro natural.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     * intervalo 100 a 999.
     * @return boolean Retorna {true} se satisfazer a propriedade 153
     * e {false} caso contrário.
     */
    public static boolean verificaPropriedade153(final int n) {
        if (n < MIN || n > MAX) {
            throw new IllegalArgumentException("O número não está no "
                    + "intervalor: 100 <= n <= 999");
        }

        final int r = n % DIVISOR_CEM;
        final int c = n / DIVISOR_CEM;
        final int d = r / DIVISOR_DEZ;
        final int u = r % DIVISOR_DEZ;

        return (c * c * c + d * d * d + u * u * u) == n;
    }

    /**
     * Maximo número que a propriedade se aplica.
     */
    private static final int MAX2 = 9999;

    /**
     * Verifica se um dado numero é verdadeiro usando a Propriedade 3025.
     *
     * @param n Numero inteiro natural.
     * @return boolean Retorna {true} se o número fornecido como argumento
     * satisfaz a propriedade Propriedade 3025, {false} caso contrário.
     */
    public static boolean verificaPropriedade3025(final int n) {
        if (n < 0 || n > MAX2) {
            throw new IllegalArgumentException("Numero fora do range "
                    + "100 <= n <= 999");
        }

        final double i = n / DIVISOR_CEM;
        final double j = n % DIVISOR_CEM;
        final double m = i + j;

        return m * m == n;
    }

    /**
     * Constante usada pelo método calculaQuadradoPerfeito.
     */
    private static final int CONST = 2;

    /**
     * Verifica se o dado número é um quadrado perefeito, satisfazendo
     * esquação do algoritmo.
     *
     * @param n Número inteiro.
     * @return {boolean} boolean Retorna {true} se o número fornecido é
     * um quadrado perfeito, caso contrário, {false}.
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     **/
    public static boolean calculaQuadradoPerfeito(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
                    + "que 1");
        }

        int i = 1;
        int s = 1;

        while (s < n) {
            i += CONST;
            s += i;
        }

        return s == n;
    }

    /**
     * Constante divisora usada pelo método @raizQuadrada.
     */
    private static final int DIV = 2;

    /**
     * Calcula a raiz quadrada de um número usando o Método Babilônico.
     *
     * @param n Número racional positivo.
     * @param i Numero inteiro nartual usado como o fator de prescisão.
     * @return double Retorna raiz quadrada de n usando a precisão i.
     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
     *                                  intervalos: n > 0.
     **/
    public static double raizQuadrada(final int n, final int i) {
        if (n < 0) {
            throw new IllegalArgumentException("O numero 'n' deverá ser maior "
                    + "que 0");
        }
        double numRaiz = 1;

        int aux = i;
        while (aux >= 0) {
            numRaiz = (numRaiz + n / numRaiz) / DIV;
            aux -= 1;
        }

        return numRaiz;
    }

    /**
     * Calcula a razão área através do processo iniciado com dois
     * números inteiros positivos e um valor que determina a precisão.
     *
     * @param x Numero inteiro natural.
     * @param y Numero inteiro natural.
     * @param k Numero inteiro natural usado como fator de prescisão.
     * @throws IllegalArgumentException Se os argumentos estiverem fora dos
     * intervalos: x >= 0; x < y e k > 0.
     * @return double Razão áurea de dois numeros.
     */
    public static double calculaRazaoAurea(final int x, final int y,
                                           final int k) {
        if ((x < 0 || x > y) || k <= 0) {
            throw new IllegalArgumentException("Números deve ser: x >= 0, x < "
                    + "y e k > 0");
        }

        int t;
        int c = y;
        int a = x;

        int i = 1;
        while (i <= k) {
            t = c;
            c += a;
            a = t;
            i = i + 1;
        }

        return c / a;
    }

    /**
     * Dado dois numeros, está função encontra o resto da divisão de x por y.
     *
     * @param x Numero racional.
     * @param y Número racional.
     * @throws IllegalArgumentException Se os argumentos estiver fora dos
     *                                  intervalos: y >= 0; x > 0.
     * @return int Retorna o resto da duvisão inteira.
     */
    public static int calculaRestoDivisao(final int x, final int y) {
        if (x < 0 || y <= 0) {
            throw new IllegalArgumentException("O numeros devem ser y >= 0 && "
                    + "x > 0.");
        }

        int i = y;
        int resto = x;
        while (i <= resto) {
            resto -= i;
        }

        return resto;
    }

    /**
     * Dado um número natural, soma os todos os primeiros naturais
     * ate o dado número.
     *
     * @param n Número inteiro natural.
     * @return int Número inteiro natural.
     *
     * @throws IllegalArgumentException Se o argumento estiver fora do
     *                                  intervalo: n >= 1.
     */
    public static int somaNaturais(final int n) {
        if (n < 1) {
            throw new IllegalArgumentException("O numero 'n' tem que ser "
                    + "n >= 1.");
        }

        int i = 2;
        int soma = 1;
        while (i <= n) {
            soma += i;
            i += 1;
        }

        return soma;
    }

    /**
     * Constate resto usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int RESTO = 10;

    /**
     * Constate estatica usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int ONZE = 11;

    /**
     * Constate estatica usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int DEZ = 10;

    /**
     * Constate estatica usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int NOVE = 9;

    /**
     * Constate estatica usado pelos métodos: validaCPF e validaCPFRegraHorner.
     */
    private static final int OITO = 8;

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamente.
     *
     * @param cpf Array de numeros rais.
     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
     * @throws IllegalArgumentException Se no argumento tiver algum
     * número: 0 <= n >= 9.
     * @return boolean true ou false Valor lógico.
     **/
    public static boolean validaCPF(final int[] cpf) {
        if (cpf.length != ONZE) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        //TODO: Verificar numeros invalidos no vetor

        int j = 0;
        int k = 0;
        //CONST = 8;
        for (int i = 0; i < NOVE; i++) {
            j += cpf[i];
        }

        for (int i = 1; i < DEZ; i++) {
            k += cpf[i];
        }

        final int dj = (j % ONZE) % RESTO;
        final int dk = (k % ONZE) % RESTO;

        return (dj == cpf[cpf.length - 1]) && (dk == cpf[cpf.length]);
    }

    /**
     * Verifica se um dado CPF segue a regra de formação dos digitos
     * corretamenten usando o Método de Horner.
     *
     * @param d Array de numeros rais.
     * @throws IllegalArgumentException Se o argumento não tiver 11 digitos.
     * @throws IllegalArgumentException Se no argumento tiver algum
     * número: 0 <= n >= 9.
     * @return boolean true ou false Valor lógico.
     **/
    public static boolean validaCPFRegraHorner(final int[] d) {
        if (d.length != ONZE) {
            throw new IllegalArgumentException("o cpf deve ter 11 digitos");
        }

        int p = d[NOVE];
        int s = d[NOVE];
        int o = OITO;
        while (o >= 1) {
            p += d[o];
            s += p;
            o -= 1;
        }

        final int j = (s % ONZE) % RESTO;
        final int k = ((s - p + NOVE * d[DEZ]) % ONZE) % RESTO;

        return (j == d[d.length - 1]) && (k == d[d.length]);
    }
}
