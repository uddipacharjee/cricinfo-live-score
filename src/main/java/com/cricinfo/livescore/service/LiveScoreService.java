package com.cricinfo.livescore.service;

import com.cricinfo.livescore.model.entity.Match;
import com.cricinfo.livescore.model.Rss;
import com.cricinfo.livescore.repository.MatchRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Slf4j
@Service
@RequiredArgsConstructor(onConstructor_ ={@Autowired} )
public class LiveScoreService {

    @Value("${external.api.live_score_url}")
    private String baseURL;

    private final RestTemplate restTemplate;

    private final MatchRepository matchRepository;

    public void fetchAndStoreLiveScoreData(){
        try {
            Rss scoreResponse = restTemplate.getForObject(baseURL,Rss.class);

            if (scoreResponse != null) {
                log.info(scoreResponse.toString());

                List<Match> savedMatches = scoreResponse
                        .getChannel()
                        .getItem()
                        .stream()
                        .map(match -> {
                            if(!matchRepository.existsByGuid(match.getGuid())){
                                log.info("saving .. " + match);
                                return matchRepository.save(match);
                            }else {
                                log.warn("Already exists .." + match);
                            }
                            return null;
                        })
                        .filter(match -> !Objects.isNull(match))
                        .collect(Collectors.toList());

                log.info("saved list : " + savedMatches);
            }
        }catch (Exception e){
            log.error(e.getMessage());
        }
    }
}
