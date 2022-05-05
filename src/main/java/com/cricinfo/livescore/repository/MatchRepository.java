package com.cricinfo.livescore.repository;

import com.cricinfo.livescore.model.entity.Match;
import org.springframework.data.jpa.datatables.repository.DataTablesRepository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MatchRepository extends JpaRepository<Match, Long> , DataTablesRepository<Match,Long> {
    public boolean existsByGuid(String guid);
}
