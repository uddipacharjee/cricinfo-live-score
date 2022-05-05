package com.cricinfo.livescore.model.entity;

import com.cricinfo.livescore.util.StringTrimConverter;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "matches")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Match  {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "link")
    private String link;

    @Column(name = "match_description")
    private String description;

    @Column(name = "guid", unique = true)
    @Convert(converter = StringTrimConverter.class)
    private String guid;

}
