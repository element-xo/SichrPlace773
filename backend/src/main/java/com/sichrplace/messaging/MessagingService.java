package com.sichrplace.messaging;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.messaging.dto.MessageRequest;
import com.sichrplace.messaging.dto.MessageThreadRequest;
import com.sichrplace.messaging.dto.MessageThreadResponse;
import java.util.List;

public interface MessagingService {
    ApiResponse<List<MessageThreadResponse>> listThreads();
    ApiResponse<MessageThreadResponse> getThread(Long id);
    ApiResponse<MessageThreadResponse> createThread(MessageThreadRequest request);
    ApiResponse<Void> postMessage(Long threadId, MessageRequest request);
}
