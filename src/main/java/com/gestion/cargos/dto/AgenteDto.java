package com.gestion.cargos.dto;



import java.util.Date;

import com.gestion.cargos.modelo.TipoDocumento;
import lombok.Data;

@Data
public class AgenteDto{
	
	private Long id;

	private String nombre;

	private String apellido;

	private TipoDocumento tipoDocId;

	private Integer documento;

	private Date fechaNac;

	private String Legajo;

	private String email;

	private String telefono;

	private String domicilio;

    private Date createdAt;
    
    private Date UpdatedAt;

}
