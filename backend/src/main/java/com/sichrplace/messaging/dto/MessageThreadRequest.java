package com.sichrplace.messaging.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MessageThreadRequest {
    private Long listingId;
    private Long tenantProfileId;
    private Long landlordProfileId;
}
