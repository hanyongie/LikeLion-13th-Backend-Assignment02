package com.likelion.assignment_2.item.api;

import com.likelion.assignment_2.item.api.dto.MusicalDto;
import com.likelion.assignment_2.item.application.MusicalService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class MusicalController {
    private final MusicalService musicalService;

    @PostMapping("musical")
    public void save(@RequestBody MusicalDto musicalDto){
        musicalService.saveMusical(musicalDto);
    }

    @GetMapping("musical/{id}")
    public MusicalDto findMusicalById(@PathVariable Long id){
        return musicalService.findMusicalById(id);
    }

    @GetMapping("musical")
    public List<MusicalDto> findAllMusical(){
        return musicalService.findAllMusical();
    }

    @PatchMapping("musical/{id}")
    public void updateMusicalById(@PathVariable Long id, @RequestBody MusicalDto musicalDto){
        musicalService.updateMusicalById(id, musicalDto);
    }
    @DeleteMapping("musical/{id}")
    public void deleteMusicalById(@PathVariable Long id){
        musicalService.deleteMusicalById(id);
    }
}
