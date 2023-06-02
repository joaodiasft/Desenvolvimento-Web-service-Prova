package br.senac.go.repositories;

import br.senac.go.domain.Hotel;
import br.senac.go.domain.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends JpaRepository<Hotel, Integer> {

    List<Hotel> findHotelsByNomeLikeIgnoreCase(String nome);

}
