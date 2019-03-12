package org.launchcode.bankrolltracker.models.data;

import org.launchcode.bankrolltracker.models.Total;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface TotalDao extends CrudRepository<Total, Integer> {
}