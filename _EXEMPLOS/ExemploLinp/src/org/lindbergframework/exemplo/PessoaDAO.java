package org.lindbergframework.exemplo;

import java.util.List;
import java.util.Map;

import org.lindbergframework.exemplo.beans.Endereco;
import org.lindbergframework.exemplo.beans.Pessoa;
import org.lindbergframework.persistence.dao.LinpDAO;
import org.lindbergframework.persistence.sql.SqlArg;

/**
 * 
 * @author Victor Lindberg (victor.silva@serpro.gov.br)
 * 
 */
public class PessoaDAO extends LinpDAO{

    /**
     * Construtor padrão.
     */
    public PessoaDAO() {
        //
    }
    
    public List<Pessoa> listarPessoas(){
        return getPersistTemplate().execQuery(Pessoa.class, "listarPessoas");
    }
    
    public void inserirPessoa(Pessoa pessoa){
        Endereco endereco = pessoa.getEndereco();
        getPersistTemplate().execUpdate("inserirPessoa", pessoa.getNome(), pessoa.getCpf(),
                                                         endereco.getBairro(), endereco.getRua(), 
                                                         endereco.getNumero(), endereco.getCep().getNumero());
    }
    
    public void excluirPessoa(Pessoa pessoa){
        getPersistTemplate().execUpdate("excluirPessoa", pessoa.getCpf());
    }
    
    public Pessoa consultarPessoa(String cpf){
        return getPersistTemplate().execQueryForObject(Pessoa.class, "consultarPessoa", cpf);
    }
    
    public void atualizarPessoa(Pessoa pessoa){
        Endereco endereco = pessoa.getEndereco();
        getPersistTemplate().execUpdate("atualizarEnderecoPessoa", endereco.getBairro(),
                                                                   endereco.getRua(),
                                                                   endereco.getNumero(),
                                                                   endereco.getCep().getNumero(),
                                                                   pessoa.getCpf());
    }
    
    public List<Pessoa> listarPessoasPorIniciaisNomeUsandoProcedure(String exemploNome){
        Map parametrosOut = getPersistTemplate().callProcedure("listarPessoasPorIniciaisNome", new SqlArg("NOMEEXEMPLO", exemploNome));
        return (List<Pessoa>) parametrosOut.get("PESSOAS");
    }
}
