package com.yrllanio.controleveiculos.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.yrllanio.controleveiculos.dto.VeiculoDTO;
import com.yrllanio.controleveiculos.entities.Veiculo;
import com.yrllanio.controleveiculos.repositories.VeiculoRepository;
import com.yrllanio.controleveiculos.services.exceptions.DataBaseException;
import com.yrllanio.controleveiculos.services.exceptions.ServiceNotFoundException;

@Service
public class VeiculoService {

	@Autowired
	private VeiculoRepository veiculoRepositorio;

	@Transactional(readOnly = true)
	public Page<VeiculoDTO> buscaTodos(PageRequest pageRequest) {
		Page<Veiculo> pagina = veiculoRepositorio.findAll(pageRequest);

		return pagina.map(x -> new VeiculoDTO(x));
	}

	@Transactional(readOnly = true)
	public VeiculoDTO buscaPorId(Long id) {
		try {
			Optional<Veiculo> obj = veiculoRepositorio.findById(id);
			Veiculo entidade = obj.orElseThrow(() -> new ServiceNotFoundException("Entidade não encontrada"));
			return new VeiculoDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new ServiceNotFoundException("Veículo " + id + " não existe ");
		}

	}

	@Transactional
	public VeiculoDTO inserir(VeiculoDTO dto) {
		Veiculo entidade = new Veiculo();
		copiaDtoParaEntidade(dto, entidade);		

		entidade = veiculoRepositorio.save(entidade);
		return new VeiculoDTO(entidade);

	}

	@Transactional
	public VeiculoDTO atualizar(Long id, VeiculoDTO dto) {
		Veiculo entidade = veiculoRepositorio.getOne(id);
		try {
			copiaDtoParaEntidade(dto, entidade);	

			entidade = veiculoRepositorio.save(entidade);
			return new VeiculoDTO(entidade);
		} catch (EntityNotFoundException e) {
			throw new ServiceNotFoundException("Id não encontrado " + id);
		}

	}

	public void deletar(Long id) {
		try {
			veiculoRepositorio.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ServiceNotFoundException("Id não encontrado " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DataBaseException("Violação de Integridade");
		}

	}

	private void copiaDtoParaEntidade(VeiculoDTO dto, Veiculo entidade) {
		entidade.setMarca(dto.getMarca());
		entidade.setModeloDoVeiculo(dto.getModeloDoVeiculo());
		entidade.setAno(dto.getAno());

	}
}
