package com.riwi.simulacro_SpringBoot.Infraestructure.abstract_services;

import org.springframework.data.domain.Page;


public interface CrudService<RQ, RS, ID>{
    public RS create(RQ request);
    public RS get(ID id);
    public RS update(RQ request, ID id);
    public void dalete(ID id);
    public Page<RS> getAll(int page, int size);
}
