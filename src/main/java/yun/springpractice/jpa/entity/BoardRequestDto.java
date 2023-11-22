package yun.springpractice.jpa.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import yun.springpractice.jpa.entity.Board;

@Setter
@NoArgsConstructor
@Getter
public class BoardRequestDto {

    private Long id;
    private String writer;
    private String title;
    private String content;

    @Builder
    public BoardRequestDto(String writer, String title, String content) {
        this.writer = writer;
        this.title = title;
        this.content = content;
    }

    public Board ToEntity(){
        return Board.builder()
                .writer(this.writer)
                .title(this.title)
                .content(this.content)
                .build();
    }
}