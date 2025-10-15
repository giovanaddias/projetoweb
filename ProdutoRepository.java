package com.ifsp.GiDias.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.ifsp.GiDias.model.Produto;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;

@Repository
public class ProdutoRepository {
    @PersistenceContext
    private EntityManager entityManager;
    @Transactional
    public void salvar(Produto produto){
        String comando = "INSERT INTO produto (Id, nome,descricao, preco, quantidade) VALUES (:Idv, :nomev, :descricaov, :precov, :quantidadev)";
        Query query = entityManager.createNativeQuery(comando);
        query.setParameter("Idv", produto.getId());
        query.setParameter("nomev", produto.getNome());
        query.setParameter("descricaov", produto.getDescricao());
        query.setParameter("precov", produto.getPreco());
        query.setParameter("quantidadev", produto.getQuantidade());
        query.executeUpdate();
    }

  public List<Produto> findAll() {
        TypedQuery<Produto> query = entityManager.createQuery("SELECT p FROM Produto p", Produto.class);
        return query.getResultList();
    }

}

