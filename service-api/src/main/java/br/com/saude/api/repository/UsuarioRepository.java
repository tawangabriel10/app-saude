package br.com.saude.api.repository;

import br.com.saude.api.domain.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by tawan on 2/27/17.
 */
@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    @Query(" select u from Usuario u " +
            " where u.nome = :nome ")
    List<Usuario> findByNome(@Param("nome") String nome);

    @Query(" select u from Usuario u " +
            " where u.email=:email and u.senha=:senha ")
    Usuario findEmailAndSenha(@Param("email") String email, @Param("senha") String senha);
}
