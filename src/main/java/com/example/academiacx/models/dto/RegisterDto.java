package com.example.academiacx.models.dto;

import com.example.academiacx.models.UserRole;

public record RegisterDto(String username, String password, UserRole role) {
}
