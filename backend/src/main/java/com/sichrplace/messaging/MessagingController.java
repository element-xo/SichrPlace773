package com.sichrplace.messaging;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.messaging.dto.MessageRequest;
import com.sichrplace.messaging.dto.MessageThreadRequest;
import com.sichrplace.messaging.dto.MessageThreadResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
@RequiredArgsConstructor
public class MessagingController {

    private final MessagingService messagingService;

    @GetMapping("/threads")
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<List<MessageThreadResponse>>> getThreads() {
        return ResponseEntity.ok(messagingService.listThreads());
    }

    @GetMapping("/threads/{id}")
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<MessageThreadResponse>> getThread(@PathVariable Long id) {
        return ResponseEntity.ok(messagingService.getThread(id));
    }

    @PostMapping("/threads")
    @PreAuthorize("hasRole('TENANT')")
    public ResponseEntity<ApiResponse<MessageThreadResponse>> createThread(@RequestBody MessageThreadRequest request) {
        return ResponseEntity.ok(messagingService.createThread(request));
    }

    @PostMapping("/threads/{id}/messages")
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<Void>> postMessage(@PathVariable Long id, @RequestBody MessageRequest request) {
        return ResponseEntity.ok(messagingService.postMessage(id, request));
    }
}
