package com.formacionbdi.springboot.app.usuarios.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.formacionbdi.springboot.app.usuarios.commons.models.entity.Usuario;


@RepositoryRestResource(path="usuarios")
public interface UsuarioDAO extends PagingAndSortingRepository<Usuario, Long>{

	//Ver Spring data repository - consulta por palabras clave
	
	//con esto evitamos tener que poner en la url el nombre del metodo
	@RestResource(path="buscar-username")
	public Usuario findByUsername(@Param("nombre") String username);
	
	//La misma consulta pero con anotaciones
	@Query("select u from Usuario u where u.username=?1")
	public Usuario obtenerPorUsername(String username );
	
	/*
	 *  En POSTMAN:
	 *  
	 *  1) Sin @RestResource: 
	 *      - localhost:8090/api/usuarios/usuarios/search/findByUsername?username=admin
	 *  	- localhost:8090/api/usuarios/usuarios/search/obtenerPorUsername?username=admin
	 *  
	 *  2) Con @RestResource y @param: localhost:8090/api/usuarios/usuarios/search/buscar-username?nombre=admin
	 *  
	 */
	
}
