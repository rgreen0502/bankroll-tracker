package org.launchcode.bankrolltracker.models.data;

import org.launchcode.bankrolltracker.models.Newgame;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface NewgameDao extends CrudRepository<Newgame, Integer> {
}
