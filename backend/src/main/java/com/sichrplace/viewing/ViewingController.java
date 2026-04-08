package com.sichrplace.viewing;

import com.sichrplace.common.dto.ApiResponse;
import com.sichrplace.viewing.dto.ViewingRequestDto;
import com.sichrplace.viewing.dto.ViewingResponse;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/viewings")
@RequiredArgsConstructor
public class ViewingController {

    private final ViewingService viewingService;

    @PostMapping
    @PreAuthorize("hasRole('TENANT')")
    public ResponseEntity<ApiResponse<ViewingResponse>> createViewing(@RequestBody ViewingRequestDto request) {
        return ResponseEntity.ok(viewingService.createViewing(request));
    }

    @GetMapping
    @PreAuthorize("hasAnyRole('TENANT','LANDLORD')")
    public ResponseEntity<ApiResponse<List<ViewingResponse>>> listViewings() {
        return ResponseEntity.ok(viewingService.listViewings());
    }

    @PutMapping("/{id}/confirm")
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<Void>> confirmViewing(@PathVariable Long id) {
        return ResponseEntity.ok(viewingService.confirmViewing(id));
    }

    @PutMapping("/{id}/reject")
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<Void>> rejectViewing(@PathVariable Long id) {
        return ResponseEntity.ok(viewingService.rejectViewing(id));
    }

    @PutMapping("/{id}/complete")
    @PreAuthorize("hasRole('LANDLORD')")
    public ResponseEntity<ApiResponse<Void>> completeViewing(@PathVariable Long id) {
        return ResponseEntity.ok(viewingService.completeViewing(id));
    }
}
