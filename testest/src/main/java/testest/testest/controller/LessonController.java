package testest.testest.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import testest.testest.entity.Lesson;
import testest.testest.repository.LessonRepository;

@RestController
@RequiredArgsConstructor
@RequestMapping("/lesson")
public class LessonController {
    private final LessonRepository lessonRepository;

    @PostMapping
    private void postLesson(@RequestBody Lesson lesson){
        lessonRepository.save(lesson);
    }
}
