package com.sichrplace.messaging;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.messaging.dto.MessageRequest;
import com.sichrplace.messaging.dto.MessageThreadRequest;
import com.sichrplace.messaging.dto.MessageThreadResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class MessagingServiceImpl implements MessagingService {

    private final MessageThreadRepository messageThreadRepository;
    private final MessageRepository messageRepository;

    @Override
    public ApiResponse<List<MessageThreadResponse>> listThreads() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<MessageThreadResponse> getThread(Long id) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<MessageThreadResponse> createThread(MessageThreadRequest request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> postMessage(Long threadId, MessageRequest request) {
        throw new UnsupportedOperationException("TODO");
    }
}
