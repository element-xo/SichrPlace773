package com.sichrplace.viewing.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ViewingResponse {
    private Long id;
    private LocalDateTime proposedDatetime;
}
