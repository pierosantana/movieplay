package com.psantana.movieplay.web.exception;

public record ApiError(
        String type,
        String message
) {
}
