package br.senac.go.resources;

import br.senac.go.domain.Cliente;
import br.senac.go.generics.GenericOperationsResource;

import java.util.List;

public class ClienteResource implements GenericOperationsResource<Cliente, Integer> {

    @Override
    public Cliente post(Cliente entity) {
        return null;
    }

    @Override
    public List<Cliente> get() {
        return null;
    }

    @Override
    public void put(Cliente entity, Integer id) {

    }

    @Override
    public void patch(Cliente entity, Integer id) throws Exception {

    }

    @Override
    public void delete(Cliente entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

}
