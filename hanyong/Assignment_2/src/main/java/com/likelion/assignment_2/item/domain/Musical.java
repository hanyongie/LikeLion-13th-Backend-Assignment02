package com.likelion.assignment_2.item.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
public class Musical {
    private  Long id; //뮤지컬 고유 id
    private String name; //뮤지컬 이름
    private String time; //상여시간

    @Builder
    public Musical(Long id, String name, String time) {
        this.id = id;
        this.name= name;
        this.time = time;
    }
    public void update(String name, String time) {
        this.name = name;
        this.time = time;
    }
}
