package br.senac.go.services;

import br.senac.go.domain.Hotel;
import br.senac.go.generics.IService;
import br.senac.go.repositories.HotelRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Slf4j
public class HotelService implements IService<Hotel, Integer> {

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    @Transactional
    public Hotel create(Hotel entity) {
        log.info("Método HotelService.create invocado");
        log.debug("Valores informados HotelService.create: {}", entity);
        return hotelRepository.save(entity);
    }

    @Override
    public Hotel readById(Integer id) throws Exception {
        log.info("Método HotelService.readById invocado");
        log.debug("Valores informados HotelService.readById: {}", id);
        Optional<Hotel> hotelOptional = hotelRepository.findById(id);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            log.debug("Valores recuperados em HotelService.readById: {}", hotel);
            return hotel;
        } else {
            log.error("Hotel não encontrado");
            throw new Exception("Registro não encontrado.");
        }
    }

    @Override
    public Hotel read(Hotel entity) throws Exception {
        log.info("Método HotelService.read invocado");
        log.debug("Valores informados HotelService.read: {}", entity);
        Example<Hotel> hotelExample = Example.of(entity);
        Optional<Hotel> hotelOptional = hotelRepository.findOne(hotelExample);
        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            log.debug("Valores recuperados em HotelService.read: {}", hotel);
            return hotel;
        } else {
            log.error("Hotel não encontrado");
            throw new Exception("Registro não encontrado.");
        }
    }

    @Override
    @Transactional
    public Hotel updatePatch(Hotel entity, Integer id) throws Exception {
        log.info("Método HotelService.updatePatch invocado");
        log.debug("Valores informados HotelService.updatePatch: {} {}", entity, id);

        Optional<Hotel> hotelOptional = hotelRepository.findById(id);

        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            // Atualiza os campos do hotel com os valores recebidos
            // Exemplo:
            // hotel.setNome(entity.getNome());
            // hotel.setEndereco(entity.getEndereco());
            // ...
            Hotel hotelAtualizado = hotelRepository.save(hotel);
            log.debug("Valores atualizados em HotelService.updatePatch: {}", hotelAtualizado);
            return hotelAtualizado;
        } else {
            log.error("Hotel não encontrado");
            throw new Exception("Registro não encontrado.");
        }
    }

    @Override
    @Transactional
    public Hotel updatePut(Hotel entity, Integer id) throws Exception {
        log.info("Método HotelService.updatePut invocado");
        log.debug("Valores informados HotelService.updatePut: {} {}", entity, id);

        Optional<Hotel> hotelOptional = hotelRepository.findById(id);

        if (hotelOptional.isPresent()) {
            // Atualiza o ID do hotel com o ID recebido
            entity.setId(id);
            Hotel hotelAtualizado = hotelRepository.save(entity);
            log.debug("Valores atualizados em HotelService.updatePut: {}", hotelAtualizado);
            return hotelAtualizado;
        } else {
            log.error("Hotel não encontrado");
            throw new Exception("Registro não encontrado.");
        }
    }

    @Override
    @Transactional
    public Hotel deleteById(Integer id) throws Exception {
        log.info("Método HotelService.deleteById invocado");
        log.debug("Valores informados HotelService.deleteById: {}", id);

        Optional<Hotel> hotelOptional = hotelRepository.findById(id);

        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            hotelRepository.deleteById(id);
            log.debug("Hotel removido em HotelService.deleteById: {}", hotel);
            return hotel;
        } else {
            log.error("Hotel não encontrado");
            throw new Exception("Registro não encontrado.");
        }
    }

    @Override
    @Transactional
    public Hotel delete(Hotel entity) throws Exception {
        log.info("Método HotelService.delete invocado");
        log.debug("Valores informados HotelService.delete: {}", entity);

        Example<Hotel> hotelExample = Example.of(entity);
        Optional<Hotel> hotelOptional = hotelRepository.findOne(hotelExample);

        if (hotelOptional.isPresent()) {
            Hotel hotel = hotelOptional.get();
            hotelRepository.delete(hotel);
            log.debug("Hotel removido em HotelService.delete: {}", hotel);
            return hotel;
        } else {
            log.error("Hotel não encontrado");
            throw new Exception("Registro não encontrado.");
        }
    }
}
