package com.riwi.simulacro_SpringBoot.api.dto.error;

import java.util.List;
import java.util.Map;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
@EqualsAndHashCode(callSuper=false)
@Data
@SuperBuilder
@AllArgsConstructor
@NoArgsConstructor
public class ErrorResp extends BaseErrorResp {
    private List<Map<String,String>> errors;
}
