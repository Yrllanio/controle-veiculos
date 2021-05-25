package com.yrllanio.controleveiculos.services;

import java.util.Optional;
import java.util.stream.Collectors;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrllanio.controleveiculos.dto.UsuarioDTO;
import com.yrllanio.controleveiculos.dto.VeiculoDTO;
import com.yrllanio.controleveiculos.entities.Usuario;
import com.yrllanio.controleveiculos.entities.Veiculo;
import com.yrllanio.controleveiculos.repositories.UsuarioRepository;
import com.yrllanio.controleveiculos.repositories.VeiculoRepository;
import com.yrllanio.controleveiculos.services.exceptions.DataBaseException;
import com.yrllanio.controleveiculos.services.exceptions.ServiceNotFoundException;

@Service
public class UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepositorio;

	@Autowired
	private VeiculoRepository veiculoRepositorio;

	@Transactional(readOnly = true)
	public Page<UsuarioDTO> buscaTodos(Pageable paginavel) {
		Page<Usuario> pagina = usuarioRepositorio.findAll(paginavel);
		usuarioRepositorio.buscaUsuarioComVeiculos(pagina.stream().collect(Collectors.toList()));
		return pagina.map(x -> new UsuarioDTO(x));
	}

	@Transactional(readOnly = true)
	public UsuarioDTO buscaPorId(Long id) {
		try {
			Optional<Usuario> obj = usuarioRepositorio.findById(id);
			Usuario entidade = obj.orElseThrow(() -> new ServiceNotFoundException("Entidade não encontrada"));
			return new UsuarioDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new ServiceNotFoundException("Usuário " + id + " não existe ");
		}
	}

	@Transactional
	public UsuarioDTO inserir(UsuarioDTO dto) {
		Usuario entidade = new Usuario();
		copiaDtoParaEntidade(dto, entidade);

		entidade = usuarioRepositorio.save(entidade);
		return new UsuarioDTO(entidade);
	}

	@Transactional
	public UsuarioDTO atualizar(Long id, UsuarioDTO dto) {
		try {
			Usuario entidade = usuarioRepositorio.getOne(id);
			copiaDtoParaEntidade(dto, entidade);
			entidade = usuarioRepositorio.save(entidade);
			return new UsuarioDTO(entidade);
		}

		catch (EntityNotFoundException e) {
			throw new ServiceNotFoundException("Id não encontrado " + id);
		}

	}

	public void deletar(Long id) {
		try {
			usuarioRepositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceNotFoundException("Id não encontrado " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de Integridade");
		}

	}

	private void copiaDtoParaEntidade(UsuarioDTO dto, Usuario entidade) {
		entidade.setNome(dto.getNome());
		entidade.setEmail(dto.getEmail());
		entidade.setCpf(dto.getCpf());
		entidade.setDataNascimento(dto.getDataNascimento());

		entidade.getVeiculos().clear();
		for (VeiculoDTO veiculoDto : dto.getVeiculos()) {
			Veiculo veiculo = veiculoRepositorio.getOne(veiculoDto.getId());
			entidade.getVeiculos().add(veiculo);
		}

	}

}
