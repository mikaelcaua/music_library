package com.br.music_library.Main;

import com.br.music_library.Model.Cantor;
import com.br.music_library.Model.Musica;
import com.br.music_library.Repository.CantorRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;
import java.util.Scanner;

public class Main {

    private CantorRepository repository;
    private Scanner scanner = new Scanner(System.in);
        private String input;
        private Integer inputInt;
        private Long inputLong;

    public Main(CantorRepository repository) {
        this.repository = repository;
    }

    public void init(){
        int opcao;
        boolean loop = true;
        String menu = "0 - Sair do Programa\n"+
                      "1 - Cadastrar Cantor\n"+
                      "2 - Cadastrar Musica\n"+
                      "3 - Buscar Músicas por Cantor\n"+
                      "4 - Listar Todas as Músicas do Banco";

        while(loop){
            System.out.println(menu);
            opcao = scanner.nextInt();
            switch (opcao){
                case 0:
                    loop = false;
                    break;
                case 1:
                    cadastrarCantor();
                    break;
                case 2:
                    cadastrarMusica();
                    break;
                case 3:
                    buscarMusicaCantor();
                    break;
                case 4:
                    listarTodasMusicas();
                    break;
                default:
                    System.out.println("Opção Inválida");
            }
        }
    }

    private void cadastrarCantor(){
        Cantor cantorCriado = new Cantor();
        System.out.println("Qual o nome do Cantor?");
        scanner.nextLine();
        input = scanner.nextLine();
        cantorCriado.setNome(input);
        System.out.println("Qual o genero Musical que ele canta?");
        input = scanner.nextLine();
        cantorCriado.setGeneroMusical(input.toUpperCase().trim());
        System.out.println("Qual a idade do cantor?");
        inputInt = scanner.nextInt();
        cantorCriado.setIdade(inputInt);

        this.repository.save(cantorCriado);

    }

    private void cadastrarMusica(){
        Musica musicaCriada = new Musica();

        List<Cantor>cantores = repository.findAll();
        cantores.forEach(c-> System.out.println(c.getNome()+" -- "+c.getGeneroMusical()+" -- "+c.getId()));
        System.out.println("Digite o código do cantor dessa música:");
        inputLong = scanner.nextLong();
        Optional<Cantor> cantor = repository.findById(inputLong);
        if(cantor.isPresent()){
            Cantor cantorSelecionado = cantor.get();
            System.out.println(cantorSelecionado);
            System.out.println("Digite o nome da música:");
            scanner.nextLine();
            input = scanner.nextLine();
            musicaCriada.setNome(input);

            System.out.println("De 1 a 10, qual sua avaliação para essa música?");
            inputInt = scanner.nextInt();
            musicaCriada.setAvaliacao(inputInt);

            cantorSelecionado.getMusicas().add(musicaCriada);
            musicaCriada.setCantor(cantorSelecionado);
            musicaCriada.setGeneroMusical(cantorSelecionado.getGeneroMusical());
            repository.save(cantorSelecionado);

        }
        else{
            throw new IllegalArgumentException("O Código inserido não é valido");
        }


    }

    private void buscarMusicaCantor(){
        System.out.println("Insira o nome do cantor que você deseja buscar as músicas: ");
        scanner.nextLine();
        input = scanner.nextLine();
        List<Cantor> buscados = repository.findAllByNomeIgnoreCaseContaining(input);
        buscados.forEach(System.out::println);
    }

    private void listarTodasMusicas(){
        List<Musica> todasMusicas = repository.findAllMusics();
        todasMusicas.forEach(System.out::println);
    }
}
