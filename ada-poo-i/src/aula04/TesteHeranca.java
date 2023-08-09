package aula04;

public class TesteHeranca {
    public static void main(String[] args) {
        Carro carroGol = new Carro("AAA", "Cinza", "Gol", 2021, 4, "Flex");
        carroGol.exibirDados();

        Moto moto = new Moto("BBB", "Preto", "Kawasaki", 2023, 2000);
        moto.exibirDados();



    }
}
