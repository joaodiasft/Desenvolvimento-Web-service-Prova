package br.senac.go.resources;

import br.senac.go.domain.Hotel;
import br.senac.go.domain.Pessoa;
import br.senac.go.generics.GenericOperationsResource;
import br.senac.go.services.HotelService;
import br.senac.go.services.PessoaService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import redis.clients.jedis.params.Params;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(path = "/hotel")
@Api(tags = "hotel ")
public class HotelResource implements GenericOperationsResource<Hotel, Integer> {

    @Autowired
    private HotelService hotelService;

    private static final Logger LOGGER = Logger.getLogger(HotelResource.class.getName());

    Params entity
    @return

    @Override
    @PostMapping(consumes = {MediaType.APPLICATION_JSON_VALUE,
            "application/xml;charset=UTF-8"},produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    @ApiOperation(value="${resource.hotel-post}",
            notes="Criar dados de hotel.")
    @ApiResponses(value={
            @ApiResponse(code = 200, message = "Requisição feita com sucesso.", response = Hotel.class),
            @ApiResponse(code = 201, message = "Registro criado com sucesso.", response = Hotel.class),
            @ApiResponse(code = 204, message = "O servidor processou a solicitação com sucesso e não está retornando nenhum conteúdo."),
            @ApiResponse(code = 301, message = "Redirecionamento permanente.", response = Hotel.class),
            @ApiResponse(code = 401, message = "Não autorizado.", response = Hotel.class),
            @ApiResponse(code = 404, message = "Registro não encontrado.", response = Hotel.class),
            @ApiResponse(code = 500, message = "Erro na requisão, verifique configurações do servidor.", response = Hotel.class)
    })

    public Hotel post(@RequestBody @Validated Hotel entity) {
        LOGGER.log(Level.INFO,"HotelResource.post inicado {} ", entity);

        Hotel pessoaPersitida = this.hotelService.create(entity);

        Object hotelPersitida;
        LOGGER.log(Level.INFO,"HotelResource.post concluído {} ", hotelPersitida);
        return (Hotel) hotelPersitida;
    }

    @Override
    @GetMapping(produces = { MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE })
    public List<Hotel> get() {

        LOGGER.log(Level.INFO, "Exemplo do GET:");
        return null;
    }

    @Override
    @PutMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public void put(@RequestBody @Validated Hotel entity,
            @PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do PUT: %s | %d", entity, id));

        this.hotelService.updatePut(entity, id);

    }

    @Override
    @PatchMapping(value = "/{id}", consumes = { MediaType.APPLICATION_JSON_VALUE })
    public void patch(@RequestBody @Validated Hotel entity,
            @PathVariable("id") Integer id) throws Exception {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do PATCH: %s | %d", entity, id));

        this.hotelService.updatePatch(entity, id);

    }

    @Override
    @DeleteMapping(consumes = { MediaType.APPLICATION_JSON_VALUE })
    public void delete(@RequestBody @Validated Hotel entity) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do DELETE: %s", entity));
    }

    @Override
    @DeleteMapping(value = "/{id}")
    public void deleteById(@PathVariable("id") Integer id) {
        LOGGER.log(Level.INFO,
                String.format("Exemplo do DELETE: %d", id));
    }
}
