package testest.testest.controller;


import org.springframework.web.bind.annotation.*;
import testest.testest.entity.Application;
import lombok.RequiredArgsConstructor;
import testest.testest.entity.ApplicationStatus;
import testest.testest.entity.Member;
import testest.testest.repository.ApplicationRepository;
import testest.testest.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/apply")
public class ApplicationController {

    public final MemberRepository memberRepository;
    public final ApplicationRepository applicationRepository;

    @PostMapping()
    public void apply(@RequestBody Application application){
        System.out.println("application.getCount() = " + application.getCount());
        applicationRepository.save(application);
    }

    @GetMapping("/guest")
    public List<Application> getAll(){
        List<Application> all = applicationRepository.findAll();
        return all;
    }

    @GetMapping("/{userId}")
    public Application getOneUser(@PathVariable Long userId){
        Optional<Application> optional = applicationRepository.findById(userId);
        if (optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        Application application = optional.get();
        return application;
    }

    @DeleteMapping("/{userId}")
    public void deletee(@PathVariable Long userId){
        applicationRepository.deleteById(userId);
    }

    @PutMapping("/{userId}")
    public void putt(@PathVariable Long userId, @RequestBody Application application){
        Optional<Application> optional = applicationRepository.findById(userId);
        if (optional.isEmpty()){
            throw new IllegalArgumentException();
        }
        Application find = optional.get();
        find.setReason(application.getReason());
        find.setAfter(application.getAfter());
    }

}