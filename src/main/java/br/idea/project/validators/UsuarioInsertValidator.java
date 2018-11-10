package br.idea.project.validators;

import java.util.ArrayList;
import java.util.List;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import br.idea.project.dto.UsuarioDTO;
import br.idea.project.entity.Usuario;
import br.idea.project.repository.UsuarioRepository;
import br.idea.project.resource.exception.FieldMessage;

public class UsuarioInsertValidator  implements ConstraintValidator<UsuarioInsert, Usuario> {

	public UsuarioInsertValidator() {
		// TODO Auto-generated constructor stub
	}
	
	@Autowired
	private UsuarioRepository repo;
	
	@Override
	public void initialize(UsuarioInsert ann) {
	}

	@Override
	public boolean isValid(Usuario objDto, ConstraintValidatorContext context) {
		
		List<FieldMessage> list = new ArrayList<>();
		
		

		Usuario aux = repo.findByEmail(objDto.getEmail());
		if (aux != null) {
			list.add(new FieldMessage("email", "Email já existente"));
		}
		
		for (FieldMessage e : list) {
			context.disableDefaultConstraintViolation();
			context.buildConstraintViolationWithTemplate(e.getMessage()).addPropertyNode(e.getFieldName())
					.addConstraintViolation();
		}
		return list.isEmpty();
	}

}
