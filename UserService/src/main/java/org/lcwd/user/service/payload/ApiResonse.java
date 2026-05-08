package org.lcwd.user.service.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResonse {

    private String message;
    private boolean success;
    private HttpStatus status;
}
