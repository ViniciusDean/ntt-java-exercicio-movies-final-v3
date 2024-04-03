package com.example.academiacx.utils;

import com.example.academiacx.models.dto.ResultDto;

public final class MovieUtil {
   public static ResultDto result(final String message, final Integer status){
       return new ResultDto(message, status);
   }

}

