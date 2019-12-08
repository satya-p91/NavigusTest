package com.satya.BLB.projectBLB;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource
public interface RestRepository extends CrudRepository<Beer, Long> {

}
