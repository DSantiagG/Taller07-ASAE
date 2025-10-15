package co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicauca.asae.taller07.franjaHoraria.infraestructura.output.persistencia.entidades.AsignaturaEntity;

public interface AsignaturaRepository extends JpaRepository<AsignaturaEntity, Integer>{

}
