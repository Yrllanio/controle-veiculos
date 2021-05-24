package com.yrllanio.controleveiculos.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.yrllanio.controleveiculos.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query("SELECT obj FROM Usuario obj JOIN FETCH obj.veiculos WHERE obj IN :usuarios")
	List<Usuario> buscaUsuarioComVeiculos(List<Usuario> usuarios);
}
