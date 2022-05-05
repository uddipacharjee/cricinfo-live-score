package com.cricinfo.livescore.service;

import com.cricinfo.livescore.model.entity.Match;
import com.cricinfo.livescore.model.response.MatchSearchResponse;
import com.cricinfo.livescore.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ ={@Autowired} )
public class MatchService {

    private final MatchRepository matchRepository;


    public DataTablesOutput<MatchSearchResponse> getMatchSearchResponse(DataTablesInput dataTablesInput) {
        return matchRepository.findAll(dataTablesInput, this::convertToMatchSearchResponse);
    }

    private MatchSearchResponse convertToMatchSearchResponse(Match match) {
        return MatchSearchResponse
                .builder()
                .title(match.getTitle())
                .description(match.getDescription())
                .guid(match.getGuid())
                .link(match.getLink())
                .build();
    }
}
