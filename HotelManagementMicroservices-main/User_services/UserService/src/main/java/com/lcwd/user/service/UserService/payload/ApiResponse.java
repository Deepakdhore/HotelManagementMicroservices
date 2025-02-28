package com.lcwd.user.service.UserService.payload;

import lombok.*;
import org.springframework.http.HttpStatus;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ApiResponse {
    private String message;
    private boolean success;
    private HttpStatus status;

    ////////////////////////////////////////////

    private ApiResponse(Builder builder) {
        this.message = builder.message;
        this.success = builder.success;
        this.status = builder.status;
    }

    public static class Builder {
        private String message;
        private boolean success;
        private HttpStatus status;

        public Builder message(String message) {
            this.message = message;
            return this;
        }

        public Builder success(boolean success) {
            this.success = success;
            return this;
        }

        public Builder status(HttpStatus status) {
            this.status = status;
            return this;
        }

        public ApiResponse build() {
            return new ApiResponse(this);
        }
    }

    public static Builder builder() {
        return new Builder();
    }

}
