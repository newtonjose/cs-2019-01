/**
 * Classe auxiliar para validar parametros passados. A classe valida tipo
 * {array} e tipo {number}.
 *
 * @type {module.ValidaParametros}
 */
class ValidaParametros {
    /**
     * Função auxiliar que verifica se um dado paramêtro é do tipo 'number'.
     * @param n Parametros tipo número.
     * @returns {boolean}
     */
    static verificaTipoNumero(n) {
        return typeof n == "number";
    }

    /**
     * Função auxiliar que verifica se um dado paramêtro é do tipo 'array'.
     * @param a Váriável do tipo array.
     * @returns {boolean} arg is Array
     */
    static verificaTipoArray(a) {
        return Array.isArray(a);
    }

    /**
     * Metódo auxiliar que verifica se um parametro é número do tipo float.
     * @param n Número inteiro.
     * @returns {boolean}
     */
    static verificaTipoFloat(n) {
        return Number(n) === n && n % 1 !== 0;
    }

    /**
     * Método auxiliar que realiza teste sobre um array de parâmetros.
     * @param a Array de parâmetros de entrada.
     * @throws {Error} Caso a entrada seja null ou undefined.
     * @throws {TypeError} Caso a entrada não do tipo numero.
     * @throws {TypeError} Caso a entrada não seja números inteiros.
     */
    static validaEntrada(a) {
        for (let i = 0; i < a.length; i++) {
            if (a[i] == null || a[i] === undefined) {
                throw new Error("Entrada invalidada, null e undefined nao " +
                    "sao entradas validas");
            }

            if (!ValidaParametros.verificaTipoNumero(a[i])) {
                throw new TypeError("argumento(s) valido(s) é/são do tipo " +
                    "número.");
            }

            if (ValidaParametros.verificaTipoFloat(a[i])) {
                throw new TypeError("agumento(s) deve(m) ser tipo inteiro.");
            }
        }
    }
}

// TODO: Documentação da classe.
class EstruturasIteracao {

    /**
     * Método que encontra a menor temperatura em um vetor.
     *
     * @param {array} temps Vetor de temperaturas.
     * @returns {int} Menor temperatura do vetor passado como paramentro.
     * @throws {TypeError} Se o argumento 'temps' não for um array.
     * @throws {RangeError} Se o vetor de temperatura for vazio.
     * @throws {TypeError} Se algum elemento do vetor de temperaturas
     * não for do tipo número.
     */
    static encontrarMenorTemp(temps) {
        if (!ValidaParametros.verificaTipoArray(temps)) {
            throw new TypeError("o argumento a deve ser do tipo array");
        }

        if (temps.length === 0) {
            throw new RangeError("nenhuma temperatura fio informada");
        }

        temps.forEach((temp) => {
            ValidaParametros.validaEntrada([temp,]);
        });

        let menorTemp = temps[0];
        let maiorTemp = temps[0];

        temps.forEach((value) => {
            if (value > maiorTemp) {
                maiorTemp = value
            }

            if (value < menorTemp) {
                menorTemp = value
            }
        });

        return menorTemp;
    }

    /**
     * Soma a quantidade de números impares em um dado vetor.
     *
     * @param {array} numbers Vetor de numeros naturais.
     * @returns {int} Soma de todos os impares do vetor passado como parametro.
     * @throws {TypeError} Se o argumento 'numbers' não for um array.
     * @throws {RangeError} Se o vetor for vazio.
     * @throws {TypeError} Se algum elemento do vetor não for do tipo número.
     */
    static somaNumerosImpares(numbers) {
        if (!ValidaParametros.verificaTipoArray(numbers)) {
            throw new TypeError("o argumento a deve ser do tipo array");
        }

        if (numbers.length === 0) {
            throw new RangeError("nenhuma temperatura foi informada");
        }

        numbers.forEach((temp) => {
            ValidaParametros.validaEntrada([temp]);
        });


        const impares = numbers.filter(value => {
            if (value % 2 !== 0) {
                return value;
            }
        });

        return impares.reduce((total, value) => {
            return total + value;
        });
    }

    /**
     * Conta a quanidade de um elemento dado em vetor.
     * @param num Número inteiro a ser contado no vetor.
     * @param numbers Array de números inteiros.
     * @returns int Quantidade de ocorrências de num no vetor.
     * @throws {TypeError} Se o argumento num não for do tipo inteiro.
     * @throws {TypeError} Se o argumento 'numbers' não for um array.
     * @throws {RangeError} Se o vetor for vazio.
     */
    static getQuantidadeElementos(num, numbers) {
        ValidaParametros.validaEntrada([num]);

        if (!ValidaParametros.verificaTipoArray(numbers)) {
            throw new TypeError("o argumento a deve ser do tipo array");
        }

        if (numbers.length === 0) {
            throw new RangeError("nenhuma elemento foi informado");
        }

        const finds = numbers.filter((value) => {
            return value === num;
        });

        return finds.length;
    }

    /**
     * Método que conta a quantidade de ocorrencias de cada letras em uma
     * string.
     *
     * @param {string} msgs Sequencia de caracteres.
     * @return {Object} Objeto com a ocorrencias de cada palavra.
     * @throws {TypeError} Se parâmetro não for do tipo string.
     * @throws {RangeError} Caso o parametro seja uma string vazia.
     */
    static getOcorrenciasLetras(msgs) {

        if (typeof msgs != "string") {
            throw new TypeError("o parametro tem que ser do tipo string.")
        }

        if (msgs.length === 0) {
            throw new RangeError("a string está vazia.");
        }

        const num_letras = {};

        const msgs_vet = msgs.split('');
        msgs_vet.forEach((value) => {
            num_letras[value] = msgs_vet.filter((caracter) => {
                return value === caracter;
            }).length;
        });

        return num_letras;
    }

    /**
     * Método que encontra a palavra com mais orcorrencia numa array de string.
     *
     * @param {string} msgs Sequencia de caracteres.
     * @returns {string} Palavra com mais ocorrência no Arrays.
     * @throws {TypeError} Se parâmetro não for do tipo string.
     * @throws {RangeError} Caso o parametro seja uma string vazia.
     */
    static localizaPalavraMaisFrequente(msgs) {
        if (typeof msgs != "string") {
            throw new TypeError("o parametro tem que ser do tipo string.")
        }

        if (msgs.length === 0) {
            throw new RangeError("a string está vazia.");
        }

        const num_palavras = {};

        const msgs_vet = msgs.split(' ');
        msgs_vet.forEach((value) => {
            num_palavras[value] = msgs_vet.filter((caracter) => {
                return value === caracter;
            }).length;
        });

        const sortable = [];
        for (let palavra in num_palavras) {
            sortable.push([palavra, num_palavras[palavra]]);
        }

        sortable.sort(function(a, b) {
            return a[1] - b[1];
        });

        return sortable[sortable.length-1][0];
    }
}

module.exports = EstruturasIteracao;
