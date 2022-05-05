package com.cricinfo.livescore.model;

import com.cricinfo.livescore.model.entity.Match;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import java.util.Set;

@ToString
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Channel {

    @JacksonXmlElementWrapper(useWrapping = false)
    private Set<Match> item;

}
