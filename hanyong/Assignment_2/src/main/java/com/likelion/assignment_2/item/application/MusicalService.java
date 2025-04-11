package com.likelion.assignment_2.item.application;

import com.likelion.assignment_2.item.api.dto.MusicalDto;
import com.likelion.assignment_2.item.domain.Musical;
import com.likelion.assignment_2.item.domain.MusicalRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MusicalService {
    private final MusicalRepository musicalRepository;

    private static Long sequence = 0L;

    public void saveMusical(MusicalDto musicalDto) {
        Musical musical = Musical.builder()
                .id(++sequence)
                .name(musicalDto.name())
                .time(musicalDto.time())
                .build();

        musicalRepository.save(musical);
    }

    public MusicalDto findMusicalById(Long id){
        Musical musical = musicalRepository.findById(id);
        if( musical == null){
            throw new IllegalArgumentException("해당 뮤지컬이 없습니다. id = " + id);
        }
        return toDto(musical);
    }

    public List<MusicalDto> findAllMusical(){
        return musicalRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }
    public Musical updateMusicalById(Long id, MusicalDto musicalDto) {
        Musical musical = musicalRepository.findById(id);
        if( musical == null){
            throw new IllegalArgumentException("해당 뮤지컬 없습니다. id = " + id);
        }

        musical.update(musicalDto.name(), musicalDto.time());
        musicalRepository.updateById(id, musical);
        return musical;
    }
    public void deleteMusicalById(Long id){
        musicalRepository.deleteById(id);
    }
    private MusicalDto toDto(Musical musical){
        return MusicalDto.builder()
                .id(musical.getId())
                .name(musical.getName())
                .time(musical.getTime())
                .build();
    }
}
