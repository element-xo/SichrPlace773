package com.sichrplace.common.response;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class PagedResponse<T> extends ApiResponse<T> {

    private int page;
    private int size;
    private long totalElements;

    public PagedResponse(boolean success, String message, T data, int page, int size, long totalElements) {
        super(success, message, data, java.time.Instant.now());
        this.page = page;
        this.size = size;
        this.totalElements = totalElements;
    }
}
