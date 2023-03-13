package com.brigido.contas.dto.account;

import lombok.*;
import java.util.UUID;

@Getter @Setter
@AllArgsConstructor @NoArgsConstructor
@Builder
public class SearchAccountDTO {
    private UUID personId;
}
