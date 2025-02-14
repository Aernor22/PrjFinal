package ifsp.edu.br.ProjetoFinal.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import ifsp.edu.br.ProjetoFinal.modelo.Usuario;

public interface UsuarioRepositorio extends CrudRepository<Usuario, Long> {
	Usuario findByUsername(String username);
	
	@Query("SELECT u FROM Usuario u JOIN u.papeis p WHERE p.papel = 'ROLE_ADMIN'")
	List<Usuario> findAllAdmin();
	
	@Query("SELECT u FROM Usuario u JOIN u.papeis p WHERE p.papel = :role")
	List<Usuario> findAllByRole(String role);
	
	@Query("SELECT u FROM Usuario u WHERE u.habilitado = false")
	List<Usuario> findDesabilitados();
	
//	@Query("SELECT u FROM Usuario u JOIN papeis p on p.papel = u.papel JOIN OrdemServico o ON o.instalador.id = u.id "
//			+ "WHERE p.papel = 'ROLE_INSTALLER' AND o.dataFinalInstalacao is null AND o.dataContratacao+5 < CURDATE()") //Validar Querys
//	List<Usuario> findInstaladoresComOsAtrasada();
}
