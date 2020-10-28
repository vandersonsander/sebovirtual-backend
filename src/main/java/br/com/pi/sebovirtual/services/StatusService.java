package br.com.pi.sebovirtual.services;

import org.springframework.stereotype.Service;

import br.com.pi.sebovirtual.entities.Status;
import br.com.pi.sebovirtual.repositories.StatusRepository;
import br.com.pi.sebovirtual.resource.BaseService;

@Service
public class StatusService extends BaseService<Status, StatusRepository>{

}
