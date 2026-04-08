package com.sichrplace.support.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class SupportTicketResponse {
    private Long id;
    private String subject;
    private String body;
}
