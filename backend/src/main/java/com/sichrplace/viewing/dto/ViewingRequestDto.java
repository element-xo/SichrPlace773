package com.sichrplace.viewing.dto;

import java.time.LocalDateTime;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ViewingRequestDto {
    private Long listingId;
    private Long tenantProfileId;
    private Long landlordProfileId;
    private LocalDateTime proposedDatetime;
}
