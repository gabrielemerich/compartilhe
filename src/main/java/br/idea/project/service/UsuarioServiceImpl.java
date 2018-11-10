package br.idea.project.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import br.idea.project.contract.IUsuarioContract;
import br.idea.project.dto.UsuarioDTO;
import br.idea.project.entity.Usuario;
import br.idea.project.repository.UsuarioRepository;
import br.idea.project.security.UsuarioSecurity;
import br.idea.project.service.exception.AuthException;
import br.idea.project.service.exception.NotAuth;
import br.idea.project.service.exception.ObjectNotFound;

@Service
public class UsuarioServiceImpl implements IUsuarioContract {

	@Autowired
	private UsuarioRepository user_repo;

	@Autowired
	private BCryptPasswordEncoder pass_encoder;

	public UsuarioServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@Transactional
	public Usuario salvar(Usuario user) {

		Usuario user_email = user_repo.findByEmail(user.getEmail());
		if(user_email != null) 
			throw new NotAuth("Já existe um cadastro com este endereço de email.");
		
		user.setSenha(pass_encoder.encode(user.getSenha()));
		return this.user_repo.save(user);

	}

	public Usuario fromDTO(UsuarioDTO objDto) {
		return new Usuario(0, objDto.getNome(), objDto.getEmail(), objDto.getSenha());
	}
	
	
	@Override
	public void deletar(Usuario user) {
		this.user_repo.delete(user);

	}

	@Override
	public Usuario atualizar(Usuario user) {
		return this.user_repo.save(user);
	}

	@Override
	public List<Usuario> listarRegistros() {
		return this.user_repo.findAll();
	}

	public UsuarioDTO getUserLogado() {
		UsuarioSecurity usLogado = UsuarioLogado();
		if (usLogado == null)
			throw new AuthException("Acesso Negado!!");
		Optional<Usuario> user = this.user_repo.findById(usLogado.getId());
		
		UsuarioDTO u = new UsuarioDTO(user);
		u.setProfile_id(user.get().getProfile().getId());
		return u;
	}
	
	@Override
	public Usuario buscarId(Integer id) {
		//UsuarioSecurity usLogado = UsuarioLogado();
		/*Usuario só pode recuperar ele mesmo
		if (usLogado == null || !id.equals(usLogado.getId())) {
			throw new AuthException("Acesso Negado!!");
		}*/
		Optional<Usuario> user = this.user_repo.findById(id);
		return user.orElseThrow(() -> new ObjectNotFound("Objeto não encontrado..."));
	}

	public static UsuarioSecurity UsuarioLogado() {

		try {
			return (UsuarioSecurity) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception e) {
			return null;
		}
	}

}
