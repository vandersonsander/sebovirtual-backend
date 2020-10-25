package br.com.pi.sebovirtual.resource;

import org.springframework.data.jpa.repository.JpaRepository;

public abstract interface BaseRepository<E extends BaseEntity> extends JpaRepository<E, Integer>{

}
