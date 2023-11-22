package yun.springpractice.jpa.entity;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
public class BoardApiController {

    @Autowired
    private final BoardServiceImpl boardService;
    @Autowired
    private final BoardRepository boardRepository;

    @PostMapping("/api/post")
    public BoardResponseDto savePost(@RequestBody BoardRequestDto request) {

        boardService.savePost(request);

        return new BoardResponseDto(
                request.ToEntity().getTitle(),
                request.ToEntity().getWriter(),
                request.ToEntity().getContent()
                );

    }

    @PutMapping("/api/post/{id}")
    public BoardResponseDto updatePost(@PathVariable("id") Long id,
                                       @RequestBody BoardRequestDto request) {

        boardService.update(id, request);
        Optional<Board> findPost = boardRepository.findById(id);
        Board board = findPost.get();

        return new BoardResponseDto(
                board.getTitle(),
                board.getWriter(),
                board.getContent());
    }

    @GetMapping("/api/board/posts")
    public List<BoardRequestDto> findPosts(){
        List<Board> findAll = boardRepository.findAll();
        List<BoardRequestDto> allPost = new ArrayList<>();

        for(Board board : findAll){
            BoardRequestDto build = BoardRequestDto.builder()
                    .content(board.getContent())
                    .writer(board.getWriter())
                    .title(board.getTitle())
                    .build();

            allPost.add(build);
        }

        return allPost;
    }

    @GetMapping("/api/board/post/{id}")
    public BoardResponseDto findPost(@PathVariable("id") Long id){
        BoardRequestDto post = boardService.getPost(id);

        return new BoardResponseDto(
                post.getWriter(),
                post.getTitle(),
                post.getContent()
        );
    }

    @DeleteMapping("/api/post/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        boardService.deletePost(id);
    }

}