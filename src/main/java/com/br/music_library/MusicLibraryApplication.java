package com.br.music_library;

import com.br.music_library.Main.Main;
import com.br.music_library.Model.Cantor;
import com.br.music_library.Repository.CantorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.JpaRepository;

@SpringBootApplication
public class MusicLibraryApplication implements CommandLineRunner {
	@Autowired
	private CantorRepository repository;
	public static void main(String[] args) {
		SpringApplication.run(MusicLibraryApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Main main = new Main(repository);
		main.init();
	}

}
