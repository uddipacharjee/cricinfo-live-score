package com.cricinfo.livescore.model.response;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class MatchSearchResponse {
    private String title;
    private String link;
    private String description;
    private String guid;
}
