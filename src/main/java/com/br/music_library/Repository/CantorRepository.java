package com.br.music_library.Repository;

import com.br.music_library.Model.Cantor;
import com.br.music_library.Model.Musica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CantorRepository extends JpaRepository<Cantor, Long> {
    List<Cantor> findAllByNomeIgnoreCaseContaining(String nome);

    @Query("SELECT m FROM Musica m ORDER BY m.nome")
    List<Musica> findAllMusics();
}
