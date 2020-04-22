package tasks.domain.dto;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import tasks.domain.DTO;
import tasks.domain.TrelloList;

import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public  class TrelloBoardDto extends DTO<String> {

    @JsonProperty("name")
    private String name;

    @JsonProperty("lists")
    private List<TrelloList> lists;

    @Builder
    public TrelloBoardDto(String id, String name, List<TrelloList> lists) {
        super(id);
        this.name = name;
        this.lists = lists;
    }
}