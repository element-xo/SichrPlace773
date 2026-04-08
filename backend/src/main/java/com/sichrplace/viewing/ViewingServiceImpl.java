package com.sichrplace.viewing;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.viewing.dto.ViewingRequestDto;
import com.sichrplace.viewing.dto.ViewingResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class ViewingServiceImpl implements ViewingService {

    private final ViewingRequestRepository viewingRequestRepository;

    @Override
    public ApiResponse<ViewingResponse> createViewing(ViewingRequestDto request) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    public ApiResponse<List<ViewingResponse>> listViewings() {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> confirmViewing(Long id) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> rejectViewing(Long id) {
        throw new UnsupportedOperationException("TODO");
    }

    @Override
    @Transactional
    public ApiResponse<Void> completeViewing(Long id) {
        throw new UnsupportedOperationException("TODO");
    }
}
