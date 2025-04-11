package com.likelion.assignment_2.item.api.dto;

import lombok.Builder;

@Builder
public record MusicalDto(
        Long id,
        String name,
        String time
) {
}
