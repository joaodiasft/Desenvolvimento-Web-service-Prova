package br.senac.go.resources;

import br.senac.go.domain.Quarto;
import br.senac.go.generics.GenericOperationsResource;

import java.util.List;

public class QuartoResource implements GenericOperationsResource<Quarto, Integer> {

    @Override
    public Quarto post(Quarto entity) {
        return null;
    }

    @Override
    public List<Quarto> get() {
        return null;
    }

    @Override
    public void put(Quarto entity, Integer id) {

    }

    @Override
    public void patch(Quarto entity, Integer id) throws Exception {

    }

    @Override
    public void delete(Quarto entity) {

    }

    @Override
    public void deleteById(Integer id) {

    }

}