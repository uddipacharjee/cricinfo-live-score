package com.cricinfo.livescore.controller;

import com.cricinfo.livescore.model.response.MatchSearchResponse;
import com.cricinfo.livescore.service.MatchService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.datatables.mapping.DataTablesInput;
import org.springframework.data.jpa.datatables.mapping.DataTablesOutput;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/api/match")
@RequiredArgsConstructor(onConstructor_ ={@Autowired} )
public class MatchRestController {
    private final MatchService matchService;

    @PostMapping("/search")
    public DataTablesOutput<MatchSearchResponse> list(@Valid @RequestBody DataTablesInput dataTablesInput) {
        return matchService.getMatchSearchResponse(dataTablesInput);
    }
}
