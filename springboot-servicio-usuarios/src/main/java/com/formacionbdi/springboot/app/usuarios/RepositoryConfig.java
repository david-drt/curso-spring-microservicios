package com.formacionbdi.springboot.app.usuarios;

 

import org.springframework.context.annotation.Configuration;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.data.rest.webmvc.config.RepositoryRestConfigurer;

import com.formacionbdi.springboot.app.usuarios.commons.models.entity.Usuario;
import com.formacionbdi.springboot.app.usuarios.commons.models.entity.Rol;

@Configuration
public class RepositoryConfig implements RepositoryRestConfigurer{

	/*
	 *  Configuracion para mostrar el ID de las clases
	 * 
	 */
	
	@Override
	public void configureRepositoryRestConfiguration(RepositoryRestConfiguration config) {
		config.exposeIdsFor(Usuario.class,Rol.class);
	}
	
}
