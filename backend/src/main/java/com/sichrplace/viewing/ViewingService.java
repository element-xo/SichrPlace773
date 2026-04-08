package com.sichrplace.viewing;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.viewing.dto.ViewingRequestDto;
import com.sichrplace.viewing.dto.ViewingResponse;
import java.util.List;

public interface ViewingService {
    ApiResponse<ViewingResponse> createViewing(ViewingRequestDto request);
    ApiResponse<List<ViewingResponse>> listViewings();
    ApiResponse<Void> confirmViewing(Long id);
    ApiResponse<Void> rejectViewing(Long id);
    ApiResponse<Void> completeViewing(Long id);
}
