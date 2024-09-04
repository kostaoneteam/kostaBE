<<<<<<< HEAD
package com.example.demo.presentation;

import com.example.demo.application.service.LikesService;
import com.example.demo.application.dto.LikesDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@RequiredArgsConstructor
public class LikesController {
    private final LikesService likesService;

    @PostMapping
    public ResponseEntity<Void> addLike(@RequestBody LikesDto likesDto) {
        likesService.addLike(likesDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> removeLike(@RequestBody LikesDto likesDto) {
        likesService.removeLike(likesDto);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/count/{postId}")
    public ResponseEntity<Integer> countLikes(@PathVariable Long postId) {
        int count = likesService.countLikes(postId);
        return ResponseEntity.ok(count);
    }

    @GetMapping("/is-liked")
    public ResponseEntity<Boolean> isLiked(@RequestParam Long userId, @RequestParam Long postId) {
        LikesDto likesDto = new LikesDto(userId, postId);
        boolean liked = likesService.isLiked(likesDto);
        return ResponseEntity.ok(liked);
    }
=======
package com.example.demo.presentation;public class LikesController {
>>>>>>> f7201aa3ba97944595125338727f3e4685fc5986
}
